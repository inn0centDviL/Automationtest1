package com.ap.au.ExtentReport.Listener;

import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReporterN implements IReporter //using interface IReporter
{
	//creating a private constructor and creating an object named extent
	//private only because we want to keep the results within this project
	private ExtentReports extent;
	
	/*creating a method that has 3 arguments: first and second - Creating List, and third - expects String)
	
	Sargil:
	Created a method with 3 arguments using mechanism named list (will have arrays), using xmlsuite (xml file 
	that will have class that contain loginpage, homepage, etc.), based on the results it will share the info 
	as String values with extent reports */
	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite>suites, String outputDirectory)
	{
		//Invoking the object "extent" and showing results(outputDirectory) 
		
		/*Creating virtual obejct where I will save all my output that are saved as String, which are my test results
		 * File Separator is not need if you run it on the same machine. It converts that slashes (Win has \, so mac
		 * might have /)
		 * The file will be saved as Extent.html
		 * Boolean only if there is any results that are generated. If not, then don't generate any results.
		 */
		extent = new ExtentReports(outputDirectory + File.separator+ "Extent.html", true);
	
		/* Map obtains an unique value(Pass, fail, skip for each of the classes we have) that is NOT a duplicate, 
		 * and it will map it to one location(extentreport)! Map is an interface in JAVA
		 * : will run one or the other suites
		*/
		for(ISuite suite : suites)
		{
		Map<String, ISuiteResult>result = suite.getResults();
	
		/* Nested for loop.
		 * It gets the results from the top line and gets the contexts and gives it a Logstatus
		 */
		for(ISuiteResult r : result.values())
		{
			ITestContext context = r.getTestContext();
		
			/* Once the results are obtained, it will login as Pass, Fail, or SKIP */
			buildTestNo(context.getPassedTests(), LogStatus.PASS);
			buildTestNo(context.getFailedTests(), LogStatus.FAIL);
			buildTestNo(context.getSkippedTests(), LogStatus.SKIP);
			
		}
		}
		
	//flush adds the results and attaches it to the html file.
	extent.flush();
	//closes the report
	extent.close();
	
	}
	
	//creating a private constructor 
	private void buildTestNo(IResultMap tests, LogStatus status)
	{
		ExtentTest test;
		
		/* if test are greater than zero, if the result equal you'll get method name
		 * 
		 */
		if(tests.size()>0)
		{
			for (ITestResult result : tests.getAllResults())
			{
				test = extent.startTest(result.getMethod().getMethodName());
				
				/* How long it took to get the results: Start time to end time
				*/
				test.setStartedTime(getTime(result.getStartMillis()));
				test.setEndedTime(getTime(result.getEndMillis()));
				
				//Going through all the results and organize the passes, fails and skips
				for(String group : result.getMethod().getGroups())
					test.assignCategory(group);
				
				//logs all errors and if not, it takes the the status and add "ed" at the end
				if(result.getThrowable() !=null)
				{
					test.log(status, result.getThrowable());
				}
				else
				{
					test.log(status, "Test" + status.toString().toLowerCase() + "ed");
					
				}
				extent.endTest(test);
				
			}
		}
	}
	
	//private constructor and it will stamp the local machine's start and end time
	private Date getTime(long millis)
	{
		Calendar calender = Calendar.getInstance();
		calender.setTimeInMillis(millis);
		return calender.getTime();
	}
	
}








