package Sem.Model;

/**
 * Stops the program from running if there is no database to be found
 */
public class NoDatabaseException extends RuntimeException {

    /**
     * Creates a new instance with a specific message
     */
    public NoDatabaseException(){
        super("No database for items found");
    }
}
