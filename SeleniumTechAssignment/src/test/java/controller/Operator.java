package controller;

import java.io.*;
import java.util.*;
import org.openqa.selenium.*;
import org.testng.annotations.*;
import Checker.*;
import Exception.InputOutputException;
import Exception.elementNotFoundException;
import Pages.*;
import internet.Browser;

public class Operator {

	WebDriver webDriver;
	Properties properties = new Properties();
	Browser browser;
	LoginPage loginPage;
	WebElement webElement;
	SignUpPage signUpPage;
	HomePageChecker hpageChecker;
	LoginPageChecker lpageChecker;

	@Test
	public void Browser() throws IOException, InputOutputException{
		browser = new Browser(webDriver);
		webDriver= browser.startBrowser(browser.selectBrowser());
	}
	
	@Test(dependsOnMethods="Browser")
	public void openHomePage() throws IOException, elementNotFoundException {
		HomePage homepage = new HomePage(webDriver);
		homepage.openHomePageUrl()
				.clickOnLogin()
				.verifyTitle()
				.verifyLoginStatus();
	}
	
	@Test(dependsOnMethods="openHomePage")
	public void checkLoginPage() throws IOException, elementNotFoundException{
		loginPage = new LoginPage(webDriver);
		loginPage.waitVisibilityConditionByXpath()
				 .verifyLogin()
				 .verifyTitle()
				 .openSignUpPage()
				 .signUpStatus();
	}
	
	@Test(dependsOnMethods="checkLoginPage")
	public void checkSignUpPage() throws IOException, elementNotFoundException{
		signUpPage = new SignUpPage(webDriver);
		signUpPage.checkTitle()
				  .verifySignUp()
				  .enterEmailIdInSignUpText()
				  .clickSignUpButton();
	}
	
	@Test(dependsOnMethods="checkSignUpPage")
	public void verifySuccessFailure() throws Exception{
		SuccessChecker success = new SuccessChecker(webDriver);
		success.waitVisibilityConditionByXpath();
		success.verifySignUp();
	}
	
	@AfterClass
	public void theEnd(){
		webDriver.close();
	}
}
