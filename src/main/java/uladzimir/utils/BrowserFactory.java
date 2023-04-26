package uladzimir.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import static uladzimir.utils.ConfigUtil.getIncognitoMode;


public abstract class BrowserFactory {

    public enum Browser {
        CHROME, FIREFOX, EDGE
    }

    public static WebDriver getWebDriver (Browser browser) {
        return switch (browser) {
            case CHROME -> getChromeDriver();
            case FIREFOX -> getFirefoxDriver();
            default -> null;
        };
    }

    private static ChromeDriver getChromeDriver () {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments(getIncognitoMode());
        options.addArguments("start-maximized");
        return new ChromeDriver(options);
    }

    private static FirefoxDriver getFirefoxDriver () {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments(getIncognitoMode());
        options.addArguments("start-maximized");
        return new FirefoxDriver(options);
    }

}
