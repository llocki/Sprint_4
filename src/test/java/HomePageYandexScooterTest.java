import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class HomePageYandexScooterTest {

        WebDriver driver = new ChromeDriver();

        private final By question;
        private final By answer;
        private final String text;

        public  HomePageYandexScooterTest(By question, By answer,String text){
            this.question= question;
            this.answer = answer;
            this.text = text;
        }

        @Parameterized.Parameters
        public static Object[][] getCredentials() {
            return new Object[][]{
                    {HomePageYandexScooter.importantQuestions_1,HomePageYandexScooter.answerToQuestion_1, HomePageYandexScooter.text_1},
                    {HomePageYandexScooter.importantQuestions_2,HomePageYandexScooter.answerToQuestion_2, HomePageYandexScooter.text_2},
                    {HomePageYandexScooter.importantQuestions_3,HomePageYandexScooter.answerToQuestion_3, HomePageYandexScooter.text_3},
                    {HomePageYandexScooter.importantQuestions_4,HomePageYandexScooter.answerToQuestion_4, HomePageYandexScooter.text_4},
                    {HomePageYandexScooter.importantQuestions_5,HomePageYandexScooter.answerToQuestion_5, HomePageYandexScooter.text_5},
                    {HomePageYandexScooter.importantQuestions_6,HomePageYandexScooter.answerToQuestion_6, HomePageYandexScooter.text_6},
                    {HomePageYandexScooter.importantQuestions_7,HomePageYandexScooter.answerToQuestion_7, HomePageYandexScooter.text_7},
                    {HomePageYandexScooter.importantQuestions_8,HomePageYandexScooter.answerToQuestion_8, HomePageYandexScooter.text_8},
            };
        }

        @Test
        public void questions() {

            driver.get("https://qa-scooter.praktikum-services.ru");

            HomePageYandexScooter home = new HomePageYandexScooter(driver);

            home.questionsAboutImportant(question);

            String actual = home.answer(answer);
            assertEquals("Неверное значение, обрати внимание на ответ", text, actual);
        }

        @After
        public void teardown() {
            driver.quit();
        }
    }
