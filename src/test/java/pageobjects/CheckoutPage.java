package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import abstractComponents.GenericUtils;

public class CheckoutPage extends GenericUtils {

	public WebDriver driver;
	
	public CheckoutPage(WebDriver driver){
		
		super(driver);
		this.driver=driver;
		
	}
	
	private By productNameContainer = By.xpath("(//tbody/tr/td)[2]/p");
	private By applyButton = By.xpath("//button[@class='promoBtn']");
	private By placeOrderButton = By.xpath("//div[contains(@style,'100%')]/button");
	
	public String getProductNameCP() {
		
		waitForElementToAppear(productNameContainer);
		return driver.findElement(productNameContainer).getText();
		
	}
	
	public boolean applyButtonVisible() {
		
		return driver.findElement(applyButton).isDisplayed();
		
	}
	
	public boolean placeOrderButtonVisible() {
		
		return driver.findElement(placeOrderButton).isDisplayed();
		
	}
	
}
