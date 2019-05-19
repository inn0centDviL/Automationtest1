package com.ap.au.testcases;



import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ap.au.base.TestBase;
import com.ap.au.pages.HomePage;
import com.ap.au.pages.LoginPage;
import com.ap.au.pages.SearchPage;

public class SearchItemTest extends TestBase
{
	LoginPage loginPage;
	HomePage homePage;
	SearchPage searchPage;

public SearchItemTest()
{
	super();
}

@BeforeMethod
public void setUpDriver()
{
	initialization();
	loginPage = new LoginPage();
	homePage = new HomePage();
}


@Test (priority = 3)
public void testSearchItem()
{
	String product = "Evening";
	homePage.clickOnSignIn();
	homePage = loginPage.login(propt.getProperty("username"), propt.getProperty("password"));
	
	searchPage = homePage.searchProduct("Evening");
	String header = searchPage.getHeader();
	System.out.println(header);
	
	Assert.assertTrue(header.toLowerCase().contains(product.toLowerCase()));
	homePage.logOut();
}

@AfterMethod
public void tearDown()
{
	driver.quit();
}
}










