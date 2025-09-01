package testCases;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.ClientsPage;
import pageObjects.LoginPage;

public class TC_Addclient_01 extends BaseClass
{
	
	@Test(groups={"Regression","Master"})
	public void createClients() 
	{
       
		LoginPage login = new LoginPage(driver);
    	login.setUserName(p.getProperty("EmailId"));
		login.setpassword(p.getProperty("Password"));
		login.LoginButton();
		
	   	String message= login.getConfirmationMsg();
		Assert.assertTrue(message.contains("Welcome "));
		
		//Clients page
		 logger.info("starting creating client");
		ClientsPage clients = new ClientsPage(driver);
		clients.ClientsModule();
		clients.createclient();
		clients.setclientName(randomString());
		clients.setphone(randomNumber());
		clients.setinvoiceemail(randomString()+"@gmail.com");
		clients.setaddress("Europe");
		clients.setaddressline1("cragwood village,suite no 1");
		clients.country();
		clients.State();
		clients.setcity("Texas");
		clients.setzipcode(randomNumber());
		clients.save();
		logger.info("client created successfully");
	
	}
}
/*//New Project

	@FindBy(xpath="//span[text()='Projects']")
	WebElement ProjectsModule;
  @FindBy(xpath="//div[contains(text(),'Select a criteria to display projects')]")
	WebElement ProjectsModuleHeader;
	@FindBy(xpath="btnProject")
	WebElement Newproject;
	
	//	New Client
	@FindBy(xpath="//span[@id='anc_Project' and @title='Create New Client/Vendor']")
	WebElement Createnewclient;
	@FindBy(id="createclient")
	WebElement createclientslider;
	@FindBy(id="txtClientname")
	WebElement NewClient;
	@FindBy(id="txtprojectinvoiceEmail")
	WebElement InvoiceEmail;
	@FindBy(id="txtfriendlyaddressname")
	WebElement Addressname;
	@FindBy(xpath="txtprojClientStreet")
	WebElement AddressclientName;
	@FindBy(id="s2id_ddlCountryproject")
	WebElement country;
	@FindBy(id="s2id_ddlCountryproject")
	WebElement selectcountry;
	@FindBy(id="s2id_ddlState")
	WebElement state;
	@FindBy(id="ddlState")
	WebElement selectstate;
  @FindBy(id="txtprojClientCity")
	WebElement city;
	@FindBy(id="txtprojectclientzipcode")
	WebElement zipcode;
	@FindBy(id="txtprojectname")
	WebElement Project;
	@FindBy(id="txtProjStartDate")
	WebElement projectstartdate;
	@FindBy(id="txtProjEnddate")
	WebElement projectEnddate;
	@FindBy(id="ddladdressnames")
	WebElement projectaddress;
	@FindBy(id="btnSaveClientProjectnew")
	WebElement saveproject;
	@FindBy(xpath="//div[text()='Project Saved Successfully.']")
	WebElement projectsavepopup;
	@FindBy(id="//button[@class='btn btn-green' and text()='Yes']")
	WebElement yesButton;
	@FindBy(xpath="//button[text()='NO']")
	WebElement noButton;
	
	
	@FindBy(id="btnsaveClientfromProjects")
	
	//New User
	WebElement createUser;
	@FindBy(id="userdetails")
	WebElement userslider;
	@FindBy(id="txtfirstname")
	WebElement userfirstname;
	@FindBy(id="txtlastname")
	WebElement userlastname;
	@FindBy(id="txtpersonalemail")
	WebElement userpersonalemail;
	@FindBy(id="txtworkemail")
	WebElement userworkemail;
	@FindBy(id="s2id_ddledituserrole")
	WebElement userrole;
	@FindBy(id="ddledituserrole")//Consultant
	WebElement userroleselect;
	@FindBy(id="txtaddress1")
	WebElement useraddress;
	@FindBy(id="lbltxtcity")
	WebElement usercity;
	@FindBy(id="s2id_ddlusercountry")
	WebElement usercountry;
	@FindBy(id="ddlusercountry")//United States
	WebElement usercountryselect;
	@FindBy(id="s2id_ddluserstate")//New York [NY]
	WebElement userstate;
	@FindBy(id="ddluserstate")
	WebElement userstateselect;
	@FindBy(id="textzipcode")
	WebElement employeezipcode;
	@FindBy(id="txtemploystartdate") //mm/dd/yyyy
	WebElement save;
	@FindBy(id="rbluserrojecttype_Emp")
	WebElement sertype;
	@FindBy(id="btnassignprojectsave")
	WebElement usersave;
	
	//Time sheet details
	@FindBy(id="s2id_ddltimecard")
	WebElement timesheet;
	@FindBy(id="ddltimecard")
	WebElement timesheetselect;//Monthly
	@FindBy(id="s2id_ddlprofitcenter")
	WebElement profitcenter;//TAR
	@FindBy(id="ddlprofitcenter")
	WebElement profitcentrecodeselect;
	
	
	//Invoice details
	@FindBy(id="s2id_ddlinvoice")
	WebElement invoice;
	@FindBy(id="ddlinvoice")//Monthly
	WebElement invoicescheduleselect;
	@FindBy(id="s2id_ddlpayterm")
	WebElement paymenttermype;
	@FindBy(id="ddlpayterm")
	WebElement paymenttermypeselect;//Net 30
	
	
	//client details
	@FindBy(id="txtAssignprojbillclient")
	WebElement billingclient;
	@FindBy(id="//div[@id='btnAssignprojbillclient' and @title='Search']")//enterNishitha D
	WebElement search;
	@FindBy(id="(//a[normalize-space()='Nishitha D'])[1]")
	WebElement client;
	@FindBy(id="s2id_ddlbillingaddress")
	WebElement billingaddress;
	@FindBy(id="ddlbillingaddress")//Value//12837
	WebElement billingaddressselect;
	@FindBy(id="s2id_ddlprojectaddress")
	WebElement projectlocation;
	@FindBy(id="ddlprojectaddress")//select first selected address
	WebElement projectlocationselect;
	*/