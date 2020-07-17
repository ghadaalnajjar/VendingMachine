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
        //Arrange
        snack = new Snacks(1, "Chips" , 20,150 , "Snack Day");
        food = new Foods(2, "Banana" , 10 ,100 , "Natural");
        drink = new Drinks(3, "Red Bull" , 50 ,45 , "Energy");

        machine = new Machine();
        machine.addProduct(snack);
        machine.addProduct(food);
        machine.addProduct(drink);
    }

    @Test
    public void productTest() {
       //ACT
        snack = new Snacks(1, "Chips" , 20,150 , "Snack Day");

        //Assert
        assertEquals(1,snack.getProductNumber());
        assertEquals("Chips",snack.getProductName());
        assertEquals(20, snack.getPrice());
        assertEquals(150, snack.getCalories());
        assertEquals("Snack Day", snack.getDescription());
    }

    @Test
    public void machineTest(){
        //Arrange
        machine.addCurrency(100, "kr");

        //act
        machine.request(1).toString();
        machine.request(2).toString();
        machine.request(3).toString();

        //Assert
        assertEquals(20, machine.getBalance());
        assertEquals("Energy", machine.getDescription(3));


        // act
        machine.endSession();

        //Assert
        assertEquals(0, machine.deposit);
    }


    @Test
    public void machineGetProducts(){
        String[] products = machine.getProducts();

        assertArrayEquals(products, machine.getProducts());
    }
}

