package org.example;

public class Foods extends Product {

    public Foods(int productNumber, String productName, int price, int calories, String description) {
        super(productNumber, productName, price, calories, description);
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
        System.out.println("Foods : " + super.getProductName());
    }
}
