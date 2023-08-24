package UITesting.StepDefinitions;

import UITesting.Pages.Elements;
import UITesting.Utilities.ConfigurationReader;
import io.cucumber.java.en.*;

public class _03_SearchFunctionSteps {

    Elements e = new Elements();

    @When("Send a word to search box")
    public void sendAWordToSearchBox() {
        e.sendKeysFunction(e.searchBox, ConfigurationReader.getProperty("aranacakKelime"));
    }

    @Then("Verify that results contain searched word")
    public void verifyThatResultsContainSearchedWord() {
        e.verifyAllResultsContainSearchedWord(e.urunler, e.enSonSayfa, e.sonrakiSayfa,
                ConfigurationReader.getProperty("aranacakKelime"));
    }
}
