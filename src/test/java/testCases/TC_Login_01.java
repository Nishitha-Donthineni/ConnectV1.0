package testCases;


import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginPage;

public class TC_Login_01 extends BaseClass
 
 {
	
	
       @Test(groups={"Sanity", "Master"},alwaysRun = true)
	 
	 public void Login()
	 {
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
	
	 }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
  }
