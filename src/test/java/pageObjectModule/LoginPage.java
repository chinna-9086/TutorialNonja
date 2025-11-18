package pageObjectModule;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utillity.ElementUtils;

public class LoginPage {
	
	WebDriver driver;
	ElementUtils elementutils;

	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		elementutils=new ElementUtils(driver);
	}
	
	@FindBy(xpath="//input[@name='email']")
	WebElement txtEmail;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement txtPassword;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement buttonlogin;
	
	public void setEmail(String email) {
		elementutils.textTotheElement(txtEmail, email, 30);
		
	}
	
	public void setPassword(String password) {
		elementutils.textTotheElement(txtPassword, password, 30);
		
	}
	
	public void clickLoginButton() {
		elementutils.elemnetClickable(buttonlogin, 30);
		
	}

}
