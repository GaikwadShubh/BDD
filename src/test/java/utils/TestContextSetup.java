package utils;

import org.openqa.selenium.WebDriver;
import pom.PageObjectManager;

import java.io.IOException;

public class TestContextSetup
{
    public WebDriver driver;
    public  String landingExtractedProductName;
    public PageObjectManager pageObjectManager;
    public TestBase testBase;
    public GenericUtils genericUtils;

    public TestContextSetup() throws IOException
    {
        testBase = new TestBase();
        pageObjectManager = new PageObjectManager(testBase.webDriverManager());
        genericUtils = new GenericUtils(testBase.webDriverManager());
    }
}
