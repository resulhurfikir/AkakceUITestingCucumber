package UITesting.Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/java/UITesting/FeatureFiles/_05_TaskGivenByAkakce.feature"},
        glue = {"UITesting/StepDefinitions"},
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
)
public class RunnerAkakceTask extends AbstractTestNGCucumberTests{

}
