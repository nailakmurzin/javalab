/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1.storages;

import lab1.Exceptions.*;
import lab1.Items.*;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Nail
 */
public class PileTest {

    @Test
    public void testAddItem() throws Exception {
        Pile pile1 = new Pile("стопка1", 3);
        Book book1 = new Book("книга1", 1, "КНИГА");
        assertTrue(pile1.addItem(book1));
    }

    @Test(expected = AddYourselfException.class)
    public void testAddItemAddYourselfException() throws Exception {
        Pile pile1 = new Pile("стопка1", 3);
        pile1.addItem(pile1);
    }

    @Test(expected = NullAddItemException.class)
    public void testAddItemNullAddItemException() throws Exception {
        Pile pile1 = new Pile("стопка1", 3);
        pile1.addItem(null);
    }

    @Test(expected = ExcessAmountException.class)
    public void testAddItemExcessAmountException() throws Exception {
        Pile pile1 = new Pile("стопка1", 1);
        Book book1 = new Book("книга1", 1, "КНИГА111111");
        Book book2 = new Book("книга2", 3, "КНИГА222222");
        pile1.addItem(book1);
        pile1.addItem(book2);
    }

    @Test(expected = AddNotPerticulareItemException.class)
    public void testAddItemAddNotPerticulareItemException() throws Exception {
        Pile pile1 = new Pile("стопка1", 3);
        Book book1 = new Book("книга1", 1, "КНИГА111111");
        Brick brick1 = new Brick("brick1", 3.4);
        pile1.addItem(book1);
        pile1.addItem(brick1);
    }

    public void testPopItem() throws Exception {
        Pile pile1 = new Pile("стопка1", 3);
        Book book1 = new Book("книга1", 1, "КНИГА");
        assertEquals(null, pile1.popItem());
        assertTrue(pile1.addItem(book1));
        assertEquals(book1, pile1.popItem());
    }

}
