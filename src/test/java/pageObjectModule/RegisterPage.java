package pageObjectModule;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utillity.ElementUtils;

public class RegisterPage {
	WebDriver driver;
	ElementUtils elementutils;

	public RegisterPage(WebDriver driver) {
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
		elementutils=new ElementUtils(driver);
		
	}
	
	@FindBy(id="input-firstname")
	WebElement txtFirstName;
	
	@FindBy(id="input-lastname")
	WebElement txtLastName;
	
	@FindBy(id="input-email")
	WebElement txtEmail;
	
	@FindBy(id="input-telephone")
	WebElement txtPhone;
	
	@FindBy(id="input-password")
	WebElement txtPassword;
	
	@FindBy(id="input-confirm")
	WebElement txtconformPassword;
	
	@FindBy(xpath="//label[@class='radio-inline']//input[@value='1']")
	WebElement buttonNewsletter;
	
	@FindBy(xpath="//input[@type='checkbox']")
	WebElement buttonPrivacyPolocy;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement buttonContineu;
	
	
	public void setFirstName(String fname) {
		elementutils.textTotheElement(txtFirstName, fname, 30);
		
	}
	
	public void setLastName(String lname) {
		elementutils.textTotheElement(txtLastName, lname, 30);
		
	}
	
	public void setEmail(String email) {
		elementutils.textTotheElement(txtEmail, email, 30);
		
	}
	
	public void setphoneNum(String phone) {
		elementutils.textTotheElement(txtPhone, phone, 30);
	
	}
	
	public void setPassword(String password) {
		elementutils.textTotheElement(txtPassword, password, 30);
		
	}

	public void setConformPassword(String password) {
		elementutils.textTotheElement(txtconformPassword, password, 30);
		
	}
	
	public void clickNewSletter() {
		elementutils.elemnetClickable(buttonNewsletter, 30);
		
	}
	
	public void clickPrivacyPolocy() {
		elementutils.elemnetClickable(buttonPrivacyPolocy, 30);
	
	}
	
	public void clickCoutineu() {
		elementutils.elemnetClickable(buttonContineu, 30);
		
	}
}
