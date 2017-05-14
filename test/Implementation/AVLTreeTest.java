/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implementation;

import Interfaces.Position;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author danie_000
 */
public class AVLTreeTest {
    
    public AVLTreeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of itHolds method, of class AVLTree.
     */
    @Test
    public void testItHolds() {
        System.out.println("itHolds");
        
 
        AVLTree instance = new AVLTree();
        instance.addRoot(3);
        Position pos1=instance.Insert(instance.root, 5);
        Position pos2=instance.Insert(instance.root, 6);
        Position pos3=instance.Insert(instance.root, 4);
        Position pos4=instance.Insert(instance.root, 2);
        
        boolean expResult = true;
        boolean result = instance.itHolds(pos1);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of simpleLeftRotation method, of class AVLTree.
     */
    @Test
    public void testSimpleLeftRotation() {
        System.out.println("simpleLeftRotation");
        AVLTree instance = new AVLTree();
        instance.addRoot(-4);
        Position pos1=instance.Insert(instance.root, -6);
        Position pos2=instance.Insert(instance.root, -5);
        Position pos3=instance.Insert(instance.root, -7);
        Position pos4=instance.Insert(instance.root, -8);
        Position pos5=instance.Insert(instance.root, 6);
        Position pos6=instance.Insert(instance.root, 7);
        Position pos7=instance.Insert(instance.root, -1);
        Position pos8=instance.Insert(instance.root, 1);
        Position pos9=instance.Insert(instance.root, -2);
        Position pos10=instance.Insert(instance.root, -3);
        
        instance.simpleLeftRotation(pos5);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of simpleRightRotation method, of class AVLTree.
     */
    @Test
    public void testSimpleRightRotation() {
        System.out.println("simpleRightRotation");
        AVLTree instance = new AVLTree();
        instance.addRoot(10);
        Position pos1=instance.Insert(instance.root,4);
        Position pos2=instance.Insert(instance.root,3);
        Position pos3=instance.Insert(instance.root,6);
        Position pos4=instance.Insert(instance.root,5);
        Position pos5=instance.Insert(instance.root,7);
        Position pos6=instance.Insert(instance.root,8);
        Position pos7=instance.Insert(instance.root,13);
        Position pos8=instance.Insert(instance.root,14);
        Position pos9=instance.Insert(instance.root,12);
        Position pos10=instance.Insert(instance.root,11);
        
        instance.simpleRightRotation(pos1);
        // TODO review the generated test code and remove the default call to fail
    }

    /**
     * Test of DoubleRightRotation method, of class AVLTree.
     */
    @Test
    public void testDoubleRightRotation() {
        System.out.println("DoubleRightRotation");
        AVLTree instance = new AVLTree();
        instance.addRoot(10);
        Position pos1=instance.Insert(instance.root,3);
        Position pos2=instance.Insert(instance.root,2);
        Position pos3=instance.Insert(instance.root,6);
        Position pos4=instance.Insert(instance.root,5);
        Position pos5=instance.Insert(instance.root,4);
        Position pos6=instance.Insert(instance.root,7);
        Position pos7=instance.Insert(instance.root,8);
        Position pos8=instance.Insert(instance.root,13);
        Position pos9=instance.Insert(instance.root,12);
        Position pos10=instance.Insert(instance.root,11);
        Position pos11=instance.Insert(instance.root,14);
        instance.DoubleRightRotation(pos1);
        
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of DoubleLeftRotation method, of class AVLTree.
     */
    @Test
    public void testDoubleLeftRotation() {
        System.out.println("DoubleLeftRotation");
        AVLTree instance = new AVLTree();
        instance.addRoot(-4);
        Position pos1=instance.Insert(instance.root, -6);
        Position pos2=instance.Insert(instance.root, -5);
        Position pos3=instance.Insert(instance.root, -7);
        Position pos4=instance.Insert(instance.root, -8);
        Position pos5=instance.Insert(instance.root, 6);
        Position pos6=instance.Insert(instance.root, 7);
        Position pos7=instance.Insert(instance.root, -1);
        Position pos8=instance.Insert(instance.root, 1);
        Position pos9=instance.Insert(instance.root, -2);
        Position pos10=instance.Insert(instance.root, -3);
        Position pos11=instance.Insert(instance.root, 2);
        instance.DoubleLeftRotation(pos5);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of Insert method, of class AVLTree.
     */
    @Test
    public void testInsert() {
        System.out.println("Insert");
        int element =4;
        AVLTree instance = new AVLTree();
        instance.addRoot(3);
        instance.Insert(instance.root, element);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of search method, of class AVLTree.
     */
    @Test
    public void testSearch() {
        System.out.println("search");
        AVLTree instance = new AVLTree();
        instance.addRoot(-4);
        Position pos1=instance.Insert(instance.root, -6);
        Position pos2=instance.Insert(instance.root, -5);
        Position pos3=instance.Insert(instance.root, -7);
        Position pos4=instance.Insert(instance.root, -8);
        Position pos5=instance.Insert(instance.root, 6);
        Position pos6=instance.Insert(instance.root, 7);
        Position pos7=instance.Insert(instance.root, -1);
        Position pos8=instance.Insert(instance.root, 1);
        Position pos9=instance.Insert(instance.root, -2);
        Position pos10=instance.Insert(instance.root, -3);
        Position pos11=instance.Insert(instance.root, 2);
        Position expResult = pos7;
        Position result = instance.search(instance.root,-1);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of delete method, of class AVLTree.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        AVLTree instance = new AVLTree();
        instance.addRoot(-4);
        Position pos1=instance.Insert(instance.root, -6);
        Position pos2=instance.Insert(instance.root, -5);
        Position pos3=instance.Insert(instance.root, -7);
        Position pos4=instance.Insert(instance.root, -8);
        Position pos5=instance.Insert(instance.root, 6);
        Position pos6=instance.Insert(instance.root, 7);
        Position pos7=instance.Insert(instance.root, -1);
        Position pos8=instance.Insert(instance.root, 1);
        Position pos9=instance.Insert(instance.root, -2);
        Position pos10=instance.Insert(instance.root, -3);
        Position pos11=instance.Insert(instance.root, 2);
        instance.delete(instance.root, -1);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of balance method, of class AVLTree.
     */
    @Test
    public void testBalance() {
        System.out.println("balance");
        AVLTree instance = new AVLTree();
        instance.addRoot(10);
        Position pos1=instance.Insert(instance.root,3);
        Position pos2=instance.Insert(instance.root,2);
        Position pos3=instance.Insert(instance.root,6);
        Position pos4=instance.Insert(instance.root,5);
        Position pos5=instance.Insert(instance.root,4);
        Position pos6=instance.Insert(instance.root,7);
        Position pos7=instance.Insert(instance.root,8);
        Position pos8=instance.Insert(instance.root,13);
        Position pos9=instance.Insert(instance.root,12);
        Position pos10=instance.Insert(instance.root,11);
        Position pos11=instance.Insert(instance.root,14);
        instance.balance(pos1);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
