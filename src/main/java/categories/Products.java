package categories;
//Single Responsibility Principle
public class Products implements ICategories{
    private long id;
    private String name;
    private double count;
    private double price;
    private double weight;
    private double rating;

    public Products(long id, String name, double count, double price, double weight) {
        this.id = id;
        this.name = name;
        this.count = count;
        this.price = price;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Products{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", count=" + count +
                ", price=" + price +
                ", weight=" + weight +
                ", rating=" + rating +
                '}';
    }
}
