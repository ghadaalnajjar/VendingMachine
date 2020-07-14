package org.example;

import java.util.Arrays;

public class Machine implements VendingMachine{

    Product[] products = new Product[0];

    public static Product[] incressProductSize(Product[] product) {
        return Arrays.copyOf(product, product.length + 1);
    }

    public Machine(Product product){
        products = incressProductSize(products);
        products[products.length - 1] = product;
    }

    String[] denomination = {"1kr", "2kr", "5kr", "10kr", "20kr", "50kr", "100kr", "200kr", "500kr", "1000kr"};
    int amount = 0;
    int deposit = 0;

    @Override
    public void addCurrency(int amount, String krona) {
        boolean check = true;
        for (int i = 0; i<denomination.length; i++){
            if(denomination[i].equals(amount + krona)) {
                System.out.println("The amount is valid : " + amount + krona);
                this.amount += amount;
                deposit += amount;
                check = false;
            }
        }
        if(check){
            System.out.println("The amount is not valid : " + amount + krona);
        }
    }

    @Override
    public Product request(int productNumber) {
        for (int i = 0; i < products.length; i ++){
            if(products[i].getProductNumber() == productNumber){
                amount -= products[i].getPrice();
                return products[i];
            }
        }
        return null;
    }

    @Override
    public int endSession() {
        int total = amount;
        int nettotal = deposit;
        if(total >= 0){
            System.out.println("The deposit : " + nettotal + "\tand amount : " + total + "\tless zero please add amount");
            amount = 0;
            deposit = 0;
            return total;
        }
        else
            System.out.println("The deposit : " + nettotal + "\tand amount : " + total);
            return total;
    }

    @Override
    public String getDescription(int productNumber) {
        for (int i = 0; i < products.length; i ++){
            if(products[i].getProductNumber() == productNumber){
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
        for (int i = 0; i < products.length; i ++){
            p[0] = String.valueOf(products[i].getProductNumber());
            p[1] = products[i].getProductName();
        }
        return p;
    }
}



