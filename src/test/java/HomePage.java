import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends UnitedAirlinesTest {

    //Locators
    By fromAirportLocator = By.id("bookFlightOriginInput");  // from
    By destinationAirportLocator = By.id("bookFlightDestinationInput"); // destination
    By departDateLocator = By.id("DepartDate");  //date
    By oneway = By.id("oneway"); // one way flight

    String pageUrl = "https://www.united.com";  //Page URL

    public HomePage() {
        driver.get(pageUrl);
    }

    public void inputFlightData(String fromAirportInput, String toAirportInput, String departDateInput, boolean isOneWay) {

        PageFactory.initElements(driver, this);
        if (isOneWay) {
            driver.findElement(oneway).click();
        }
        inputData(fromAirportInput, fromAirportLocator);
        inputData(toAirportInput, destinationAirportLocator);
        inputData(departDateInput, departDateLocator);
        driver.findElement(departDateLocator).submit();
    }

    private void inputData(String inputData, By inputLocator) {
        driver.findElement(inputLocator).sendKeys(Keys.CONTROL + "a");
        driver.findElement(inputLocator).sendKeys(Keys.DELETE);
        driver.findElement(inputLocator).sendKeys(inputData);
    }
}
