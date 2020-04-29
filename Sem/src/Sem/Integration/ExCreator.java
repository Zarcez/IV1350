package Sem.Integration;

import Sem.Model.ExAccounting;
import Sem.Model.ExInventory;

/**
 * Serves to create the external systems
 */
public class ExCreator {

    private ExAccounting exAccounting = new ExAccounting();
    private ExInventory exInventory = new ExInventory();

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
