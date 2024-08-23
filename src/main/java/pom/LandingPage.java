package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LandingPage
{
    public WebDriver driver;
    public LandingPage(WebDriver driver)
    {
        this.driver=driver;
    }

    private By search = By.xpath("//div[@class='search']/form/input[@placeholder='Search for Vegetables and Fruits']");
    private By productName = By.xpath("//h4[@class='product-name']");
    private By topDeals = By.xpath("//a[text()='Top Deals']");

    private By incrementQuantity = By.xpath("//a[@class='increment']");
    private By addToCart = By.xpath("//button[contains(text(),'ADD TO CART')]");

    public void searchItem(String name)
    {
        driver.findElement(search).sendKeys(name);
    }

    public String getProductName()
    {
        String actualProductName=driver.findElement(productName).getText();
        return actualProductName;
    }

    public void selectTopDealsPage()
    {
        driver.findElement(topDeals).click();
    }

    public String getLandingPageTitle()
    {
        return driver.getTitle();
    }

    public void incrementQuantity(int quantity)
    {
        int i=quantity-1;
        while (i>0)
        {
            driver.findElement(incrementQuantity).click();
            i--;
        }
    }

    public void addToCart()
    {
        driver.findElement(addToCart).click();
    }

}
