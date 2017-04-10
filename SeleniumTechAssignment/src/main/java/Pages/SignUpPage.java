package Pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import Checker.SignUpPageChecker;
import Exception.elementNotFoundException;
	
public class SignUpPage {
	
	Random randomGenerator = new Random();
	int randomInt = randomGenerator.nextInt(1000);  
	String emailId = "username"+ randomInt + randomInt +"@gmail.com";
	WebDriver webDriver; 
	Properties properties = new Properties();
	FileInputStream fileInput;
	
	public SignUpPage(WebDriver webDriver) throws IOException{
		this.webDriver = webDriver;
		
		fileInput = new FileInputStream(new File("Properties/SignUpPage.properties"));
		properties.load(fileInput);
		if(fileInput==null){
			throw new FileNotFoundException("File Not Found Exception");
		}
	}
	
	public SignUpPage enterEmailIdInSignUpText() throws IOException, elementNotFoundException{
		webDriver.findElement(By.xpath(properties.getProperty("signUpTextField"))).sendKeys(emailId);
		if(webDriver==null){
			throw new elementNotFoundException("Element was not located");
		}
		return new SignUpPage(webDriver);
	}
	
	public SignUpPage verifyTitle() throws IOException
	{
		SignUpPageChecker pageChecker = new SignUpPageChecker(webDriver);
		pageChecker.checkLoginTitle();
		return new SignUpPage(webDriver);
	}
	
	public SignUpPage verifySignUp() throws IOException{
		SignUpPageChecker pageChecker = new SignUpPageChecker(webDriver);
		pageChecker.verifySignUpTag();
		return new SignUpPage(webDriver);
	}
	
	public SignUpPage clickSignUpButton() throws IOException, elementNotFoundException{
		webDriver.findElement(By.xpath(properties.getProperty("signUpButton"))).click();
		if(webDriver==null){
			throw new elementNotFoundException("Element was not located");
		}
		return new SignUpPage(webDriver);
	}
	
	public SignUpPage checkTitle() throws IOException{
		
		Assert.assertTrue(webDriver.getTitle().contains("Sign Up for AppDirect"));
		return new SignUpPage(webDriver);
	}
}
