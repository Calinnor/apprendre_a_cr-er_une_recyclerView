package com.cirederf.rcv;

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
