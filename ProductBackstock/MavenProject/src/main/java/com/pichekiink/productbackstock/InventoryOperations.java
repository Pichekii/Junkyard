
package com.pichekiink.productbackstock;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;

/**
 * The {@code InventoryOperations} class provides a method for sorting the
 * valid products in the inventory list and a method to parse the text file
 * containing the product inventory.
 * 
 * @author Scott Natelli
 */
public class InventoryOperations {
    
    /**
     * Sorts the inventory using the product's price from high to low.
     * @param inventory A {@code } object containing the {@code Product} inventory.
     */
    public static void insertionSort(LinkedList<Product> inventory) {
        
        for(int currentItem = 1; currentItem < inventory.size(); currentItem++) {
            Product temp = inventory.get(currentItem);
            int previousItem;
            
            for(previousItem = currentItem - 1; previousItem >= 0 && temp.getPrice() > inventory.get(previousItem).getPrice(); previousItem--) {
                inventory.set(previousItem + 1, inventory.get(previousItem));
            }
            
            inventory.set(previousItem + 1, temp);
        }
    }
    
    /**
     * Parses a text file for any product with a quantity greater than or equal
     * to 50 units and stores the information in a {@code Product} object.
     * @param file The file path for the inventory list text file.
     * @return A {@code LinkedList} containing the valid inventory products.
     */
    public static LinkedList<Product> readInventoryManifest(String file) {
        LinkedList<Product> inventory = new LinkedList<>();
        
        InputStream inputStream = InventoryOperations.class.getResourceAsStream(file);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        
        try {
            String line = reader.readLine();
            
            while((line = reader.readLine()) !=  null) {
                String[] values = line.split("\\s+");
                
                if(Integer.valueOf(values[2]) >= 50) {
                    Product product = new Product(values[0], Double.valueOf(values[1]), Integer.valueOf(values[2]));
                    inventory.add(product);
                }
            }
            
            reader.close();
        } catch (IOException ex) {
            System.out.println(ex);
        }
        
        return inventory;
    }
}
