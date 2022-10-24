package parseFileJson;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

abstract class ParseJsonToList<T> {

    private List<T> listObj;
    private String stringJson;

    //Open-Closed Principle
    protected abstract T parseObj(JSONObject jsonObject);

    public List<T> getList() {
        return listObj;
    }

    protected ParseJsonToList(String fileJson) {
        this.stringJson = getStringFromFileJson(fileJson);
        jsonFileToList();
    }

    private List<T> jsonFileToList() {
        JSONParser jsonParser = new JSONParser();
        this.listObj = new ArrayList<>();

        try {
            JSONArray jsonArray = (JSONArray) jsonParser.parse(this.stringJson);
            for (Object item : jsonArray) {
                JSONObject jsonObject = (JSONObject) item;
                listObj.add(parseObj(jsonObject));
            }
        } catch (ParseException e) {
            System.out.println("Error parse: " + e);
        }
        return this.listObj;
    }

    private String getStringFromFileJson(String fileJson) {
        StringBuilder builder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileJson))) {
            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.toString());
        }
        return builder.toString();
    }
}
