package org.example;

public interface VendingMachine {

    public void addCurrency (int amount, String krona);

    public Product request (int productNumber);

    public int endSession ();

    public String getDescription (int productNumber);

    public int getBalance ();

    public String [] getProducts ();
}
