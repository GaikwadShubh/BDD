package stepDefinition;

import io.cucumber.java.en.Then;
import org.testng.Assert;
import pom.LandingPage;
import pom.OffersPage;
import utils.TestContextSetup;

public class OfferPageStepDefinitionMultiProduct {

    public  String extractedOfferPageProductName;
    TestContextSetup testContextSetup;

    public OfferPageStepDefinitionMultiProduct(TestContextSetup testContextSetup)
    {
        this.testContextSetup=testContextSetup;
    }

    @Then("^user search for (.+) in offers page to check product exist with same name in multiple search$")
    public void user_search_for_same_in_offers_page_to_check_product_exist(String offerPageProductName) throws InterruptedException
    {
        switchToOfferPage();
        OffersPage offersPage = new OffersPage(testContextSetup.driver);

        offersPage.searchItem(offerPageProductName);
        Thread.sleep(2000);
        extractedOfferPageProductName=offersPage.getDealProductName();

    }

    public void switchToOfferPage() throws InterruptedException
    {
        LandingPage landingPage = testContextSetup.pageObjectManager.getLandingPage();
        landingPage.selectTopDealsPage();
        Thread.sleep(2000);
        testContextSetup.genericUtils.switchWindowToChild();

    }


    @Then("validate landing page product name match with offer page product name for multiple product")
    public void validateLandingPageProductNameMatchWithOfferPageProductName()
    {
        Assert.assertEquals(extractedOfferPageProductName,testContextSetup.landingExtractedProductName);
    }

}
