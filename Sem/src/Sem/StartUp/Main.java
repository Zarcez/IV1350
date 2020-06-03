package Sem.StartUp;

import Sem.Controller.Controller;
import Sem.Integration.CatalogCreator;
import Sem.Integration.ExCreator;
import Sem.Integration.Printer;
import Sem.Integration.NoDatabaseException;
import Sem.View.View;

import java.io.IOException;


public class Main {

    /**
     * Starts the application
     *
     * @param args no command line parameters
     */

    public static void main(String[] args)  {
        try {
            ExCreator exCreator = new ExCreator();
            CatalogCreator catalogCreator = new CatalogCreator();
            Printer printer = new Printer();
            Controller controller = new Controller(exCreator, catalogCreator, printer);
            new View(controller).test();
        }
        catch (NoDatabaseException exception){
            System.out.println("Unable to start program");
            exception.printStackTrace();
        }
        catch (IOException exception){
            System.out.println("Unable to start program");
            exception.printStackTrace();
        }


    }
}
