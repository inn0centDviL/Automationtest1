package com.ap.au.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.ap.au.utilities.TestUtilities;
import com.ap.au.utilities.WebEventListener;

public class TestBase //Blueprint of the class 
{
	//setting up the property values
	public static WebDriver driver;
	public static Properties propt; // properties that links all the utility 
	public static EventFiringWebDriver en_driver; // initiates/kick-starts the webdriver
	public static WebEventListener eventListener; // captures the info and sends it to extent reporting
	
	public TestBase() // constructor - object that is being invoked (same name of class)
						// Doesn't initialize objects or codes, only ERROR handling. 
	{
		//captures an error and avoids the error by throwing an exception
		try 
		{
			//creating object for the properties file
			propt = new Properties();
			
			//finds the path of the properties and reads the file 
			//system.getproperty here because we are retrieving data from somewhere
			FileInputStream ipa = new FileInputStream(System.getProperty("user.dir") + "//Automationtest1//src//main//java//com//ap//au//config//config.properties");
			propt.load(ipa);	 //calling a file
		}
		
		catch (FileNotFoundException e) 
		{
			e.printStackTrace(); // print out all the description of the error 
		}
		
		catch (IOException e) 
		{
			e.printStackTrace();   
		}
	}
	
	public static void initialization() //another object that is being invoked
	//any void is a method
	{
		String browserName = propt.getProperty("browser"); //getting browser from config file
		
		if (browserName.equalsIgnoreCase("chrome")) 
		{
			//system.setproperty because we are NOT retrieving any data from the webdriver
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//src//resources//drivers//chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		//expanding our browser matrix
		else if (browserName.equalsIgnoreCase("FF"))
		{
			System.setProperty("webdriver.gecko.driver", "");
			driver = new FirefoxDriver ();
		}
		
		else if (browserName.equalsIgnoreCase("IE"))
		{
			System.setProperty("Webdriver.ie.driver", "");
			driver = new InternetExplorerDriver();
		}
		
		//en_driver deals with all the events, and driver object deals with webdriver 
		//creating object for action that's occurring and sharing with driver
		en_driver = new EventFiringWebDriver(driver);
		
		//captures events and tells us if it passes, fails, or skips
		//creating object of WebEventListener to register with eventFiringWebdriver
		eventListener = new WebEventListener(); 
		
		//event can be captured based on the method we create WebEventListener class
		en_driver.register(eventListener);
		
		/*since our driver object is for browser, and  en_driver is for event that's taking place. 
		 * we're declaring that they are equal to each other when they are exchanging the info. */
		driver = en_driver;
		
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		
		//waiting 10 seconds as mentioned in TestUtilities
		driver.manage().timeouts().implicitlyWait(TestUtilities.Implicit_Wait, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtilities.Page_Load, TimeUnit.SECONDS);
		
		//getting url from the config.property
		driver.get(propt.getProperty("url"));
		
		
	}
}
