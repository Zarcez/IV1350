package Sem.Integration;

import Sem.Model.Amount;

/**
 * Used to represent an external accounting, handles incoming amount and saves the value.
 */
public class ExAccounting {
    private Amount amount;

    /**
     * As there is no database, we simply create a value to be used
     */
    public ExAccounting(){
        this.amount = new Amount(100);
    }

    /**
     * Uppdates the current amount saved in the class with the amount given
     * @param amount The amount given and how much it will change by
     */
    public void UppdateAccounting(Amount amount){
        this.amount = this.amount.plus(amount);
    }
}
