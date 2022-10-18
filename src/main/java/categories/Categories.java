package categories;

import java.util.HashMap;
import java.util.List;

public class Categories {
    private HashMap<String, List<?>> cat = new HashMap<>();

    public void addCategories(String name, List<?> cate) {
        cat.put(name, cate);
    }

    public void print() {
        System.out.println(cat.toString());
    }

    //todo вывод списка по ключу
}
