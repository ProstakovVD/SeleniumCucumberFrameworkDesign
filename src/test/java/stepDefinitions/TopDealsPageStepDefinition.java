package stepDefinitions;

import org.junit.Assert;

import abstractComponents.PageObjectManager;
import io.cucumber.java.en.Then;
import pageObjects.LandingPage;
import pageObjects.TopDealsPage;
import utils.TestContextSetup;

public class TopDealsPageStepDefinition {

	TestContextSetup testContextSetup;
	PageObjectManager pageObjectManager;
	public LandingPage landingPage;
	public TopDealsPage topDealsPage;
	
	public TopDealsPageStepDefinition(TestContextSetup testContextSetup) {
		
		this.testContextSetup=testContextSetup;
		this.landingPage = testContextSetup.pageObjectManager.getLandingPage();
		this.topDealsPage = testContextSetup.pageObjectManager.getTopDealsPage();
		
	}
	
    @Then("^User searches for the same Shortname (.+) in TopDeals page to check if product exists$")
    public void user_searches_for_the_same_shortname_something_in_topdeals_page_to_check_if_product_exists(String shortName) throws InterruptedException {
    	
    	landingPage.switchToTopDealsPage();
		topDealsPage.sendProductNameToSearchField(shortName);
    	Thread.sleep(1000);
    	testContextSetup.productNameTDP = topDealsPage.getProductNameText();
    	
    }
    
    @Then("^Validate that product names in TopDeals page and Landing page are equals$")
    public void validate_that_product_names_in_topdeals_page_and_landing_page_are_equals() {

    	Assert.assertEquals(testContextSetup.productNameLP, testContextSetup.productNameTDP);
    	
    }
	
}
