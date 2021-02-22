
package com.pichekiink.productbackstock;

/**
 * The {@code Product} class contains the name, price, and quantity of a product
 * in the inventory list.
 * 
 * @author Scott Natelli
 */
public class Product {
    
    private double price;
    private String name;
    private int quantity;
    
    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
    
    public String getName() {
        return this.name;
    }
    
    public double getPrice() {
        return this.price;
    }
    
    public int getQuantity() {
        return this.quantity;
    }
}
