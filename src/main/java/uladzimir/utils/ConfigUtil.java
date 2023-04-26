package uladzimir.utils;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;

/**
 * @author Uladzimir Tarasavets
 * Created 25.04.2023.
 */
public abstract class ConfigUtil {

    private static final String CONFIG_DATA = "src/main/resources/configData.json";
    private static final String TEST_DATA = "src/main/resources/testData.json";

    public static JSONObject getJObject (String filePath){
        try{
            FileReader reader = new FileReader(filePath);
            JSONParser jsonParser = new JSONParser();
            return (JSONObject) jsonParser.parse(reader);
        } catch (IOException | ParseException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static int getWaitingTime () {
        return Integer.parseInt(Objects.requireNonNull(getJObject(CONFIG_DATA)).get("waitingTime").toString());
    }

    public static String getIncognitoMode () {
        return Objects.requireNonNull(getJObject(CONFIG_DATA)).get("incognitoMode").toString();
    }

    public static String getBrowserName () {
        return Objects.requireNonNull(getJObject(CONFIG_DATA)).get("browser").toString();
    }

    public static String getSearchGame () {
        return Objects.requireNonNull(getJObject(TEST_DATA)).get("searchGame").toString();
    }

    public static String getMainPageURL () {
        return Objects.requireNonNull(getJObject(TEST_DATA)).get("mainPageURL").toString();
    }

    public static int getNumberOfResultsSaved () {
        return Integer.parseInt(Objects.requireNonNull(getJObject(TEST_DATA)).get("numberOfResultsSaved").toString());
    }

}
