package school.redRover;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * @Author boyko
 */
public abstract class BaseTest {

    public static WebDriver driver;

    @BeforeAll
    public static void start() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*", "--window-size=1920,1080");
        driver = new ChromeDriver(chromeOptions);
    }

    @AfterAll
    public static void close() {
        driver.quit();
    }
}
