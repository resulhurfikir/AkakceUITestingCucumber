package UITesting.Runners;

import UITesting.Utilities.DriverManager;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

@CucumberOptions(
        tags = "@Parallel",
        features = {"src/test/java/UITesting/FeatureFiles"},
        glue = {"UITesting/StepDefinitions"},
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
)
public class RunnerParallel extends AbstractTestNGCucumberTests {

    @BeforeClass(alwaysRun = true)
    @Parameters("browserType")
    public void beforeClass(String browser){
        DriverManager.threadBrowserSet(browser);
    }
}
