package categories;

//Single Responsibility Principle
public class HouseAppliancesTV extends Products implements ICategories {
    private double diagonal;

    public HouseAppliancesTV(long id, String name, double count, double price, double diagonal) {
        super(id, name, count, price);
        this.diagonal = diagonal;
    }

    @Override
    public String toString() {
        return "HouseAppliancesTV{" +
                "diagonal=" + diagonal +
                '}';
    }
}
