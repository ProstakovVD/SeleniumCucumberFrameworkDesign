package abstractComponents;

import org.openqa.selenium.WebDriver;

import pageObjects.CheckoutPage;
import pageObjects.LandingPage;
import pageObjects.TopDealsPage;

public class PageObjectManager {

	public LandingPage landingPage;
	public TopDealsPage topDealsPage;
	public CheckoutPage checkoutPage;
	public WebDriver driver;
	
	public PageObjectManager(WebDriver driver) {
		
		this.driver = driver;
		
	}
	
	public LandingPage getLandingPage() {
		
		landingPage = new LandingPage(driver);
		return landingPage;
		
	}
	
	public TopDealsPage getTopDealsPage() {
		
		topDealsPage = new TopDealsPage(driver);
		return topDealsPage;
		
	}
	
	public CheckoutPage getCheckoutPage() {
		
		checkoutPage = new CheckoutPage(driver);
		return checkoutPage;
		
	}
	
}
