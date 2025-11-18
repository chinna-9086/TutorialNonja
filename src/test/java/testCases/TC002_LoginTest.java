package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import pageObjectModule.HomePage;
import pageObjectModule.LoginPage;
import pageObjectModule.MyAccountPage;

public class TC002_LoginTest extends BaseClass {
	
	@Test(groups="reggrasion")
	public void verify_loginTest() {
		try {
		logger.info("logintest case started");
		logger.info("user navigate to the login page");
		
		HomePage homepage=new HomePage(driver);
		homepage.myaccountdrop();
		homepage.clickLogin();
		
		logger.info("user enter valid credentials to the feils");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.setEmail(pro.getProperty("username"));
		loginpage.setPassword(pro.getProperty("password"));
		loginpage.clickLoginButton();
		
		logger.info("validating the login details");
		MyAccountPage account=new MyAccountPage(driver);
		 boolean value = account.getMyAccountMassege();
		
		Assert.assertTrue(value);
		
		logger.info("loggin testcase is finished");
		}catch(Exception e) {
			logger.error("test is failed"+e.getMessage());
			logger.debug("test is failed"+e.getMessage());
		}
	}

}
