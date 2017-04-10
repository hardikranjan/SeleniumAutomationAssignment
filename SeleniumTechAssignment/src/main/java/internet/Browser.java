package internet;

import java.io.*;
import java.util.Properties;
import java.util.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Reporter;

import Exception.InputOutputException;
import Utils.ReporterLog;

public class Browser extends EnumBrowser {
	
	public static final int Chrome = 0;
	public static final int Firefox = 1;
	public static final int IE = 2;
	boolean val = true;
	ReporterLog log = new ReporterLog();
	
	Scanner scanner = new Scanner(System.in);
	InternetBrowser ibrowser;
	String choice;
	WebDriver webDriver;
	FileInputStream fileInput;
	Properties properties = new Properties();
	
	Browser(InternetBrowser ibrowser){
		this.ibrowser = ibrowser;
	}
	
	public Browser(WebDriver webDriver) throws IOException{
		this.webDriver = webDriver;
	
		fileInput = new FileInputStream(new File("Properties/Browser.properties"));
		properties.load(fileInput);
		if(fileInput==null){
			throw new FileNotFoundException("File Not Found Exception");
		}
	}
	
	public String selectBrowser() throws InputOutputException{
		System.out.println("Which Browser To Start");
		for(InternetBrowser ibrowser: InternetBrowser.values()){
			System.out.print(ibrowser+" ");
		}
		choice = scanner.next();
		if(choice==""){
			throw new InputOutputException("Input Not Found Exception");
		}
		return choice;
	}
	
	public WebDriver startBrowser(String browserName) throws IOException{
		if(InternetBrowser.Chrome.toString().equalsIgnoreCase(browserName)){
			log.info("Open Chrome Browser",val);
			System.setProperty(properties.getProperty("cdriverName"),properties.getProperty("cdriverPath"));
			webDriver = new ChromeDriver();
		}
		else if(InternetBrowser.Firefox.toString().equalsIgnoreCase(browserName)){
			log.info("Open Firefox Browser",val);
			System.setProperty(properties.getProperty("fdriverName"),properties.getProperty("fdriverPath"));
			webDriver = new FirefoxDriver();
		}
		else if(InternetBrowser.Safari.toString().equalsIgnoreCase(browserName)){
			log.info("Open Safari Browser",val);
			webDriver = new SafariDriver();
		}
		return webDriver;
	}
}