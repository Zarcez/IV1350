package Sem.Model;


/**
 * A listner for the sale class that handles information about sales. In it's current iteration only deals with one specific observer
 */
public interface SaleObserver {

    /**
     * Invoked when a new payment is made
     * @param amount The payment to be added
     */
    void newPayment(Amount amount);
}
