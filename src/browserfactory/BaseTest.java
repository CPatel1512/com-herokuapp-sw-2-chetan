package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {

    public static WebDriver driver;

    public void setBaseUrl(){
        String baseUrl = "http://the-internet.herokuapp.com/login";
        //launch the Chrome browser
        driver = new ChromeDriver();
        //open the url in browser
        driver.get(baseUrl);
        //Maximise Browser
        driver.manage().window().maximize();
        //we give Implicite wait to Driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
}
