package Sem.Model;

/**
 * Used to simply store the increase of amount per sale
 */
public class Register {
    private Amount amount;

    /**
     * As we have no specific value, creates the object with a amount of 0
     */
    public Register(){
        amount = new Amount(0);
    }

    /**
     * Increase the amount stored in the class
     * @param amount The amount to increase with
     */
    public void uppdateBalance(Amount amount){
        this.amount = this.amount.plus(amount);
    }
}
