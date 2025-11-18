package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import pageObjectModule.HomePage;
import pageObjectModule.RegisterPage;
import pageObjectModule.RegisterSuccessPage;

public class TC001_AccountRegister extends BaseClass {
	
	@Test(groups="smoke")
	public void accountRegister() {
		try {
		logger.info("User Navigate To the Account Register Page");
		
		HomePage homePage=new HomePage(driver);
		homePage.myaccountdrop();
		homePage.selectRegister();
		
		logger.info("User enters the valid details to register  account ");
		RegisterPage Register=new RegisterPage(driver);
		Register.setFirstName(randomString());
		Register.setLastName(randomString());
		Register.setEmail(randomString()+"@gmail.com");
		Register.setphoneNum(randomNumber());
		
		String password = randomNumber();
		
		Register.setPassword(password);
		Register.setConformPassword(password);
		Register.clickNewSletter();
		Register.clickPrivacyPolocy();
		Register.clickCoutineu();
		
		logger.info("user successfully register the account ");
		RegisterSuccessPage success=new RegisterSuccessPage(driver);
		String conformassage = success.getConformationmassege();
		
		
		Assert.assertEquals(conformassage, "Your Account Has Been Created!");
		}catch(Exception e){
			logger.error("Exception occured", new Exception("Element Not Found"));
			logger.debug("test fail"+e.getMessage());
		}
		
	}
	
	
	

}
