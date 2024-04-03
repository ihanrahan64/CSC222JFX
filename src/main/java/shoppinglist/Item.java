/*
 * Shopping Item POJO Class
 */
package shoppinglist;

/**
 *
 * @author Wade
 */
public class Item {

    private String item;
    private int quantity;
    private float price;
    private String notes;

    public Item() {
        this("", 0, (float) 0, "");
    }

    public Item(String item, int quantity, float price, String notes) {
        this.item = item;
        this.quantity = quantity;
        this.price = price;
        this.notes = notes;
    }

    /**
     * @return the item description
     */
    public String getItem() {
        return item;
    }

    /**
     * @param item the item to set
     */
    public void setItem(String item) {
        this.item = item;
    }

    /**
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * @return the price
     */
    public float getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(float price) {
        this.price = price;
    }

    /**
     * @return the notes
     */
    public String getNotes() {
        return notes;
    }

    /**
     * @param notes the notes to set
     */
    public void setNotes(String notes) {
        this.notes = notes;
    }

    public float getCost() {
        return getQuantity() * getPrice();
    }

}
