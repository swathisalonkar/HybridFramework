package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass {

	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class, groups= {"DataDriven"})
	public void verify_loginDDT(String email, String pwd, String exp) {
		
		logger.info("-------Starting TC002_LoginTest-------");
		try {
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLoginPageLink();
		
		LoginPage login = new LoginPage(driver);
		login.setLoginEmail(email);
		login.setLoginPassword(pwd);
		login.clickLoginBtn();
		
		MyAccountPage account = new MyAccountPage(driver);
		boolean loginSuccess = account.verifyLogin();
		
		if(exp.equalsIgnoreCase("Valid")) {
			if(loginSuccess==true) {
				account.clickLogout();
				account.clickConfirmLogout();
				Assert.assertTrue(true);
			}
			else 
				Assert.assertTrue(false);
		}
		
		if(exp.equalsIgnoreCase("Invalid")) {
			if(loginSuccess==true) {
				account.clickLogout();
				account.clickConfirmLogout();
				Assert.assertTrue(false);
			}
			else 
				Assert.assertTrue(true);
		}
		}
		catch(Exception e) {
			Assert.fail();
		}
		
		logger.info("-------Finished TC002_LoginTest-------");
	}
}