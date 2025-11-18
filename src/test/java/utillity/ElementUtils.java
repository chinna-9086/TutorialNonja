package utillity;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtils {
	WebDriver driver;
	
	public ElementUtils(WebDriver driver) {
		this.driver=driver;
	}
	
	public WebElement waitforElement(WebElement element,long timoout) {
		WebElement webelement = null;
		try {
		
		 WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(timoout));
		 webelement = wait.until(ExpectedConditions.elementToBeClickable(element));
		}catch(Exception e) {
		  e.printStackTrace();
		}
		return webelement;
	}
	
	public void elemnetClickable(WebElement element,long timoout) {
		
		WebElement webelement = waitforElement(element,timoout);
		webelement.click();
	}
	
	public void textTotheElement(WebElement element,String text,long timoout) {
		WebElement webelement = waitforElement(element,timoout);
		webelement.click();
		webelement.clear();
		webelement.sendKeys(text);
		
	}
	
	public void selectValueFromDropDown(WebElement element,String text,long timoout) {
		WebElement webelement = waitforElement(element,timoout);
		Select select=new Select(webelement);
		select.selectByVisibleText(text);
	}
	
	public Alert alertPrasent(long timoout) {
		Alert alert = null;
		try {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(timoout));
		alert = wait.until(ExpectedConditions.alertIsPresent());
		}catch(Exception e) {
			e.printStackTrace();
		}
		return alert;
	}
	
	public void alertAccepted(long timoout) {
		Alert alert = alertPrasent(timoout);
		alert.accept();
	}
	
	public void dissmisAlert(long timeout) {
		Alert alert = alertPrasent(timeout);
		alert.dismiss();
	}
	
	public WebElement elementtoBevisable(WebElement element,long timoout) {
		WebElement webelement = null;
		try {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(timoout));
		webelement = wait.until(ExpectedConditions.visibilityOf(element));
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		return webelement;
	}
	
	public void moueseHourClick(WebElement element,long timoout) {
		WebElement webelement = elementtoBevisable(element,timoout);
		Actions act=new Actions(driver);
		act.moveToElement(webelement).perform();
	}
	

	public void javaScriptClick(WebElement element,long timoout) {
		WebElement webelement = elementtoBevisable(element,timoout);
		
		JavascriptExecutor jsc=(JavascriptExecutor)driver;
		jsc.executeScript("arguments[0].click();", webelement);
		
	}
	
	public void javaScriptExecutortext(WebElement element,String text,long timoout) {
        WebElement webelement = elementtoBevisable(element,timoout);
		
		JavascriptExecutor jsc=(JavascriptExecutor)driver;
		jsc.executeScript("arguments[0].value='"+text+"';", webelement);
		
	}
	
	public String getTextFromElement(WebElement element,long timoout) {
	   
		WebElement webelement = elementtoBevisable(element,timoout);
	    return webelement.getText();
	}
	
	public boolean displayStatusOfElement(WebElement element,long timoout) {
		try {
		WebElement webelement = elementtoBevisable(element,timoout);
		return webelement.isDisplayed();
		}catch(Exception e) {
			return false;
		}
	}
	
}
