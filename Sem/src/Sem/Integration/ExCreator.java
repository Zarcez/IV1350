package Sem.Integration;

/**
 * Serves to create the external systems
 */
public class ExCreator {

    private ExAccounting exAccounting = new ExAccounting();
    private ExInventory exInventory = new ExInventory(true);

    /**
     * Get external accounting
     *
     * @return external accounting
     */
    public ExAccounting getExAccounting() {
        return exAccounting;
    }

    /**
     * Get external Inventory
     *
     * @return external inventory
     */
    public ExInventory getExInventory() {
        return exInventory;
    }
}
