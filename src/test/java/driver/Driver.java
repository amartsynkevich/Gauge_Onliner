package driver;

import com.thoughtworks.gauge.BeforeSuite;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {

    public static WebDriver driver;

    @BeforeSuite
    public static void getWebDriver() {
        System.setProperty("webdriver.chrome.driver", "/dev-tools/ChromeDriver/chromedriver.exe");
        driver =  new ChromeDriver();
    }
}
