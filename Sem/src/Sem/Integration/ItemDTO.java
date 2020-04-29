package Sem.Integration;

import Sem.Model.Amount;

/**
 * The class to handle the item object and their properties
 */
public class ItemDTO {
    private final Amount price;
    private final String itemName;
    private final double itemVat;
    private final String itemID;

    /**
     *
     * @param price Price of an item
     * @param itemName Name of an item
     * @param itemVat The Vat of the item
     * @param itemID The items identifier, random number and letters
     */

    public ItemDTO(Amount price, String itemName, double itemVat, String itemID){
        this.price = price;
        this.itemName = itemName;
        this.itemVat = itemVat;
        this.itemID = itemID;
    }

    /**
     *
     * @return the items name
     */
    public String getItemName(){
        return itemName;
    }

    /**
     *
     * @return price of item
     */
    public Amount getPrice() {
        return price;
    }

    /**
     *
     * @return Vat of the item
     */
    public double getItemVat() {
        return itemVat;
    }

    /**
     *
     * @return the items ID
     */
    public String getItemID() {
        return itemID;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Item: " + itemName + ", ");
        builder.append("Price: " + price + ", ");
        builder.append("Vat: " + itemVat + ", ");
        return builder.toString();
    }
}
