package org.example;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AppTest 
{

    Product snack, food, drink;
    Machine machine;

    @Before
    public void doBefore(){
        snack = new Snacks(1, "Chips" , 20 ,2, 150 , "Snack Day");
        food = new Foods(2, "Banana" , 10 ,1, 100 , "Natural");
        drink = new Drinks(3, "Red Bull" , 50 ,1, 45 , "Energy");

        machine = new Machine();
        machine.addProduct(snack);
        machine.addProduct(food);
        machine.addProduct(drink);
    }

    @Test
    public void productTest() {

        //Assert
        assertEquals(1,snack.getProductNumber());
        assertEquals("Chips",snack.getProductName());
        assertEquals(20, snack.getPrice());
        assertEquals(2, snack.getQuantity(), 0.001);
        assertEquals(150, snack.getCalories());
        assertEquals("Snack Day", snack.getDescription());
    }

    @Test
    public void machineTest(){
        machine.addCurrency(100, "kr");
        System.out.println(machine.request(1).toString());
        System.out.println(machine.request(3).toString());
        System.out.println(machine.request(3).toString());

        assertEquals(-20, machine.getBalance());
        assertEquals("Energy", machine.getDescription(3));

        // Test end Session

        machine.endSession();
        //Assert
        assertNotEquals(0, machine.deposit);

        machine.addCurrency(100, "kr");
        machine.endSession();
        //Assert
        assertEquals(0, machine.deposit);
    }


    @Test
    public void machineGetProducts(){
        String[] products = machine.getProducts();
        for (int i = 0; i < products.length; i ++){
            System.out.println(products[i]);
        }

        assertArrayEquals(products, machine.getProducts());
    }

    @Test
    public void testMethodProduct(){
        System.out.println(snack.examine());
        snack.use();

        System.out.println(food.examine());
        food.use();

        System.out.println(drink.examine());
        drink.use();
    }
}

