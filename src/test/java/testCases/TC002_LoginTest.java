package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass {

	@Test(groups={"Sanity", "Master"})
	public void verify_TestLogin() {
		try
		{
		logger.info("-------Starting TC002_LoginTest-------");
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLoginPageLink();
		
		LoginPage login = new LoginPage(driver);
		login.setLoginEmail(p.getProperty("email"));
		login.setLoginPassword(p.getProperty("password"));
		login.clickLoginBtn();
		
		MyAccountPage account = new MyAccountPage(driver);
		boolean loginSuccess = account.verifyLogin();
	
		Assert.assertEquals(loginSuccess, true, "Login failed");
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("-------Finished TC002_LoginTest-------");
	}
}