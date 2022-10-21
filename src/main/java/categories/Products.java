package categories;
//Single Responsibility Principle
public class Products {
    private long id;
    private String name;
    private double count;
    private double price;
    private double rating;

    public Products(long id, String name, double count, double price) {
        this.id = id;
        this.name = name;
        this.count = count;
        this.price = price;
    }

}
