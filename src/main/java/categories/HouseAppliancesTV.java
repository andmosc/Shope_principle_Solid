package categories;

import java.util.List;

//Single Responsibility Principle
public class HouseAppliancesTV implements ICategories {
    private long id;
    private String model;
    private double diagonal;
    private double price;

    public HouseAppliancesTV(long id, String model, double diagonal, double price) {
        this.id = id;
        this.model = model;
        this.diagonal = diagonal;
        this.price = price;
    }

    @Override
    public String toString() {
        return "HouseAppliancesTV{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", diagonal=" + diagonal +
                ", price=" + price +
                '}';
    }
}
