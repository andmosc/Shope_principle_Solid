package categories;

import payment.Products;

//Single Responsibility Principle
public class HouseAppliancesTV extends Products implements IShowInfo {
    private double diagonal;

    public HouseAppliancesTV(long id, String name, double amount, double price, double diagonal) {
        super(id, name, amount, price);
        this.diagonal = diagonal;
    }

    @Override
    public void showInfo() {
        System.out.println("Модель: "
                + super.getName()
                + "\nДиагональ: "
                + diagonal
                + "\nЦена: "
                + super.getPrice()
                + ((super.getCount() == 0) ? "Товара нет в наличии":""));
    }
}
