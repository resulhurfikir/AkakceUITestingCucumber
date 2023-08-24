package UITesting.StepDefinitions;

import UITesting.Pages.Elements;
import UITesting.Utilities.DBUtility;
import com.github.javafaker.Faker;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class _04_AddressFunctionSteps {

    Elements e = new Elements();
    Faker faker = new Faker();
    @And("SendKeys to the Element")
    public void sendkeysToTheElement(DataTable dt) {
        List<List<String>> items = dt.asLists(String.class);
        for (int i = 0; i < items.size(); i++) {
            WebElement w = e.getWebElement(items.get(i).get(0));
            e.sendKeysFunction(w,items.get(i).get(1));
        }
    }

    @And("Choose the *il* and *ilce*")
    public void chooseTheIlAndIlce() {
        e.select(e.ilSelect).selectByVisibleText("Ankara");
        e.waitUntilAttributeNotContains(e.ilceSelect,"disabled","");
        e.select(e.ilceSelect).selectByVisibleText("Çankaya");
    }

    @And("Enter the address details by using database with {string}")
    public void enterTheAddressDetailsByUsingDatabaseWith(String query) {
        ArrayList<ArrayList<String>> dbList = DBUtility.getListData(query);
        e.sendKeysFunction(e.adresKutusu, dbList.get(0).get(1).trim());
    }

    @And("Enter the *adres basligi* by using *FakerClass*")
    public void enterThePhoneNumberByUsingFakerClass() {
        e.sendKeysFunction(e.adresBasligi, faker.name().fullName());
    }

    @Then("Verify that the address was saved successfully")
    public void verifyThatTheAddressWasSavedSuccessfully() {
        e.verifyContainsTextFunction(e.kayitMesaji, "başarı");
    }
}
