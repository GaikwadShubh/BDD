package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pom.LandingPage;
import pom.OffersPage;
import utils.TestContextSetup;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

public class OfferPageStepDefinition {

    public  String extractedOfferPageProductName;
    TestContextSetup testContextSetup;

    public OfferPageStepDefinition(TestContextSetup testContextSetup)
    {
        this.testContextSetup=testContextSetup;
    }

    @Then("user search for {string} in offers page to check product exist with same name")
    public void user_search_for_same_in_offers_page_to_check_product_exist(String offerPageProductName) throws InterruptedException
    {
        switchToOfferPage();
        OffersPage offersPage = new OffersPage(testContextSetup.driver);

        offersPage.searchItem(offerPageProductName);
        Thread.sleep(2000);
        extractedOfferPageProductName=offersPage.getDealProductName();

    }

    public void switchToOfferPage()
    {
        LandingPage landingPage = new LandingPage(testContextSetup.driver);
        landingPage.selectTopDealsPage();

        ArrayList<String> windowHandles= new ArrayList<>(testContextSetup.driver.getWindowHandles());
        testContextSetup.driver.switchTo().window(windowHandles.get(1));
//        Iterator<String> iterate=windowHandles.iterator();
//        while(iterate.hasNext())
//        {
//            String handle = iterate.next();
//            String url = testContextSetup.driver.getCurrentUrl();
//            if(url.equalsIgnoreCase("https://rahulshettyacademy.com/seleniumPractise/#/offers"))
//            {
//                System.out.println("We are on top deals page");
//                break;
//            }
//        }
    }


    @Then("validate landing page product name match with offer page product name")
    public void validateLandingPageProductNameMatchWithOfferPageProductName()
    {
        Assert.assertEquals(extractedOfferPageProductName,testContextSetup.landingExtractedProductName);
    }

}
