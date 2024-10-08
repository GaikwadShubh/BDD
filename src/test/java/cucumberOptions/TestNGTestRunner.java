package cucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(features="src/test/java/features",glue="stepDefinition",monochrome = true,tags = "@SearchProduct or @OfferPage or @Multiple",
plugin = {"pretty","html:src/test/java/result/Report.html","json:src/test/java/result/Report.json",
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
        "rerun:target/failed_scenario.txt"})
public class TestNGTestRunner extends AbstractTestNGCucumberTests
{
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios()
    {
        return super.scenarios();
    }
}

