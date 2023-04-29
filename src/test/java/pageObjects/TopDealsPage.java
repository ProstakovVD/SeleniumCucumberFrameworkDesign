package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import abstractComponents.GenericUtils;

public class TopDealsPage extends GenericUtils{

	public WebDriver driver;
	
	public TopDealsPage(WebDriver driver){
		
		super(driver);
		this.driver=driver;
		
	}
	
	
	private By searchFieldTD = By.id("search-field");
	private By productNameFromTable = By.xpath("(//tbody/tr/td)[1]");
	
	public void sendProductNameToSearchField(String shortName) throws InterruptedException {
		
		waitForElementToAppear(searchFieldTD);
		driver.findElement(searchFieldTD).sendKeys(shortName);
		
	}
	
	public String getProductNameText() {
		
		return driver.findElement(productNameFromTable).getText();
		 
	}
	
}
