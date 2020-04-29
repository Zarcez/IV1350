package Sem.View;

import Sem.Controller.Controller;
import Sem.Integration.ItemDTO;
import Sem.Model.Amount;
import Sem.Model.Sale;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * This program has no view, instead, this class is a placeholder for the entire
 * view.
 */
public class View {
    private Controller controller;

   /**
     * Creates a new instance.
     *
     * @param controller The controller that is used for all operations.
     */
    public View(Controller controller) {
        this.controller = controller;
    }

    /**
     * Simulates a user input that generates calls to all system operations.
     */
    public void sampleExecution(){
        List<String> goods = new ArrayList<String>();
        Scanner scanner = new Scanner(System.in);
        goods.add("A00001");
        goods.add("C00003");
        goods.add("D00004");
        goods.add("C00003");

        controller.startNewSale();
        for (String good: goods) {
            ItemDTO foundItem = controller.itemExists(good);
            if(foundItem != null){
                System.out.println(foundItem);
                System.out.println("Enter amount of item");
                int itemAmount = scanner.nextInt();
                Amount amount = controller.uppdateSale(foundItem,itemAmount);
                System.out.println("Total "+amount+"\n");
            }
            else
                System.out.println("Not a valid ID\n");
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
}
