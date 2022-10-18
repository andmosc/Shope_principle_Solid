package parseFileJson;

import categories.Products;
import org.json.simple.JSONObject;
import parseFileJson.ParseJsonToList;
//Open-Closed Principle
public class ParseJsonProducts implements ParseJsonToList<Products> {
    @Override
    public Products parseObj(JSONObject jsonObject) {
        return new Products((long)jsonObject.get("id"), (String) jsonObject.get("name")
                , (Double) jsonObject.get("count")
                , (Double) jsonObject.get("price")
                , (Double) jsonObject.get("weight"));
    }
}
