package categories;

public class FruitsAndVegetables extends Products implements ICategories{
    private double weight;

    public FruitsAndVegetables(long id, String name, double count, double price, double weight) {
        super(id, name, count, price);
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "FruitsAndVegetables{" +
                "weight=" + weight +
                '}';
    }
}
