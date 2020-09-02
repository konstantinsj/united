import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class UnitedAirlinesTest {

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

    @Test
    public void searchFlightTest() {
        // input parameters
        String fromAirportInput = "New York, NY, US (JFK)";
        String toAirportInput = "Miami, FL, US (MIA - All Airports)";
        String departDateInput = "OCT 01";
        boolean isOneWay = true;

        // test itself
        HomePage home = new HomePage(driver);
        home.inputFlightData(driver, fromAirportInput, toAirportInput, departDateInput, isOneWay);
        ResultPage resultPage = new ResultPage();
        resultPage.printResults(driver);
    }
}

