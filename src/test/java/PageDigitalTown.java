import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageDigitalTown {
    By appsLocator = By.xpath("//*[@class='presentation__header']/*[@class='container']");
    By TDinappsLocator =By.xpath("//*[@data-id='3']/*[@class='switcher__button']");
    By KnowMoreLocator =By.xpath("//*[@class='content active']/*[@class='content__more']");
    By KnowMore2Locator =By.xpath("//*[@id='food']//*[@class='apps__more']");

    private final WebDriver driver;
    public PageDigitalTown(WebDriver driver) {
        this.driver=driver;
        if (!driver.getTitle().equals("Цифровой город"))
        {
            throw new IllegalStateException("Неверное название страницы. " +driver.getTitle());
        }

    }
    public void ClickTD()
    {
        WebElement TDbutton = driver.findElement(appsLocator).findElement(TDinappsLocator);
        TDbutton.click();
    }
    public void KnowMoreClick()
    {
        WebElement KnowMoreButton = driver.findElement(KnowMoreLocator);
        KnowMoreButton.click();
    }
    public void KnowMore2Click() {
        WebElement KnowMore2Button = driver.findElement(KnowMore2Locator);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        KnowMore2Button.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {


            for(String winHandle : driver.getWindowHandles()){
                driver.switchTo().window(winHandle);
            }
        }catch(Exception e){
            System.out.println("fail");
        }
    }
}
