package cucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/features",glue="stepDefinition",monochrome = true,
plugin = {"pretty","html:src/test/java/result/Report.html"})
public class TestNGTestRunner extends AbstractTestNGCucumberTests {
}
