/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1.storages;

import lab1.Exceptions.AddYourselfException;
import lab1.Exceptions.ExcessWeightException;
import lab1.Exceptions.NullAddItemException;
import lab1.Items.*;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Nail
 */
public class BagTest {

    public void testAddItem() throws Exception {
        Bag bag1 = new Bag("мешок1", 10.2, 0.3, "картофельный");
        Brick brick1 = new Brick("brick1", 3.4);
        assertTrue(bag1.addItem(brick1));
        assertFalse(bag1.addItem(brick1));
    }

    @Test(expected = AddYourselfException.class)
    public void testAddItemAddYourselfException() throws Exception {
        Bag bag1 = new Bag("мешок1", 10.2, 0.3, "картофельный");
        bag1.addItem(bag1);
    }

    @Test(expected = NullAddItemException.class)
    public void testAddItemNullAddItemException() throws Exception {
        Bag bag1 = new Bag("мешок1", 10.2, 0.3, "картофельный");
        bag1.addItem(null);
    }

    @Test(expected = ExcessWeightException.class)
    public void testAddItemExcessWeightException() throws Exception {
        Bag bag1 = new Bag("мешок1", 10.2, 0.3, "картофельный");
        Brick brick1 = new Brick("brick1", 30.4);
        bag1.addItem(brick1);
    }

    @Test
    public void testPopItem() throws Exception {
        Bag bag1 = new Bag("мешок1", 10.2, 0.3, "картофельный");
        Brick brick1 = new Brick("brick1", 3.4);
        assertEquals(null, bag1.popItem());
        bag1.addItem(brick1);
        assertEquals(brick1, bag1.popItem());
    }

    @Test
    public void testMakeFlat() throws Exception {
        Bag bag1 = new Bag("мешок1", 10.2, 0.3, "картофельный");
        Brick brick1 = new Brick("brick1", 3.4, "плоский");
        Brick brick2 = new Brick("brick2", 3.9);
        bag1.addItem(brick1);
        assertTrue(bag1.makeFlat());
        bag1.addItem(brick2);
        assertFalse(bag1.makeFlat());
    }

}
