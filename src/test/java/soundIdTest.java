import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class soundIdTest {

    static WebDriver driver;

    @BeforeClass
    public static void setup()
    {
            System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(20000, TimeUnit.MILLISECONDS);
    }
    @Test
    public void loginTest() {

        // predefined variables
        String baseUrl = "https://www.united.com";    // web page
        By oneway = By.id("oneway");      // click on oneway
        By fromAirport = By.id("bookFlightOriginInput");  // from
        By destinationAirport = By.id("bookFlightDestinationInput"); // destination
        By departDate = By.id("DepartDate");
        By fareType = By.id("column-ECO-BASIC");

        String fromAirportInput = "New York, NY, US (JFK)";
        String toAirportInput = "Miami, FL, US (MIA - All Airports)";
        String departDateValue = "OCT 01";


        // opening page:
        driver.get(baseUrl);

        //click on my account
        driver.findElement(oneway).click();

        //input from
        driver.findElement(fromAirport).sendKeys(Keys.CONTROL + "a");
        driver.findElement(fromAirport).sendKeys(Keys.DELETE);
        driver.findElement(fromAirport).sendKeys(fromAirportInput);
        driver.findElement(destinationAirport).sendKeys(toAirportInput);

        //input date
        driver.findElement(departDate).sendKeys(Keys.CONTROL + "a");
        driver.findElement(departDate).sendKeys(Keys.DELETE);
        driver.findElement(departDate).sendKeys(departDateValue);
        driver.findElement(departDate).submit();

//        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        WebElement table = driver.findElement(By.xpath("//*[@id=\"flight-result-list-revised\"]"));
//        List<WebElement> rows = table.findElements(By.tagName("li"));

      driver.findElement(By.id("a-results-show-all")).click();
        driver.findElement(fareType).click();

        List<WebElement> getTableDepartData = driver.findElements(By.className("flight-time-depart"));
        List<WebElement> getTableArriveData = driver.findElements(By.className("flight-time-arrive"));
        List<WebElement> getTableFlightData = driver.findElements(By.className("flight-duration"));
        List<WebElement> getTableEcoPrice = driver.findElements(By.cssSelector("[id*=sr_product_ECO-BASIC]"));

        try {
  //          for (int i = 1; i < getTableEcoPrice.size(); i++) {
            for (int i = 0; i < 2; i++) {
                System.out.println(getTableDepartData.get(i).getText());
                System.out.println(getTableArriveData.get(i).getText());
               System.out.println(getTableFlightData.get(i).getText());
               System.out.println(getTableEcoPrice.get(i).getText());

//                System.out.println(gson.toJson(getTableDepartData.get(i).getText()) + gson.toJson(getTableArriveData.get(i).getText()) + gson.toJson(getTableFlightData.get(i).getText()) + gson.toJson(getTableEcoPrice.get(i).getText()));
            }
        }

        catch
        (Exception e)
        {
            System.out.println("No Data Found");
        }
    }

    @AfterClass
    public static void tearDown()
    {
        driver.close();
    }
}
