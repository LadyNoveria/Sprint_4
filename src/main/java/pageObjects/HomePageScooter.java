package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePageScooter {
    private final WebDriver driver;
    private final By topOrderButton = By.xpath(".//div[@class='Header_Nav__AGCXC']/button[@class='Button_Button__ra12g']");
    private final By bottomOrderButton = By.xpath(".//div[@class='Home_ThirdPart__LSTEE']//button");
    private final By cookieButton = By.id("rcc-confirm-button");
    private final By cookiePanelText = By.className("App_CookieText__1sbqp");
    private final By panelHowItWorks = By.className("Home_ThirdPart__LSTEE");
    private final By headerHomePage = By.className("Home_Header__iJKdX");
    private final By logoYandex = By.xpath(".//img[@alt='Yandex']");
    private final By searchInput = By.className("arrow__input mini-suggest__input");

    public HomePageScooter(WebDriver driver) {
        this.driver = driver;
    }

    public void scrollToPanelHowItWorks() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();",
                driver.findElement(panelHowItWorks));
    }

    public void closeCookiePanel() {
        new WebDriverWait(driver, 3).until(driver -> driver.findElement(cookiePanelText).isDisplayed());
        driver.findElement(cookieButton).click();
    }

    public void clickLogoYandex() {
        driver.findElement(logoYandex).click();
    }

    public void clickTopOrderButton() {
        driver.findElement(topOrderButton).click();
    }

    public void clickBottomOrderButton() {
        driver.findElement(bottomOrderButton).click();
    }

    public boolean getHeaderHomePage() {
        return driver.findElement(headerHomePage).isDisplayed();
    }

    public boolean getSearchInput() {
        driver.navigate().refresh();
        return driver.findElement(searchInput).isDisplayed();
        //class="oe8327050"
        //Сделать поиск Яндекса основным?
    }
}
