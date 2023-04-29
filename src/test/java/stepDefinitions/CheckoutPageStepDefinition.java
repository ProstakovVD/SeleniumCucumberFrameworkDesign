package stepDefinitions;

import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;

import abstractComponents.PageObjectManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageObjects.CheckoutPage;
import pageObjects.LandingPage;
import utils.TestContextSetup;

public class CheckoutPageStepDefinition {

	TestContextSetup testContextSetup;
	PageObjectManager pageObjectManager;
	public LandingPage landingPage;
	public CheckoutPage checkoutPage;
	
	public CheckoutPageStepDefinition(TestContextSetup testContextSetup) {
		
		this.testContextSetup=testContextSetup;
		this.landingPage = testContextSetup.pageObjectManager.getLandingPage();
		this.checkoutPage = testContextSetup.pageObjectManager.getCheckoutPage();
		
	}
	
    @Then("^User proceeds to the Cart page$")
    public void user_proceeds_to_the_cart_page() {

    	landingPage.switchToCheckoutPage();
    	
    }

    @And("^Validates that product names in Cart page and Landing page are equals$")
    public void validates_that_product_names_in_cart_page_and_landing_page_are_equals() {

    	
    	testContextSetup.usualProductNameCP = checkoutPage.getProductNameCP().split("-")[0].trim();
    	Assert.assertEquals(testContextSetup.usualProductNameCP, testContextSetup.productNameLP);
    	
    }

    @And("^Apply button and Place Order button are visible$")
    public void apply_button_and_place_order_button_are_visible() {

    	SoftAssertions softAssert = new SoftAssertions();
    	softAssert.assertThat(checkoutPage.applyButtonVisible()).isTrue();
    	softAssert.assertThat(checkoutPage.placeOrderButtonVisible()).isTrue();
    	softAssert.assertAll();
    	
    }
	
}
