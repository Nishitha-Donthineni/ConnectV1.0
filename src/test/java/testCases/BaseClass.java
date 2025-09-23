package testCases;

import java.io.File;


import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

    public class BaseClass {
	public  WebDriver driver;
	
	public Logger logger;	
	public  Properties p;
	@BeforeClass(groups= {"Sanity","Regression","Master","Sanity2"}, alwaysRun = true)
	@Parameters({"os","browser"})
	public void setup(String os, String br) throws IOException 
	{
	    // Load config.properties
	    FileReader file = new FileReader(System.getProperty("user.dir") + "/src/test/resources/Config.properties");
	    p = new Properties();
	    p.load(file);

	    logger = LogManager.getLogger(this.getClass());

	    // Get environment from Jenkins/Maven parameter; default to 'qa' if not set
        String env = System.getProperty("env", "qa"); // dev / qa / prod

        // Get URL, email, and password for the selected environment
        String url = p.getProperty(env + ".URL");
        String email = p.getProperty(env + ".EmailId");
        String password = p.getProperty(env + ".Password");

        if (url == null || email == null || password == null) {
            throw new IllegalArgumentException("Missing configuration for environment: " + env);
        }

        logger.info("URL: " + url);
        logger.info("Email: " + email);

	    // Get execution environment (local/remote)
	    String executionEnv = p.getProperty("execution_environment");

	    // Remote execution
	    if (executionEnv.equalsIgnoreCase("remote")) {
	        URL gridUrl = new URL("http://localhost:4444/wd/hub"); 
	        switch (br.toLowerCase()) {
	            case "chrome":
	                driver = new RemoteWebDriver(gridUrl, new ChromeOptions());
	                break;
	            case "firefox":
	                driver = new RemoteWebDriver(gridUrl, new FirefoxOptions());
	                break;
	            case "edge":
	                driver = new RemoteWebDriver(gridUrl, new EdgeOptions());
	                break;
	            default:
	                throw new IllegalArgumentException("Browser not supported: " + br);
	        }
	    }

	    // Local execution
	    if (executionEnv.equalsIgnoreCase("local")) {
	        switch (br.toLowerCase()) {
	            case "chrome":
	                driver = new ChromeDriver();
	                break;
	            case "edge":
	                System.setProperty("webdriver.edge.driver", "D:\\software\\new driver\\edgedriver\\msedgedriver.exe");
	                driver = new EdgeDriver();
	                break;
	            case "firefox":
	                System.setProperty("webdriver.gecko.driver", "D:\\software\\new driver\\firefoxdriver\\geckodriver.exe");
	                driver = new FirefoxDriver();
	                break;
	            default:
	                throw new IllegalArgumentException("Invalid browser: " + br);
	        }
	    }

	    // Browser setup
	    driver.manage().deleteAllCookies();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	    driver.get(url);
	    driver.manage().window().maximize();
	}

	
	
	 
	 
	 @AfterClass(groups= {"Sanity","Regression","Master","Sanity2"},alwaysRun = true)
	 public void teardown() 
	 {
		 driver.quit();
	 }

	 public String  randomString() 
     {
       String generatedstring =RandomStringUtils.randomAlphabetic(5);
       return generatedstring;
     }
	
     public String  randomString2() 
     {
       String generatedstringlastnum =RandomStringUtils.randomAlphabetic(1);
       return generatedstringlastnum;
     }
	
	public String randomNumber() 
	{
		 String generatednumber =RandomStringUtils.randomNumeric(6);
	       return generatednumber;
	}
	
	
	public String captureScreen(String tname) 
	
	{
		String timeStamp= new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		TakesScreenshot takesScreenshot = ((TakesScreenshot) driver);
	    File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
	    
	    String targetFilePath = System.getProperty("user.dir")+"\\screenshots\\"+ tname + "_" + timeStamp +".png";
	    File targetFile = new File(targetFilePath);
	    
	    
	    sourceFile.renameTo(targetFile);
	    
	    return targetFilePath;

	}
		
}
