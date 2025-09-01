package pageObjects;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{


 public LoginPage(WebDriver driver)
 {
	 super(driver);
	// PageFactory.initElements(driver,this);
	
 }
	//Account Login
	@FindBy(id="email")
	WebElement userName;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(id="LoginBtn")
	WebElement Login;
	
	@FindBy(xpath="//h4[contains(text(),'Welcome ')]")
	WebElement welcomeMessage;
	
	public void setUserName(String userId)
	{
		userName.sendKeys(userId);
	}
	public void setpassword(String password1)
	{
		password.sendKeys(password1);
	}
	
    public void LoginButton()
    {
    	
    	Login.click();
    }
    
    
    public String getConfirmationMsg()
    {
    	try {
    		return(welcomeMessage.getText());
    	    }
    	catch(Exception e)
    	  {
    	    return(e.getMessage());
    	  }
    }
    
    
  
}
