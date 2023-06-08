import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderPage {

    private WebDriver driver;
    //Локаторы------------------------------------------------------------------------------------------------------------------------

    // имя
    private final By name = By.xpath(".//input[@placeholder='* Имя']");
    //Фамилия
    private final By sekondName = By.xpath(".//input[@placeholder='* Фамилия']");
    //Адрес
    private final By address = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");


    //Станция метро
    private final By metroStationСhoice = By.xpath(".//input[@placeholder='* Станция метро']");

    //Станция метро Бульвар  Рокосовского
    static final By metroBoulevardRokosovsky = By.xpath(".//button[@value='1']/div[2][text()='Бульвар Рокоссовского']");
     //Станция тетро Черкизовская
    static final By metroCherkizovskai = By.xpath(".//button[@value='2']/div[2][text()='Черкизовская']");


    //телефон
    private final By phone = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    //Кнопка Далее
    private final By next = By.xpath(".//button[text()='Далее']");
    //Когда привезти самокат
    private final By time = By.xpath(".//input[@placeholder='* Когда привезти самокат']");


    //Срок Аренды
    private final By arendTime = By.xpath(".//span[@class='Dropdown-arrow']");
    //Выбор двух суток
     static final By twoDays = By.xpath(".//div[text()='двое суток']");
    //Выбор трех суток
    static final By tрreeDays = By.xpath(".//div[text()='трое суток']");


    //Выбор цвета "Черный"
    static final By blackColour = By.xpath(".//input[@id='black']");
    //Выбор цвета "серый"
    static final By greyColour = By.xpath(".//input[@id='grey']");


    //Комментарий курьеру
    private final By comment = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    //Кнопка заказать
    private final By order = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    //Кнопка ДА
    private final By yes = By.xpath(".//button[text()='Да']");
    //Кнопка посмореть статус
    private final By orderIsProcessed = By.xpath(".//button[text()='Посмотреть статус']");

//Конструктор---------------------------------------------------------------------------------------------------------

public OrderPage(WebDriver driver){
    this.driver = driver;
}

//Методы---------------------------------------------------------------------------------------------------------

    //Выбираем метро
    public void inputMetroStation(By metroStation){
    driver.findElement(metroStationСhoice).click();
    driver.findElement(metroStation).click();
    }

    //Срок аренды
    public void inputArendTime(By days){
    driver.findElement(arendTime).click();
    driver.findElement(days).click();
    }

    public String results(){
       return driver.findElement(orderIsProcessed).getText();
    }

    // Шаг
    public void all (String name1,String sekondName1, String address1, String phone1, String time1,String commen1, By metroStation,By days, By colour){

        driver.findElement(name).sendKeys(name1);
        driver.findElement(sekondName).sendKeys(sekondName1);
        driver.findElement(address).sendKeys(address1);

        inputMetroStation(metroStation);

        driver.findElement(phone).sendKeys(phone1);
        driver.findElement(next).click();
        driver.findElement(time).sendKeys(time1);

        inputArendTime(days);

        driver.findElement(colour).click();

        driver.findElement(comment).sendKeys(commen1);
        driver.findElement(order).click();
        driver.findElement(yes).click();
    }

    }


