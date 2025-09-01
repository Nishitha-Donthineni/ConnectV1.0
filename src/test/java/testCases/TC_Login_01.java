package testCases;


import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginPage;

public class TC_Login_01 extends BaseClass
 
 {
	
	
       @Test(groups={"Sanity", "Master"},alwaysRun = true)
	 
	 public void Login()
	 {
		 LoginPage login = new LoginPage(driver);
		 login.setUserName(p.getProperty("EmailId"));
		 login.setpassword(p.getProperty("Password"));
		 login.LoginButton();
	
		String message= login.getConfirmationMsg();
		Assert.assertTrue(message.contains("Welcome "));
	
	 }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
  }
