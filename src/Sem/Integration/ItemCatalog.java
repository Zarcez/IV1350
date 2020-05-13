package Sem.Integration;

import Sem.Model.Amount;

import java.util.ArrayList;
import java.util.List;

/**
 * No longer in use, fused with external inventory as per task flow
 */
@Deprecated
public class ItemCatalog {
    private List<ItemData> items = new ArrayList<>();

    ItemCatalog(){
        addItems();
    }

    /**
     * Search for an item matching ID
     * @param searchedItem This string is used as an identifier
     * @return If we found the product, return the values in an ItemDTO, if no such thing is found, return null
     */
    public ItemDTO findItem(String searchedItem){
        for (ItemData item : items){
            if(matches(searchedItem,item))
                return new ItemDTO(item.price,item.itemName,item.itemVat,item.itemID);
        }
        return null;
    }

    /**
     *this is taken from the example given in the book
     *
     * @param searched The string we are looking for
     * @param found The current items ID we are comparing with
     * @return If equal return true, else false
     */
    private boolean matches(String searched, ItemData found){
        if(searched.equals(found.itemID))
            return true;
        else
            return false;
    }

    /**
     * Add some items as we have no database
     */
    private void addItems(){
        items.add(new ItemData(new Amount(10),"A",1.06,"A00001"));
        items.add(new ItemData(new Amount(20),"B",1.12,"B00002"));
        items.add(new ItemData(new Amount(10),"C",1.25,"C00003"));
    }

    private static class ItemData{
        private Amount price;
        private String itemName;
        private double itemVat;
        private String itemID;

        public ItemData(Amount price, String itemName, double itemVat, String itemID){
            this.price = price;
            this.itemName = itemName;
            this.itemVat = itemVat;
            this.itemID = itemID;
        }
    }


}
