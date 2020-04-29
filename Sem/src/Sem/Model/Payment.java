package Sem.Model;

/**
 * Payment is to handle payment and what is left to pay
 */
public class Payment {
    private Amount amount;

    /**
     * Creates a new payment instance with what needs to be paid
     * @param amount The amount is used to represent
     */
    public Payment(Amount amount){
        this.amount = amount;
    }

    /**
     * Change the amount in the current payment
     * @param pay The amount payed
     * @return What's left of the payment
     */
    public Amount UppdatePayment(Amount pay){
        amount = amount.minus(pay);
        return amount;
    }

    public Amount getAmount() {
        return amount;
    }
}
