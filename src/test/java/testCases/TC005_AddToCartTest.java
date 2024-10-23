package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.SearchResultsPage;
import testBase.BaseClass;

public class TC005_AddToCartTest extends BaseClass {

	@Test(groups = { "Master", "Sanity" })
	public void verify_AddToCart() {
		try {

			logger.info("-------Started TC005_AddToCartTest-------");
			String product = p.getProperty("searchProductName");

			HomePage hp = new HomePage(driver);
			hp.enterSearchBox(product);
			hp.clickSearchBtn();

			SearchResultsPage sp = new SearchResultsPage(driver);
			String prodName = sp.getProduct();

			if (sp.getMessage() == true) {
				System.out.println("No matching products");
				return;
			} else if (prodName.contains(product)) {
				sp.clickAddBtn();
				Assert.assertTrue(true);
			} else {
				System.out.println("Product results mismatched");
				Assert.assertTrue(false);
			}

		} catch (Exception e) {
			Assert.fail();
		}
		logger.info("-------Finished TC005_AddToCartTest-------");
	}
}
