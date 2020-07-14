package org.example;
public class App{

    public static void main(String[] args) {

        Product product = new Snacks(1, "Chips" , 20 ,2, 150 , "description");

        Machine m = new Machine(product);
        m.addCurrency(10,"kr");

    }
}


