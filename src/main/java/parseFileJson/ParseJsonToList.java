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

interface ParseJsonToList<T> {

    default List<T> jsonFileToList(String stringJson) {
        JSONParser jsonParser = new JSONParser();
        List<T> listObj = new ArrayList<>();

        try {
            JSONArray jsonArray = (JSONArray) jsonParser.parse(stringJson);
            for (Object item : jsonArray) {
                //Java представление в jason строки, наследует hashMap(ключ,значение)
                JSONObject jsonObject = (JSONObject) item;
                //доавляем в список новый созданный объект Empoyee
                listObj.add(parseObj(jsonObject));
            }
        } catch (ParseException e) {
            System.out.println("Error parse: " + e);
        }
        return listObj;
    }

    T parseObj(JSONObject jsonObject);

    default String getStringFromFileJson(String fileJson) {
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
