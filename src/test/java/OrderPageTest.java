import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class OrderPageTest {

    WebDriver driver = new ChromeDriver();

    private final String name;
    private final String sekondName;
    private final String address;
    private final String phone;
    private final String time;
    private final String comment;
    private final By metroStantion;
    private final By days;
    private final By colour;
    private final By button;


    public OrderPageTest(String name, String sekondName, String address, String phone, String time, String comment, By metroStantion, By days, By colour, By button) {
        this.name = name;
        this.sekondName = sekondName;
        this.address = address;
        this.phone = phone;
        this.time = time;
        this.comment = comment;
        this.metroStantion = metroStantion;
        this.days = days;
        this.colour = colour;
        this.button = button;
    }

    @Parameterized.Parameters

    public static Object[][] getCredentials() {
        return new Object[][]{

                {"Олег", "Иванов", "Чапаева 40", "22222222222", "25.10.2023", "Домофон не работает", OrderPage.metroBoulevardRokosovsky,
                        OrderPage.twoDays, OrderPage.blackColour, HomePageYandexScooter.orderButtonAtTheTop},
                {"Петр", "Крайнов", "Гагарина 10", "55555555555", "12.05.2023", "Позвонить после 17:00", OrderPage.metroCherkizovskai,
                        OrderPage.tрreeDays, OrderPage.greyColour, HomePageYandexScooter.orderButtonAtTheBottom}
        };
    }

        @Test
                public void TestMetod() {

            driver.get("https://qa-scooter.praktikum-services.ru");

            HomePageYandexScooter home = new HomePageYandexScooter(driver);
            OrderPage order = new OrderPage(driver);

            home.clickOrderButton(button);
            order.all(name, sekondName,address,phone,time,comment,metroStantion,days,colour);

            String result = order.results();
            assertEquals("Ошибка, заказ не сформирован", "Посмотреть статус", result);

        }
        @After
            public void teardown(){
            driver.quit();
    }


}
