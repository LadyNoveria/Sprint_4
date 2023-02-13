package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.lang.String.format;

public class AboutRentForm {
    private final WebDriver driver;
    private final By headerForm = By.className("Order_Form__17u6u");
    private final By deliveryDate = By.cssSelector(".react-datepicker__input-container>input");
    private final By rentalPeriod = By.className("Dropdown-placeholder");
    private final By blackColor = By.id("black");
    private final By greyColor = By.id("grey");
    private final By commentForCourier = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    private final By orderButton = By.cssSelector("#root > div > div.Order_Content__bmtHS > div.Order_Buttons__1xGrp > button:nth-child(2)");
    private final By confirmationPanel = By.className("Order_ModalHeader__3FDaJ");
    private final By consentButton = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Да']");
    private final By orderCompletedPanel = By.xpath(".//div[text()='Заказ оформлен']");
    private final By textOrderCompletedPanel = By.className("Order_Text__2broi");

    public AboutRentForm(WebDriver driver) {
        this.driver = driver;
    }

    public String getTextOrderCompletedPanel() {
        return driver.findElement(textOrderCompletedPanel).getText();
    }

    public void waitForLoadHeaderForm() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(headerForm));
    }

    public void waitForLoadConfirmationPanel() {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(confirmationPanel));
    }

    public void waitForLoadOrderCompletedPanel() {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(orderCompletedPanel));
    }

    public void fillingAboutRentForm(String date) {
        fillingInDeliveryDate(date);

    }

    public void fillingInDeliveryDate(String date) {
        driver.findElement(deliveryDate).click();
        driver.findElement(deliveryDate).clear();
        driver.findElement(deliveryDate).sendKeys(date, Keys.ENTER);
    }

    public void fillingRentalPeriod(int period) {
        driver.findElement(rentalPeriod).click();
        driver.findElement(getPeriod(period)).click();
    }

    private By getPeriod(int period) {
        switch (period) {
            case 2:
                return getPeriod("двое суток");
            case 3:
                return getPeriod("трое суток");
            case 4:
                return getPeriod("четверо суток");
            case 5:
                return getPeriod("пятеро суток");
            case 6:
                return getPeriod("шестеро суток");
            case 7:
                return getPeriod("семеро суток");
            case 1:
            default: return getPeriod("сутки");
        }
    }

    private By getPeriod(String period) {
        return By.xpath(format(".//div[@class='Dropdown-menu']/div[text()='%s']", period));
    }

    public void chooseBlackScooter() {
        driver.findElement(blackColor).click();
    }

    public void chooseAGreyScooter() {
        driver.findElement(greyColor).click();
    }

    public void fillingComment(String comment) {
        driver.findElement(commentForCourier).click();
        driver.findElement(commentForCourier).clear();
        driver.findElement(commentForCourier).sendKeys(comment);
    }

    public void clickOrderButton() {
        driver.findElement(orderButton).click();
    }

    public void clickConsentButton() {
        driver.findElement(consentButton).click();
    }

}
