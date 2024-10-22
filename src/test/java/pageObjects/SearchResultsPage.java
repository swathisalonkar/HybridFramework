package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultsPage extends BasePage {

	public SearchResultsPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//div[@class='caption']//a") WebElement resultSearch;
	@FindBy(xpath = "//p[contains(text(),'There is no product that matches the search criter')]") WebElement msgNoProducts;

	public String getProduct() {
		try {
			return (resultSearch.getText());
		} catch (Exception e) {
			return (e.getMessage());
		}
	}

	public boolean getMessage() {
		try {
			return (msgNoProducts.isDisplayed());
		} catch (Exception e) {
			return false;
		}
	}

}
