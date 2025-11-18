package pageObjectModule;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utillity.ElementUtils;

public class HomePage {
	
	WebDriver driver;
	ElementUtils elementutils;

	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		elementutils=new ElementUtils(driver);
		
	}
	
	@FindBy(xpath="//a[@title='My Account']")
	WebElement linMyAccount;
	
	@FindBy(linkText="Register")
	WebElement linkRegister;
	
	@FindBy(xpath="//a[text()='Login']")
	WebElement linkLogin;
	
	public void myaccountdrop() {
		elementutils.elemnetClickable(linMyAccount,30);
	}
	
	public void selectRegister() {
		elementutils.elemnetClickable(linkRegister,30);
		
	}
	
	public void clickLogin() {
		elementutils.elemnetClickable(linkLogin,30);
		
		
	}

}
