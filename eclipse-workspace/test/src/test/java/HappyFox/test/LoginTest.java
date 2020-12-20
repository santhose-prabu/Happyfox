package HappyFox.test;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;



public class LoginTest extends Base {
	
	loginPage log;
	ViewTicketsPage VTP;
	
	public LoginTest() {
		super();
		
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		log=new loginPage(driver);
		VTP=new ViewTicketsPage(driver);
		
	}
	
	
	
	@Test(priority=1)
	public void enterlogindetails() throws IOException {
		log.loginuser();
		VTP.Logout();
		
	}
	
	
	
	

}
