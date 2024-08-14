package stepDefinition;
import java.lang.*;
import java.util.Iterator;
import java.util.Set;

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
import utils.TestContextSetup;

public class LandingPageStepDefinition {

    public  String extractedOfferPageProductName;
    TestContextSetup testContextSetup;
    public LandingPageStepDefinition(TestContextSetup testContextSetup)
    {
        this.testContextSetup=testContextSetup;
    }
    @Given("user is on GreenKart landing page")
    public void user_is_on_green_kart_landing_page() {
        WebDriverManager.chromedriver().setup();
        testContextSetup.driver = new ChromeDriver();
        testContextSetup.driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

    }
    @When("user searched with short name {string} and extract  actual name of product")
    public void user_searched_with_short_name_and_extract_actual_name_of_product(String productName) throws InterruptedException
    {
        LandingPage landingPage = new LandingPage(testContextSetup.driver);
        landingPage.searchItem(productName);

        Thread.sleep(2000);
        testContextSetup.landingExtractedProductName=landingPage.getProductName().split("-")[0].trim();

        Thread.sleep(2000);
        System.out.println("Home page product name :"+testContextSetup.landingExtractedProductName);
    }




}
