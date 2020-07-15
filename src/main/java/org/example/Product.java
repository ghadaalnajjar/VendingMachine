package org.example;

public abstract class Product {

    private int productNumber;
    private String productName;
    private int price;
    private double quantity;
    private int calories;
    private String description;

    public Product(int productNumber, String productName, int price, double quantity, int calories, String description) {
        this.productNumber = productNumber;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.calories = calories;
        this.description = description;
    }

    public int getProductNumber() {
        return productNumber;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        productName = productName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public abstract String examine();

    public abstract void use();

    public abstract Product purchase(int money);

    @Override
    public String toString() {
        return getProductNumber() + "\t" + getProductName() + "\t" + getPrice() + "\t" + getQuantity() + "\t" + getCalories() + "\t" + getDescription();
    }
}
