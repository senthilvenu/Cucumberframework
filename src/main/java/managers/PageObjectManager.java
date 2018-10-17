package managers;

import org.openqa.selenium.WebDriver;

import pageObjects.CartPage;
import pageObjects.Checkoutpage;
import pageObjects.HomePage;
import pageObjects.ProductlistingPage;

public class PageObjectManager {
	
	private WebDriver driver;
	
	private ProductlistingPage productListingPage;
	 
	private CartPage cartPage;
 
	private HomePage homePage;
 
	private Checkoutpage checkoutPage;
 
	
	public PageObjectManager(WebDriver driver) {
		this.driver=driver;
	}

	public ProductlistingPage getProductListingPage() {
		
		return (productListingPage==null)? productListingPage = new ProductlistingPage(driver) : productListingPage;
	}
	
	
	public CartPage getcartPage() {
		
		return (cartPage==null)? cartPage = new CartPage(driver) : cartPage;
	}

	public HomePage gethomePage() {
		
		return (homePage==null)? homePage = new HomePage(driver) : homePage;
	}
	
	public Checkoutpage getcheckoutPage() {
		
		return (checkoutPage==null)? checkoutPage = new Checkoutpage(driver) : checkoutPage;
	}
	
	
}
