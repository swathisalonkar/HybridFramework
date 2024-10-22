package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.SearchResultsPage;
import testBase.BaseClass;

public class TC004_SearchTest extends BaseClass {

	@Test(groups = { "Sanity", "Master" })
	public void verify_SearchProduct() {

		try {
			logger.info("-------Starting TC004_SearchTest-------");
			String product = p.getProperty("searchProductName");

			HomePage hp = new HomePage(driver);
			hp.enterSearchBox(product);
			hp.clickSearchBtn();

			SearchResultsPage sp = new SearchResultsPage(driver);
			String result = sp.getProduct();

			if (sp.getMessage() == true) {
				System.out.println("No matching products found");
				Assert.assertTrue(true);
			} else if (result.contains(product)) {
				System.out.println("Search success");
				Assert.assertTrue(true);
			} else {
				System.out.println("Search failed");
				Assert.assertTrue(false);
			}

		} catch (Exception e) {
			System.out.println("Search failed");
			Assert.fail();
		}
		logger.info("-------Finished TC004_SearchTest-------");
	}
}