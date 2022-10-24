package categories;

import payment.Products;
//Liskov substitution principle
public class FruitsAndVegetables extends Products implements IShowInfo {
    private double weight;

    public FruitsAndVegetables(long id, String name, double amount, double price, double weight) {
        super(id, name, amount, price);
        this.weight = weight;
    }

    @Override
    public void showInfo() {
        System.out.println(super.getName()
                +"\nЦена: "
                + super.getPrice()
                + "\nВес: "
                + weight);
    }
}
