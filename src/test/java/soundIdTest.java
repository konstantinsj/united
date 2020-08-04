import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

public class soundIdTest {

        @Test
        public void loginTest()  {

            System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver\\chromedriver.exe");
            WebDriver driver = new ChromeDriver();

            String baseUrl = "https://www.sonarworks.com/soundid";    // web page
            By my_account = By.linkText("My account");      // click my account
            By continueWithEmail = By.linkText("Continue with Email");  // vacancies
            By emailInputField= By.id("input-field-1");
            By passwordInputField = By.id("input-field-2");
            By loginButton = By.cssSelector("button.button");
            By logOutButton = By.className("log-out");
            String my_email = "Konstantin.Ekimov@gmail.com";
            String my_password = "ekimovcmd";

            // opening page:
            driver.get(baseUrl);
            driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);

            //click on my account
            driver.findElement(my_account).click();

            //click on login with email
            driver.findElement(continueWithEmail).click();

            //enter credentials
            driver.findElement(emailInputField).sendKeys(my_email);
            driver.findElement(passwordInputField).sendKeys(my_password);
            driver.findElement(loginButton).click();

            //check if there is log out button, which means we are logged in
            driver.findElement(logOutButton);

            //close browser
            driver.close();
        }
    }
