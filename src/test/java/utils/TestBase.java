package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class TestBase
{
    public WebDriver driver;
    public WebDriver webDriverManager() throws IOException {
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/globalProperties.properties");
        Properties prop = new Properties();
        prop.load(fis);
        String url =prop.getProperty("QAUrl");
        String browser_prop=prop.getProperty("browser");
        String browser_maven=System.getProperty("browser");

        /* To handle the browser value from CMD at runtime
        *  mvn test -Dbrowser="firefox"  ->browser is key & firefox is value from CMD
        * */
       // result = browser_maven !=null ? value1:value2;
        String browser= browser_maven != null ? browser_maven : browser_prop;


        if(driver==null)
        {
            if(browser.equalsIgnoreCase("chrome"))
            {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver(); // driver gets life
                driver.manage().window().maximize();
            }
            if(browser.equalsIgnoreCase("firefox"))
            {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                driver.manage().window().maximize();

            }
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
            driver.get(url);
        }
        return driver;
    }
}
