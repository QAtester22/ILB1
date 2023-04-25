package uladzimir.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import static uladzimir.utils.DriverUtil.driver;

public abstract class Utility {

    public static void scrollToPageElement (By element) {
        JavascriptExecutor js = (JavascriptExecutor) driver();
        js.executeScript("arguments[0].scrollIntoView(true);", (driver().findElement(element)));

    }

}
