import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageObjects.AboutRentForm;
import pageObjects.ForWhomForm;
import pageObjects.HomePageScooter;

import static org.hamcrest.CoreMatchers.*;

public class OrderingTests {

    @Test
    public void orderingSuccess() {
        //WebDriver driver = new ChromeDriver();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        HomePageScooter objHomePage = new HomePageScooter(driver);
        objHomePage.waitForLoadCookiePanelText();
        objHomePage.clickCookieButton();
        objHomePage.scrollToPanelHowItWorks();
        objHomePage.clickBottomOrderButton();
        ForWhomForm objForWhoForm = new ForWhomForm(driver);
        objForWhoForm.waitForLoadHeaderForm();
        objForWhoForm.fillingForWhomForm(
                "Имя",
                "Фамилия",
                "Город город, ул. Улица, д. 2, копр. 3, кв. 3",
                "Беговая",
                "+71231238989");
//        objForWhoForm.fillingInTheNameField("Имя");
//        objForWhoForm.fillingInTheSurnameField("Фамилия");
//        objForWhoForm.fillingInTheAddressField("Город город, ул. Улица, д. 2, копр. 3, кв. 3");
//        objForWhoForm.fillingInTheMetroStationField("Беговая");
//        objForWhoForm.fillingInThePhoneField("+71231238989");
        objForWhoForm.clickNextButton();
        AboutRentForm objAboutRent = new AboutRentForm(driver);
        objAboutRent.waitForLoadHeaderForm();
        objAboutRent.fillingInDeliveryDate("10/10/2023");
        objAboutRent.fillingRentalPeriod("трое суток");
        objAboutRent.chooseBlackScooter();
        objAboutRent.fillingComment("Вы классный!");
        objAboutRent.clickOrderButton();
        objAboutRent.waitForLoadConfirmationPanel();
        objAboutRent.clickConsentButton();
        objAboutRent.waitForLoadOrderCompletedPanel();
        String actual = objAboutRent.getTextOrderCompletedPanel();
        MatcherAssert.assertThat(actual, allOf(startsWith("Номер заказа:"), endsWith("пригодится, чтобы отслеживать статус")));
        driver.quit();
    }
}
