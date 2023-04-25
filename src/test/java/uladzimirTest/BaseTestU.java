package uladzimirTest;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static uladzimir.utils.ConfigUtil.getMainPageURL;
import static uladzimir.utils.DriverUtil.driver;
import static uladzimir.utils.DriverUtil.quitDriver;

/**
 * @author Uladzimir Tarasavets
 * Created 25.04.2023.
 */
public abstract class BaseTestU {
    @BeforeMethod
    public void setup() {
        driver().get(getMainPageURL());
    }

    @AfterMethod
    public void tearDown() {
        quitDriver();
    }

}
