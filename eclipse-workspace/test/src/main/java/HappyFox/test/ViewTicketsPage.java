package HappyFox.test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import HappyFox.test.Utilities.ResultAssertion;
import HappyFox.test.Utilities.Utilities;


public class ViewTicketsPage extends Base {
	
	@FindBy(xpath="//div[@Class='hf-top-bar_title']/div/div/div")
	WebElement DropDown;
	
	@FindBy(xpath="//div[contains(text(),'Manage')]/../../../ul/li/a[contains(text(),'Statuses')]")
	WebElement Statuses;
	
	@FindBy(xpath="//div[@Class='hf-manage-entity']/header//button")
	WebElement AddStatusButton;
	
	@FindBy(xpath="//input[@Class='hf-form-field-input hf-text-input   ember-text-field ember-view']")
	WebElement StatusName;
	
	@FindBy(xpath="//div[contains(.,'Behavior')]/../../div[2]/div/div/div")
	WebElement Behaviour;
	
	@FindBy(xpath="//li[contains(.,'Pending')]")
	WebElement pending;
	
	@FindBy (xpath="//div[contains(.,'Description')]/../../div[2]/textarea")
	WebElement Description;
	
	@FindBy(xpath="//button[contains(text(),'Add Status')]")
	WebElement AddStatus;
	
	@FindBy(xpath="//a[contains(text(),'Priorities')]")
	WebElement Priorities;
	
	@FindBy(xpath="//div[contains(text(),'Manage')]/../../../ul/li/a[contains(text(),'Priorities')]")
	WebElement priorities;
	
	@FindBy(xpath="//div[contains(text(),'Priorities')]/../button")
	WebElement AddPriority;
	
	@FindBy(xpath="//div[contains(.,'Priority Name')]/../../div[2]/input")
	WebElement PriorityName;
	
	@FindBy(xpath="//div[contains(.,'Description')]/../../div[2]/textarea")
	WebElement PriorityDescription;
	
	@FindBy(xpath="//div[contains(.,'Help text')]/../../div[2]/textarea")
	WebElement HelpText;
	
	@FindBy(xpath="//button[contains(text(),'Add Priority')]")
	WebElement AddPriorityButton;
	
	@FindBy(xpath="//span[contains(text(),'Search Tickets and Contacts')]")
	WebElement SearchTicket;
	
	@FindBy(xpath="//span[contains(text(),'Search Tickets and Contacts')]/..")
	WebElement EnterTicketName;
	
	@FindBy(xpath="//span[contains(text(),'TICKETS')]/../ul/li[1]/div/div[2]")
	WebElement ticketdropdown;
	
	@FindBy(xpath="//a[contains(.,'New Ticket')]")
	WebElement TicketName;
	
	@FindBy(xpath="//span[contains(text(),'Reply')]")
	WebElement Reply;
	
	@FindBy(xpath="//div[@Class='hf-floating-editor_toolbar ']/div/div/div/span")
	WebElement Action;
	
	@FindBy(xpath="//div[@Class='ember-power-select-search']/Input")
	WebElement searchbar;
	
	@FindBy(xpath="//section[@Class='hf-updates-section-body']/article/ul")
	List<WebElement> TicketProperties;
	
	@FindBy(xpath="//li[contains(.,'Reply to Customer Query')]")
	WebElement CanAction;
	
	@FindBy(xpath="//button[contains(text(),'Apply')]")
	WebElement Apply;
	
	@FindBy(xpath="//button[contains(text(),'Add Reply')]")
	WebElement AddReply;
	
	@FindBy(xpath="//li[contains(text(),'Status changed from ')]")
	WebElement Update;
	
	@FindBy(xpath="//div[@Class='hf-staff-menu hf-u-vertically-centered-container hf-popover-trigger ember-view']/div")
	WebElement Account;
	
	@FindBy(xpath="//a[contains(.,'Logout')]")
	WebElement logout;
	
	/*@FindBy(xpath="//div[contains(text(),'Issue created')]/ancestor::td/following-sibling::td/div//a[contains(text(),'Make Default')]")
	WebElement MakeDefaultStatus;
	
	@FindBy(xpath="//span[contains(text(),'Assistance required')]/../following-sibling::td/div/div[contains(text(),'Make Default')]")
	WebElement MakeDefaultPriority;*/
	
	@FindBy(xpath="//div[contains(text(),'Issue created')]/ancestor::td/div")
	WebElement Status;
	
	@FindBy(xpath="//a[contains(.,'Delete')]")
	WebElement DeleteButton;
	
	@FindBy(xpath="//span[contains(.,'Choose Status')]")
	WebElement ChooseStatus;
	
	@FindBy(xpath="//li[contains(.,'In Progress')]")
	WebElement Inprog;
	
	@FindBy(xpath="//button[contains(.,'Delete')]")
	WebElement Delete;
	
	@FindBy(xpath="//span[contains(text(),'Assistance required')]")
	WebElement priority;
	
	@FindBy(xpath="//span[contains(.,'Choose Priority')]")
	WebElement ChoosePriority;
	
	@FindBy(xpath="//li[contains(.,'testpriority3')]")
	WebElement alternatePriority;
	
	@FindBy(xpath="//div[@Class='tse-scroll-content ember-view']//table/tbody/tr")
	List<WebElement> table;
	
	@FindBy(xpath="//section[@Class='hf-updates-section-body']/article/div/ul")
	List<WebElement> ticketupdates;
	
	@FindBy(xpath="//div[@Class='hf-toast-message ember-view']")
	WebElement floatingMessage;
	
	WebElement Statuselement;
	WebElement Priorityelement;
	String statusname;
	String priorityname;
	String StatusDelete= "Status \"Issue Created\" is deleted successfully";
	String PriorityDelete= "Priority \"Assistance Required\" is deleted successfully";
	String logoutText="You have logged out successfully.";
	
	
	
	public ViewTicketsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	public void CreateStatus(String status,String behavior,String description) {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		DropDown.click();
		
		//Adding new Status
		
		Statuses.click();
		AddStatusButton.click();
		StatusName.sendKeys(status);
		statusname=status;
		Behaviour.click();
		pending.click();
		Description.sendKeys(description);
		AddStatus.click();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		//since status name is dynamic using the below method to find the status
		Statuselement=driver.findElement(By.xpath("//div[contains(text(),'"+status+"')]/ancestor::td/following-sibling::td/div//a[contains(text(),'Make Default')]"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Statuselement.isDisplayed();
		
		//using java scipt executor to click status name by the method defined in Utilities class
		Utilities.ClickElementHelper(Statuselement);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//getupdates(table);
		
		
	}
	
	public void CreatePriority(String Priorityname, String description, String text) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		DropDown.click();
		
		//Adding new priority
		
		priorities.click();
		AddPriority.click();
		PriorityName.sendKeys(Priorityname);
		priorityname=Priorityname;
		PriorityDescription.sendKeys(description);
		HelpText.sendKeys(text);
		AddPriorityButton.click();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		
		//since priority name is dynamic using the below method to find the element
		
		Priorityelement=driver.findElement(By.xpath("//span[contains(text(),'"+priorityname+"')]/../following-sibling::td/div/div[contains(.,'Make Default')]"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Priorityelement.isDisplayed();
		
		//using java scipt executor to click status name by the method defined in Utilities class
		
		Utilities.ClickElementHelper(Priorityelement);
		//getupdates(table);
				
	}
	
	public void TicketAction() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		SearchTicket.click();
		
		//getting the ticket name from CreateTicketpage class 
		
		String NameofTicket=CreateTicketPage.Ticketname;
		System.out.println(CreateTicketPage.Ticketname);
		EnterTicketName.sendKeys("New Ticket");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//TicketName.click();
		WebElement ticketname=driver.findElement(By.xpath("//a[contains(.,'"+NameofTicket+"')]"));
		ticketname.click();
		getupdates(TicketProperties);  //Using the below method to get the ticket status, priority
		
		Reply.click();
		Action.click();
		CanAction.click();
		Apply.click();
		AddReply.click();
		String A=floatingMessage.getText();
		System.out.println(A);
		
		getupdates(ticketupdates);  //Using the below method to get the updated ticket status, priority and tag
		
				
	}
	
	public void DeleteStatus()  {
		
		driver.navigate().refresh();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		DropDown.click();
		Statuses.click();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		
		//since status name is dynamic using the below method to find the element
		
		Statuselement=driver.findElement(By.xpath("//div[@Class='tse-scroll-content ember-view']//table/tbody//td[contains(.,'"+statusname+"')]"));
		Utilities.ClickElementHelper(Statuselement);
		
		DeleteButton.click();
		ChooseStatus.click();
		Inprog.click();
		Delete.click();
		String A=floatingMessage.getText();  //to confirm the Status is deleted 
		//System.out.println(A);
		ResultAssertion.ValidateResult(A,StatusDelete,A);
	}
	
	public void DeletePriority() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().refresh();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		DropDown.click();
		priorities.click();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		
		//since priority name is dynamic using the below method to find the element
		
		Priorityelement=driver.findElement(By.xpath("//div[@Class='tse-scroll-content ember-view']//table/tbody//td[contains(.,'"+priorityname+"')]"));
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Utilities.ClickElementHelper(Priorityelement);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		DeleteButton.click();
		ChoosePriority.click();
		alternatePriority.click();
		Delete.click();
		String A=floatingMessage.getText();  //to confirm the priority is deleted 
		//System.out.println(A);
		ResultAssertion.ValidateResult(A,PriorityDelete,A);
		
	}
	
			
	public void getupdates(List<WebElement> properties) {
			for(WebElement Inlist: properties) {
			String name=Inlist.getText();
			System.out.println(name);
			
		}
	}
	
	public void Logout() {
		driver.navigate().refresh();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Account.click();
		logout.click();
		}
	
}
