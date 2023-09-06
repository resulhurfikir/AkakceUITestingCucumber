package UITesting.StepDefinitions;

import UITesting.Pages.Elements;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class _05_TaskGivenByAkakceSteps {

    Elements e =new Elements();
    String name;

    @And("Choose a product from the result list randomly and click on it")
    public void chooseAProductFromTheResultListRandomlyAndClickOnIt() {
    int randomUrun = e.randomGenerator(e.uruneGitButonlari.size());
    e.jsClickFunction(e.uruneGitButonlari.get(randomUrun));
    name=e.getText(e.randomSecilenUrunIsmi);
    }


    @Then("Verify that the product that is chosen randomly is in the watch list")
    public void verifyThatTheProductThatIsChosenRandomlyIsInTheWatchList() {
        e.assertByText(name,e.urunler);
    }

    @And("Click on the *takip butonu* to add the product")
    public void clickOnTheTakipButonuToAddTheProduct() {
        e.jsClickFunction(e.takipButonu);
    }
}
