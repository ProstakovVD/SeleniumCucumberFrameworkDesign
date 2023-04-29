package stepDefinitions;

import org.junit.Assert;

import abstractComponents.PageObjectManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import utils.TestContextSetup;

public class LandingPageStepDefinition{

	TestContextSetup testContextSetup;
	PageObjectManager pageObjectManager;
	public LandingPage landingPage;

	public LandingPageStepDefinition(TestContextSetup testContextSetup) {
		
		this.testContextSetup=testContextSetup;
		this.landingPage = testContextSetup.pageObjectManager.getLandingPage();
		
	}
	
    @Given("^User in on the GreenKart Landing page$")
    public void user_in_on_the_greenkart_landing_page() {

    	Assert.assertTrue(landingPage.getTitleLP().contains("GreenKart"));
    	
    }

    @When("^User searches with (.+) and extracts actual name of product$")
    public void user_searches_with_something_and_extracts_actual_name_of_product(String shortName) throws InterruptedException {
 
    	landingPage.searchForAnElement(shortName);
    	Thread.sleep(1000);
    	testContextSetup.productNameLP = landingPage.getProductNameFromProductCard().split("-")[0].trim();
    	
    }
    
    @Then("^User changes amount of the product to (.+)$")
    public void user_changes_amount_of_the_product_to(String number) {

    	landingPage.changeAmountOfProduct(number);
    	
    }

    @And("^Adds product to cart$")
    public void adds_product_to_cart() {

    	landingPage.addToCart();
    	
    }
	
}
