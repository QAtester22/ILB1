package uladzimir.pages;

import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import uladzimir.model.Information;
import uladzimir.pages.pageElements.MenuBar;

import java.util.ArrayList;
import java.util.List;

import static uladzimir.utils.Converter.objectToJson;
import static uladzimir.utils.DriverUtil.driver;

/**
 * @author Uladzimir Tarasavets
 * Created 25.04.2023.
 */
public class SearchPage {

    public MenuBar menuBar = new MenuBar();

    private static final By UNIQUE_RESULT_PAGE_ELEMENT = By.id("advsearchform");
    private static final By SEARCH_FIELD = By.xpath("//input[@id='term']");
    private static final By LIST_OF_SEARCH_RESULTS = By.xpath("//div[@id='search_resultsRows']/a");
    private static final By NAME_FROM_RESULT_LIST = By.xpath(".//span[@class='title']");
    private static final By PLATFORMS_FROM_RESULT_LIST = By.xpath(".//span[contains(@class,'platform_img')]");
    private static final By RELEASE_DATA_FROM_RESULT_LIST = By.xpath(".//div[contains(@class,'search_released')]");
    private static final By REVIEW_SUMMARY_RESULT_FROM_RESULT_LIST = By.xpath(".//span[contains(@class,'search_review_summary')]");
    private static final By PRICE_FROM_RESULT_LIST = By.xpath(".//div[2][contains(@class,'search_price')]");


    public boolean checkResultPage () {
        return driver().findElements(UNIQUE_RESULT_PAGE_ELEMENT).size() > 0;
    }

    public String getSearchBoxResult () {
        return driver().findElement(SEARCH_FIELD).getAttribute("value");
    }

    public static List<WebElement> getListOfSearchResults () {
        return driver().findElements(LIST_OF_SEARCH_RESULTS);
    }

    public String getSearchNameInTheList (int number) {
        return getListOfSearchResults().get(number).findElement(By.xpath(".//span[@class='title']")).getText();
    }

    public static JSONObject getInformation (int number) {
        WebElement webElement1 = getListOfSearchResults().get(number);
        String name = webElement1.findElement(NAME_FROM_RESULT_LIST).getText();

        List<String> platforms = new ArrayList<>();
        List<WebElement> listPlatforms = webElement1.findElements(PLATFORMS_FROM_RESULT_LIST);
        for (WebElement el : listPlatforms){
            platforms.add(el.getAttribute("class"));
        }

        String releaseDate = webElement1.findElement(RELEASE_DATA_FROM_RESULT_LIST).getText();
        String nameAttribute = webElement1.findElement(REVIEW_SUMMARY_RESULT_FROM_RESULT_LIST).getAttribute("data-tooltip-html");
        String[] review = nameAttribute.split("<");
        String reviewSummaryResult = review[0];
        String price = webElement1.findElement(PRICE_FROM_RESULT_LIST).getText();

        return objectToJson(new Information(name, platforms, releaseDate, reviewSummaryResult, price));
    }

    public static List<JSONObject> getListResultPieces(int pieces){
        List<JSONObject> jsonObjList = new ArrayList<>();
        for (int i = 0; i < pieces; i++) {
            jsonObjList.add(getInformation(i));
        }
        return jsonObjList;
    }

}
