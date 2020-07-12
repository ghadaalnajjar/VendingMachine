package org.example;

import java.util.Arrays;

public class Machine extends Product implements VendingMachine{

    public Product[] products = new Product[3];
    String[] denomination = {"1kr", "2kr", "5kr", "10kr", "20kr", "50kr", "100kr", "200kr", "500kr", "1000kr"};
    int amount = 0;
    int deposit = 0;

    public Machine(int productId, String productName, int price, double quantity, int calories, String description) {
        super(productId, productName, price, quantity, calories, description);
    }

    @Override
    public void addCurrency(int amount, String krona) {
        boolean check = true;
        for (int i = 0; i<denomination.length; i++){
            if(denomination[i].equals(amount + krona)) {
                System.out.println("The amount is valid : " + amount + krona);
                this.amount = amount;
                deposit = amount;
                check = false;
            }
        }
        if(check){
            System.out.println("The amount is not valid : " + amount + krona);
        }
    }

    @Override
    public Product request(int productNumber) {
        for (int i = 0; i < products.length; i++){
            if (products[i].getProductId() == productNumber) {
                amount = amount - products[i].getPrice();
                return products[i];
            }
        }
        return null;
    }

    @Override
    public int endSession() {
        if(amount >= 0){
            System.out.println("The deposit : " + deposit + "\tand amount : " + amount + "\tless zero please add amount");
            return amount;
        }
        else
            System.out.println("The deposit : " + deposit + "\tand amount : " + amount);
            return amount;
    }

    @Override
    public String getDescription(int productNumber) {
        for (int i = 0; i < products.length; i++){
            if (products[i].getProductId() == productNumber) {
                return products[i].getDescription();
            }
        }
        return null;
    }

    @Override
    public int getBalance() {
        return amount;
    }

    @Override
    public String[] getProducts() {
        String[] p = new String[products.length];
        for (int i = 0; i < products.length; i++){
            p[0] = String.valueOf(products[i].getProductId());
            p[1] = products[i].getProductName();
        }
        return p;
    }
}



