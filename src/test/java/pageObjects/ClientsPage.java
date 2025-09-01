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

public class ClientsPage extends BasePage
{
	
	public ClientsPage (WebDriver driver) 
	{
	super(driver);
	}

	//New client
	
	
	@FindBy(xpath="//span[contains(text(),'Clients/Vendors')]")
	WebElement ClientsModule;
	
	
	@FindBy(xpath="//div[contains(text(),'Select a criteria to display Clients/Vendors')]")
	WebElement ClientHeader;
	
	
	@FindBy(id="btnClient")
	WebElement NewClient;
	
	@FindBy(id="txtClientname")
	WebElement ClientName;
	
	@FindBy(id="txtPhone")
	WebElement phoneNumber;
	
	@FindBy(id="txtinvoiceEmail")
	WebElement InvoiceEmail;
	
	
	//Address
	
	@FindBy(id="txtfriendlyaddress")
	WebElement Address;
	
	@FindBy(id="txtaddress1")
	WebElement addressline1;
	
	
	@FindBy(id="ddlclientcounrty")
	WebElement Country;
	
	@FindBy(id="s2id_ddlclientstate")
	WebElement stateclick;
	@FindBy(id="ddlclientstate")
	WebElement state;
	
	@FindBy(id="txtcity")
	WebElement City;
	
	@FindBy(id="txtzipcode")
	WebElement Zipcode;
	
	
	@FindBy(xpath="//a[@id='divsave']")
	WebElement save;
	
	@FindBy(xpath="//div[contains(text(),'Client/Vendor created successfully. Do you want to add contact for this client/vendor?')]")
	WebElement clientsaveHeader;
	
	@FindBy(xpath="//button[contains(@class,'btn btn-green')]")
	WebElement YESButton;
	
	@FindBy(xpath="//button[text()='NO']")
	WebElement NoButton;
	
	
	public void ClientsModule()
	{
		 
		 Actions a = new Actions(driver);
		 a.moveByOffset(0,150).build().perform();
		
		 WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		 wait.until(ExpectedConditions.elementToBeClickable(ClientsModule));
		 ClientsModule.click();
		 wait.until(ExpectedConditions.visibilityOf(ClientHeader));
	
	}
	
	public void createclient()
	{
		NewClient.click();
	}
	
	public void setclientName(String clientname) 
	
	{
		ClientName.sendKeys(clientname);
	}
	
	public void setphone(String mobile) 
	
	{
		phoneNumber.sendKeys(mobile);
	}
	public void setinvoiceemail(String mailId) 

    {
	InvoiceEmail.sendKeys(mailId);

    }
	
    public void setaddress(String address) 
	
	{
    	Address.sendKeys(address);
    
	}
	
    public void setaddressline1(String addressline) 
	
	{
	addressline1.sendKeys(addressline);
    
	}
    
	public void country()
	
	{
		
		Select countrydd= new Select(Country);
	    countrydd.selectByVisibleText("United States");
	
	}
   public void State() 

    {
	   stateclick.click();
	   Select statedd= new Select(state);
	   statedd.selectByVisibleText("Connecticut [CT]");

    }
	public void setcity(String city) 
	
	{
		City.sendKeys(city);
	
	}
	public void setzipcode(String zipcode) 
	
	{
		Zipcode.sendKeys(zipcode);
	
	}

    public void save()
    {
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("window.scrollTo(0, 0)");
    	save.click();
    	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
    	wait.until(ExpectedConditions.visibilityOf(clientsaveHeader));
    	NoButton.click();
    	
    	wait.until(ExpectedConditions.visibilityOf(ClientHeader));
    	
    }
    
    
    
 
}
