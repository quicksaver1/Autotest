import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageTownDelivery {

    By CatalogLocator=By.xpath("//*[@id='app']//*[@href='/catalog']");
    By SearchLocator =By.xpath("//*[@id='app']//*[@class='search-bar__input']");
    By SearchButtonLocator = By.xpath("//*[@id='app']//*[@class='search-bar__submit']");
    By GoodsLocator =By.xpath("//*[@class='card-16fc7r card-20JGDS']");
    By CartLocator=By.xpath("//*[@class='button button_size_sm button_skin_primary button-1vA65L']");

    private final WebDriver driver;
    private int GoodsCount;

    public  PageTownDelivery(WebDriver driver)
    {
        this.driver=driver;
        if (!driver.getTitle().equals("Городская доставка"))
        {
            throw new IllegalStateException("Неверное название страницы. " +driver.getTitle());
        }
    }

    public void LentaClick() {
        WebElement CatalogButton = driver.findElement(CatalogLocator);
        CatalogButton.click();

    }

    public void Search(String input) {
        WebElement SearchField =driver.findElement(SearchLocator);
        SearchField.sendKeys(input);
        WebElement SearchButton =driver.findElement(SearchButtonLocator);
        SearchButton.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    public void CheckGoods(int x)
    {
        GoodsCount=driver.findElements(GoodsLocator).size();
        WebElement Goods [] = new WebElement[GoodsCount];
        driver.findElements(GoodsLocator).toArray(Goods);
        if (!(GoodsCount == x))
        {
            System.out.println("Неверное количество товаров: "+ GoodsCount);
        }
        for (int i=0;i<GoodsCount;i++)
        {
            if (Goods[i].findElements(CartLocator).size()==0)
            {
                System.out.println("Нет кнопки 'В корзину' у товара №"+(i+1));
            }
        }
    }
}
