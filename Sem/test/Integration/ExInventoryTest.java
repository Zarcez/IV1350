package Integration;

import Sem.Integration.ExInventory;
import Sem.Integration.ItemDTO;
import Sem.Integration.NoDatabaseException;
import Sem.Integration.NoItemException;
import Sem.Model.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ExInventoryTest {


    @Test
    public void testFindItem()  {
        try {
            ExInventory exInventory = new ExInventory(true);
            List<String> itemTests = new ArrayList<>();
            itemTests.add("A00001");
            itemTests.add("B00001");
            for (String ID : itemTests) {
                try {
                    ItemDTO item = exInventory.findItem(ID);
                    System.out.println(item);
                } catch (NoItemException noItemException) {
                    System.out.println(noItemException.getMessage());
                }
            }
        }
        catch (NoDatabaseException exception){
            exception.printStackTrace();
        }
    }

    @Test
    public void testUppdateInventory()  {
        ExInventory exInventory = new ExInventory(true);
        ItemDTO item = new ItemDTO(new Amount(10),"a",1,"A00001");
        SaleDTO sale = new SaleDTO(item,6);
        System.out.println(exInventory.getItemAmount(sale));
        exInventory.UppdateInventory(sale);
        System.out.println(exInventory.getItemAmount(sale));
    }

    @Test
    public void testDatabase()  {
        try {
            ExInventory exInventory = new ExInventory(false);
        }
        catch (NoDatabaseException exception) {
            exception.printStackTrace();
            System.out.println("No database found");
        }
    }
}
