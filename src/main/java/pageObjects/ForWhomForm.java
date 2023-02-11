package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ForWhomForm {

    private final WebDriver driver;
    private final By headerForm = By.className("Order_Header__BZXOb");
    private final By name = By.xpath(".//input[@placeholder='* Имя']");
    private final By surname = By.xpath(".//input[@placeholder='* Фамилия']");
    private final By address = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    private final By metroStation = By.xpath(".//input[@placeholder='* Станция метро']");
    private final By phone = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    private final By nextButton = By.className("Button_Button__ra12g Button_Middle__1CSJM");

    public ForWhomForm(WebDriver driver){
        this.driver = driver;
    }

    public void waitForLoadHeaderForm(){
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(headerForm));
    }
    private void clickSurname(){
        driver.findElement(surname).click();
    }

    private void clickAddress(){
        driver.findElement(address).click();
    }

    private void clickMetroStation(){
        driver.findElement(metroStation).click();
    }

    private void clickPhone(){
        driver.findElement(metroStation).click();
    }

    public void clickNextButton(){
        driver.findElement(nextButton).click();
    }

    private void clickName(){
        driver.findElement(name).click();
    }
    public void fillingInTheNameField(String value){
        clickName();
        driver.findElement(name).clear();
        driver.findElement(name).sendKeys(value);
    }

    public void fillingInTheSurnameField(String value){
        clickSurname();
        driver.findElement(surname).clear();
        driver.findElement(surname).sendKeys(value);
    }

    public void fillingInTheAddressField(String value){
        clickAddress();
        driver.findElement(address).clear();
        driver.findElement(address).sendKeys(value);
    }
    public void fillingInTheMetroStationField(String value){
        clickMetroStation();
        driver.findElement(metroStation).clear();
        driver.findElement(metroStation).sendKeys(value);
        driver.findElement(By.xpath(".//*[text()='" + value + "']")).click();
    }

    public void fillingInThePhoneField(String value){
        clickPhone();
        driver.findElement(phone).clear();
        driver.findElement(phone).sendKeys(value);
    }

}
