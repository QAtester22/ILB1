package uladzimir.pages.pageElements;

import org.openqa.selenium.By;

import static uladzimir.utils.DriverUtil.driver;


public class MenuBar {

    private static final By SEARCH_FIELD = By.xpath("//input[@id='store_nav_search_term']");
    private static final By SEARCH_BTN = By.xpath("//a[@id='store_search_link']/img");

    public void setSearchInTheSearchField (String value) {
        driver().findElement(SEARCH_FIELD).sendKeys(value);
    }

    public void clickSearchBtn () {
        driver().findElement(SEARCH_BTN).click();
    }

}
