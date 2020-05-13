package Sem.Model;

import Sem.Integration.ItemDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * The sale object used to handle all interactions that is on a per sale basis
 */
public class Sale {
    private Payment payment;
    private ExInventory exInventory;
    private ExAccounting exAccounting;

    private List<SaleDTO> items = new ArrayList<>();
    private Amount total;
    private Amount totalNoTax;

    private List<SaleObserver> saleObserver = new ArrayList<>();

    /**
     * Creates the objectes needed
     * @param exInventory
     * @param exAccounting As both parameters are already created on start up, they are passed along here
     */
    public Sale(ExInventory exInventory, ExAccounting exAccounting){
        this.exInventory = exInventory;
        this.exAccounting = exAccounting;
        total = new Amount(0);
        totalNoTax = new Amount(0);
    }

    /**
     * This method takes change what is currently stored in the sale.
     * If the item already exist in the sale, increase the amount of the item else add the item and it's quantity to the list
     * Then get the price of the new item and add it to the total
     * @param item The new item
     * @param itemAmount The amount of the item
     * @return The new total value of the items
     */
    public Amount uppdateSale (ItemDTO item, int itemAmount){
        int indexItem = indexOfItem(item);
        if(indexItem != -1){
            int newItemAmount = items.get(indexItem).getItemAmount() + itemAmount;
            items.get(indexItem).setItemAmount(newItemAmount);
        }
        else{
            items.add(new SaleDTO(item,itemAmount));
        }
        Amount amount = new Amount(item.getPrice().getAmount() * itemAmount );
        totalNoTax = amount.plus(totalNoTax);
        amount =  new Amount(item.getPrice().getAmount() * itemAmount * item.getItemVat());
        total = amount.plus(total);
        return total;
    }

    /**
     * Goes through all the item to see if there already exist an item with the same ID
     * @param item The ID of the new item
     * @return If there is, return the position in the list, else -1 as a false
     */
    private int indexOfItem(ItemDTO item){
        for(int i = 0; i < items.size(); i++){
            if(items.get(i).getItem().getItemID().equals(item.getItemID()))
                return i;
        }
        return -1;
    }

    /**
     * When the sale ends, create the payment instance with the total value
     * @return The total payment required
     */
    public Amount endSale(){
        payment = new Payment(total);
        return total;
    }

    /**
     * Handles the pay sent to payment, if the payment is zero or under, the sale is complete and the external system gets updated
     * @param paid The amount to has been paid
     * @return What is left to be paid or the change to be given back
     */
    public Amount salePayment(Amount paid){
        Amount change = payment.UppdatePayment(paid);
        if(change.getAmount() <= 0){
            UppdateExternal();
            notifyObserver();
        }
        return change;
    }

    /**
     * Notify and uppdates observers
     */
    private void notifyObserver(){
        for (SaleObserver obs: saleObserver){
            obs.newPayment(total);
        }
    }

    /**
     * Add a single observer
     * @param obs The observer to be added
     */
    public void addSaleObserver(SaleObserver obs){
        saleObserver.add(obs);
    }

    /**
     * Add a list of observers
     * @param obs The list of observers
     */
    public void addSaleObservers(List<SaleObserver> obs){
        saleObserver.addAll(obs);
    }

    public Amount getPayment(){
        return payment.getAmount();
    }


    /**
     * Send all the SaleDTOs to the external inventory to update and the total to the external accounting
     */
    private void UppdateExternal(){
        for(SaleDTO item: items){
            exInventory.UppdateInventory(item);
        }
        exAccounting.UppdateAccounting(total);
    }

    /**
     * Create the receipt String by sending the itself with it and it's toString method
     * @return The string with sale info
     */
    public String print(){
        Receipt receipt = new Receipt(this);
        return receipt.createReceiptString();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for(SaleDTO item: items){
            builder.append(item.getItem().getItemName());
            builder.append(" quantity: " + String.valueOf(item.getItemAmount()));
            builder.append(" price: " + item.getItem().getPrice().toString());
            endSection(builder);

        }
        appendLine(builder, "Total: " + totalNoTax.toString());
        appendLine(builder,"Total with taxes"+total.toString());
        return builder.toString();
    }


    private void appendLine(StringBuilder builder, String line){
        builder.append(line);
        builder.append("\n");
    }
    private void endSection(StringBuilder builder) {
        builder.append("\n");
    }
}
