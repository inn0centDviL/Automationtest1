package com.ap.au.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ap.au.base.TestBase;

public class HomePage extends TestBase
{
	//locator values and objects
	//Page Factory
	@FindBy(xpath = "//*[@id='header']/div[2]/div/div/nav/div[1]/a") //Sargil did css
	WebElement signInButton;
	
	@FindBy (xpath = "//*[@id='contact-link']/a") //Sargil did id
	WebElement contactLink;
	
	@FindBy (id = "search_query_top") 
	WebElement searchField;
	
	@FindBy (xpath = "//*[@id='searchbox']/button") //Sargil did css
	WebElement submitSearchButton;
	
	@FindBy (xpath = "//*[@id='header']/div[2]/div/div/nav/div[2]/a") //Sargil did css "[class='logout']"
	WebElement logOutButton;
	
//	@FindBy (xpath = "//*[@id='header_logo']/a/img")
//	WebElement apLogo; 
	
	
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
/*	public String verifypageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean validateAPImage()
	{
		return apLogo.isDisplayed();
	}
*/	
	
	
	//Method for SignIn						
	public HomePage clickOnSignIn()
	{
		signInButton.click();
		
		return new HomePage();
	}
	
	//Method for ContactLink
	public void contactLink()
	{
		contactLink.click();
	}
	
	//Method for SearchPage
	public SearchPage searchProduct(String productName)
	{
		searchField.sendKeys(productName);
		submitSearchButton.click();
		
		return new SearchPage();
	}
	
	//Method for logout
	public void logOut()
	{
		logOutButton.click();
	}
	
	/*	ACTION ITEM:

		All on the HOMEPAGE Class only!

		FIll out Object for Login, contact button, search field, submit search, logout		
		Initialize the page object 
		Create method for SearchPage, SignIn, Contactbutton, logout.
		
	 */
}
