package uladzimir.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public abstract class Converter {

    public static JSONObject objectToJson(Object obj) {
        ObjectMapper mapper = new ObjectMapper();
        JSONParser parser = new JSONParser();
        try {
            return (JSONObject) parser.parse(mapper.writeValueAsString(obj));
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

}
