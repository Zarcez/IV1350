package Sem.Model;

/**
 * Throws when an items ID doesn't have a match
 */
public class NoItemException extends Exception{
    String itemID;

    /**
     * Creates a new instance representing the item ID
     * @param itemID The unmatched ID
     */
    public NoItemException(String itemID){
        super("No item found with the ID "+itemID);
        this.itemID = itemID;
    }

    public String getItemID() {
        return itemID;
    }
}
