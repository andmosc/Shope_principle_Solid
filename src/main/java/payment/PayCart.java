package payment;

public class PayCart  {

    public boolean productsPay(Cart cart) {

        if(!cart.getMapProducts().isEmpty()) {
            cart.getMapProducts().forEach((product, amount) -> {
                double count = (product.getCount() - amount);
                product.setCount(count);
            });
            if (productIsPaid(cart.getTotalAmount())) {
                cart.clearCart();
                return true;
            }
        }
        return false;
    }

    //todo реализация метода проверки
    private boolean productIsPaid(double totalAmount) {
        return true;
    }

}
