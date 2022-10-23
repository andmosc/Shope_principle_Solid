package payment;

import categories.IShowInfo;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class Cart implements IShowInfo, IAvailability,ICart {
    private Map<Products, Integer> mapProducts;

    private int amount;
    private int numIndex;
    protected double totalAmount;

    public Cart() {
        mapProducts = new HashMap<>();
        amount = 1;
        numIndex = 0;
    }

    public Map<Products, Integer> getMapProducts() {
        return mapProducts;
    }

    public void addProduct(Products products) {
        if (mapProducts.get(products) != null) {
            amount = mapProducts.get(products) + 1;
        } else {
            amount = 1;
        }
        if (isAvailability(products, amount)) {
            mapProducts.put(products, amount);
        } else {
            amount = 1;
            //todo товара нет в наличии
        }

    }

    @Override
    public boolean isAvailability(Products products, int amount) {
        return (products.getCount() - amount) >= 0;
    }

    @Override
    public void showInfo() {
        if (!mapProducts.isEmpty()) {
            Stream<Map.Entry<Products, Integer>> optionalIsbn = mapProducts.entrySet().stream();
            mapProducts.forEach((p, k) -> {
                System.out.println(++numIndex);
                p.showInfo();
                System.out.println("Кол-во: " + k.toString() + " шт.");
                totalAmount += k * p.getPrice();
            });
            System.out.println("\nИтого к оплате: " + totalAmount);
        } else {
            System.out.println("Ваша корзина пуста!");
        }
    }

    public boolean clearCart() {
        if (!mapProducts.isEmpty()) {
        mapProducts = new HashMap<>();
        numIndex = 0;
        return true;
        } else {
            mapProducts.size();
            System.out.println("Корзина пуста");
        }
        return false;
    }

    protected double getTotalAmount() {
        return totalAmount;
    }
}
