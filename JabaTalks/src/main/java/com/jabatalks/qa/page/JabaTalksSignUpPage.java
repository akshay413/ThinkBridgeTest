package com.jabatalks.qa.page;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.jabatalks.qa.base.JabaTalksBase;

public class JabaTalksSignUpPage extends JabaTalksBase{
	
	// Object Repository
	@FindBy(id = "name")    // Username element
	WebElement username;
	
	@FindBy(id="orgName")   // organisation element
	WebElement organization;
	
	@FindBy(id="singUpEmail")  // email element
	WebElement email;
	
	@FindBy(xpath = "//section[@class='logo']//child::a//child::img[@width ='150px']")   // Logo element
	WebElement JabaTalksLogo;
	
	@FindBy(id= "language")      // Language element
	WebElement language;
	
	@FindBy(xpath = "//span[@class='black-color ng-binding']")    // Terms and conditions checkbox element
	WebElement termsChecckBox;
	
	
	@FindBy(xpath = "//button[@type='submit']")    // Submit button element
	WebElement submit;
	
	@FindBy(xpath = "//span[contains(text(),' A welcome email has been sent. Please check your email. ')]")    // Message displayed after signup
	WebElement message;
	
	@FindBy(xpath = "//div[contains(@id,'ui-select-choices-row-1-')]")    // all the languages in the dropdown
	List<WebElement> languages;
	

	@FindBy(id= "login")      //email
	WebElement emaillogin;
	
	//submit
	@FindBy(className ="sbut")      //submit button
	WebElement emailsubmit;
	
	//(//span[contains(text(),'JabaTalks Development')])[1]
	@FindBy(xpath = "(//span[contains(text(),'JabaTalks Development')])[1]")      //check email
	WebElement emailcheck;
	
	//ifinbox
	@FindBy(id = "ifinbox")      //check inbox
	WebElement inbox;
	
	//Initializing the Page Objects
	public JabaTalksSignUpPage(){
		PageFactory.initElements(driver, this);
	}
	
	//Functionalities
            //Validate title of the page	
			public String validateSignUpPageTitle(){
				return driver.getTitle();
				//Jabatalks
			}
			
			
		    // Validate if logo is displayed
			public boolean validateJabaTalksImage(){
				return JabaTalksLogo.isDisplayed();
			}
			
			//Signup functionality
			public String jabaTalksSignUp(String name, String org, String emailid) throws InterruptedException{
				username.sendKeys(name);
				organization.sendKeys(org);
				email.sendKeys(emailid);
				termsChecckBox.click();	
				submit.click(); 
				Thread.sleep(10000);
				String mess = message.getText();
				return mess;
				
			}
			
			//Validate the values present in dropdown
			public List<WebElement> languageValidation() {
			
				//Click on the language drop down
				language.click();			
				//save all the values present in the language dropdown in languages variable
				return languages;										
					
				}
			//A welcome email has been sent. Please check your email.
			
			public boolean emailCheck(String url,String username) throws InterruptedException {
				driver.navigate().to(url);
				//http://www.yopmail.com/en/
				if(emaillogin.isDisplayed()) {
					emaillogin.sendKeys(username);
				}
				
				emailsubmit.click();
				Thread.sleep(20000);
				driver.switchTo().frame(inbox);
				return emailcheck.isDisplayed();
				
				
				
			}
				
}

	
	


