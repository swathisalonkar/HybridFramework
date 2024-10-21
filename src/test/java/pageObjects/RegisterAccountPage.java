package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterAccountPage extends BasePage{

	// constructor
	public RegisterAccountPage(WebDriver driver) {
		super(driver);
	}
	
	// locators
	@FindBy(id="input-firstname") WebElement txtFirstName;	
	@FindBy(id="input-lastname") WebElement txtLastName;	
	@FindBy(id="input-email") WebElement txtEmail;	
	@FindBy(id="input-telephone") WebElement txtTelephone;	
	@FindBy(id="input-password") WebElement txtPassword;	
	@FindBy(id="input-confirm") WebElement txtConfirmPwd;
	@FindBy(xpath="//input[@name='agree']") WebElement checkTerms;	
	@FindBy(xpath="//input[@value='Continue']") WebElement btnSubmit;
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']") WebElement confirmMsg;
	
	// action methods
	public void setFirstName(String fname) {
		txtFirstName.sendKeys(fname);
	}
	
	public void setLastName(String lname) {
		txtLastName.sendKeys(lname);
	}
	
	public void setEmail(String email) {
		txtEmail.sendKeys(email);
	}
	
	public void setTelephone(String phone) {
		txtTelephone.sendKeys(phone);
	}
	
	public void setPassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}
	
	public void setConfirmPwd(String pwd) {
		txtConfirmPwd.sendKeys(pwd);
	}
	
	public void checkTerms() {
		checkTerms.click();
	}
	
	public void clickSubmit() {
		btnSubmit.click();
	}
	
	public String getMessage() {
		try {
		return (confirmMsg.getText());
		} catch(Exception e) {
		return (e.getMessage());
		}
	}

}
