package testCases;

import org.apache.commons.lang3.RandomStringUtils;



import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import pageObjects.UserPage;

public class TC_AddUser_01 extends BaseClass
{
 
 @Test(groups={"Regression","Master"})
   public void createUser()
     {
    
	  logger.info("Starting TC_AddUser_01");

 	 String env = System.getProperty("env");
		 LoginPage login = new LoginPage(driver);
		 if (env == null || env.isEmpty()) 
		 throw new IllegalArgumentException("Environment not specified. Pass it via -Denv=<dev|qa|prod>");
		 String email = p.getProperty(env + ".EmailId");
		 String password = p.getProperty(env + ".Password");
		 if (email == null || password == null) 
		 throw new IllegalArgumentException("Missing credentials for environment: " + env);
		 login.setUserName(email);
		 login.setpassword(password);
		 login.LoginButton();
   		String message= login.getConfirmationMsg();
		Assert.assertTrue(message.contains("Welcome "));
	    logger.info("Logged in successfully");
	
	
	
	    logger.info("Creating user");
	    try {
	    	UserPage user = new UserPage(driver);
	    	user.usermoduleclick();
	        user.newuser();
	        user.setFirstName(randomString().toUpperCase());
	        user.setLastName(randomString2());
	        user.AssignRole();
	        user.setworkemailId(randomString()+"@gmail.com");
	        user.setpersonalemailId(randomString()+"@gmail.com");
	        user.setaddressField("suite no 2,cragwoord");
	        
	        user.setcity("canada");
	        user.country();
	        user.states();
	        user.setzipcode(randomNumber());
	        user.consultant();
	        user.next();
	        user.setstartdate("01/01/2025");
	        user.setpassportno("232487050");
	        user.setpassportstartdate("01/01/2025");
	        user.setpassportenddate("01/31/2025");
	        user.finish();
	        user.headercheck();
	        logger.info("user created");
	        
		    }
		    
	    catch(Exception e)
	    {
	    	 e.printStackTrace();
	    	 logger.error("Test failed2");
		     logger.debug("Debug logs2");
	    	 Assert.fail();
	    }
	  
	         logger.info("Finished execution of TC_AddUser_01");
	  
	  
	}
	
   
}
