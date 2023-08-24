package UITesting.StepDefinitions;

import UITesting.Pages.Elements;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebElement;
import java.util.List;

public class _02_WatchListSteps {

    Elements e = new Elements();
    String name;

    @Given("Hover to Kategoriler and Elektronik orderly then click on the laptop ve notebook link")
    public void hoverToKategorilerAndElektronikOrderlyThenClickOnTheLaptopVeNotebookLink() {
        e.actions(e.girisDogrulama, "hover");
        e.actions(e.kategoriler, "hover");
        e.actions(e.elektronik, "hover");
        e.clickFunction(e.laptopVeNotebook);
    }

    @And("jsClick on the Element to apply filtering options")
    public void jsClickOnTheElementToApplyFilteringOptions(DataTable dt) {
        List<String> buttons = dt.asList(String.class);
        for (String b : buttons) {
            WebElement w = e.getWebElement(b);
            e.jsClickFunction(w);
        }
    }

    @And("Click on the Element")
    public void clickOnTheElement(DataTable dt) {
        List<String> buttons = dt.asList(String.class);
        for (String b : buttons) {
            WebElement w = e.getWebElement(b);
            e.clickFunction(w);
        }
    }

    @And("Click on the *takip butonu* to add the product into the watch list")
    public void clickOnTheTakipButonuToAddTheProductIntoTheWatchList() {
        e.jsClickFunction(e.takipButonu);

    }
    @And("Get the product name for verifying")
    public void getTheProductNameForVerifying() {
        name = e.getText(e.enYuksekFiyatliUrun);
    }

    @And("Click on the *Takip Lisesi Iconu* to go to the watch list")
    public void clickOnTheTakipLisesiIconuToGoToTheWatchList() {
        e.clickFunction(e.takipListesiIconu);
    }

    @Then("Verify that the product is in the watch list")
    public void verifyThatTheProductIsInTheWatchList() {
        e.assertByText(name, e.urunler);
    }

    @And("Empty watch list if there are any products on the list")
    public void emptyWatchListIfThereAreAnyProductsOnTheList() {
        if (e.urunler.size() > 0) {
            e.clickFunction(e.duzenleButonu);
            e.waitUntilClickable(e.tumunuSecButonu);
            e.clickAllItems(e.duzenleCheckBoxes);
            e.clickFunction(e.takibiBirak);
            e.clickFunction(e.takibiBirakConfirm);
        }
    }

    @Then("Verify that the watch list is empty")
    public void verifyThatTheWatchListIsEmpty() {
        e.assertionTrue(e.takipListesiBos, "d");
    }

}
