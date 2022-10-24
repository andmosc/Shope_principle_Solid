package payment;
//Interface segregation principle
public interface IAvailability {
    boolean isAvailability(Products products,int amount);
}
