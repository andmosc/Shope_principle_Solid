import categories.Categories;
import categories.HouseAppliancesTV;
import categories.Products;
import parseFileJson.ParseJsonAppliances;
import parseFileJson.ParseJsonProducts;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String jsonFruitFile = "data/VegetblesAndFruit.json";
        String jsonAppliancesFile = "data/HouseAppliancesTV.json";

        //продукты
        ParseJsonProducts parseProducts = new ParseJsonProducts();
        String jsonString = parseProducts.getStringFromFileJson(jsonFruitFile);
        List<Products> listProduct = parseProducts.jsonFileToList(jsonString);
        listProduct.forEach(System.out::println);

        System.out.println();

        //бытовая техника
        ParseJsonAppliances parseAppliances = new ParseJsonAppliances();
        jsonString = parseAppliances.getStringFromFileJson(jsonAppliancesFile);
        List<HouseAppliancesTV> listAppliances = parseAppliances.jsonFileToList(jsonString);
        listAppliances.forEach(System.out::println);

        Categories cat = new Categories();
        cat.addCategories("Овощи и фрукты",listProduct);
        cat.addCategories("ТВ",listAppliances);

//todo



    }
}
