package legacy;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GreenKartSDBase {

	public WebDriver driver;
	public String clearPoductNameLP;
	public String poductNameTdP;
	
    @Given("^User in on the GreenKart Landing page$")
    public void user_in_on_the_greenkart_landing_page() {

    	System.setProperty("webdriver.http.factory", "jdk-http-client");
    	driver = new ChromeDriver();
    	driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
    	
    }

    @When("^User searches with Shortname \"([^\"]*)\" and extracts actual name of product$")
    public void user_searches_with_shortname_something_and_extracts_actual_name_of_product(String strArg1) throws InterruptedException {

    	driver.findElement(By.className("search-keyword")).sendKeys(strArg1);
    	Thread.sleep(1000);
    	String productName = driver.findElement(By.className("product")).getText();
    	String[] parts = productName.split("-");
    	clearPoductNameLP = parts[0].trim();
    	
    	
    }

    @Then("^User searches for the same Shortname \"([^\"]*)\" in TopDeals page to check if product exists$")
    public void user_searches_for_the_same_shortname_something_in_topdeals_page_to_check_if_product_exists(String strArg1) throws InterruptedException {

    	driver.findElement(By.linkText("Top Deals")).click();
    	
    	List<String> windows = new ArrayList<String>(driver.getWindowHandles());
    	driver.switchTo().window(windows.get(1));
    	
    	WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(5));
		w.until(ExpectedConditions.visibilityOfElementLocated(By.id("search-field")));
    	driver.findElement(By.id("search-field")).sendKeys(strArg1);
    	Thread.sleep(1000);
    	poductNameTdP = driver.findElement(By.xpath("(//tbody/tr/td)[1]")).getText();
    	
    }
    
    @Then("^Validate that product names in TopDeals page and Landing page are equals$")
    public void validate_that_product_names_in_topdeals_page_and_landing_page_are_equals() {

    	Assert.assertEquals(clearPoductNameLP, poductNameTdP);
    	
    }
	
}
