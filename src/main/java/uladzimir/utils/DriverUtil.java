package uladzimir.utils;

import org.openqa.selenium.WebDriver;

import static uladzimir.utils.ConfigUtil.getBrowserName;

public abstract class DriverUtil {

    private static WebDriver driver;

    public static WebDriver driver(){
        if (driver == null)
        {
            driver = BrowserFactory.getWebDriver(BrowserFactory.Browser.valueOf(getBrowserName()));
        }
        return driver;
    }

    public static void quitDriver() {
        driver.quit();
        driver = null;
    }

}
