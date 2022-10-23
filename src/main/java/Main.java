import categories.Categories;
import parseFileJson.ParseJsonAppliances;
import parseFileJson.ParseJsonFruits;
import payment.Cart;
import payment.PayCart;
import payment.Products;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final String[] mainMenu = {
            "Выберите действие",
            "1 - Показать все категории товаров",
            "2 - Фильтрация товаров по ключевым словам, ценам, производителям",
            "3 - Купить товары",
            "4 - Вывести на экран товары, которые в корзине",
            "5 - Купить товары, которые в корзине",
            "6 - Очистить корзину",
            "7 - Выход"
    };


    private static final String VegetblesAndFruit = "Овощи и фрукты";
    private static final String HouseAppliancesTV = "Бытовая техника";

    public static void main(String[] args) {

        Cart cart = new Cart();
        PayCart payCart = new PayCart();

        String jsonFruitFile = "data/VegetblesAndFruit.json";
        String jsonAppliancesFile = "data/HouseAppliancesTV.json";

        //продукты
        ParseJsonFruits parseProducts = new ParseJsonFruits(jsonFruitFile);
        List<Products> listFuits = parseProducts.getList();

        //бытовая техника
        ParseJsonAppliances parseAppliances = new ParseJsonAppliances(jsonAppliancesFile);
        List<Products> listAppliances = parseAppliances.getList();


        List<Categories> categories = Arrays.asList(new Categories(VegetblesAndFruit, listFuits),
                new Categories(HouseAppliancesTV, listAppliances));

        boolean exit = true;
        int choice = 0;
        boolean subMenu = false;
        Scanner scanner = new Scanner(System.in);
        while (exit) {

            if (!subMenu) {
                printMenu(mainMenu);
                choice = correctInput(scanner, mainMenu.length - 1);
            }

            switch (choice) {
                case 1:
                    System.out.println("Категория товаров");
                    categories.forEach(p -> System.out.println(p.getCategoryName()));
                    choice = correctInput(scanner, categories.size());
                    categories.get(choice - 1).showInfo();

                    System.out.println("Введите номер товара для добавления в корзину: ");
                    int choiceProduct = correctInput(scanner, categories.get(choice - 1).getCounterList());
                    cart.addProduct(categories.get(choice - 1).getProducts(choiceProduct - 1));
                    subMenu = false;
                    break;
                case 3:
                    choice = 1;
                    subMenu = true;
                    break;
                case 4:
                    cart.showInfo();
                    break;
                case 5:
                    if (payCart.productsPay(cart)) {
                        System.out.println("Оплата прошла успешно");
                    } else {
                        System.out.println("Корзина пуста");
                    }
                    break;
                case 6:
                    cart.clearCart();
                    break;
                case 7:
                    exit = false;
                    break;
            }
        }
    }

    private static void printMenu(String[] mainMenu) {
        Arrays.stream(mainMenu).forEachOrdered(System.out::println);
    }

    private static int correctInput(Scanner scanner, int sizeMenu) {
        boolean correct = false;
        int choiceInt = 0;
        String choice;
        scanner = new Scanner(System.in);
        do {
            System.out.print("Введите значение: ");
            choice = scanner.nextLine();
            if (strIsNum(choice)) {
                choiceInt = Integer.parseInt(choice);
                if (choiceInt <= sizeMenu && choiceInt > 0) {
                    correct = true;
                } else {
                    correct = false;
                }
            }
        } while (!correct);
        return choiceInt;
    }

    private static boolean strIsNum(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
