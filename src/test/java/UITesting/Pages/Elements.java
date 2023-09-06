package UITesting.Pages;

import UITesting.Utilities.DriverManager;
import UITesting.Utilities.Methods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class Elements extends Methods {

    public Elements() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }


    @FindBy(css = "div>a[href='/akakcem/giris/']")
    public WebElement girisYapAnaSayfa;
    @FindBy(id = "life")
    public WebElement ePostaBox;
    @FindBy(id = "lifp")
    public WebElement sifreBox;
    @FindBy(id = "lfb")
    public WebElement girisYapButonu;
    @FindBy(css = "[class='bt_v8 line_v8']")
    public WebElement hataliGirisTamamButonu;
    @FindBy(css = "i>[href='/akakcem/']")
    public WebElement girisDogrulama;
    @FindBy(id = "H_c_v8")
    public WebElement kategoriler;
    @FindBy(xpath = "(//a[text()='Elektronik'])[1]")
    public WebElement elektronik;
    @FindBy(xpath = "(//a[text()='Laptop ve Notebook'])[1]")
    public WebElement laptopVeNotebook;
    @FindBy(xpath = "//a[text()='HP']")
    public WebElement markaHp;
    @FindBy(css = "[data-id='1181397']")
    public WebElement ekranKartiRTX4060;
    @FindBy(xpath = "//span[text()='Intel Core i7']")
    public WebElement islemciI7;
    @FindBy(linkText = "EN YÜKSEK FİYAT")
    public WebElement siralaEnYuksekFiyat;
    @FindBy(xpath = "(//h3[@class='pn_v8'])[1]")
    public WebElement enYuksekFiyatliUrun;
    @FindBy(xpath = "//span[@class='ufo_v8']")
    public WebElement takipButonu;
    @FindBy(id = "H_f_v8")
    public WebElement takipListesiIconu;
    @FindBy(css = "h3[class='pn_v8']")
    public List<WebElement> urunler;
    @FindBy(id = "editBtn")
    public WebElement duzenleButonu;
    @FindBy(id = "allSelectBtn")
    public WebElement tumunuSecButonu;
    @FindBy(css = "span[class='fl-li-chk']>input")
    public List<WebElement> duzenleCheckBoxes;
    @FindBy(id = "deleteItemModalButton")
    public WebElement takibiBirak;
    @FindBy(css = "button[class='bt_v8']")
    public WebElement takibiBirakConfirm;
    @FindBy(className = "empty-follow-list")
    public WebElement takipListesiBos;
    @FindBy(id = "q")
    public WebElement searchBox;
    @FindBy(css = "[title='Ara']")
    public WebElement searchIconu;
    @FindBy(linkText = "Sonraki")
    public List<WebElement> sonrakiSayfa;
    @FindBy(css = "[href=''][onclick='return false']")
    public List<WebElement> enSonSayfa;
    @FindBy(css = "a[title='Outdoor Giyim']")
    public WebElement outdoorGiyim;
    @FindBy(linkText = "Adreslerim")
    public WebElement adreslerim;
    @FindBy(css = "span[class='aan']")
    public WebElement yeniAdresEkle;
    @FindBy(id = "locl")
    public WebElement adresBasligi;
    @FindBy(id = "locpr")
    public WebElement ilSelect;
    @FindBy(id = "locds")
    public WebElement ilceSelect;
    @FindBy(id = "locad")
    public WebElement adresKutusu;
    @FindBy(id = "loccp")
    public WebElement cepTel;
    @FindBy(css = "[type='button']")
    public WebElement kaydetButonu;
    @FindBy(css = "[class='alertX t1']")
    public WebElement kayitMesaji;
    @FindBy(css = "[class='bt_v8']")
    public List<WebElement> uruneGitButonlari;
    @FindBy(css = "[class='pdt_v8']>h1")
    public WebElement randomSecilenUrunIsmi;


    public WebElement getWebElement(String element) {
        switch (element) {
            case "markaHp": return markaHp;
            case "ekranKartiRTX4060": return ekranKartiRTX4060;
            case "islemciI7": return islemciI7;
            case "siralaEnYuksekFiyat": return siralaEnYuksekFiyat;
            case "searchBox": return searchBox;
            case "searchIconu": return searchIconu;
            case "outdoorGiyim": return outdoorGiyim;
            case "takipListesiIconu": return takipListesiIconu;
            case "girisDogrulama": return girisDogrulama;
            case "adreslerim": return adreslerim;
            case "yeniAdresEkle": return yeniAdresEkle;
            case "cepTel": return cepTel;
            case "kaydetButonu": return kaydetButonu;
        }
        return null;
    }
}
