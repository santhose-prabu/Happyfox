package HappyFox.test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import HappyFox.test.Utilities.Utilities;

public class CreateTicketPage extends Base {
	@FindBy(xpath="//label[contains(text(),'Subject')]/../div/input")
	WebElement Subject;
	
	@FindBy(xpath="//label[contains(text(),'Message')]/../div/div/div/div")
	WebElement Message;
	
	@FindBy(xpath="//input[@id='id_name']")
	WebElement FullName;
	
	@FindBy(xpath="//input[@id='id_email']")
	WebElement Email;
	
	@FindBy(xpath="//input[@id='id_phone']")
	WebElement Phone;
	
	@FindBy(xpath="//button[contains(text(),'Create Ticket')]")
	WebElement CreateButton;
	
	@FindBy(xpath="//div[@Class='hf-header_link']/a[contains(text(),'Agent Portal')]")
	WebElement AgentPortalButton;
	
	String A= prop.getProperty("url2");
	public static String Ticketname;
	
	public CreateTicketPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	
	public void createticket(String sub,String mes, String name, String email, String number) throws IOException {
		driver.get(A);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Ticketname=sub;
		Subject.sendKeys(sub);
		Message.sendKeys(mes);
		FullName.sendKeys(name);
		Email.sendKeys(email);
		Phone.sendKeys(number);
		CreateButton.click();
		Utilities.takescreenshoot("Ticket_Created");
		AgentPortalButton.click();
		
		
	}

}
