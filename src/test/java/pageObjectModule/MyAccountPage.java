package pageObjectModule;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utillity.ElementUtils;

public class MyAccountPage {
	WebDriver driver;
	ElementUtils elementutils;

	public MyAccountPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		elementutils=new ElementUtils(driver);
	}
	
	@FindBy(xpath="//div[@id='content']//h2[text()='My Account']")
	WebElement mesageMyaccount;
	
	@FindBy(xpath="//a[text()='Logout' and @class='list-group-item']")
	WebElement clickLogout;
	

	public boolean getMyAccountMassege() {
		
		return elementutils.displayStatusOfElement(mesageMyaccount, 30);
	}
	
	public void clickLogout() {
		elementutils.elemnetClickable(clickLogout, 30);
		
	}
	

}
