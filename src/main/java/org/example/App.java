package org.example;
public class App{

    public static void main(String[] args) {

        Product product = new Snacks(1, "Chips" , 20 ,2, 150 , "Snack Day");

        Machine m = new Machine(product);
        m.addCurrency(20,"kr");

        product.use();
        if (product instanceof Snacks){
            Snacks temp = (Snacks)product;
            System.out.println(temp);

        }
    }
}


