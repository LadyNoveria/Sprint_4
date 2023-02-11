package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AboutRentForm {
    private final WebDriver driver;
    private final By headerForm = By.className("Order_Form__17u6u");
    private final By deliveryDate = By.xpath(".//input[@placeholder='placeholder=\"* Когда привезти самокат\"']");
    private final By rentalPeriod= By.xpath(".//div[text()='* Срок аренды']");
    private final By blackColor = By.id("black");
    private final By greyColor = By.id("grey");
    private final By comment = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    private final By orderButton = By.cssSelector("#root > div > div.Order_Content__bmtHS > div.Order_Buttons__1xGrp > button:nth-child(2)");

    public AboutRentForm(WebDriver driver){
        this.driver = driver;
    }

    public void waitForLoadHeaderForm(){
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(headerForm));
    }

    public void fillingInDeliveryDate(String date){
        //aria-label="Choose суббота, 9-е декабря 2023 г."
        driver.findElement(deliveryDate).click();
        driver.findElement(deliveryDate).clear();
        driver.findElement(deliveryDate).sendKeys(date);
        driver.findElement(By.xpath(".//div[contains(text(), '')]")).click();
    }
}
