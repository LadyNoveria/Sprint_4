import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.ForWhomForm;
import pageObjects.HomePageScooter;

public class OrderingTests {

    @Test
    public void orderingSuccess() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        HomePageScooter objHomePage = new HomePageScooter(driver);
        objHomePage.waitForLoadCookiePanelText();
        objHomePage.clickCookieButton();
        objHomePage.scrollToPanelHowItWorks();
        objHomePage.clickBottomOrderButton();
        ForWhomForm objForWhoForm = new ForWhomForm(driver);
        objForWhoForm.waitForLoadHeaderForm();
        objForWhoForm.fillingInTheNameField("Имя");
        objForWhoForm.fillingInTheSurnameField("Фамилия");
        objForWhoForm.fillingInTheAddressField("Город город, ул. Улица, д. 2, копр. 3, кв. 3");
        objForWhoForm.fillingInTheMetroStationField("Беговая");
        objForWhoForm.fillingInThePhoneField("+71231238989");
        objForWhoForm.clickNextButton();


        //driver.quit();
    }
}
