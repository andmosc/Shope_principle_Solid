package categories;
import payment.Products;

import java.util.List;

//Single Responsibility Principle
public class Categories {
    private final String categoryName;
    private final List<Products> products;
    private final int id;
    private int counterList = 0;

    private static int lastId = 1;

    public Categories(String categoryName, List<Products> products) {
        this.categoryName = categoryName;
        this.products = products;
        this.id = lastId++;
    }

    public Products getProducts(int choice) {
        return products.get(choice);
    }

    public void showInfo() {
        products.forEach(p-> {
            System.out.println(++counterList);
            p.showInfo();
        }
        );
    }

    public String getCategoryName() {
        return id+"."+categoryName;
    }

    public int getCounterList() {
        return counterList;
    }
}
