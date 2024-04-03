package shoppinglist;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import jakarta.xml.bind.*;

/**
 *
 * @author Wade
 */
public class ShoppingListModel {

    Items shoppingList;
    static final String location = "src/main/java/shoppinglist/mylist.xml";

    public ShoppingListModel() {
        shoppingList = new Items();
    }
    
    public List<Item> getItems()
    {
        return shoppingList.getList();
    }

    public void loadList() {
        // test if file is present
        if (Files.exists(Paths.get(location))) {

            // try to open file for deserialization
            try (BufferedReader input
                    = Files.newBufferedReader(Paths.get(location))) {
                // unmarshal the file's contents
                shoppingList = JAXB.unmarshal(input, Items.class);

            } catch (IOException ioException) {
                System.err.println("Error opening file.");
            }
        }
    }

    /**
     * Looks for a matching item description (ignoring case) and removes from list
     * if found.
     * @param item 
     */
    public void removeItem(Item item) {
        Iterator<Item> iterator = shoppingList.getList().iterator();
        boolean found = false;
        while (iterator.hasNext())
        {
            if (iterator.next().getItem().toLowerCase().equals(item.getItem().toLowerCase()))
            {
                iterator.remove();
                found = true;
                break;
            }
        }  
        if (found)
            updateList();
    }

    /**
     * Writes the Shopping List contents to XML file
     */
    public void updateList() {
        try (BufferedWriter output
                = Files.newBufferedWriter(Paths.get(location))) {
            // Write the Shopping List to XML file
            JAXB.marshal(shoppingList, output);
        } catch (IOException ioException) {
            System.err.println("Error opening file.");
        }
    }

    /**
     * If Item passed in matches an existing item, the contents are updated, else
     * a new item is added.
     * @param item 
     */
    public void addItem(Item item) {
        if (item.getItem().length() > 0)
        {
            Iterator<Item> iterator = shoppingList.getList().iterator();
            boolean found = false;
            while (iterator.hasNext())
            {
                Item currentItem = iterator.next();
                if (currentItem.getItem().toLowerCase().equals(item.getItem().toLowerCase()))
                {   // found matching item in the list, update
                    currentItem.setItem(item.getItem());
                    currentItem.setQuantity(item.getQuantity());
                    currentItem.setPrice(item.getPrice());
                    currentItem.setNotes(item.getNotes());
                    found = true;   
                    break;
                }
            }  
            if (!found) // if existing item not modified, add it
                shoppingList.getList().add(item);
            updateList();   // persist new list to file system
        }
    }
    
    /**
     * Looks for matching shopping list items and returns a list of whats found
     * @param i item to look for
     * @return list of matching items
     */
    public List<Item> findItem(Item i)
    {
        List<Item> items = shoppingList.getList();
        List<Item> matched = new ArrayList<>();
        
        if (i.getItem().length() > 0)
        {   
            for (Item item : items)
            {
                if (item.getItem().toLowerCase().contains(i.getItem().toLowerCase()))
                {
                    matched.add(item);
                }
            }
        }
        return matched;    
    }
}
