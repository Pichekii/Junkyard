
package com.pichekiink.productbackstock;

import java.util.LinkedList;

/**
 * The {@code InventoryCatalog} class parses the inventory manifest file for a
 * list of products with a quantity greater than or equal to 50 units, and then
 * displays on {@code STDOUT} the remaining products sorted by price from high to low.
 * 
 * @author Scott Natelli
 */
public class InventoryCatalog {
    
    private static final String INVENTORY_MANIFEST = "/manifest.txt";
    
    public static void main(String[] args) {
        
        LinkedList<Product> inventory = InventoryOperations.readInventoryManifest(INVENTORY_MANIFEST);
        InventoryOperations.insertionSort(inventory);
        
        System.out.println("PRODUCT\t\tPRICE\tQUANTITY");
        
        for(Product product : inventory) {
            System.out.println( product.getName() + "\t\t" + product.getPrice() + "\t" + product.getQuantity());
        }
    }
}
