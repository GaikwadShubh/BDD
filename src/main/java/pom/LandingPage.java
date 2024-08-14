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

}
