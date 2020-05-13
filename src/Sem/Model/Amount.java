package Sem.Model;

/**
 * The class used to handle an amount of money
 */
public class Amount {
    private final double amount;

    /**
     * Creates a new instance, representing the amount specified
     * @param amount The amount in the new instance
     */
    public Amount(double amount){
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    /**
     * Gets a secondary amount and subtract it from the current instances value
     * @param other The secondary value to be used
     * @return The result of the subtraction
     */
    public Amount minus(Amount other){
        return new Amount(amount-other.amount);
    }

    /**
     * Gets a secondary amount and add it together to the current instances value
     * @param other The secondary value to be used
     * @return The result of the addition
     */
    public Amount plus(Amount other){
        return new Amount(amount+other.amount);
    }


    @Override
    public String toString() {
        return Double.toString(amount);
    }


}
