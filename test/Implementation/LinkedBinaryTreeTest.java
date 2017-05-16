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
        LinkedBinaryTree.Node expResult = instance.createNode("Hi everybody", instance.root, null, null);
        LinkedBinaryTree.Node result = instance.createNode("Hi everybody", instance.root, null, null);
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
        instance.addRoot("Root");
        LinkedBinaryTree.Node expResult = instance.validate(instance.root);
        LinkedBinaryTree.Node result = instance.validate(instance.root);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of addRoot method, of class LinkedBinaryTree.
     */
    @Test
    public void testAddRoot() {
        System.out.println("addRoot");
        Object element = 69;
        LinkedBinaryTree instance = new LinkedBinaryTree();
        LinkedBinaryTree instance2= new LinkedBinaryTree();
        Position expResult = instance.addRoot(element);
        Position result = instance2.addRoot(element);
        assertNotEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of addLeft method, of class LinkedBinaryTree.
     */
    @Test
    public void testAddLeft() {
        System.out.println("addLeft");
        LinkedBinaryTree instance = new LinkedBinaryTree();
        instance.addRoot("Root");
        Position expResult =instance.addLeft("Left child", instance.root) ;
        Position result = instance.addLeft("other left child", expResult);
        assertNotEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of addRight method, of class LinkedBinaryTree.
     */
    @Test
    public void testAddRight() {
        LinkedBinaryTree instance = new LinkedBinaryTree();
        instance.addRoot("Root");
        Position expResult =instance.addRight("Right child", instance.root) ;
        Position result = instance.addRight("other right child", expResult);
        assertNotEquals(expResult, result);
    }

    /**
     * Test of set method, of class LinkedBinaryTree.
     */
    @Test
    public void testSet() {
        System.out.println("set");
        LinkedBinaryTree instance = new LinkedBinaryTree();
        Position root=instance.addRoot("Root");
        Object expResult = "added element";
        Object result = instance.set(root,expResult);
        assertNotEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of attach method, of class LinkedBinaryTree.
     */
    @Test
    public void testAttach() {
        System.out.println("attach");
        LinkedBinaryTree instance = new LinkedBinaryTree();
        LinkedBinaryTree instance2= new LinkedBinaryTree();
        instance2.addRoot("Root");
        Position lefttchild =instance2.addLeft("Left child", instance2.root);
        Position leaf = instance2.addLeft("other left child", lefttchild);
        
        
        instance.addRoot("Root");
        Position rightChild =instance.addRight("Right child", instance.root);
        Position otherRightChild = instance.addRight("other right child", rightChild);
        
        instance.attach(leaf,instance2,instance);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of remove method, of class LinkedBinaryTree.
     */
    @Test
    public void testRemove() {
        System.out.println("remove");
        LinkedBinaryTree instance = new LinkedBinaryTree();
        instance.addRoot("Root");
        Position child=instance.addRight("Right child", instance.root);
        Object expResult = instance.remove(child);
        // TODO review the generated test code and remove the default call to fail
    }

    /**
     * Test of right method, of class LinkedBinaryTree.
     */
    @Test
    public void testRight() {
        System.out.println("right");
        LinkedBinaryTree instance = new LinkedBinaryTree();
        Position root=instance.addRoot("Root");
        Position child=instance.addRight("Right child", instance.root);
                
        Position expResult=instance.right(root);
        Position result = instance.right(root);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of left method, of class LinkedBinaryTree.
     */
    @Test
    public void testLeft() {
        System.out.println("left");
        LinkedBinaryTree instance = new LinkedBinaryTree();
        Position root=instance.addRoot("Root");
        Position child=instance.addLeft("Left child", instance.root);
                
        Position expResult=instance.left(root);
        Position result = instance.left(root);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of root method, of class LinkedBinaryTree.
     */
    @Test
    public void testRoot() {
        System.out.println("root");
        LinkedBinaryTree instance = new LinkedBinaryTree();
        Position expResult = instance.addRoot("Root");
        Position result = instance.root();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of parent method, of class LinkedBinaryTree.
     */
    @Test
    public void testParent() {
        System.out.println("parent");
        LinkedBinaryTree instance = new LinkedBinaryTree();
        Position p = instance.addRoot("Root");
        Position child=instance.addRight("Right Child", p);
        Position expResult = instance.parent(child);
        Position result = instance.parent(child);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of isRoot method, of class LinkedBinaryTree.
     */
    @Test
    public void testIsRoot() {
        System.out.println("isRoot");
        LinkedBinaryTree instance = new LinkedBinaryTree();
        Position p = instance.addRoot("Root");
        boolean expResult = true;
        boolean result = instance.isRoot(p);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of size method, of class LinkedBinaryTree.
     */
    @Test
    public void testSize() {
        System.out.println("size");
        LinkedBinaryTree instance = new LinkedBinaryTree();
        Position p = instance.addRoot("Root");
        Position child=instance.addRight("Right Child", p);
        Position grandChild=instance.addRight("Right Child", child);
        
        int expResult = 3;
        int result = instance.size();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
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
