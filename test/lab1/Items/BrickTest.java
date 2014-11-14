/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1.Items;

import lab1.Models.AbstractItem;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Nail
 */
public class BrickTest {

    public BrickTest() {
    }

    @Test
    public void testSomeMethod() {
        System.out.println("#Тест класса КИРПИЧ:");
        Brick A = new Brick("Кирпич1", 4.4, new String[]{"квадратный", "красный", "плоский"});
        AbstractItem B = new Brick("Кирпич2", 6.1, new String[]{"прямоугольный", "красный", "плоский"});
        AbstractItem C = new Brick("Кирпич3", 6.1, new String[]{"прямоугольный", "красный", "плоский"});

        assertTrue(A.peculiar("плоский"));
        assertTrue(B.peculiar("плоский"));
        assertTrue(A.peculiar("квадратный"));
        assertFalse(B.peculiar("квадратный"));        
        assertFalse(A.equals(B));
        assertFalse(B.equals(C));
        
        System.out.println(A);
        System.out.println(B);
    }

}
