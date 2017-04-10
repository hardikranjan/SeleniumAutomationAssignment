package Checker;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import Pages.HomePage;
import Utils.ReporterLog;

public class HomePageChecker {
	ReporterLog rlog = new ReporterLog();
	WebDriver webDriver;
	FileInputStream fileInput;
	Properties properties = new Properties();
	
	public HomePageChecker(WebDriver webDriver) throws IOException{
		this.webDriver = webDriver;
		
		fileInput = new FileInputStream(new File("Properties/HomePageChecker.properties"));
		properties.load(fileInput);
		
		if(fileInput==null){
			throw new FileNotFoundException("File Not Found Exception");
		}
	}
	
	public void checkTitle(){
		rlog.info("Verify If Appdirect HomePage Title",true);
		Assert.assertEquals(webDriver.getTitle(), properties.getProperty("title"));
	}
	
	public void checkLoginStatus() throws IOException{
		rlog.verify("Verify If Appdirect HomePage is Displayed",true);
		boolean status = webDriver.findElement(By.cssSelector(properties.getProperty("cssSelector"))).isDisplayed();
		Assert.assertTrue(status);
	}
	
}