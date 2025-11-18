package testCases;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import pageObjectModule.HomePage;
import pageObjectModule.LoginPage;
import pageObjectModule.MyAccountPage;
import utillity.DataProviderTest;

public class TC003_DataDrivenTest extends BaseClass{
	
	@Test(dataProvider="logindata",dataProviderClass=DataProviderTest.class)
	public void verify_loginTest(String username,String password,String exp) {
		try {
		logger.info("logintest case started");
		logger.info("user navigate to the login page");
		
		HomePage homepage=new HomePage(driver);
		homepage.myaccountdrop();
		homepage.clickLogin();
		
		logger.info("user enter valid credentials to the feils");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.setEmail(username);
		loginpage.setPassword(password);
		loginpage.clickLoginButton();
		
		logger.info("validating the login details");
		MyAccountPage account=new MyAccountPage(driver);
		 boolean value = account.getMyAccountMassege();
		 
		 if(exp.equalsIgnoreCase("Valid")) {
			 
			 if(value==true) {
				 account.clickLogout();
				 Assert.assertTrue(true);
				 
			 }else {
				 Assert.assertTrue(false);
			 }
		 }
		 
		 if(exp.equalsIgnoreCase("Invalid")) {
			 if(value==true) {
				 account.clickLogout();
				 Assert.assertTrue(false);
			 }else {
				 Assert.assertTrue(true);
			 }
		 }
		
		
		
		logger.info("loggin testcase is finished");
		}catch(Exception e) {
			Assert.fail();
		}
	}

}
