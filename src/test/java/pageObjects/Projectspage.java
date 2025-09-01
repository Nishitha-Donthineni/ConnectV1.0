package pageObjects;

import java.time.Duration;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Projectspage extends BasePage

{
	public Projectspage (WebDriver driver) 
	{
	super(driver);
	}

	//New Project
	
	@FindBy(xpath="//span[text()='Projects']")
	WebElement ProjectsModule;
    @FindBy(xpath="//div[contains(text(),'Select a criteria to display projects')]")
	WebElement ProjectsModuleHeader;
	@FindBy(id="btnProject")
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
	@FindBy(id="txtprojClientStreet")
	WebElement clientaddressName;
	@FindBy(id="s2id_ddlCountryproject")
	WebElement country;
	@FindBy(id="ddlCountryproject")
	WebElement selectcountry;
	@FindBy(id="s2id_ddlState")
	WebElement states;
	@FindBy(id="ddlState")
	WebElement selectstate;
    @FindBy(id="txtprojClientCity")
	WebElement City;
	@FindBy(id="txtprojectclientzipcode")
	WebElement Zipcode;
	@FindBy (xpath="//a[@id='btnsaveClientfromProjects']")
	WebElement SAVECLIENT;

	
	//New project
	@FindBy(id="txtprojectname")
	WebElement Project;
	@FindBy(id="txtProjStartDate")
	WebElement Projectstartdate;
	@FindBy(id="txtProjEnddate")
	WebElement ProjectEnddate;
	
	//create address
	@FindBy(xpath="//span[@title='Create Address']")
	WebElement projectaddress;
	@FindBy(id="txtfriendlyaddress")
	WebElement addaddress;
	@FindBy(xpath="//input[@id='txtaddress1']")
	WebElement address1;
	@FindBy(id="s2id_ddlclientcounrty")
	WebElement country1;
	@FindBy(id="ddlclientcounrty")//United States
	WebElement country1select;
	@FindBy(id="s2id_ddlclientstate")
	WebElement state1;
	@FindBy(id="ddlclientstate")//New York [NY]
	WebElement state1select;
	@FindBy(id="txtcity")
	WebElement city1;
	@FindBy(id="txtzipcode")
	WebElement zipcode1;
	@FindBy(xpath="//a[@id='ancbtnsave']")
	WebElement saveaddress;
	//div[contains(@class,'zselect')]
	@FindBy(xpath="//div[contains(@class,'zselect')]")
	WebElement addressselect;
	@FindBy(id="ddladdressnames")
	WebElement addressdd;
	@FindBy(xpath="//span[contains(text(),'Please Select')]")
	WebElement AddressNames;
	@FindBy(xpath="//span[contains(text(),'Suite')]//preceding-sibling::input")
	WebElement Addressselection;
	
	//Save project 
	
	@FindBy(id="btnSaveClientProjectnew")
	WebElement saveproject;
	/* @FindBy(xpath = "//span[contains(text(),'Project Saved Successfully.')]")
	  public WebElement PjSaveSuccessfully;
	  @FindBy(xpath = "//button[contains(text(),'Yes')]")
	  public WebElement YesBtn;*/
	@FindBy(xpath="//span[contains(text(),'Project Saved Successfully.')]")
	WebElement projectsavepopup;
	//Add user
	@FindBy(id="//button[contains(text(),'Yes')]")
	WebElement yesButton;
	
	@FindBy(xpath="//button[text()='NO']")
	WebElement noButton;
	@FindBy(id="btnsaveClientfromProjects")
	WebElement ab;
	
	//New User
	@FindBy(id="liAssignedUsers")
	WebElement Assignuserheader;
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
	
	
	
	public void projectmodule()
	{ 
		Actions a = new Actions(driver);
	  a.moveByOffset(0,150).build().perform();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		 wait.until(ExpectedConditions.elementToBeClickable(ProjectsModule));
		 ProjectsModule.click();
		 wait.until(ExpectedConditions.visibilityOf(ProjectsModuleHeader));
	}
	
	public void project() 
	{
		Newproject.click();
		
	}
	public void newclient() 
	{   
		Createnewclient.click();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(createclientslider));
		
		
	}
	public void setclientname(String client)
	{
		NewClient.sendKeys(client);
	}
	public void setinvoiceemail(String EMAIL)
	{
		InvoiceEmail.sendKeys(EMAIL);
	}
	public void setaddress(String address)
	{
		Addressname.sendKeys(address);
	}
	public void setclientaddress(String clientaddress)
	{
		clientaddressName.sendKeys(clientaddress);
	}
	public void country()
	{
		country.click();
		Select COUNTRY= new Select(selectcountry);
		COUNTRY.selectByValue("1");
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.ESCAPE).perform();

		
		
		
	}
	public void state()
	{   WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
	    wait.until(ExpectedConditions.visibilityOf(states));
		//states.click();
		Select state= new Select(selectstate);
		state.selectByVisibleText("New York [NY]");
	}
	public void setcity(String city)
	{
		City.sendKeys(city);
	}
	public void setzipcode(String zipcode)
	{
		Zipcode.sendKeys(zipcode);
		
	}
	
	public void saveclient() throws InterruptedException
	{
		
		SAVECLIENT.click();
		}
	public void sliderclose() 
	{
	
	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	 wait.until(ExpectedConditions.invisibilityOf(createclientslider));
	    
	}

	
	public void setnewProject(String projectcreating)
	{
	 
		Project.sendKeys(projectcreating);
	}
	
	public void setProjectstartdate(String projectstartdate)
	{
	 
		Projectstartdate.sendKeys(projectstartdate);
	}
	
	public void setProjectEnddate(String projectenddate)
	{
	 
		ProjectEnddate.sendKeys(projectenddate);
	}
	
	public void Projectaddress()
	{
	   
		projectaddress.click();
		
	}
	public void setaddressnew(String addressnew) 
	{
		addaddress.sendKeys(addressnew);
	}
	
	public void setaddressname1(String addressnameone) 
	{
		Actions actions = new Actions(driver);
		actions.moveToElement(address1).click().sendKeys(addressnameone).build().perform();

	}
	public void country1()
	{
		country1.click();
		Select country1 = new Select(country1select);
		country1.selectByVisibleText("United States");
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.ESCAPE).perform();
	}
	public void state1()
	{
		state1.click();
		Select state1 = new Select(state1select);
		state1.selectByVisibleText("New York [NY]");
				
	}
	public void setcity1(String cityone) 
	{
		city1.sendKeys(cityone);
	}
	public void setzipcode1(String zipcodeone) 
	{
		zipcode1.sendKeys(zipcodeone);
	}
	
	public void saveaddress() throws InterruptedException 
	{
		saveaddress.click();
		Thread.sleep(2000);
	}
	public void setprojectlocation() 
	{   
		AddressNames.click();
		Addressselection.click();
		/*Select addressdropdown = new Select (addressdd);
		addressdropdown.selectByVisibleText("Suite5");*/
	}
	public void save() 
	{
		saveproject.click();
	}
	public void Assignuserpopup()
	{
		 WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(projectsavepopup));
		 yesButton.click();
		 wait.until(ExpectedConditions.visibilityOf(Assignuserheader));
		
	}
  
	


}










































































