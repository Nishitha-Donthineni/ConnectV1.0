package pageObjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserPage extends BasePage{
	
	
	public UserPage(WebDriver driver)
	{
		super(driver);
	}

	//New users
	//General Information
	
	@FindBy(xpath="//i[@class='fa fa-users']")
	 WebElement UserModule;
	
	@FindBy(xpath="//div[contains(text(),'Select a criteria to display users')]")
	 WebElement userHeader;
	@FindBy(id="spnusercreate")
	 WebElement newUser;
	@FindBy(id="txtfirstname")
	 WebElement firstName;
	@FindBy(id="LNameField")
	 WebElement lastName;
	@FindBy(xpath="//div[@id='divddlrolesassigned']/div/a")
	 WebElement AssignRole;
	@FindBy(xpath="//div[text()='Consultant']")
	 WebElement Consultant;
	@FindBy(xpath = "//div[contains(text(),'Staff')]")
	 WebElement Staff;
	@FindBy(name = "WorkEmailField")
	 WebElement workemailId;
	@FindBy(id="PersonalEmailField")
	 WebElement personalEmailID;
	@FindBy(id="Address1Field")
	 WebElement addressField;
	@FindBy(id="CityField")
	 WebElement cityField;
	@FindBy(id="ddlcountry")
	 WebElement country;
    @FindBy(xpath="//span[text()='United States']")
     WebElement unitedStates;
	@FindBy(id="ddlStatemail")
	 WebElement States;
	@FindBy(xpath="//option[contains(text(),'California [CA]')]")
	 WebElement California;
	@FindBy(id="txtmailzip")
	 WebElement zipcode;
	@FindBy(id="rblusertype_Emp")
	 WebElement consultant;
	@FindBy(id="userNext")
	 WebElement nextButton;
	
	
	
	//Staff only
	@FindBy(id = "ddlusertype")
	 WebElement UserType;
	@FindBy(id="txtstartdate")
	 WebElement startDate;
	
	

	  //Immigration Info
	 @FindBy(id="txtPasspostNumber")
	  WebElement PassportNumber;
	 @FindBy(id="txtPassportStartdate")
	   WebElement PassportStartDate;
	 @FindBy(id="txtPassportEnddate")
	  WebElement PassportEndDate;
	 @FindBy(xpath="//a[contains(text(),'Finish')]")
	  WebElement FinishButton;
	

	
     public void usermoduleclick()
     {
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
	 wait.until(ExpectedConditions.elementToBeClickable(UserModule));
	 UserModule.click();
	 wait.until(ExpectedConditions.visibilityOf(userHeader));
	 
     }
	
	
	public void newuser() 
	{
    
	  newUser.click();
	}
	
	public void setFirstName(String fname) 
	{
	  firstName.sendKeys(fname);
	}
	public void setLastName(String LName)
	{
		 lastName.sendKeys(LName);
	}
	  
	public void AssignRole() 
	{
	  AssignRole.click();
	  Consultant.click();
    }
	public void setworkemailId(String workemail)
	{
	  workemailId.sendKeys(workemail);
	}
	public void setpersonalemailId(String personalemail)
	{
	  personalEmailID.sendKeys(personalemail);
	}
	
	public void setaddressField(String Address) 
	{
	  addressField.sendKeys(Address);
    }
	 public void setcity(String City) 
	 {
	   cityField.sendKeys(City);
	 }
	 public void country() 
	 {
	 // country.click();
	  Select US = new Select(country);
	  US.selectByValue("1");
	 // unitedStates.click();
	  }
	 public void states() 
	 {
	   //States.click();
	   Select california = new Select(States);
	   california.selectByValue("5");
	   
	 // California.click();
	 }
	 
	 public void setzipcode(String Zipcode) 
	 {
	  zipcode.sendKeys(Zipcode);
	  }
	 public void consultant() 
	 {
	  consultant.click();
	 }
	 public void next() {
	  JavascriptExecutor js = ((JavascriptExecutor)driver);
	   js.executeScript("window.scrollBy(0,1000)");
	 
	  WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(3));
	  wait.until(ExpectedConditions.elementToBeClickable(nextButton)).click();
	  wait.until(ExpectedConditions.visibilityOf(startDate));
	  }
	  
	  //staff only
	 public void setstartdate(String startdate) 
	 {
	//  UserTypeInStaffOnly.click();
		 Select employee = new Select(UserType);
		 employee.selectByVisibleText("Employee");
		 
	  Actions a = new Actions(driver);
	  a.moveToElement(startDate).build().perform();
	  startDate.sendKeys(startdate);
	  }
	 public void setpassportno(String passport) 
	 {
		  PassportNumber.sendKeys(passport);
	 }
	 public void setpassportstartdate(String passportstartdate) 
	 {
		 PassportStartDate.sendKeys(passportstartdate);
	 }
	 public void setpassportenddate(String passportenddate) 
	 {
		 PassportStartDate.sendKeys(passportenddate);
	 }
	 public void finish()
	 {
	  FinishButton.click();
	  }
	 public void headercheck() 
	 {
      WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(3)); 
	  wait.until(ExpectedConditions.visibilityOf(userHeader));
	 }
	  
	  
	  
	
	
	
	
	
}
