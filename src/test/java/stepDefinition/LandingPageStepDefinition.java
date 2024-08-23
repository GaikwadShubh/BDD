package stepDefinition;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.*;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import com.aventstack.extentreports.Status;
import io.cucumber.java.en.And;
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
import pom.PageObjectManager;
import utils.ExtentReportUtil;
import utils.TestContextSetup;

public class LandingPageStepDefinition {

    public  String extractedOfferPageProductName;
    public PageObjectManager pageObjectManager;
    public LandingPage landingPage;
    TestContextSetup testContextSetup;
    public LandingPageStepDefinition(TestContextSetup testContextSetup)
    {
        this.testContextSetup=testContextSetup;
    }
    @Given("user is on GreenKart landing page")
    public void user_is_on_green_kart_landing_page() throws IOException {

       testContextSetup.driver = testContextSetup.testBase.webDriverManager();

    }
    @When("user searched with short name {string} and extract  actual name of product")
    public void user_searched_with_short_name_and_extract_actual_name_of_product(String productName) throws InterruptedException
    {
        pageObjectManager = new PageObjectManager(testContextSetup.driver);
        landingPage = pageObjectManager.getLandingPage();
       // LandingPage landingPage = new LandingPage(testContextSetup.driver);
       // LandingPage landingPage=testContextSetup.pageObjectManager.getLandingPage();
        landingPage.searchItem(productName);

        Thread.sleep(2000);
        testContextSetup.landingExtractedProductName=landingPage.getProductName().split("-")[0].trim();

        Thread.sleep(2000);
        System.out.println("Home page product name :"+testContextSetup.landingExtractedProductName);
    }

//    @And("Added {String} items of the selected product to cart")
//    public void Added_quantity_items_of_the_selected_product_to_cart(String quantity)
//    {
//        landingPage.incrementQuantity(Integer.parseInt(quantity));
//        landingPage.addToCart();
//    }


    @And("Added {string} items of the selected product to cart")
    public void addedItemsOfTheSelectedProductToCart(String quantity) throws IOException {
        landingPage.incrementQuantity(Integer.parseInt(quantity));
        landingPage.addToCart();

    }
}
