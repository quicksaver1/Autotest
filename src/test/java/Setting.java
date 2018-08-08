import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;


public class Setting {
    private static WebDriver driver;
    private static ChromeOptions options = new ChromeOptions();

    public WebDriver CreateDriver()
    {
        options.addArguments("--disable-notifications");
        String root = System.getProperty("user.dir");
        root = root + "//src//chromedriver//chromedriver";
        System.setProperty("webdriver.chrome.driver", root);
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        return driver;
    }
}

