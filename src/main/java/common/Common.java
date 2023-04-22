package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class Common {
    private static final Common INSTANCE = new Common();
    public static Common getInstance(){
        return INSTANCE;
    }
    private WebDriver driver;

    public WebDriver selenium(String url) {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*", "--window-size=1920,1080");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(url);
        driver.manage().window().maximize();
        return driver;
    }
        public void quit(){
        driver.quit();
    }
}
