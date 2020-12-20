package HappyFox.test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import HappyFox.test.Utilities.ResultAssertion;
import HappyFox.test.Utilities.Utilities;


public class loginPage extends Base {
	
	
	@FindBy(id="id_username")
	WebElement UsernameField;
	
	@FindBy(id="id_password")
	WebElement PasswordField;
	
	@FindBy(className="smooth-button")
	WebElement LoginButton;
	
	@FindBy(xpath="//div[@Class='hf-staff-menu hf-u-vertically-centered-container hf-popover-trigger ember-view']/div")
	WebElement Account;
	
	@FindBy(xpath="//div[@Class='confirmation']")
	WebElement logoutconfirmation;
	
	String UserName=prop.getProperty("username");
	String Password=prop.getProperty("password");
	String url=prop.getProperty("url");
	
	String Expected= "View Tickets - HappyFox";
	String Confirmation= "Login Successfull";
	ResultAssertion RA;
	
	
	


public loginPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}




public void loginuser() {
	driver.get(url);
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	UsernameField.sendKeys(UserName);
	PasswordField.sendKeys(Password);
	
	LoginButton.click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	Account.isDisplayed();
	
	driver.navigate().refresh();
	String Actual=driver.getTitle();
	
	
	ResultAssertion.ValidateResult(Actual , Expected, Confirmation);
}



}
