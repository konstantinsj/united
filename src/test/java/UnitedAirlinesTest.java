import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
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
    public static void tearDown()
    {
        driver.close();
    }

    @Test
    public void searchFlightTest() {
        String fromAirportInput = "New York, NY, US (JFK)";
        String toAirportInput = "Miami, FL, US (MIA - All Airports)";
        String departDateValue = "OCT 01";

        HomePage home = new HomePage(driver);
        home.inputFlightData(driver, fromAirportInput, toAirportInput, departDateValue);

        WebElement showAllResults = driver.findElement(By.id("a-results-show-all"));
        WebElement sortByColumn = driver.findElement(By.id("column-ECO-BASIC"));

        // results page
        showAllResults.click();
        sortByColumn.click();

        List<WebElement> getTableDepartData = driver.findElements(By.className("flight-time-depart"));
        List<WebElement> getTableArriveData = driver.findElements(By.className("flight-time-arrive"));
        List<WebElement> getTableStopsData = driver.findElements(By.className("flight-connection-container"));
        List<WebElement> getTableFlightData = driver.findElements(By.className("flight-duration"));
        List<WebElement> getTableEcoPrice = driver.findElements(By.cssSelector("[id*=sr_product_ECO-BASIC]"));

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try {
            for (int i = 0; i < getTableEcoPrice.size(); i++) {
                System.out.println(gson.toJson(getTableDepartData.get(i).getText()) +
                        gson.toJson(getTableArriveData.get(i).getText()) +
                        gson.toJson(getTableFlightData.get(i).getText()) +
                        gson.toJson(getTableStopsData.get(i).getText()) +
                        gson.toJson(getTableEcoPrice.get(i).getText()));
            }
        }

        catch
        (Exception e)
        {
            System.out.println("No Data Found");
        }
    }
}

