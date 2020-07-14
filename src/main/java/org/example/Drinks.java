package org.example;

public class Drinks extends Product {

    public Drinks(int productNumber, String productName, int price, double quantity, int calories, String description) {
        super(productNumber, productName, price, quantity, calories, description);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public String examine() {
        return "\nExamine: " + super.getProductName() + "\t\t" + super.getPrice();
    }

    @Override
    public void use() {
        System.out.println("Drinks : " + super.getProductName());
    }

    @Override
    public Product purchase(int money) {
        return null;
    }
}

