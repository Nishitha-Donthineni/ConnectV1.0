package utilities;


import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.ImageHtmlEmail;
import org.apache.commons.mail.resolver.DataSourceUrlResolver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testCases.BaseClass;

public class ExtentReportManager implements ITestListener
{
  
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	String reportName;
	
	public void onStart(ITestContext testContext)
	{
		/*SimpleDateFormat df = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
		Date dt= new Date();
		String currentdatetimestamp= df.format(dt);*/
		
		//Another way of creating time stamp
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		
		
		reportName="Test-Report" + timeStamp + ".html";
		sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"/reports//"+reportName);
		sparkReporter.config().setDocumentTitle("Connect Automation Report");
		sparkReporter.config().setReportName("Connect Functional Testing");
		sparkReporter.config().setTheme(Theme.DARK);
		
		
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Application", "Connect");
		extent.setSystemInfo("module", "Login");
		extent.setSystemInfo("subModule", "Users");
		extent.setSystemInfo("UserName",System.getProperty("user.name"));
		extent.setSystemInfo("Environment","QA");
		
		
		String os = testContext.getCurrentXmlTest().getParameter("os");
		extent.setSystemInfo("Operating System", os);
		
		String browser = testContext.getCurrentXmlTest().getParameter("browser");
		extent.setSystemInfo("Browser", browser);
		
		List <String> includedGroups = testContext.getCurrentXmlTest().getIncludedGroups();
		if(!includedGroups.isEmpty()) //If non group.xml file is executed
		{
			extent.setSystemInfo("Groups", includedGroups.toString());
		}
		
		
	}	
	
	public void onTestSuccess(ITestResult result)
	{
		
		test= extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups()); //to display groups in report
		test.log(Status.PASS, result.getName()+"got successfully executed");
		
	}
	public void onTestFailure(ITestResult result)
	{
		
		test= extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups()); //to display groups in report
		test.log(Status.FAIL, result.getName()+"got failed");
		test.log(Status.INFO, result.getThrowable().getMessage());
		
		try
		{
			String imgpath = new BaseClass().captureScreen(result.getName());
			test.addScreenCaptureFromPath(imgpath);
	    }
		catch( Exception e1)
		{
			e1.printStackTrace();
		}
		
	}
	
	
	public void onTestSkipped(ITestResult result) 
	{
		test = extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.SKIP, result.getName()+" Got skipped");
		test.log(Status.INFO, result.getThrowable().getMessage());
	}
	
	public void  onFinish(ITestContext testContext)
	{
		extent.flush();
		String pathOfExtentReport = System.getProperty("user.dir")+ "\\reports\\"+ reportName;
		File extentReport = new File(pathOfExtentReport);
		
		try 
		{
			Desktop.getDesktop().browse(extentReport.toURI());
			
		}
		catch(IOException e) 
		{
			e.printStackTrace();
		}
		
	}
	
    /*	try 
	{
		URL url = new URL("file:///"+System.getProperty("uer.dir")+"\\reports\\"+reportName);
		// create the email message
		ImageHtmlEmail email = new ImageHtmlEmail();
		email.setDataSourceResolver(new DataSourceUrlResolver(url));
		email.setHostName("smtp.googleemail.com");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator("nishitha.connect@gmail.com","Nishitha@22 "));
		email.setSSLOnConnect(true);
		email.setFrom("nishitha.connect@gmail.com"); //Sender
		email.setSubject("Test Results");
		email.setMsg("please find attached report");
		email.addTo("nishtha.vultus@gmail.com"); //Receiver
		email.attach(url, "extent Report", "please check report ");
		email.send();
	
	
	}
	catch(Exception e) 
	{
		e.printStackTrace();
	}
	*/
	
}
