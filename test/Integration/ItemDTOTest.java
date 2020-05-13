package Integration;

import Sem.Model.Amount;
import Sem.Integration.ItemDTO;
import org.junit.Test;

public class ItemDTOTest {

    @Test
    public void testToString(){
        Amount price = new Amount(10);
        String name = "a";
        double vat = 1;
        String ID = "01";

        ItemDTO item = new ItemDTO(price,name,vat,ID);
        System.out.println(item);

    }
}
