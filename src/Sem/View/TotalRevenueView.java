package Sem.View;

import Sem.Model.Amount;
import Sem.Model.SaleObserver;

/**
 * Shows the running revenue since the program started
 */
class TotalRevenueView implements SaleObserver {
    private Amount amount;

    /**
     * Creates a new instance with the value at zero
     */
    protected TotalRevenueView(){
        amount = new Amount(0);
    }

    @Override
    public void newPayment(Amount amount){
        this.amount = amount.plus(this.amount);
        printCurrentState();
    }

    /**
     * Prints the current revenue since program started
     */
    private void printCurrentState(){
        System.out.println("The current revenue is " + this.amount.toString());
    }
}
