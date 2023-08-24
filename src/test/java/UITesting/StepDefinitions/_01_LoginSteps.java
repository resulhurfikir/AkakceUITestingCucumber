package UITesting.StepDefinitions;

import UITesting.Pages.Elements;
import UITesting.Utilities.ConfigurationReader;
import UITesting.Utilities.DriverManager;
import UITesting.Utilities.ExcelUtility;
import io.cucumber.java.en.*;

public class _01_LoginSteps {
    Elements e = new Elements();

    @Given("Navigate to Akakce Website")
    public void navigateToAkakceWebsite() {
        DriverManager.getDriver().get(ConfigurationReader.getProperty("url"));
    }

    @When("Click on the *Giris Yap* button on right up side")
    public void clickOnTheGirisYapButtonOnRightUpSide() {
        e.clickFunction(e.girisYapAnaSayfa);
    }

    @Given("User enter email as {string}  password  as {string}")
    public void userEnterEmailAsPasswordAs(String ePosta, String sifre) {
        e.sendKeysFunction(e.ePostaBox, ePosta);
        e.sendKeysFunction(e.sifreBox, sifre);
    }

    @When("Click on the *Giris Yap* button under the boxes")
    public void clickOnTheGirisYapButtonUnderTheBoxes() {
        e.clickFunction(e.girisYapButonu);
    }

    @Then("Verify that the user should not be logged successfully")
    public void verifyThatTheUserShouldNotBeLoggedSuccessfully() {
        e.assertionTrue(e.hataliGirisTamamButonu, "d");
    }

    @Given("User enter valid email and password")
    public void userEnterValidEmailAndPassword() {
        e.sendKeysFunction(e.ePostaBox, ExcelUtility
                .getDataExcel("src/test/resources/ExcelFiles/LoginInfo.xlsx", "Login", 2).get(0).get(0));
        e.sendKeysFunction(e.sifreBox, ExcelUtility
                .getDataExcel("src/test/resources/ExcelFiles/LoginInfo.xlsx", "Login", 2).get(0).get(1));
    }

    @Then("Verify that the user should be logged successfully")
    public void verifyThatTheUserShouldBeLoggedSuccessfully() {
        e.assertionTrue(e.girisDogrulama, "d");
    }
}
