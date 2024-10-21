package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

	// constructor
	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	
	// locators
	@FindBy(xpath="//h2[normalize-space()='My Account']") WebElement msgHeading;
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']") WebElement lnkLogout;
	@FindBy(xpath="//a[@class='btn btn-primary']") WebElement btnConfirmLogout;
	
	// action methods
	public boolean verifyLogin() {
		try {
			return(msgHeading.isDisplayed());
		}
		catch(Exception e) {
			return false;
		}
	}
	
	public void clickLogout() {
		lnkLogout.click();
	}
	
	public void clickConfirmLogout() {
		btnConfirmLogout.click();
	}
}
