package Checker;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import Pages.HomePage;
import Pages.LoginPage;
import Utils.ReporterLog;

public class LoginPageChecker {
	ReporterLog rlog = new ReporterLog();
	WebDriver webDriver;
	WebDriverWait wait;
	FileInputStream fileInput;
	Properties properties = new Properties();
	
	public LoginPageChecker(WebDriver webDriver) throws IOException{
		this.webDriver = webDriver;
		
		fileInput = new FileInputStream(new File("Properties/LoginPageChecker.properties"));
		properties.load(fileInput);
		if(fileInput==null){
			throw new FileNotFoundException("File Not Found Exception");
		}
	}
	
	public void verifyLogin(){
		rlog.verify("Verify If Appdirect Login is Displayed",true);
		boolean status = webDriver.findElement(By.cssSelector(properties.getProperty("cssSelector"))).isDisplayed();
		Assert.assertTrue(status);
	}
	
	public LoginPageChecker waitVisibilityConditionByXpath() throws IOException{
		wait = new WebDriverWait(webDriver, 50);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("xpath"))));
		return new LoginPageChecker(webDriver);
	}
	
	public void checkLoginTitle(){
		rlog.verify("Verify If Login Page Title is correct",true);
		Assert.assertEquals(webDriver.getTitle(), properties.getProperty("name"));
	}
	
}
