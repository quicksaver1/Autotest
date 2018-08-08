import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;


public class Maintest {
    private static WebDriver driver;
    private static Setting setting=new Setting();
    @BeforeClass
    public static void Setup() {
        driver = setting.CreateDriver();
        //1.Пользователь открывает сайт
        driver.get("http://xn--c1a1b.xn--p1ai/");


    }

    @Test
    public void ConductTest() {
        PageDigitalTown Mainpage = new PageDigitalTown(driver);
        // 2. Находит приложения.
        // 3. Нажимает на иконку приложения “Городская доставка”.
        Mainpage.ClickTD();
        // 4. Нажимает “узнать больше”.
        Mainpage.KnowMoreClick();
        // 5. Переходит к инфо-блоку и снова жмет “узнать больше”.
        Mainpage.KnowMore2Click();
        PageTownDelivery Secondpage = new PageTownDelivery(driver);
        // 6.На главной странице “Городской доставки” нажимает на каталог Ленты.
        Secondpage.LentaClick();
        // 7.Вводит в поиск “пицца пепперони”.
        // 8. Нажимает на поиск.
        Secondpage.Search("пицца пепперони");
        // 9.Проверяет, что товаров в списке 4.
        // 10.Проверяет,что у всех товаров есть кнопка “в корзину”.
        Secondpage.CheckGoods(4);
    }

    @AfterClass
    public static void CompleteTest() {
        driver.quit();
    }


}
