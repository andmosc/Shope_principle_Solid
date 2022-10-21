package parseFileJson;

import categories.HouseAppliancesTV;
import categories.Products;
import org.json.simple.JSONObject;
//Open-Closed Principle
public class ParseJsonAppliances extends ParseJsonToList<Products> {

    public ParseJsonAppliances(String stringJson) {
        super(stringJson);
    }

    @Override
    protected HouseAppliancesTV parseObj(JSONObject jsonObject) {
        return new HouseAppliancesTV((long)jsonObject.get("id"),(String) jsonObject.get("model")
        ,(Double) jsonObject.get("diagonal")
        ,(Double) jsonObject.get("price")
        , (long) jsonObject.get("count"));
    }

}
