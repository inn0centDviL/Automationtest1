package com.ap.au.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ap.au.base.TestBase;
import com.ap.au.pages.HomePage;
import com.ap.au.pages.LoginPage;

//if you don't extend TestBase, some functions won't work
public class LoginTest extends TestBase
{
	//creating object for each page
	LoginPage loginPage;
	HomePage homePage;
	
	//constructor
	public LoginTest()
	{
		//constructor for the superclass
		super();
	}
	
	@BeforeMethod
	public void setUpdriver()
	{
		initialization();
		loginPage = new LoginPage();
	}
	
	@Test (priority = 1)
	public void loginPageTitleTest()
	{
		//Created a string, calling login page and verifying page title
		String title = loginPage.verifypageTitle();
		//Assert is a function in TestNG that allows you to verify certain info if it's true or not
		Assert.assertEquals(title, "Later, we'll check on the site");
	}
	
	@Test (priority = 2)
	public void apLogoTest()
	{
		boolean value = loginPage.validateAPImage();
		Assert.assertTrue(value);
	}
	
	//getting the property values
	@Test (priority =3)
	public void loginTest()
	{	//making connection with username and password with the properties values set up in TestBase, which
		//	will link to the config.properties file
		homePage = loginPage.login(propt.getProperty("username"), propt.getProperty("password"));
	}
	
	
	@AfterMethod
	public void closeBrowser()
	{
		driver.quit();
	}
}














