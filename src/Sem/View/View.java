package Sem.View;

import Sem.Controller.Controller;
import Sem.Integration.ItemDTO;
import Sem.Model.NoDatabaseException;
import Sem.Model.NoItemException;
import Sem.Model.Amount;
import Sem.util.LogHandler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * This program has no view, instead, this class is a placeholder for the entire
 * view.
 */
public class View {
    private Controller controller;
    private ErrorMessageHandler errorMessageHandler = new ErrorMessageHandler();
    private LogHandler logHandler;

   /**
     * Creates a new instance.
     *
     * @param controller The controller that is used for all operations.
     */
    public View(Controller controller) throws IOException {
        this.controller = controller;
        controller.addSaleObserver(new TotalRevenueView());
        this.logHandler = new LogHandler();
    }

    /**
     * Simulates a user input that generates calls to all system operations.
     */

    public void test(){
        sampleExecution();
        sampleExecution();
    }

    private void sampleExecution(){
        List<String> goods = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        goods.add("A00001");
        goods.add("C00003");
        goods.add("D00004");
        goods.add("C00003");

        controller.startNewSale();
        for (String good: goods) {
            try {
                ItemDTO foundItem = controller.itemExists(good);
                if (foundItem != null) {
                    System.out.println(foundItem);
                    System.out.println("Enter amount of item");
                    int itemAmount = scanner.nextInt();
                    Amount amount = controller.uppdateSale(foundItem, itemAmount);
                    System.out.println("Total " + amount + "\n");
                }
            }
            catch(NoItemException noItmEx) {
                handleException("No item found", noItmEx);
            }

        }
        System.out.println("More items?");
        System.out.println("Total to pay is "+controller.endSale().toString());
        System.out.println("Please enter pay:");
        Amount change;
        do {
            Amount pay = new Amount(scanner.nextDouble());
            change = controller.pay(pay);
            if (change.getAmount() > 0) {
                System.out.println("Remaining"+controller.getPayment().getAmount());
            }
        }while (change.getAmount() > 0);
        controller.print();
        System.out.println("Your change is "+(-change.getAmount()));

    }

    private void handleException(String msg, Exception exc){
        errorMessageHandler.ShowErrorMessage(msg);
        logHandler.logException(exc);
    }
}
