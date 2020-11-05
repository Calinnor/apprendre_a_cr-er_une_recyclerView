package com.cirederf.rcv;

/*
class create for recyclerview implementation
Step 2 recyclerview create getters/setters
step3 recyclerview go in xml (here is main)
 */
public  class Ingredients {

    private final String name;
    private final int quantity;

    public Ingredients(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }
}
