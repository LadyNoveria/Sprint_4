import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageObjects.AboutRentForm;
import pageObjects.ForWhomForm;
import pageObjects.HomePageScooter;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.endsWith;
import static org.hamcrest.CoreMatchers.startsWith;

@RunWith(Parameterized.class)
public class OrderingTests {
    private final String name;
    private final String surname;
    private final String address;
    private final String metroStation;
    private final String phone;
    private final String date;
    private final int period;
    private final String comment;
    private final WebDriver driver;

    public OrderingTests(String name,
                         String surname,
                         String address,
                         String metroStation,
                         String phone,
                         String date,
                         int period,
                         String comment) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.metroStation = metroStation;
        this.phone = phone;
        this.date = date;
        this.period = period;
        this.comment = comment;
        this.driver = new ChromeDriver();
    }

    @Parameterized.Parameters(name = "{index}: имя: {0}, фамилия: {1}, адрес: {2}, метро: {3},  " +
            "телефон: {4}, дата: {5}, период: {6}, комметарий: {7}")
    public static Object[][] getAnswers() {
        return new Object[][]{
                {"Мария", "Пупкина", "г. Москва, ул. Уличная, д. 1, стр. 5, кв. 3", "Беговая", "+71231238989",
                        "10/10/2023", 1, "Вы классный!"},
                {"Ар", "Ку", "Апсю, вор, 5", "Полежаевская", "89160000001", "10/10/2026", 0, ""},
                {"пр", "пр", "прпр, 6", "Нагатинская", "80000000000", "01/01/2024", 7, ""}
        };
    }

    @Test
    public void orderingSuccess() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
        HomePageScooter objHomePage = new HomePageScooter(driver);
        objHomePage.closeCookiePanel();
        objHomePage.scrollToPanelHowItWorks();
        objHomePage.clickBottomOrderButton();
        ForWhomForm objForWhoForm = new ForWhomForm(driver);
        objForWhoForm.waitForLoadHeaderForm();
        objForWhoForm.fillingForWhomForm(name, surname, address, metroStation, phone);
        objForWhoForm.clickNextButton();
        AboutRentForm objAboutRent = new AboutRentForm(driver);
        objAboutRent.waitForLoadHeaderForm();
        objAboutRent.fillingAboutRentFormWithBlackScooter(date, period, comment);
        objAboutRent.clickOrderButton();
        objAboutRent.clickConsentButton();
        String actual = objAboutRent.getTextOrderCompletedPanel();
        MatcherAssert.assertThat(
                actual, allOf(startsWith("Номер заказа:"), endsWith("пригодится, чтобы отслеживать статус")));
    }

    @After
    public void closeBrowser(){
        driver.quit();
    }
}
