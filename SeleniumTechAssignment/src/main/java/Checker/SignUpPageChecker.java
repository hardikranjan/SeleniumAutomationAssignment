package Checker;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import Utils.ReporterLog;

public class SignUpPageChecker {
	ReporterLog rlog = new ReporterLog();
	WebDriver webDriver;
	FileInputStream fileInput;
	Properties properties = new Properties();
	
	public SignUpPageChecker(WebDriver webDriver) throws IOException{
		this.webDriver = webDriver;
		
		fileInput = new FileInputStream(new File("Properties/SignUpPageChecker.properties"));
		properties.load(fileInput);
		if(fileInput==null){
			throw new FileNotFoundException("File Not Found Exception");
		}
	}
	
	public void verifySignUpTag(){
		rlog.verify("Verify If Appdirect SignUp Page is Displayed",true);
		boolean status = webDriver.findElement(By.xpath(properties.getProperty("xpath"))).isDisplayed();
		Assert.assertTrue(status);
	}
	
	public void checkLoginTitle(){
		rlog.verify("Verify If SignUpPage Title is correct",true);
		Assert.assertEquals(webDriver.getTitle(), properties.getProperty("name"));
	}
}
