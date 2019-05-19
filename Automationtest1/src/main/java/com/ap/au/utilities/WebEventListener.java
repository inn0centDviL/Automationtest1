/*We have created this class WebDriverEventListener in order to implement interface
to override all the methods and define certain helpful log actions, which would be
displayed/logged as the app under test is being executed. These methods will be invoked
by itself automatically, when certain actions are performed. Ex: click, submit, screenshot,
findby, etc.
*/

//links it with the TestBase. So we are making this to give commands

/*creating a log file to see what actions are taking place. so now we will get a report on 
what is passing or failing? */

 

package com.ap.au.utilities;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.ap.au.base.TestBase;

//starts capturing info/action when you invoke the driver. Is it passing, failing, skipping, etc.
//interface allows you to access more information that inheritance doesn't allow you to access.

public class WebEventListener extends TestBase implements WebDriverEventListener {

public void beforeNavigateTo(String url, WebDriver driver) {
System.out.println("Before navigating to: '" + url + "'");
}

public void afterNavigateTo(String url, WebDriver driver) {
System.out.println("Navigated to:'" + url + "'");
}

public void beforeChangeValueOf(WebElement element, WebDriver driver) {
System.out.println("Value of the:" + element.toString() + " before any changes made");
}

public void afterChangeValueOf(WebElement element, WebDriver driver) {
System.out.println("Element value changed to: " + element.toString());
}

public void beforeClickOn(WebElement element, WebDriver driver) {
System.out.println("Trying to click on: " + element.toString());
}

public void afterClickOn(WebElement element, WebDriver driver) {
System.out.println("Clicked on: " + element.toString());
}

public void beforeNavigateBack(WebDriver driver) {
System.out.println("Navigating back to previous page");
}

public void afterNavigateBack(WebDriver driver) {
System.out.println("Navigated back to previous page");
}

public void beforeNavigateForward(WebDriver driver) {
System.out.println("Navigating forward to next page");
}

public void afterNavigateForward(WebDriver driver) {
System.out.println("Navigated forward to next page");
}

public void onException(Throwable error, WebDriver driver) {
System.out.println("Exception occured: " + error);
try {
TestUtilities.takeScreenshotAt();
} 

catch (IOException e)
{
e.printStackTrace();
}
}

public void beforeFindBy(By by, WebElement element, WebDriver driver) 
{
System.out.println("Trying to find Element By : " + by.toString());
}

public void afterFindBy(By by, WebElement element, WebDriver driver) 
{
System.out.println("Found Element By : " + by.toString());
}

/*
* non overridden methods of WebListener class
*/

//These are non-overridden methods of the WebListener class.
//We are performing these actions only once, so we don't need to override.

public void beforeScript(String script, WebDriver driver) 
{
	
}

public void afterScript(String script, WebDriver driver) 
{
}

public void beforeAlertAccept(WebDriver driver) 
{
// TODO Auto-generated method stub

}

public void afterAlertAccept(WebDriver driver) 
{
// TODO Auto-generated method stub

}

public void afterAlertDismiss(WebDriver driver) 
{
// TODO Auto-generated method stub

}

public void beforeAlertDismiss(WebDriver driver) 
{
// TODO Auto-generated method stub

}

public void beforeNavigateRefresh(WebDriver driver) 
{
// TODO Auto-generated method stub

}

public void afterNavigateRefresh(WebDriver driver) 
{
// TODO Auto-generated method stub

}

public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend)
{
// TODO Auto-generated method stub

}

public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) 
{
// TODO Auto-generated method stub

}

//<X> makes it more dynamic!
public <X> void afterGetScreenshotAs(OutputType<X> arg0, X arg1) 
{
// TODO Auto-generated method stub

}

public void afterGetText(WebElement arg0, WebDriver arg1, String arg2) 
{
// TODO Auto-generated method stub

}

public void afterSwitchToWindow(String arg0, WebDriver arg1) 
{
// TODO Auto-generated method stub

}

public <X> void beforeGetScreenshotAs(OutputType<X> arg0) 
{
// TODO Auto-generated method stub

}

public void beforeGetText(WebElement arg0, WebDriver arg1) 
{
// TODO Auto-generated method stub

}

public void beforeSwitchToWindow(String arg0, WebDriver arg1) 
{
// TODO Auto-generated method stub

}

}