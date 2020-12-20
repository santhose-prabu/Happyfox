package HappyFox.test.Utilities;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import org.openqa.selenium.OutputType;

import HappyFox.test.Base;

public class Utilities extends Base {
	
	static Workbook book;
	static Sheet sheet;
	public static String testdatasheetpath= "\\Users\\Asus\\eclipse-workspace\\test\\src\\main\\java\\HappyFox\\TestData\\HappyFox.testdata.xlsx";

	public static Object[][] GetTestData(String SheetName) {
		
		FileInputStream file = null;
		try {
			file=new FileInputStream(testdatasheetpath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book=WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		sheet=book.getSheet(SheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for(int i=0; i< sheet.getLastRowNum(); i++) {
			for(int k=0; k<sheet.getRow(0).getLastCellNum();k++) {
				data[i][k] = sheet.getRow(i+1).getCell(k).toString();
			}
		}
		return data;
		
	}
	
	public static void ClickElementHelper(WebElement element) {
		
			try {
		JavascriptExecutor js = (JavascriptExecutor) driver;  
		js.executeScript("arguments[0].click();", element);
		
			}
			catch(Exception e){
				System.out.println(e.getMessage());
			}
	}
		
	public static void takescreenshoot(String fileName) throws IOException {
		File file =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file,new File("C:\\Users\\Asus\\eclipse-workspace\\test\\target\\Screenshots\\"+fileName+".jpg"));
		
	}
	
	
}
