package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OffersPage
{
    public WebDriver driver;
    public OffersPage(WebDriver driver)
    {
        this.driver=driver;
    }

    By searchBox=By.xpath("//input[@type='search']");
    By dealProductName=By.cssSelector("tr td:nth-child(1)");
    //By dealProductName=By.xpath("//div[@id='root']/div[@class='container-fluid']/div[@class='products-wrapper']/div[@class='products']//table[@class='table table-bordered']//td[.='Tomato']");

    public void searchItem(String shortName)
    {
        driver.findElement(searchBox).sendKeys(shortName);
    }

    public String getDealProductName()
    {
        String d1=driver.findElement(dealProductName).getText();
        System.out.println("deal page name: "+d1);
        return d1;
    }

}
