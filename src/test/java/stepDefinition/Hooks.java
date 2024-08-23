package stepDefinition;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.FileUtil;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import net.bytebuddy.implementation.bytecode.constant.TextConstant;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utils.ExtentReportUtil;
import utils.TestContextSetup;

import java.io.File;
import java.io.IOException;

public class Hooks
{
    public TestContextSetup testContextSetup;
    public Hooks(TestContextSetup testContextSetup)
    {
        this.testContextSetup=testContextSetup;
    }
    @After
    public void afterScenario() throws IOException
    {

        WebDriver driver = testContextSetup.testBase.webDriverManager();
        driver.quit();
    }

    @Before
    public void beforeScenario(Scenario scenario) {
        ExtentReportUtil.setUpExtentReport();
        ExtentReportUtil.test = ExtentReportUtil.extent.createTest(scenario.getName());
    }

    @AfterStep
    public void takeFailTestScreenshot(Scenario scenario) throws IOException {
        WebDriver driver = testContextSetup.testBase.webDriverManager();

        if(scenario.isFailed())
        {
            File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            byte [] fileContent= FileUtils.readFileToByteArray(source);
            scenario.attach(fileContent,"image/png","screenshot");
        }


    }
}
//scenario object hold all information about the test