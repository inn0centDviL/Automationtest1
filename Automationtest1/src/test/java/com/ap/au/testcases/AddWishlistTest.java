package com.ap.au.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ap.au.base.TestBase;
import com.ap.au.pages.HomePage;
import com.ap.au.pages.LoginPage;
import com.ap.au.pages.ProductDetailsPage;
import com.ap.au.pages.SearchPage;

public class AddWishlistTest extends TestBase
{
	LoginPage loginPage;
	HomePage homePage;
	SearchPage searchPage;
	ProductDetailsPage productDetailsPage;

public AddWishlistTest()
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

@Test
public void testAddProductToWishList()
{
	//creating an object and giving it a value
	String product = "Printed Chiffon Dress";
	//Goes to homepage and clicks on signin button
	homePage.clickOnSignIn(); 
	//lands on the loginPage and then enters information for username and password
	homePage = loginPage.login(propt.getProperty("username"), propt.getProperty("password"));
	
	searchPage = homePage.searchProduct(product);
	String header = searchPage.getHeader();
	Assert.assertTrue(header.toLowerCase().contains(product.toLowerCase()));
	
	productDetailsPage.clickAddWishListButton();
	productDetailsPage.verifyAddWishListMsg();
	homePage.logOut();
}

@AfterMethod 
public void teardown()
{
	driver.quit();
}
}










