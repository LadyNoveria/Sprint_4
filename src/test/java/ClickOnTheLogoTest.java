import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.ForWhomForm;
import pageObjects.HomePageScooter;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.assertTrue;

public class ClickOnTheLogoTest {
    private final WebDriver driver = new ChromeDriver();
    @Test
    public void clickOnTheLogoScooter() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
        HomePageScooter objHomePage = new HomePageScooter(driver);
        objHomePage.clickTopOrderButton();
        ForWhomForm objForWhoForm = new ForWhomForm(driver);
        objForWhoForm.waitForLoadHeaderForm();
        objForWhoForm.clickLogo();
        assertTrue(objHomePage.getHeaderHomePage());
    }

    @After
    public void closeBrowser(){
        driver.quit();
    }
}
