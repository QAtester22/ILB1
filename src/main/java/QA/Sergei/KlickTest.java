package QA.Sergei;

import common.Common;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import java.util.*;

public class KlickTest {
    private WebDriver driver;

    @Test
    public void seleniumTest() {
        driver = Common.getInstance().selenium("http://klick.ee/");
        driver.findElement(By.cssSelector(".bg-cl-transparent > .hidden-xs:nth-child(1)")).click();
        driver.findElement(By.id("search")).sendKeys("dell ");
        driver.findElement(By.id("search")).sendKeys(Keys.ENTER);
        {
            WebElement element = driver.findElement(By.id("klevuProductImage-78008"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).perform();
        }
        driver.findElement(By.linkText("Sülearvuti Dell G15 Gaming Edition, i5 16GB 512GB RTX3050 120Hz")).click();
        {
            List<WebElement> elements = driver.findElements(By.cssSelector(".add-to-cart"));
            assert(elements.size() > 0);
        }
        driver.findElement(By.cssSelector(".add-to-cart")).click();
        {
            List<WebElement> elements = driver.findElements(By.cssSelector(".checkout-btn"));
            assert(elements.size() > 0);
        }
        driver.findElement(By.cssSelector(".checkout-btn")).click();
        {
            List<WebElement> elements = driver.findElements(By.linkText("Suundu kassasse"));
            assert(elements.size() > 0);
        }
        driver.findElement(By.cssSelector(".icon-backspace")).click();
        driver.findElement(By.id("notificationAction2")).click();
        Common.getInstance().quit();
    }
}
