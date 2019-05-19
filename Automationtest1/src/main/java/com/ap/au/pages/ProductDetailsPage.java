package com.ap.au.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.ap.au.base.TestBase;

public class ProductDetailsPage extends TestBase
{
	@FindBy (id = "quantity_wanted")
	WebElement quantityButton;
	
	@FindBy (id = "group_1")
	WebElement sizeSelection;
	
	@FindBy (css = "[class='buttons_bottom_block no-print']")
	WebElement addToCart;
	
	@FindBy (xpath = "//*[@id='layer_cart']/div[1]/div[2]/div[4]/a/span")
	WebElement proceedToCheckout;
	
	@FindBy (id = "wishlist_button")
	WebElement addToWishList;
	
	@FindBy (xpath = "//*[@id='product']/div[2]/div/div/div/div/p")
	WebElement addWishListMsg;
	
	@FindBy (css = "[class='fancybox-item fancybox-close']")
	WebElement addWishListMsgCloseButton;
	
	
	public ProductDetailsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void verifyAddWishListMsg()
	{
		Assert.assertEquals(addWishListMsg.getText(), "Added to your wishlist");
		addWishListMsgCloseButton.click();
	}
	
	//method to interact with the color of the dress that will be obtained from excel sheet
	public ProductDetailsPage selectProductColor (String color)
	{
		String locator = "[name='" + color + "']";
		driver.findElement(By.cssSelector(locator)).click();
		return this; //making a script smart, in case you wanna add another color or quantity.
	}
	
	public ProductDetailsPage inputQuantity (String quantity)
	{
		quantityButton.clear();
		quantityButton.sendKeys(quantity);
		return this;
	}
	
	public ProductDetailsPage selectSize (String size)
	{
		Select select = new Select(sizeSelection);
		select.selectByVisibleText(size);
		return this;
	}
	
	public ProductDetailsPage clickAddCart()
	{
		addToCart.click();
		return this;
	}
	
	public ProductDetailsPage clickAddWishListButton()
	{
		addToWishList.click();
		return this;
	}
	
	public OrderSummaryPage proceedCheckout()
	{
		proceedToCheckout.click();
		return new OrderSummaryPage();
	}
	
	
}












