package org.example;

import java.util.Arrays;

public class Machine implements VendingMachine{

    Product product = new Product() {
        @Override
        public String examine() {
            return null;
        }

        @Override
        public void use() {

        }

        @Override
        public Product purchase(int money) {
            return null;
        }
    };

    public Machine(Product product){
        this.product = product;
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
        amount = amount - product.getPrice() ;
        return product;
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
        return product.getDescription();
    }

    @Override
    public int getBalance() {
        return amount;
    }

    @Override
    public String[] getProducts() {
        return null;
    }
}



