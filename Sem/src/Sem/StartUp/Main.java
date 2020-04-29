package Sem.StartUp;

import Sem.Controller.Controller;
import Sem.Integration.CatalogCreator;
import Sem.Integration.ExCreator;
import Sem.Integration.Printer;
import Sem.View.View;

public class Main {

    /**
     * Starts the application
     *
     * @param args no command line parameters
     */

    public static void main(String[] args) {
        ExCreator exCreator = new ExCreator();
        CatalogCreator catalogCreator = new CatalogCreator();
        Printer printer = new Printer();
        Controller controller = new Controller(exCreator,catalogCreator,printer);
        new View(controller).sampleExecution();
    }
}
