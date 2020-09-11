import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ResultPage extends UnitedAirlinesTest {

    public void printResults() {
        driver.findElement(By.id("a-results-show-all")).click();
        driver.findElement(By.id("column-ECO-BASIC")).click();

        List<WebElement> getTableDepartData = driver.findElements(By.className("flight-time-depart"));
        List<WebElement> getTableArriveData = driver.findElements(By.className("flight-time-arrive"));
        List<WebElement> getTableStopsData = driver.findElements(By.className("flight-connection-container"));
        List<WebElement> getTableFlightData = driver.findElements(By.className("flight-duration"));
        List<WebElement> getTableEcoPrice = driver.findElements(By.cssSelector("[id*=sr_product_ECO-BASIC]"));

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try {
            for (int i = 0; i < getTableEcoPrice.size(); i++) {
                System.out.println(gson.toJson(getTableDepartData.get(i).getText().replace("\n", "")) + " " +
                        gson.toJson(getTableArriveData.get(i).getText().replace("\n", " ")) + " " +
                        gson.toJson(getTableFlightData.get(i).getText().replace("\n", " ")) + " " +
                        gson.toJson(getTableStopsData.get(i).getText().replace("\n", " ")) + " " +
                        gson.toJson(getTableEcoPrice.get(i).getText().replace("\n", " ")));
            }
        } catch
        (Exception e) {
            System.out.println("No Data Found");
        }
    }
}


