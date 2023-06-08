import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
public class HomePageYandexScooter {
    //------------------------------------------------------------------------------------------
    private WebDriver driver;

    //кнопка «Заказать» вверху
    static final By orderButtonAtTheTop = By.xpath(".//button[@class='Button_Button__ra12g']");

    //кнопка «Заказать» внизу
    static final By orderButtonAtTheBottom = By.xpath(".//button[text()='Заказать']");

    //-------------------------------------------------------------------------------------------------------------------------------------------------
    //1 Вопрос
    static final By importantQuestions_1 = By.xpath(".//div[text()='Сколько это стоит? И как оплатить?']");
    //1 ответ
    static final By answerToQuestion_1 = By.xpath(".//p[text()='Сутки — 400 рублей. Оплата курьеру — наличными или картой.']");

    //2 Вопрос
    static final By importantQuestions_2 = By.xpath(".//div[text()='Хочу сразу несколько самокатов! Так можно?']");
    //2 Ответ
    static final By answerToQuestion_2 = By.xpath(".//p[starts-with(text(),'Пока что у нас так: один заказ')]");

    //3 Вопрос
    static final By importantQuestions_3 = By.xpath(".//div[@id='accordion__heading-2']");
    //3 Ответ
    static final By answerToQuestion_3 = By.xpath(".//p[starts-with(text(),'Допустим, вы оформляете заказ')]");

    //4 Вопрос
    static final By importantQuestions_4 = By.xpath(".//div[text()='Можно ли заказать самокат прямо на сегодня?']");
    //4 Ответ
    static final By answerToQuestion_4 = By.xpath(".//p[starts-with(text(),'Только начиная с завтрашнего дня')]");

    //5 Вопрос
    static final By importantQuestions_5 = By.xpath(".//div[text()='Можно ли продлить заказ или вернуть самокат раньше?']");
    //5 Ответ
    static final By answerToQuestion_5 = By.xpath(".//p[starts-with(text(),'Пока что нет! Но если что-то срочное')]");

    //6 Вопрос
    static final By importantQuestions_6 = By.xpath(".//div[text()='Вы привозите зарядку вместе с самокатом?']");
    //6 Ответ
    static final By answerToQuestion_6 = By.xpath(".//p[starts-with(text(),'Самокат приезжает к вам')]");

    //7 Вопрос
    static final By importantQuestions_7 = By.xpath(".//div[text()='Можно ли отменить заказ?']");
    //7 Ответ
    static final By answerToQuestion_7 = By.xpath(".//p[starts-with(text(),'Да, пока самокат не привезли.')]");

    //8 Вопрос
    static final By importantQuestions_8 = By.xpath(".//div[text()='Я жизу за МКАДом, привезёте?']");
    //8 Ответ
    static final By answerToQuestion_8 = By.xpath(".//p[starts-with(text(),'Да, обязательно. Всем самокатов!')]");

//------------------------------------------------------------------------------------------------------------------------------------------------------------------

    static final String text_1 = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
    static final String text_2 ="Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
    static final String text_3 ="Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
    static final String text_4 ="Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
    static final String text_5 ="Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
    static final String text_6 ="Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
    static final String text_7 ="Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
    static final String text_8 ="Да, обязательно. Всем самокатов! И Москве, и Московской области.";
    //------------------------------------------------------------------------------------------------------------------------------------------
    public HomePageYandexScooter(WebDriver driver){
    this.driver=driver;
    }

    //-------------------------------------------------------------------------------------------------------------------------------

    public void questionsAboutImportant(By question){
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(question));

        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(question));

        driver.findElement(question).click();
    }

    //Возвращает ответ
    public String answer (By answer){
       return driver.findElement(answer).getText();
    }

    //Клик по кнопкам заказать
    public void clickOrderButton(By button){
        driver.findElement(button).click();
    }
}
