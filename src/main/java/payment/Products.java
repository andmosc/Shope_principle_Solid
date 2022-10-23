package payment;

import categories.IShowInfo;

//Single Responsibility Principle
public class Products implements IShowInfo {
    private final long id;
    private final String name;
    private double count;
    private final double price;
    private double rating;

    public Products(long id, String name, double count, double price) {
        this.id = id;
        this.name = name;
        this.count = count;
        this.price = price;
    }

    @Override
    public void showInfo() {
        System.out.println("[ "+id+" ]\n"
                + name + " \n"
        + price + " руб. ");
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getCount() {
        return count;
    }

    public double getPrice() {
        return price;
    }

    public double getRating() {
        return rating;
    }

    protected void setCount(double count) {
        this.count = count;
    }
}
