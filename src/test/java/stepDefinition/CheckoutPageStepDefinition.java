package stepDefinition;

import com.aventstack.extentreports.Status;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pom.CheckoutPage;
import pom.LandingPage;
import pom.PageObjectManager;
import utils.ExtentReportUtil;
import utils.TestContextSetup;

import java.io.IOException;

public class CheckoutPageStepDefinition {

    public  String extractedOfferPageProductName;
    public PageObjectManager pageObjectManager;
    public CheckoutPage checkoutPage;
    TestContextSetup testContextSetup;
    public CheckoutPageStepDefinition(TestContextSetup testContextSetup)
    {
        this.testContextSetup=testContextSetup;
        this.checkoutPage=testContextSetup.pageObjectManager.getCheckoutPage();
    }

    @Then("^User proceed to checkout and validate the (.+) item in the checkout page$")
    public void User_proceed_to_checkout_and_validate_the_item_in_the_checkout_page(String name)
    {

        //checkoutPage=testContextSetup.pageObjectManager.getCheckoutPage(); // we can write this constructor also
        checkoutPage.checkoutItems();
        //assertion to extract product name from table and compare with landing page name
    }

    @Then("validate user has ability to enter promo code and place the order")
    public void validate_user_has_ability_to_enter_promo_code_and_place_the_order() throws InterruptedException {

           // Thread.sleep(2000);
            checkoutPage.placeOrder();


    }


}
