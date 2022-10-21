import categories.FruitsAndVegetables;
import categories.HouseAppliancesTV;
import categories.Products;
import parseFileJson.ParseJsonAppliances;
import parseFileJson.ParseJsonFruits;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String jsonFruitFile = "data/VegetblesAndFruit.json";
        String jsonAppliancesFile = "data/HouseAppliancesTV.json";

        //продукты
        ParseJsonFruits parseProducts = new ParseJsonFruits(jsonFruitFile);
        List<Products> listFuits = parseProducts.getList();

        //бытовая техника
        ParseJsonAppliances parseAppliances = new ParseJsonAppliances(jsonAppliancesFile);
        List<Products> listAppliances = parseAppliances.getList();


//todo



    }
}
