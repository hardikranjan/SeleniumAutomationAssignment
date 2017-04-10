package Checker;

import org.openqa.selenium.support.ui.*;
import org.testng.*;
import Pages.*;
import Utils.ReporterLog;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.*;

public class SuccessChecker {
	ReporterLog rlog = new ReporterLog();
	WebDriver webDriver;
	WebElement webElement1,webElement2;;
	WebDriverWait wait;
	FileInputStream fileInput;
	Properties properties = new Properties();
	
	public SuccessChecker(WebDriver webDriver) throws IOException{
		this.webDriver = webDriver;
		
		fileInput = new FileInputStream(new File("Properties/SuccessChecker.properties"));
		properties.load(fileInput);
		if(fileInput==null){
			throw new FileNotFoundException("File Not Found Exception");
		}
	}
	
	public void verifySignUp() throws Exception{
		if(webDriver.findElement(By.cssSelector(properties.getProperty("verifysignup"))).isDisplayed()){
			Reporter.log("Succcessfully SignedUp",true);
		}
		else{
			Reporter.log("Not Found",true);
		}
	}
	
	public LoginPage waitVisibilityConditionByXpath() throws IOException{
	    wait = new WebDriverWait(webDriver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(properties.getProperty("verifysignup"))));
		return new LoginPage(webDriver);
	}
	
}
