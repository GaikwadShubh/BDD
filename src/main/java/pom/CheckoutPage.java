package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage
{
    public WebDriver driver;
    public CheckoutPage(WebDriver driver)
    {
        this.driver=driver;
    }

    private By cartButton = By.xpath("//img[@alt='Cart']");
    private By checkoutButton = By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]");
    private  By promoCodeBox = By.xpath("//input[@placeholder='Enter promo code']");
    private By promoCodeApplyButton = By.xpath("//button[contains(text(),'Apply')]");
    private By invalidPromoCode = By.xpath("//span[contains(text(),'Invalid code ..!')]");
    private  By placeOrderButton = By.xpath("//button[contains(text(),'Place Order')]");

    public void checkoutItems()
    {
        driver.findElement(cartButton).click();
        driver.findElement(checkoutButton).click();
    }
    public void enterPromoCode(String promoCode)
    {
        driver.findElement(promoCodeBox).sendKeys(promoCode);
    }
    public Boolean PromoCodeApplyButtonIsAvailable()
    {
        return driver.findElement(promoCodeApplyButton).isDisplayed();
    }
    public void clickPromoCodeApplyButton()
    {
        driver.findElement(promoCodeApplyButton).click();
    }
    public Boolean placeOrderButtonIsAvailable()
    {
        return driver.findElement(placeOrderButton).isDisplayed();
    }
    public void placeOrder()
    {
        driver.findElement(placeOrderButton).click();
    }
}
