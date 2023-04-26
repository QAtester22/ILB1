package uladzimirTest;

import org.json.simple.JSONObject;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import uladzimir.pages.SearchPage;

import static uladzimir.pages.SearchPage.getListResultPieces;
import static uladzimir.utils.ConfigUtil.getNumberOfResultsSaved;
import static uladzimir.utils.ConfigUtil.getSearchGame;

/**
 * @author Uladzimir Tarasavets
 * Created 25.04.2023.
 */
public class UladzimirTest extends BaseTestU{
    SearchPage searchPage = new SearchPage();

    @Test
    public void testGameSearch () {
        searchPage.menuBar.setSearchInTheSearchField(getSearchGame());
        searchPage.menuBar.clickSearchBtn();

        Assert.assertTrue(searchPage.checkResultPage(),"Results page not open");

        Assert.assertEquals(getSearchGame(), searchPage.getSearchBoxResult(),
                "The search field on the results page does not contain the name you are looking for");

        Assert.assertEquals(getSearchGame(), searchPage.getSearchNameInTheList(0),
                "The first name in the result table is not equal to the name you are looking for");

        List<JSONObject> list1 = getListResultPieces(getNumberOfResultsSaved());
        String name2 = (String) list1.get(1).get("name");
        searchPage.menuBar.setSearchInTheSearchField(name2);
        searchPage.menuBar.clickSearchBtn();
        Assert.assertEquals(name2, searchPage.getSearchBoxResult(),
                "The search field on the results page does not contain the name you are looking for");

        List<JSONObject> list2 = getListResultPieces(getNumberOfResultsSaved());
        SoftAssert softAssert = new SoftAssert();
        for (JSONObject jsonObject : list1) {
            softAssert.assertTrue(list2.contains(jsonObject), "The result list doesn't contain the item\n " +
                    jsonObject + " \nfrom the previous search. The saved data does not match.");
        }
        softAssert.assertAll();
    }

}
