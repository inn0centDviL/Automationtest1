package com.ap.au.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ap.au.base.TestBase;
import com.ap.au.pages.ContactsPage;
import com.ap.au.pages.HomePage;

public class ContactTest extends TestBase
{
	//Linking between the pages by creating objects
	ContactsPage contactspage;
	HomePage homepage;
	
	//
	public ContactTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUpDriver()
	{
		initialization();
		contactspage = new ContactsPage();
		homepage = new HomePage();
	}
	
	@Test
	public void testContact()
	{
		homepage.clickOnContactLink();
		contactspage = contactspage.fillContactForm("Customer service", "Random@test.com", 
				"Testing", "This is test purpose");
		
		//created a method to verify with a success message
		contactspage.submitMessage();
		
		String successMsg = contactspage.getMessage();
		Assert.assertEquals(successMsg, "Your message has been successfully sent to the team");
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}














