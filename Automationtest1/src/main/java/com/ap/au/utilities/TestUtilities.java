//Lets us read all the info from an excel sheet

package com.ap.au.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.ap.au.base.TestBase;

//making a connection with the TestBase
public class TestUtilities extends TestBase
{
	public static long Page_Load = 10;
	public static long Implicit_Wait = 10;
	
	//excel sheet
	public static String XL_SHEET_PATH = "path of the xl sheet";
	
	//Go to Excel file
	static Workbook book;
	
	//Go to sheet within excel
	static org.apache.poi.ss.usermodel.Sheet sheet;
	
	//Created an object for JavaScriptExecutor
	static JavascriptExecutor js;
	
	//Added two arrays because we are only working with Username adn Password. If more info, we can add more
	//Created a method and made a String
	public static Object [] [] getTestData (String sheetName)
	{	
		//if there's no value within the excel sheet, don't perform the action
		FileInputStream file = null;
		
		//try and catch block to avoid the exception in a file level
		try
		{
			file = new FileInputStream(XL_SHEET_PATH);
		}
		
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		
		//try and catch block to avoid the exception in a workbook level
		try
		{
			book = WorkbookFactory.create(file);
		}
		
		catch (InvalidFormatException e)
		{
			e.printStackTrace();
		}
		
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		//Method that will go through the info in the excel sheet
		sheet = book.getSheet(sheetName);
		
		//Creating an array and holding info in the Object
		Object [] [] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		//Make sure everything is a String (just in case there are a mix of special characters, numbers, etc.)
		for (int i = 0; i < sheet.getLastRowNum(); i++)
		{
			for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++)
			{
				data [i] [j] = sheet.getRow(i + 1).getCell(j).toString();
			}
		}
		
		return data;
	}
	
	public static void takeScreenshotAt() throws IOException
	{
		//Screenshot method
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		//Creating the object currentDirect to set up the directory in the machine
		String currentDirect = System.getProperty("user.dir");
		
		//Directory, creating the folder screenshot, pasting the file you received into that folder, and 
		//	shows the time the screenshot was taken.
		FileUtils.copyFile(srcFile, new File(currentDirect + "/screenshot/" + System.currentTimeMillis() + ".png" ));
	}
	
	//jquery - used when developers are working with website. 
	//capturing everything (error message, title, etc.) that takes place 
	public static void runTimeInfo (String messageType, String message) throws InterruptedException
	{
		js = (JavascriptExecutor) driver;
		
		//Go find the JQuery on the website and translate whatever it is that is happening

		js.executeScript("if (!window.JQuery){"
				
				//saves the info it receives before translation
			  + "var jquery = document.createElement('script'); jquery.type = 'text/javascript';"
			  	//gets all the dependencies from the website
			  + "jquery.src = 'https://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js';"
			  	//translates the elements by tagname
			  + "document.getElementsByTagName('head')[0].appendChild(jquery);" + "}");
		Thread.sleep(2000);
		
		
		js.executeScript("$.getScript('https://the-internet.herokuapp.com/js/vendor/jquery.growl.js')");

	
		js.executeScript("$('head').append('<link rel=\"stylesheet\" "
				+ "href=\"https://the-internet.herokuapp.com/css/jquery.growl.css\" " + "type=\"text/css\" />');");
		Thread.sleep(3000);
		
		js.executeScript("$ growl({ title: 'GET'  , message: '/'});");
		
		
		//Created a logic for different scenarios
		if (messageType.equals("error"))
		{
			js.executeScript("$growl.error({ title: 'ERROR', message: '"+message+"'});");
		}
		
		else if (messageType.equals("info"))
		{
			js.executeScript("$growl.info({ title: 'Notice', message: 'your notice message will appear here'});");
		}
		
		else if (messageType.equals("warning"))
		{
			js.executeScript("$growl.warning({ title: 'Warning!!', message: 'your warning message will appear here'});");
		}
		
		else
		{
			System.out.println("Show No Error Message");
			Thread.sleep(6000);
		}
	}
	
}











