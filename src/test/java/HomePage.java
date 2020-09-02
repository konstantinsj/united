import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    //Locators
    @FindBy(id = "oneway")
    private WebElement setOneWay;

    @FindBy(id = "bookFlightOriginInput")
    private WebElement fromAirport;

    @FindBy(id = "bookFlightDestinationInput")
    private WebElement destinationAirport;

    @FindBy(id = "DepartDate")
    private WebElement departDate;

    public HomePage(WebDriver driver) {
        //Page URL
        String pageUrl = "https://www.united.com";
        driver.get(pageUrl);

    }

    public void inputFlightData(WebDriver driver, String fromAirportInput, String toAirportInput, String departDateValue, boolean isOneWay) {

        PageFactory.initElements(driver, this);
        if (isOneWay) {
            driver.findElement(By.id("oneway")).click();
        }

        By fromAirport = By.id("bookFlightOriginInput");  // from
        By destinationAirport = By.id("bookFlightDestinationInput"); // destination
        By departDate = By.id("DepartDate");

        driver.findElement(fromAirport).sendKeys(Keys.CONTROL + "a");
        driver.findElement(fromAirport).sendKeys(Keys.DELETE);
        driver.findElement(fromAirport).sendKeys(fromAirportInput);
        driver.findElement(destinationAirport).sendKeys(toAirportInput);
        driver.findElement(departDate).sendKeys(Keys.CONTROL + "a");
        driver.findElement(departDate).sendKeys(Keys.DELETE);
        driver.findElement(departDate).sendKeys(departDateValue);
        driver.findElement(departDate).submit();
    }
}
