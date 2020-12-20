package HappyFox.test.Utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import HappyFox.test.Base;

public class ResultAssertion extends Base {
	
	static SoftAssert soft=new SoftAssert();
	
	

	public static void ValidateResult(String actual, String expected, String confirmation) {
		soft.assertEquals(actual, expected);
		System.out.println(actual +"\t"+"EQUALS"+"\t"+ expected );
		System.out.println(confirmation);
		
	}
	
	

		
	}


