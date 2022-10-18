package parseFileJson;

import categories.HouseAppliancesTV;
import org.json.simple.JSONObject;
//Open-Closed Principle
public class ParseJsonAppliances implements ParseJsonToList<HouseAppliancesTV> {
    @Override
    public HouseAppliancesTV parseObj(JSONObject jsonObject) {
        return new HouseAppliancesTV((long)jsonObject.get("id"),(String) jsonObject.get("model")
        ,(Double) jsonObject.get("diagonal")
        ,(Double) jsonObject.get("price"));
    }

}
