package parseFileJson;

import categories.FruitsAndVegetables;
import categories.Products;
import org.json.simple.JSONObject;

//Open-Closed Principle
public class ParseJsonFruits extends ParseJsonToList<Products> {

    public ParseJsonFruits(String stringJson) {
        super(stringJson);
    }

    @Override
    protected FruitsAndVegetables parseObj(JSONObject jsonObject) {
        return new FruitsAndVegetables((long)jsonObject.get("id"), (String) jsonObject.get("name")
                , (Double) jsonObject.get("count")
                , (Double) jsonObject.get("price")
                , (Double) jsonObject.get("weight"));
    }
}
