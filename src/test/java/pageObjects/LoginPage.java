package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	// constructor
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	// locators
	@FindBy(id="input-email") WebElement txtLoginEmail;
	@FindBy(id="input-password") WebElement txtLoginPassword;
	@FindBy(xpath="//input[@value='Login']") WebElement btnLogin;
	
	// action methods
	public void setLoginEmail(String email) {
		txtLoginEmail.sendKeys(email);
	}
	
	public void setLoginPassword(String pwd) {
		txtLoginPassword.sendKeys(pwd);
	}
	
	public void clickLoginBtn() {
		btnLogin.click();
	}

}
