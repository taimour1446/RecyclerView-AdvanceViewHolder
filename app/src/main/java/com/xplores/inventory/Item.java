package com.xplores.inventory;

public class Item {

    /**
     * Class Data Members
     */
    String title;
    String quantity;

    /**
     * Constructors
     */
    public Item(){}

    public Item(String title, String quantity) {
        this.title = title;
        this.quantity = quantity;
    }
    /**
     * Getter and Setter
     */
    public String getTitle() {
        return title;
    }
    public String getQuantity() {
        return quantity;
    }
}
