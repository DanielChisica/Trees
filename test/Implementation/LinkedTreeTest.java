/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implementation;

import Interfaces.Position;
import java.util.ArrayList;
import java.util.Iterator;
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
public class LinkedTreeTest {
    
    public LinkedTreeTest() {
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
     * Test of iterator method, of class LinkedTree.
     */
    @Test
    public void testIterator() {
        System.out.println("iterator");
        LinkedTree instance = new LinkedTree();
        instance.addRoot(1);
        instance.add(2,instance.root);
        instance.add(3,instance.root);
        instance.add(4,instance.root);
        instance.add(5,instance.root);
        
        Iterator expResult = instance.iterator();
        Iterator result = instance.iterator();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of addRoot method, of class LinkedTree.
     */
    @Test
    public void testAddRoot() {
        System.out.println("addRoot");
        Object element = 1;
        LinkedTree instance = new LinkedTree();
        LinkedTree instance2=new LinkedTree();
        Position expResult = instance2.addRoot(1);
        Position result = instance.addRoot(1);
        assertNotEquals(expResult, result);
    }

    /**
     * Test of validate method, of class LinkedTree.
     */
    @Test
    public void testValidate() {
        System.out.println("validate");
        LinkedTree instance = new LinkedTree();
        instance.addRoot(1);
        instance.validate(instance.root);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of add method, of class LinkedTree.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        LinkedTree instance = new LinkedTree();
        instance.addRoot(1);
        Position expResult = instance.add(2,instance.root);
        Position result = instance.add(2,instance.root);
        assertNotEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of createNode method, of class LinkedTree.
     */
    @Test
    public void testCreateNode() {
        System.out.println("createNode");
        LinkedTree instance = new LinkedTree();
        instance.addRoot(1);
        ArrayList<Position> actualchildren=new ArrayList<>();
        instance.createNode(actualchildren,instance.root , 3);
        
    }

    /**
     * Test of attach method, of class LinkedTree.
     */
    @Test
    public void testAttach() {
        System.out.println("attach");
        LinkedTree instance = new LinkedTree();
        instance.addRoot(1);
        instance.add(2,instance.root);
        Position leave =instance.add(3,instance.root);
        
        LinkedTree instance2 = new LinkedTree();
        instance2.addRoot(1);
        instance2.add(2,instance.root);
        instance2.add(3,instance.root);

        
        
        instance.attach(leave, instance, instance2);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of size method, of class LinkedTree.
     */
    @Test
    public void testSize() {
        System.out.println("size");
        LinkedTree instance = new LinkedTree();
        instance.addRoot(1);
        instance.add(2,instance.root);
        Position leave =instance.add(3,instance.root);
        int expResult = 3;
        int result = instance.size();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of parent method, of class LinkedTree.
     */
    @Test
    public void testParent() {
        System.out.println("parent");
        LinkedTree instance = new LinkedTree();
        instance.addRoot(1);
        Position firstChild=instance.add(2,instance.root);
        Position secondChild=instance.add(3,instance.root);
        
        
        Position expResult = instance.parent(firstChild);
        Position result = instance.parent(secondChild);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of isRoot method, of class LinkedTree.
     */
    @Test
    public void testIsRoot() {
        System.out.println("isRoot");
        LinkedTree instance = new LinkedTree();
        Position p = instance.addRoot(44);
        boolean expResult = true;
        boolean result = instance.isRoot(p);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of Children method, of class LinkedTree.
     */
    @Test
    public void testChildren() {
        System.out.println("Children");
        LinkedTree instance = new LinkedTree();
        instance.addRoot(1);
        instance.add(2,instance.root);
        instance.add(3,instance.root);
        
        ArrayList<Position> expResult = instance.Children(instance.root);
        ArrayList<Position> result = instance.Children(instance.root);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }



    /**
     * Test of numChilds method, of class LinkedTree.
     */
    @Test
    public void testNumChilds() {
        System.out.println("numChilds");
        LinkedTree instance = new LinkedTree();
        instance.addRoot(1);
        instance.add(2,instance.root);
        instance.add(3,instance.root);
        int expResult = 2;
        int result = instance.numChilds(instance.root);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of siblings method, of class LinkedTree.
     */
    @Test
    public void testSiblings() {
        System.out.println("siblings");
        LinkedTree instance = new LinkedTree();
        instance.addRoot(1);
        instance.add(2,instance.root);
        Position sibling=instance.add(3,instance.root);
        instance.add(4,instance.root);
        
        
        ArrayList<Position> expResult = instance.siblings(sibling);
        ArrayList<Position> result = instance.siblings(sibling);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

}
