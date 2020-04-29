package Sem.Model;

import Sem.Integration.ItemDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * This class deals with external inventory as well as what items there exists and their value
 */
public class ExInventory {

    /**
     * Used instead of a database to represent the item that exist
     */
    private List<ItemData> items = new ArrayList<>();

    /**
     * Creates a new list of items
     */
    public ExInventory(){
        addItems();
    }

    /**
     * Based on a itemID, compares it to the items that exist trying to find one with same ID
     * @param searchedItem The itemID that the program is trying to find
     * @return The value of the item with the same ID, if no one is found, returns null
     */
    public ItemDTO findItem(String searchedItem){
        for (ItemData item : items){
            if(matches(searchedItem, item))
                return new ItemDTO(item.price,item.itemName,item.itemVat,item.itemID);
        }

        return null;
    }

    /**
     * Compares two itemID
     * @return The value of the comparison
     */
    private boolean matches(String searched, ItemData found){
        return (found.itemID.equals(searched));
    }

    /**
     * After a sale is complete updates the inventory with the items sold and how many of them
     * @param itemToChange The SaleDTO used for the current sale
     */
    public void UppdateInventory(SaleDTO itemToChange){
        for(ItemData item: items){
            if(matches(itemToChange.getItem().getItemID(),item)){
                int newAmount = item.itemAmount-itemToChange.getItemAmount();
                item.setItemAmount(newAmount);
            }
        }
    }

    /**
     * Example items used for testing
     */
    private void addItems(){
        items.add(new ItemData(new Amount(10),"A",1.06,"A00001",10));
        items.add(new ItemData(new Amount(20),"B",1.12,"B00002",10));
        items.add(new ItemData(new Amount(10),"C",1.25,"C00003",10));


    }



    private static class ItemData {
        private String itemID;
        private Amount price;
        private String itemName;
        private double itemVat;
        private int itemAmount;

        public ItemData(Amount price, String itemName, double itemVat, String itemID, int itemAmount) {
            this.itemID = itemID;
            this.itemAmount = itemAmount;
            this.price = price;
            this.itemName = itemName;
            this.itemVat = itemVat;
            this.itemID = itemID;
            }

        public void setItemAmount(int itemAmount){
            this.itemAmount = itemAmount;
        }

    }


}
