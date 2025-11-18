package pageObjectModule;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utillity.ElementUtils;

public class RegisterSuccessPage {
	
	WebDriver driver;
	ElementUtils elementutils;

	public RegisterSuccessPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		elementutils=new ElementUtils(driver);
		
	}
	
	@FindBy(xpath="//div[@id='content']//h1")
	WebElement msgConformation;
	
	
	
	public String getConformationmassege() {
		try {
		return (elementutils.getTextFromElement(msgConformation, 30));
		}catch(Exception e){
			return e.getMessage();
		}
	}
	
	
}
