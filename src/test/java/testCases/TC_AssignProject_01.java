package testCases;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import pageObjects.Projectspage;

public class TC_AssignProject_01 extends BaseClass 
{

	@Test(groups={"Sanity2"})

	
	public void assignproject() throws InterruptedException 
	
	{
	 	logger.info("Starting TC_login_01");
	  
	  
		 LoginPage login = new LoginPage(driver);
		 login.setUserName(p.getProperty("EmailId"));
		 login.setpassword(p.getProperty("Password"));
		 login.LoginButton();

		String message= login.getConfirmationMsg();
		Assert.assertTrue(message.contains("Welcome "));
	    logger.info("Logged in successfully");
    
    
       logger.info("starting TC_AssignProject_01");
		Projectspage project = new Projectspage(driver);
		project.projectmodule();
		project.project();
		project.newclient();
		project.setclientname(randomString());
		project.setinvoiceemail(randomString()+"@gmail.com");
		project.setaddress(randomString());
		project.setclientaddress(randomString());
		project.country();
		project.state(); 
		project.setcity(randomString());
		project.setzipcode(randomNumber());
		logger.info("Attempting to click Save Client button.");
		project.saveclient();
		logger.info("Clicked Save Client button.");
		try
		{
			project.sliderclose();
		   logger.info("Client slider closed - save likely successful.");
		}
		catch(Exception e)
		{
			logger.warn("Client slider did not close - client may not have been saved.");
		
		   logger.error("saving client failed");
		   logger.debug("debug clientsavelogs");
		   Assert.fail("Client save failed: slider did not close. Error: " + e.getMessage());
		}
		project.setnewProject(randomString());
		project.setProjectstartdate("01/01/2025");
		project.setProjectEnddate("12/31/2025");
		project.Projectaddress();
		project.setaddressnew("Suite5");
		
		try{
			project.setaddressname1(randomString());
			logger.info("address created");
		}
		catch (Exception e)
		{
		
		logger.warn("address not created");
		logger.error("address creation failed");
		logger.debug(" check Address");
		Assert.fail("address one not created Error : "+e.getMessage() );
		
		}
		
		project.country1();
		project.state1();
		project.setcity1(randomString());
		project.setzipcode1(randomNumber());
		project.saveaddress();
	    project.setprojectlocation();
		project.save();
		project.Assignuserpopup();
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
