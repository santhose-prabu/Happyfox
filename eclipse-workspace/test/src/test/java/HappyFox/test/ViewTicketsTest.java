package HappyFox.test;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import HappyFox.test.Utilities.Utilities;

public class ViewTicketsTest extends Base {
	
loginPage log;
ViewTicketsPage VTP;
CreateTicketPage CTP;
	
	
	public ViewTicketsTest() {
		super();
		
	}
	
	@BeforeTest
	public void setup() {
		initialization();
		log=new loginPage(driver);
		VTP=new ViewTicketsPage(driver);
		CTP=new CreateTicketPage(driver);
		log.loginuser();
	
	}
	
	@DataProvider
	public Object[][] GetStatusDetails() {
		Object[][] data=Utilities.GetTestData("Status Details");
		return data;
	}
	
	@Test(priority=1,dataProvider="GetStatusDetails")
	public void CreateStatusTest(String Statname, String Behavior, String Description) {
		
		VTP.CreateStatus(Statname,Behavior,Description);
		
	}
	
	@DataProvider
	public Object[][] GetPriorityDetails() {
		Object[][] data=Utilities.GetTestData("Priority Details");
		return data;
	}
	
	@Test(priority=2,dataProvider="GetPriorityDetails")	
	public void CreatePriorityTest(String PriorityName, String Description, String Text) throws InterruptedException {
			VTP.CreatePriority(PriorityName,Description,Text);
		
	}
	
	@DataProvider
	public Object[][] GetTicketDetails() {
		Object[][] data=Utilities.GetTestData("Ticket Details");
		return data;
	}
	
	@Test(priority=3,dataProvider="GetTicketDetails")
	public void createtickettest(String subject, String Message, String Name, String Email, String Phone) throws IOException {
		
		CTP.createticket(subject,Message,Name,Email,Phone);
		
	}
	
	@Test(priority=4)
	public void TakeTicketAction() throws InterruptedException {
		
		VTP.TicketAction();
		
		VTP.DeleteStatus();
		VTP.DeletePriority();
		VTP.Logout();
	}
	
	@AfterTest
	public void terminate() {
		driver.quit();
	}
}
