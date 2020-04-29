package Sem.Model;

/**
 * Used to simply store the increase of amount per sale
 */
public class Register {
    private Amount amount;

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
