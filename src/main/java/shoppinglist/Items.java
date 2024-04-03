package shoppinglist;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlElement;

/**
 *
 * @author Wade
 */
public class Items {

    // @XmlElement specifies XML element name for each object in the List
    @XmlElement(name = "item")
    private final List<Item> items = new ArrayList<>(); // holds shopping list tiems

    public List<Item> getList() {
        return items;
    }
}
