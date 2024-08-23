package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.testng.annotations.Test;
import pom.LandingPage;
import pom.PageObjectManager;
import utils.TestContextSetup;

import java.io.IOException;

public class LandingPageStepDefinitionMultiProduct {

    public  String extractedOfferPageProductName;
    public PageObjectManager pageObjectManager;
    TestContextSetup testContextSetup;
    public LandingPageStepDefinitionMultiProduct(TestContextSetup testContextSetup)
    {
        this.testContextSetup=testContextSetup;
    }


    @Given("user is on GreenKart landing page for multiple product")
    public void user_is_on_green_kart_landing_page() throws IOException {

       testContextSetup.driver = testContextSetup.testBase.webDriverManager();

    }
    @When("^user searched with short name (.+) and extract  actual name of product in multiple search$")
    public void user_searched_with_short_name_and_extract_actual_name_of_product(String productName) throws InterruptedException
    {

        pageObjectManager = new PageObjectManager(testContextSetup.driver);
        LandingPage landingPage = pageObjectManager.getLandingPage();
        landingPage.searchItem(productName);
        Thread.sleep(2000);
        testContextSetup.landingExtractedProductName=landingPage.getProductName().split("-")[0].trim();

    }

}
