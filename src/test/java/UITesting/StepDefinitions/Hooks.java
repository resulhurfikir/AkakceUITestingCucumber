package UITesting.StepDefinitions;

import UITesting.Utilities.ExcelUtility;
import UITesting.Utilities.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

   @After
   public void after(Scenario scenario){

       ExcelUtility.writeDataExcel("src/test/resources/ExcelFiles/ScenarioStatus.xlsx",
               scenario, DriverManager.threadBrowserGet());

       if (scenario.isFailed()){
           TakesScreenshot ts=(TakesScreenshot) DriverManager.getDriver();
           final byte[] ssInMemory=ts.getScreenshotAs(OutputType.BYTES);
           scenario.attach(ssInMemory, "image/png","screenshot name");
       }
       DriverManager.quitDriver();
   }
}