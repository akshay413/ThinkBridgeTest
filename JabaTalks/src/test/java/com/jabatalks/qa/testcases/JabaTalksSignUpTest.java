package com.jabatalks.qa.testcases;

import java.util.List;

import javax.swing.plaf.synth.SynthOptionPaneUI;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.jabatalks.qa.base.JabaTalksBase;
import com.jabatalks.qa.page.JabaTalksSignUpPage;

public class JabaTalksSignUpTest extends JabaTalksBase {
	JabaTalksSignUpPage signup;
	
	@BeforeMethod
	 public void setup() {
		 initialization();
		 signup = new JabaTalksSignUpPage();
	 }
	 
	 @AfterMethod
	 public void end() {
		 driver.quit();
	 }
	 
	 @Test
	 public void jabaTalksSignUP() throws InterruptedException {
		// Verify if page title is correct 
	    String title = signup.validateSignUpPageTitle();
	    Assert.assertEquals(title, "Jabatalks");
	    //Verify if Logo is getting displayed
	    boolean logo=signup.validateJabaTalksImage();
	    Assert.assertTrue(logo, "Logo is not displayed");
	    
	    //Verify that the languages are either English or Dutch
	    List<WebElement> languages= signup.languageValidation();
		//Loop through dropdown values and verify
		for(int i=0; i<languages.size(); i++) {
			String lang=languages.get(i).getText();
			System.out.println(lang);
		    if(!(lang.contains("English") || lang.contains("Dutch"))) {
			    Assert.fail("The language is not English or Dutch");
			}
		}
		
	   // register
	    String message =signup.jabaTalksSignUp("akshay", "akshay", "akshay@yopmail.com");
	    System.out.println(message);
	    Assert.assertEquals(message, "A welcome email has been sent. Please check your email.");
		
	    //check email
	   boolean value= signup.emailCheck("http://www.yopmail.com/en/", "akshay");
		 Assert.assertTrue(value, "email is not received");
		 
	 }
	

	 
	

}
