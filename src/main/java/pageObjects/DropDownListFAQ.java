package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.lang.String.format;

public class DropDownListFAQ {
    private final WebDriver driver;
    private final By dropDownListFAQ = By.className("Home_FAQ__3uVm4");
    private final By questionsAboutImportantText =
            By.xpath(".//div[@class='Home_SubHeader__zwi_E' and text()='Вопросы о важном']");
    private final By questionsAboutImportant = By.className("Home_FourPart__1uthg");

    public DropDownListFAQ(WebDriver driver) {
        this.driver = driver;
    }

    public void scrollToFAQ() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();",
                driver.findElement(questionsAboutImportant));
    }

    public void waitForLoadFAQ() {
        new WebDriverWait(driver, 3).until(driver ->
                driver.findElement(dropDownListFAQ).isEnabled() &&
                        driver.findElement(questionsAboutImportantText).isDisplayed());
    }

    public String getElementText(int numberElement) {
        driver.findElement(getElement(numberElement)).click();
        waitForLoadText(numberElement);
        return driver.findElement(getText(numberElement)).getText();
    }

    private void waitForLoadText(int numberElement) {
        new WebDriverWait(driver, 3).until(driver ->
                driver.findElement(By.id(format("accordion__panel-%s", numberElement))).isDisplayed());
    }

    private By getElement(int numberElement) {
        return By.id("accordion__heading-" + numberElement);
    }

    private By getText(int numberElement) {
        return By.xpath(".//div[@id='accordion__panel-" + numberElement + "']/p");
    }
}
