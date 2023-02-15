import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.ForWhomForm;
import pageObjects.HomePageScooter;

import static org.junit.Assert.assertTrue;

public class ClickOnTheLogoTest {
    @Test
    public void clickOnTheLogoScooter() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        HomePageScooter objHomePage = new HomePageScooter(driver);
        objHomePage.clickTopOrderButton();
        ForWhomForm objForWhoForm = new ForWhomForm(driver);
        objForWhoForm.waitForLoadHeaderForm();
        objForWhoForm.clickLogo();
        assertTrue(objHomePage.getHeaderHomePage());
        driver.quit();
    }

    @Test
    public void ClickOnTheLogoYandex(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        HomePageScooter objHomePage = new HomePageScooter(driver);
        objHomePage.clickLogoYandex();
        assertTrue(objHomePage.getSearchInput());
        driver.quit();
    }
}
