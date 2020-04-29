package Sem.Model;

import Sem.Integration.ItemDTO;

/**
 * Handles the sale info of items and how many there are of each
 */
public class SaleDTO {
    private ItemDTO item;
    private int itemAmount;

    public SaleDTO(ItemDTO item, int itemAmount){
        this.item = item;
        this.itemAmount = itemAmount;
    }

    public int getItemAmount() {
        return itemAmount;
    }

    public ItemDTO getItem() {
        return item;
    }

    public void setItem(ItemDTO item) {
        this.item = item;
    }

    public void setItemAmount(int itemAmount) {
        this.itemAmount = itemAmount;
    }
}
