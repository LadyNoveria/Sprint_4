import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.DropDownListFAQ;
import pageObjects.HomePageScooter;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class DropDownListFAQTests {
    private final String answer;
    private final int elementNumber;
    private final boolean expected;

    public DropDownListFAQTests(String answer, int elementNumber, boolean expected){
        this.answer = answer;
        this.elementNumber = elementNumber;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] getAnswers() {
        return new Object[][]{
                {"Сутки — 400 рублей. Оплата курьеру — наличными или картой.", 0, true},
                {"Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто " +
                        "сделать несколько заказов — один за другим.", 1, true},
                {"Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени " +
                        "аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая " +
                        "в 20:30, суточная аренда закончится 9 мая в 20:30.", 2, true},
                {"Только начиная с завтрашнего дня. Но скоро станем расторопнее.", 3, true},
                {"Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.", 4, true},
                {"Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься " +
                        "без передышек и во сне. Зарядка не понадобится.", 5, true},
                {"Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.", 6, true},
                {"Да, обязательно. Всем самокатов! И Москве, и Московской области.", 7, true},
//                {"", 0, false},
//                {"", 1, false},
//                {"", 2, false},
//                {"", 3, false},
//                {"", 4, false},
//                {"", 5, false},
//                {"", 6, false},
//                {"", 7, false}
        };
    }

    @Test
    public void checkAnswers(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        DropDownListFAQ objDropDownList = new DropDownListFAQ(driver);
        HomePageScooter objHomePage = new HomePageScooter(driver);
        objHomePage.waitForLoadCookiePanelText();
        objHomePage.clickCookieButton();
        objDropDownList.scrollToFAQ();
        objDropDownList.waitForLoadFAQ();
        String actual = objDropDownList.getElementText(elementNumber);
        assertEquals(expected, actual.equals(answer));
        driver.quit();
    }
}
