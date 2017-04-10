package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;
 
public class ActivityCapture implements WebDriverEventListener {
 
public void afterChangeValueOf(WebElement arg0, WebDriver arg1) {
 
}
 
public void afterClickOn(WebElement arg0, WebDriver arg1) {
 
System.out.println("After click "+arg0.toString());
 
}
 
public void afterFindBy(By arg0, WebElement arg1, WebDriver arg2) {
 
System.out.println("After FindBy "+arg0.toString());
}
 

public void afterNavigateBack(WebDriver arg0) {
 
System.out.println("After navigating back "+arg0.toString());
 
}
 

public void afterNavigateForward(WebDriver arg0) {
 
System.out.println("After navigating forword "+arg0.toString());
 
}
 
public void afterNavigateTo(String arg0, WebDriver arg1) {
 
System.out.println("After navigating "+arg0.toString());
 
System.out.println("After navigating "+arg1.toString());
 
}

public void afterScript(String arg0, WebDriver arg1) {
 
}
 
public void beforeChangeValueOf(WebElement arg0, WebDriver arg1) {
 
}
 
public void beforeClickOn(WebElement arg0, WebDriver arg1) {
 
System.out.println("before click "+arg0.toString());
 
}
 
public void beforeFindBy(By arg0, WebElement arg1, WebDriver arg2) {
 
System.out.println("before FindBY "+arg0.toString());
 
}
 
public void beforeNavigateBack(WebDriver arg0) {
 
System.out.println("Before navigating back "+arg0.toString());
}
 
public void beforeNavigateForward(WebDriver arg0) {
System.out.println("Before navigating Forword "+arg0.toString());
 
}
 
public void beforeNavigateTo(String arg0, WebDriver arg1) {
 
System.out.println("Before navigating "+arg0.toString());
System.out.println("Before navigating "+arg1.toString());
 
}
 
public void beforeScript(String arg0, WebDriver arg1) {
 
}
 
public void onException(Throwable arg0, WebDriver arg1) {
 
System.out.println("Testcase done"+arg0.toString());
System.out.println("Testcase done"+arg1.toString());
}

public void beforeAlertAccept(WebDriver driver) {
	// TODO Auto-generated method stub
	
}

public void afterAlertAccept(WebDriver driver) {
	// TODO Auto-generated method stub
	
}

public void afterAlertDismiss(WebDriver driver) {
	// TODO Auto-generated method stub
	
}

public void beforeAlertDismiss(WebDriver driver) {
	// TODO Auto-generated method stub
	
}

public void beforeNavigateRefresh(WebDriver driver) {
	// TODO Auto-generated method stub
	
}

public void afterNavigateRefresh(WebDriver driver) {
	// TODO Auto-generated method stub
	
}

public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
	// TODO Auto-generated method stub
	
}

public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
	// TODO Auto-generated method stub
	
}
 
}