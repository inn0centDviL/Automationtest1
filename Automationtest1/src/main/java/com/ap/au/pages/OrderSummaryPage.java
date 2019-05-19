package com.ap.au.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ap.au.base.TestBase;

public class OrderSummaryPage extends TestBase
{
	@FindBy (css = "[class='button btn btn-default standard-checkout button-medium']")
	WebElement proceedToCheckout;
	
	@FindBy (xpath = "//*[@id='center_column']/form/p/button/span")
	WebElement proceedAddressButton;
	
	@FindBy (xpath = "//*[@id='form']/p/button/span")
	WebElement proceedCarrierButton;
	
	@FindBy (id = "cgv")
	WebElement termsAndCondition;
	
	@FindBy (css = "[class='bankwire']")
	WebElement payByBankWire;
	
	@FindBy (xpath = "//*[@id='cart_navigation']/button/span")
	WebElement confirmOrder;
	
	@FindBy (css = "[class='page-heading']")
	WebElement orderConfirm;

	
	public OrderSummaryPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public OrderSummaryPage proceedCheckOut()
	{
		proceedToCheckout.click();
		return this;
	}
	
	public OrderSummaryPage proceedAddressCheckout()
	{
		proceedAddressButton.click();
		return this;
	}
	
	public OrderSummaryPage proceedtoCareerButton()
	{
		termsAndCondition.click();
		proceedCarrierButton.click();
		return this;
	}
	
	public OrderSummaryPage confirmOrder()
	{
		payByBankWire.click();
		confirmOrder.click();
		return this;
	}
	
	public String getConfirmationMessage()
	{
		return orderConfirm.getText();
	}
}












