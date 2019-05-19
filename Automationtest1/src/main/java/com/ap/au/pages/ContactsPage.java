package com.ap.au.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.ap.au.base.TestBase;

public class ContactsPage extends TestBase
{
	
	//Page Factory
	@FindBy (id = "id_contact")
	WebElement headingDropdown;
	
	@FindBy (id = "email")
	WebElement emailInput;
	
	@FindBy (id = "id_order")
	WebElement orderReference;
	
	@FindBy (id = "message")
	WebElement messageTextBox;
	
	@FindBy (id = "submitMessage")
	WebElement submitMessageButton;
	
	@FindBy (css = "[class='alert alert-success']")
	WebElement successMsg;
	
	//constructor
	public ContactsPage()
	{
		//call the pagefactory and initilizes the elements with driver and "this" specific class
		PageFactory.initElements(driver, this);
	}
	
	public ContactsPage fillContactForm (String heading, String email, String reference, String message)
	{
		//Multiple dropdown actions being performed
		Select select = new Select(headingDropdown);
		select.selectByVisibleText(heading);
		emailInput.sendKeys(email);
		orderReference.sendKeys(reference);
		messageTextBox.sendKeys(message);
		
		return this;
	}
	
	public void submitMessage()
	{
		submitMessageButton.click();
	}
	
	public String getMessage()
	{
		return successMsg.getText();
	}
}







