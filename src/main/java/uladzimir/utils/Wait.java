package uladzimir.utils;

import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static uladzimir.utils.ConfigUtil.getWaitingTime;
import static uladzimir.utils.DriverUtil.driver;

public abstract class Wait {

    private static WebDriverWait wait  = null;

    public static WebDriverWait getWait() {
        try {
            wait = new WebDriverWait(driver(), Duration.ofSeconds(getWaitingTime()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return wait;
    }

}
