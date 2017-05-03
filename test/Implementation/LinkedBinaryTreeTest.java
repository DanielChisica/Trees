/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implementation;

import Interfaces.Position;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;
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
public class LinkedBinaryTreeTest {
    
    public LinkedBinaryTreeTest() {
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
     * Test of createNode method, of class LinkedBinaryTree.
     */
    @Test
    public void testCreateNode() {
        System.out.println("createNode");
        LinkedBinaryTree instance = new LinkedBinaryTree();
        LinkedBinaryTree.Node expResult = instance.createNode("hello felas", null, null, null);
        LinkedBinaryTree.Node result = instance.createNode("hello felas", null, null, null);
        assertNotEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
 
    }

    /**
     * Test of validate method, of class LinkedBinaryTree.
     */
    @Test
    public void testValidate() {
        System.out.println("validate");
        LinkedBinaryTree instance = new LinkedBinaryTree();
        LinkedBinaryTree.Node expResult =instance.createNode("Hi", null, null, null);
        LinkedBinaryTree.Node result = instance.validate(expResult);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of addRoot method, of class LinkedBinaryTree.
     */
    @Test
    public void testAddRoot() {
        System.out.println("addRoot");
        Object element = "Root";
        LinkedBinaryTree instance = new LinkedBinaryTree();
        Position expResult = instance.addRoot(element);
        Position result = instance.addRoot(element);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of addLeft method, of class LinkedBinaryTree.
     */
    @Test
    public void testAddLeft() {
        System.out.println("addLeft");
        LinkedBinaryTree instance = new LinkedBinaryTree();
        Position expResult = null;
        Position result = instance.addLeft();
       // assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addRight method, of class LinkedBinaryTree.
     */
    @Test
    public void testAddRight() {
        System.out.println("addRight");
        LinkedBinaryTree instance = new LinkedBinaryTree();
        Position expResult = null;
        //Position result = instance.addRight(null);
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of set method, of class LinkedBinaryTree.
     */
    @Test
    public void testSet() {
        System.out.println("set");
        LinkedBinaryTree instance = new LinkedBinaryTree();
        Object expResult = null;
        //Object result = instance.set(null);
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of attach method, of class LinkedBinaryTree.
     */
    @Test
    public void testAttach() {
        System.out.println("attach");
        LinkedBinaryTree instance = new LinkedBinaryTree();
        //instance.attach(null);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of remove method, of class LinkedBinaryTree.
     */
    @Test
    public void testRemove() {
        System.out.println("remove");
        LinkedBinaryTree instance = new LinkedBinaryTree();
        Object expResult = null;
        Object result = instance.remove(null);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of right method, of class LinkedBinaryTree.
     */
    @Test
    public void testRight() {
        System.out.println("right");
        Position p = null;
        LinkedBinaryTree instance = new LinkedBinaryTree();
        Position expResult = null;
        Position result = instance.right(p);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of left method, of class LinkedBinaryTree.
     */
    @Test
    public void testLeft() {
        System.out.println("left");
        Position p = null;
        LinkedBinaryTree instance = new LinkedBinaryTree();
        Position expResult = null;
        Position result = instance.left(p);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of root method, of class LinkedBinaryTree.
     */
    @Test
    public void testRoot() {
        System.out.println("root");
        LinkedBinaryTree instance = new LinkedBinaryTree();
        Position expResult = null;
        Position result = instance.root();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of parent method, of class LinkedBinaryTree.
     */
    @Test
    public void testParent() {
        System.out.println("parent");
        Position p = null;
        LinkedBinaryTree instance = new LinkedBinaryTree();
        Position expResult = null;
        Position result = instance.parent(p);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isRoot method, of class LinkedBinaryTree.
     */
    @Test
    public void testIsRoot() {
        System.out.println("isRoot");
        Position p = null;
        LinkedBinaryTree instance = new LinkedBinaryTree();
        boolean expResult = false;
        boolean result = instance.isRoot(p);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of size method, of class LinkedBinaryTree.
     */
    @Test
    public void testSize() {
        System.out.println("size");
        LinkedBinaryTree instance = new LinkedBinaryTree();
        int expResult = 0;
        int result = instance.size();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of iterator method, of class LinkedBinaryTree.
     */
    @Test
    public void testIterator() {
        System.out.println("iterator");
        LinkedBinaryTree instance = new LinkedBinaryTree();
        Iterator expResult = null;
        Iterator result = instance.iterator();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of forEach method, of class LinkedBinaryTree.
     */
    @Test
    public void testForEach() {
        System.out.println("forEach");
        Consumer action = null;
        LinkedBinaryTree instance = new LinkedBinaryTree();
        instance.forEach(action);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of spliterator method, of class LinkedBinaryTree.
     */
    @Test
    public void testSpliterator() {
        System.out.println("spliterator");
        LinkedBinaryTree instance = new LinkedBinaryTree();
        Spliterator expResult = null;
        Spliterator result = instance.spliterator();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
