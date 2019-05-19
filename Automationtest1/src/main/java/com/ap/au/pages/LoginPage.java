package com.ap.au.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ap.au.base.TestBase;

public class LoginPage extends TestBase
{
	//Page Factory
	
	@FindBy (id = "email")
	WebElement username;
	
	@FindBy (id = "passwd")
	WebElement password;
	
	@FindBy (xpath = "//*[@id='SubmitLogin']/span")  
	WebElement submitbutton;
	
	@FindBy (xpath = "//*[@id='header_logo']/a/img")
	WebElement apLogo; 
	
	
	
	
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}

	//method to verify the title of the page
	public String verifypageTitle()
	{
		return driver.getTitle();
	}
	
	//method to validate the Image of the page. Will return as Displayed or not displayed.
	public boolean validateAPImage()
	{
		return apLogo.isDisplayed();
	}

	
	
	//method to send username and password and clicking the submit button
	public HomePage login(String uname, String passw)
	{
		username.sendKeys(uname);
		password.sendKeys(passw);
		submitbutton.click();
		
		return new HomePage();
	}
	
	
	
}












