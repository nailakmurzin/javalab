package lab1.storages;

import lab1.Exceptions.ItemStoreException;
import static org.junit.Assert.*;
import org.junit.Test;

public class BoxTest {

    @Test
    public void testIsOpen() {
        Box box1 = new Box("коробка1", 10.9, 0.1);
        assertTrue(box1.isOpen());
    }

    @Test
    public void testClose() throws ItemStoreException {
        Box box1 = new Box("коробка1", 10.9, 0.1);
        Box box2 = new Box("коробка2", 10.9, 0.1);
        box1.close();
        assertFalse(box1.isOpen());
        assertFalse(box1.addItem(box2));
    }

    @Test
    public void testOpen() {
        Box box1 = new Box("коробка1", 10.9, 0.1);
        box1.close();
        box1.open();
        assertTrue(box1.isOpen());
    }

}
