package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import abstractComponents.GenericUtils;

public class LandingPage extends GenericUtils{

	public WebDriver driver;
	
	public LandingPage(WebDriver driver){
		
		super(driver);
		this.driver=driver;
		
	}
	
	private By searchField = By.className("search-keyword");
	private By productCardName = By.xpath("//h4[@class='product-name']");
	private By productCartAmountField = By.xpath("//div[@class='stepper-input']/input[@type='number']");
	private By productCartAddButton = By.xpath("//div[@class='product-action']/button");
	private By topDealsLink = By.linkText("Top Deals");
	private By checkoutPageList = By.xpath("//img[@alt='Cart']");
	private By checkoutPageLink = By.xpath("(//div[@class='action-block']/button)[1]");
	
	public void searchForAnElement(String shortName) {
		
		driver.findElement(searchField).sendKeys(shortName);
		
	}
	
	public String getProductNameFromProductCard() {
		
		return driver.findElement(productCardName).getText();
		
	}
	
	public void switchToTopDealsPage() {
		
		driver.findElement(topDealsLink).click();
		switchWindowToChild();

	}
	
	public void changeAmountOfProduct(String number) {
		
		driver.findElement(productCartAmountField).clear();
		driver.findElement(productCartAmountField).sendKeys(number);
		
	}
	
	public void addToCart() {
		
		driver.findElement(productCartAddButton).click();
		
	}
	
	public void switchToCheckoutPage() {
		
		waitForElementToAppear(checkoutPageList);
		driver.findElement(checkoutPageList).click();
		driver.findElement(checkoutPageLink).click();
		
	}
	
	public String getTitleLP() {
		
		return driver.getTitle();
		
	}
	
}
