package Pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import Checker.HomePageChecker;
import Exception.elementNotFoundException;
import Utils.ReporterLog;

public class HomePage{
	ReporterLog rlog = new ReporterLog();
	WebDriver webDriver;
	
	Properties properties = new Properties();;
	FileInputStream fileInput;
	WebDriverWait wait;
	
	public HomePage(WebDriver webDriver) throws IOException {
		this.webDriver = webDriver;
		
		fileInput = new FileInputStream(new File("Properties/HomePage.properties"));
		properties.load(fileInput);
		if(fileInput==null){
			throw new FileNotFoundException("File Not Found Exception");
		}
	}
	
	public HomePage openHomePageUrl() throws IOException, elementNotFoundException {
		rlog.info("Open Appdirect HomePage",true);
		webDriver.get(properties.getProperty("website"));
		
		if(webDriver==null){
			throw new elementNotFoundException("Element was not located");
		}
		return new HomePage(webDriver);
	}
	
	public HomePage clickOnLogin() throws IOException, elementNotFoundException{
		webDriver.findElement(By.cssSelector(properties.getProperty("cssSelector"))).click();
		if(webDriver==null){
			throw new elementNotFoundException("Element was not located");
		}
		return new HomePage(webDriver);
	}
	
	public HomePage verifyLoginStatus() throws IOException{
		rlog.verify("Verify login Status",true);
		HomePageChecker checker = new HomePageChecker(webDriver);
		checker.checkLoginStatus();
		return new HomePage(webDriver);
	}
	
	public HomePage verifyTitle() throws IOException{
		rlog.verify("Verify HomePage Title", true);
		HomePageChecker checker = new HomePageChecker(webDriver);
		checker.checkTitle();
		return new HomePage(webDriver);
	}
}
