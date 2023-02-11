package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePageScooter {
    private WebDriver driver;
    private By topOrderButton = By.xpath(".//div[@class='Header_Nav__AGCXC']/button[@class='Button_Button__ra12g']");
    private By bottomOrderButton = By.xpath(".//div[@class='Home_ThirdPart__LSTEE']//button");
    private By orderStatusButton = By.className("Header_Link__1TAG7");
    private By cookieButton = By.id("rcc-confirm-button");
    private By cookiePanelText = By.className("App_CookieText__1sbqp");
    private By panelHowItWorks = By.className("Home_ThirdPart__LSTEE");
    public HomePageScooter(WebDriver driver){
        this.driver = driver;
    }

    public void waitForLoadTopOrderButton(){
        new WebDriverWait(driver, 3).until(ExpectedConditions.elementToBeClickable(topOrderButton));
    }

    public void waitForLoadOrderStatusButton(){
        new WebDriverWait(driver, 3).until(ExpectedConditions.elementToBeClickable(topOrderButton));
    }

    public void scrollToPanelHowItWorks(){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();",
                driver.findElement(panelHowItWorks));
    }

    public void waitForLoadCookiePanelText(){
        new WebDriverWait(driver, 3).until(driver -> driver.findElement(cookiePanelText).isDisplayed());
    }

    public void clickCookieButton(){
        driver.findElement(cookieButton).click();
    }

    public void clickTopOrderButton(){
        driver.findElement(topOrderButton).click();
    }

    public void clickBottomOrderButton(){
        driver.findElement(bottomOrderButton).click();
    }

    public void clickOrderStatusButton(){
        driver.findElement(orderStatusButton).click();
    }

}
