package parseFileJson;

import categories.HouseAppliancesTV;
import payment.Products;
import org.json.simple.JSONObject;
//Open-Closed Principle
public class ParseJsonAppliances extends ParseJsonToList<Products> {

    public ParseJsonAppliances(String stringJson) {
        super(stringJson);
    }

    @Override
    protected HouseAppliancesTV parseObj(JSONObject jsonObject) {
        return new HouseAppliancesTV((long)jsonObject.get("id"),(String) jsonObject.get("name")
        ,(Double) jsonObject.get("amount")
        ,(Double) jsonObject.get("price")
        , (Double) jsonObject.get("diagonal"));
    }

}
