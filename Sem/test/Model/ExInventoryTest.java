package Model;

import Sem.Integration.ItemDTO;
import Sem.Model.Amount;
import Sem.Model.ExInventory;
import Sem.Model.SaleDTO;
import org.junit.Test;

public class ExInventoryTest {

    @Test
    public void testFindItem(){
        ExInventory exInventory = new ExInventory();
        String ID = "A00001";
        ItemDTO item = exInventory.findItem(ID);
        System.out.println(item);
    }

    @Test
    public void testUppdateInventory(){
        ExInventory exInventory = new ExInventory();
        ItemDTO item = new ItemDTO(new Amount(10),"a",1,"A00001");
        SaleDTO sale = new SaleDTO(item,6);
        System.out.println(exInventory.getItemAmount(sale));
        exInventory.UppdateInventory(sale);
        System.out.println(exInventory.getItemAmount(sale));
    }
}
