package UITesting.Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        tags = "@Smoke",
        features = {"src/test/java/UITesting/FeatureFiles"},
        glue = {"UITesting/StepDefinitions"},
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
)
public class RunnerSmoke extends AbstractTestNGCucumberTests {
}
