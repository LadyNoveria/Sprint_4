package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DropDownListFAQ {
    private final WebDriver driver;
    private final By dropDownListFAQ = By.className("Home_FAQ__3uVm4");
    private final By questionsAboutImportantText =
            By.xpath(".//div[@class='Home_SubHeader__zwi_E' and text()='Вопросы о важном']");
    private final By questionsAboutImportant = By.className("Home_FourPart__1uthg");
//    private final By listItemAboutPrice = By.id("accordion__heading-0");
//    private final By aboutPriceText = By.xpath(".//div[@id='accordion__panel-0']/p");
//    private final By listItemSeveralScooters = By.id("accordion__heading-1");
//    private final By severalScootersText = By.xpath(".//div[@id='accordion__panel-1']/p");
//    private final By listItemRentalTime = By.id("accordion__heading-2");
//    private final By RentalTimeText = By.xpath(".//div[@id='accordion__panel-2']/p");
//    private final By listItemOrderToday = By.id("accordion__heading-3");
//    private final By orderTodayText = By.xpath(".//div[@id='accordion__panel-3']/p");
//    private final By listItemExtendOrReturn = By.id("accordion__heading-4");
//    private final By extendOrReturnText = By.xpath(".//div[@id='accordion__panel-4']/p");
//    private final By listItemChargingWithScooter = By.id("accordion__heading-5");
//    private final By chargingWithScooterText = By.xpath(".//div[@id='accordion__panel-5']/p");
//    private final By listItemCancelOrder = By.id("accordion__heading-6");
//    private final By cancelOrderText = By.xpath(".//div[@id='accordion__panel-6']/p");
//    private final By listItemDeliveryOutsideMsk = By.id("accordion__heading-7");
//    private final By deliveryOutsideMskText = By.xpath(".//div[@id='accordion__panel-7']/p");

    public DropDownListFAQ(WebDriver driver){
        this.driver = driver;
    }

    public void scrollToFAQ(){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();",
                driver.findElement(questionsAboutImportant));
    }

    public void waitForLoadFAQ(){
        new WebDriverWait(driver, 3).until(driver ->
                driver.findElement(dropDownListFAQ).isEnabled() &&
                        driver.findElement(questionsAboutImportantText).isDisplayed());
    }

    public String getElementText(int numberElement){
//        By element = By.id("accordion__heading-" + numberElement);
//        By elementText = By.xpath(".//div[@id='accordion__panel-" + numberElement + "']/p");
        driver.findElement(getElement(numberElement)).click();
        return driver.findElement(getText(numberElement)).getText();
    }

    private By getElement(int numberElement){
        return By.id("accordion__heading-" + numberElement);
    }

    private By getText(int numberElement){
        return By.xpath(".//div[@id='accordion__panel-" + numberElement + "']/p");
    }

//    public String getElementText(int numberElement){
//        switch (numberElement){
//            case 0: return getAboutPriceText();
//            case 1: return getSeveralScootersText();
//            case 2: return getRentalTimeText();
//            case 3: return getOrderTodayText();
//            case 4: return getExtendOrReturnText();
//            case 5: return getChargingWithScooterText();
//            case 6: return getCancelOrderText();
//            case 7: return getDeliveryOutsideMskText();
//            default: return "";
//        }
//    }
//    public String getAboutPriceText(){
//        driver.findElement(listItemAboutPrice).click();
//        return driver.findElement(aboutPriceText).getText();
//    }
//
//    public String getSeveralScootersText(){
//        driver.findElement(listItemSeveralScooters).click();
//        return driver.findElement(severalScootersText).getText();
//    }
//
//    public String getRentalTimeText(){
//        driver.findElement(listItemRentalTime).click();
//        return driver.findElement(RentalTimeText).getText();
//    }
//
//    public String getOrderTodayText(){
//        driver.findElement(listItemOrderToday).click();
//        return driver.findElement(orderTodayText).getText();
//    }
//
//    public String getExtendOrReturnText(){
//        driver.findElement(listItemExtendOrReturn).click();
//        return driver.findElement(extendOrReturnText).getText();
//    }
//
//    public String getChargingWithScooterText(){
//        driver.findElement(listItemChargingWithScooter).click();
//        return driver.findElement(chargingWithScooterText).getText();
//    }
//
//    public String getCancelOrderText(){
//        driver.findElement(listItemCancelOrder).click();
//        return driver.findElement(cancelOrderText).getText();
//    }
//
//    public String getDeliveryOutsideMskText(){
//        driver.findElement(listItemDeliveryOutsideMsk).click();
//        return driver.findElement(deliveryOutsideMskText).getText();
//    }
}
