package Sem.Controller;

import Sem.Integration.*;
import Sem.Model.*;

/**
 * The controller class, all calls to the model go through this class
 */
public class Controller {
    private DiscountCatalog discountCatalog;
    private ExInventory exInventory;
    private ExAccounting exAccounting;
    private Printer printer;
    private Sale sale;
    private Register register;

    /**
     *
     * @param exCreator Used create the external system
     * @param catalogCreator In the current iteration this has no purpose, but left for future use
     * @param printer Used to print the receipt
     */
    public Controller(ExCreator exCreator, CatalogCreator catalogCreator, Printer printer){
        this.discountCatalog = catalogCreator.getDiscountCatalog();
        this.exAccounting = exCreator.getExAccounting();
        this.exInventory = exCreator.getExInventory();
        this.printer = printer;
        this.register = new Register();
    }

    /**
     * Create a new sale object
     */
    public void startNewSale()
    {
        this.sale = new Sale(exInventory,exAccounting);
    }

    /**
     * Search the external inventory for an item with matching ID
     * @param searchedItem The ID we are looking for
     * @return Returns the ItemDTO with the values for the item with the matching ID
     */
    public ItemDTO itemExists (String searchedItem){
        return exInventory.findItem(searchedItem);
    }

    /**
     * Uppdates the sale object with the item that was scanned and the amount
     * @param item The ItemDTO that's transferred to sale
     * @param amount The amount of that item
     * @return The new total of all items scanned
     */
    public Amount uppdateSale(ItemDTO item, int amount)
    {
        return sale.uppdateSale(item, amount);
    }

    /**
     * Calls for an end of the sale
     * @return The total of all items
     */
    public Amount endSale()
    {
        return sale.endSale();
    }

    /**
     * Send the amount paid
     * @param pay The amount paid
     * @return  The change of what's paid
     */
    public Amount pay(Amount pay){
        Amount change = sale.salePayment(pay);
        register.uppdateBalance(pay);
        return change;
    }

    /**
     * Get's what is left to be paid
     * @return The amount left in payment
     */
    public Amount getPayment(){
        return sale.getPayment();
    }

    /**
     * Gets the value for the receipt then send it to receipt
     */
    public void print(){
        String receipt = sale.print();
        printer.printReciept(receipt);
    }

}
