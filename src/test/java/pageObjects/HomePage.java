package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	
	// constructor
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	// locators
	@FindBy(xpath="//span[normalize-space()='My Account']") WebElement lnkMyAccount;
	@FindBy(xpath="//a[normalize-space()='Register']") WebElement lnkRegister;
	@FindBy(xpath="//a[normalize-space()='Login']") WebElement lnkLogin;
	@FindBy(xpath="//input[@placeholder='Search']") WebElement txtSearch;
	@FindBy(xpath="//button[@class='btn btn-default btn-lg']") WebElement btnSearch;
	
	// action methods
	public void clickMyAccount() {
		lnkMyAccount.click();
	}
	
	public void clickRegisterLink() {
		lnkRegister.click();
	}

	public void clickLoginPageLink() {
		lnkLogin.click();
	}
	
	public void enterSearchBox(String product) {
		txtSearch.sendKeys(product);
	}
	
	public void clickSearchBtn() {
		btnSearch.click();
	}
}
