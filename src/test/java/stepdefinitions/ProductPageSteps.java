package stepdefinitions;

import cucumber.TestContext;
import cucumber.api.java.en.When;
import pageObjects.ProductlistingPage;
 
public class ProductPageSteps {
	
	TestContext testContext;
	ProductlistingPage productListingPage;
	
	public ProductPageSteps(TestContext context) {
		testContext = context;
		productListingPage = testContext.getpageObjectManager().getProductListingPage();
	}
 
	@When("^choose to buy the first item$")
	public void choose_to_buy_the_first_item() {
		productListingPage.select_Product(0);
		productListingPage.clickOn_AddToCart();		
	}
}
