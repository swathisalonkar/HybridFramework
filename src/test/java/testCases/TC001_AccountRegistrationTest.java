package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.RegisterAccountPage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {
	
	@Test(groups= {"Regression", "Master"})
	public void verify_AccountReg() {
		try {
		logger.info("-------Starting TC001_AccountRegistrationTest-------");
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickRegisterLink();
		
		logger.info("-------Entering user info-------");
		RegisterAccountPage reg = new RegisterAccountPage(driver);
		reg.setFirstName(randomString().toUpperCase());
		reg.setLastName(randomString().toUpperCase());
		reg.setEmail(randomString().toUpperCase()+"@gmail.com");
		reg.setTelephone(randomNumber());
		
		String pwd = randomAlphaNumeric();
		reg.setPassword(pwd);
		reg.setConfirmPwd(pwd);
		
		reg.checkTerms();
		reg.clickSubmit();		
		String message = reg.getMessage();
		if(message.equals("Your Account Has Been Created!"))
			Assert.assertTrue(true);
		else
		{
			logger.error("Testfailed");
			logger.debug("Debug logs..");
			Assert.assertTrue(false);
		}
		
		}
		catch(Exception e) {
			Assert.fail();
		}
		
		logger.info("-------Finished TC001_AccountRegistrationTest-------");
	}

}