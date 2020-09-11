import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class WebdriverParameters {

    static WebDriver driver;

    @BeforeClass
    public static void setup() {

        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20000, TimeUnit.MILLISECONDS);
    }

    @AfterClass
    public static void tearDown() {
        driver.close();
    }
}
