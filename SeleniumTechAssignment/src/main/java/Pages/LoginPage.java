package Pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import Checker.LoginPageChecker;
import Exception.elementNotFoundException;
import Utils.ReporterLog;

public class LoginPage {
	ReporterLog rlog = new ReporterLog();
	WebDriver webDriver;
	Properties properties = new Properties();
	WebDriverWait wait;
	FileInputStream fileInput;
	
	public LoginPage(WebDriver webDriver) throws IOException{
		this.webDriver = webDriver;
		fileInput = new FileInputStream(new File("Properties/LoginPage.properties"));
		properties.load(fileInput);
		if(fileInput==null){
			throw new FileNotFoundException("File Not Found Exception");
		}
	}
	
	public LoginPage openSignUpPage() throws IOException, elementNotFoundException{
		Reporter.log("Open SignUp Page",true);
		webDriver.findElement(By.xpath(properties.getProperty("signUpXpath"))).click();
		if(webDriver==null){
			throw new elementNotFoundException("Element was not located");
		}
		return new LoginPage(webDriver);
	}
	
	public LoginPage signUpStatus() throws IOException{
		rlog.verify("Verify If Appdirect LoginPages is Displayed",true);
		boolean status = webDriver.findElement(By.className(properties.getProperty("status_password"))).isDisplayed();
		Assert.assertTrue(status);
		return new LoginPage(webDriver); 
	}
	
	public LoginPage verifyLogin() throws IOException{
		rlog.verify("Verify If Appdirect LoginPages is Displayed",true);
		LoginPageChecker checker= new LoginPageChecker(webDriver);
		checker.verifyLogin();
		return new LoginPage(webDriver);
	}
	
	public LoginPage verifyTitle() throws IOException{
		rlog.verify("Verify Login Page Title", true);
		LoginPageChecker checker= new LoginPageChecker(webDriver);
		checker.checkLoginTitle();
		return new LoginPage(webDriver);
	}
	
	public LoginPage waitVisibilityConditionByXpath() throws IOException{
	    wait = new WebDriverWait(webDriver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("signUpXpath"))));
		return new LoginPage(webDriver);
	}
}
