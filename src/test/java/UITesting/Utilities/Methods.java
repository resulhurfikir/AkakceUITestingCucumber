package UITesting.Utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class Methods extends DriverManager {

    public Methods() {
        PageFactory.initElements(getDriver(), this);
    }

    WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));
    JavascriptExecutor js = (JavascriptExecutor) getDriver();


    public void clickFunction(WebElement element) {
        waitUntilClickable(element);
        scrollToElement(element);
        element.click();
    }

    public void sendKeysFunction(WebElement element, String text) {
        waitUntilVisible(element);
        waitUntilClickable(element);
        scrollToElement(element);
        element.clear();
        element.sendKeys(text);
    }

    public void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].scrollIntoView(false);", element);
    }

    public void waitUntilVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitUntilClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }



    public void jsClickFunction(WebElement element) {
        waitUntilVisible(element);
        js.executeScript("arguments[0].click();", element);
    }

    public Select select(WebElement element) {
        waitUntilClickable(element);
        return new Select(element);
    }

    

    public void actions(WebElement element, String str) {
        Actions actions = new Actions(getDriver());
        switch (str.toLowerCase()) {
            case "hover":
                wait.until(ExpectedConditions.visibilityOf(element));
                actions.moveToElement(element).perform();
                break;
        }
    }


    public void verifyContainsTextFunction(WebElement element, String value) {
        waitUntilVisible(element);
        assertTrue(element.getText().toLowerCase().contains(value.toLowerCase()), "No Such Text()");
    }

    public void assertionTrue(WebElement element, String option) {
        wait.until(ExpectedConditions.visibilityOf(element));
        switch (option.toLowerCase()) {
            case "d":
                assertTrue(element.isDisplayed());
                break;
            case "e":
                assertTrue(element.isEnabled());
                break;
            case "s":
                assertTrue(element.isSelected());
                break;
            default:
                fail("You've typed unvalid string option, please check your choose");
        }
    }


    public void assertByText(String text, List<WebElement> list) {
        boolean flag = false;
        for (WebElement we : list) {
            if (we.getText().equals(text)) {
                flag = true;
            }
        }
        if (!flag)
            fail("Your texts don't match");
    }

    public String getText(WebElement element) {
        return element.getText();
    }

    public void clickAllItems(List<WebElement> list) {
        for (WebElement we : list) {
            clickFunction(we);
        }
    }

    public void verifyAllResultsContainSearchedWord(List<WebElement> urunListesi, List<WebElement> enSonSayfa, List<WebElement> sonrakiSayfa, String arananKelime) {
        ArrayList<String> sonucUrunleri = new ArrayList<>();
        do {
            for (WebElement we : urunListesi) {
                sonucUrunleri.add(we.getText());
            }
            if (sonrakiSayfa.size() > 0)
                jsClickFunction(sonrakiSayfa.get(0));
        } while (enSonSayfa.size() < 1);
        boolean flag = true;
        int counterFail = 0;
        int counterGeneral = 0;
        for (String urunAdi : sonucUrunleri) {
            if (!urunAdi.toLowerCase().contains(arananKelime.toLowerCase())) {
                flag = false;
                System.out.println(counterGeneral + ". product: \"" + urunAdi + "\" doesn't contain \"" + arananKelime + "\" word!");
                counterFail++;
            }
            counterGeneral++;
        }
        if (!flag) {
            System.out.println(counterFail + " piece/s product don't/doesn't contain " + arananKelime + " word among " + counterGeneral + " product/s");
            fail();
        }
    }

    public void waitUntilAttributeNotContains(WebElement element, String attribute, String value) {
        wait.until(ExpectedConditions.not(ExpectedConditions.attributeContains(element, attribute, value)));
    }

    public int randomGenerator(int max) {
        return (int) (Math.random() * max);
    }


    public  void  waitUrl(String url){
        wait.until(ExpectedConditions.urlToBe(url));
    }


}