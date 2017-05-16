/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implementation;

import AbstractTrees.AbstractTree;
import Interfaces.*;
import java.awt.List;
import java.util.ArrayList;
import java.util.Iterator;
import sun.misc.*;

/**
 * A linked tree has n quantity of children in each one of their nodes
 * 
 * @author Daniel Jiménez Chísica
 * @param <T> Generic data type
 * @since 4 May 2017
 */
public class LinkedTree<T> extends AbstractTree {


    
    public Node<T> root=null;
    int size;
    
    /**
     * Represents a node
     * 
     * @param <T> Generic Data Type
     */
    protected class Node<T>  implements Position{
        private ArrayList<Position<T>> children;
        private Node<T> parent;
        private T element;
        
        /**
         * Constructor method of a node
         * 
         * @param children A list with the children
         * @param parent The parent of this position
         * @param element The element of the position
         */
        public Node(ArrayList<Position<T>> children, Node<T> parent, T element) {
            this.children = children;
            this.parent = parent;
            this.element = element;
        }
        
        
        /**
         * Gets the children
         * @return A list with the children
         */
        public ArrayList<Position<T>> getChildren() {
            return children;
        }
        
        /**
         * Sets the children of a position
         * @param children The input list
         */
        public void setChildren(ArrayList<Position<T>> children) {
            this.children = children;
        }
        
        /**
         * Gets the parent of a node
         * @return The parent node
         */
        public Node<T> getParent() {
            return parent;
        }
        
        /**
         * Sets the parent of a node
         * @param parent The input parent
         */
        public void setParent(Node<T> parent) {
            this.parent = parent;
        }
        
        /**
         * Gets the element of the node
         * @return The element
         */
        public T getElement() {
            return element;
        }
        
        /**
         * Sets the element of the node
         * @param element The input element
         */
        public void setElement(T element) {
            this.element = element;
        }
        
        
        
    }
    
      /**
       * This class configures an iterator
       */
      private class ElementIterator implements Iterator<T> {

        Iterator<Position<T>> posIterator = positions().iterator();
        
        /**
         * Wonders if the position has a next
         * @return True if it has, false it hasn't
         */
        @Override
        public boolean hasNext() {
            return posIterator.hasNext();
        }
        
        /**
         * Gets the next element
         * @return The next element
         */
        @Override
        public T next() {
            return posIterator.next().getElement();
        }
        
        /**
         * Removes
         */
        @Override
        public void remove() {
            Iterator.super.remove();
        }

    }
    
    /**
     * Calls to an iterator
     * @return The iterator
     */
    @Override
    public Iterator iterator() {
        return new ElementIterator();
    }  
    
    @Override
    public Position<T> root() {
       return root;
    }

    
     /**
     * Adds the root to the Binary Tree
     * 
     * @param element The element to be the root
     * @return The position of the root
     * @throws IllegalStateException The tree isn't empty
     */
    public Position<T> addRoot(T element)throws IllegalStateException{
          if (!isEmpty()) {
            throw new IllegalStateException("The tree isn't empty");
        }
        root = createNode(null, null, element);
        size = 1;
        return root;
        
    }
      
     /**
     * Determines if a position is really one of them
     *
     * @param p The position to be tested
     * @return The same node
     * @throws IllegalArgumentException The exceptions that could be
     */
      protected Node<T> validate(Position<T> p) throws IllegalArgumentException {
        if (!(p instanceof Node)) {
            throw new IllegalArgumentException("Isn't a valid position");
        }

        Node<T> e = (Node<T>) p;

        if (e.getParent()== e) {
            throw new IllegalArgumentException("p isn't in the tree");
        }
        return e;
    }
        
      /**
       * Adds an element to a specified position
       * @param element The input element
       * @param p The position of the insertion
       * @return The position with the added element
       * @throws IllegalArgumentException ??
       */
       public Position<T> add(T element, Position<T> p) throws IllegalArgumentException {
        Node<T> parent = validate(p);
        Node<T> child = createNode(null,parent,element);
        size++;
        ArrayList<Position<T>> actualchildren=new ArrayList<>();
        if(parent.getChildren()!=null){
            actualchildren= parent.getChildren();
        }
        
        
           
        actualchildren.add(child);   
           
        parent.setChildren(actualchildren);
        return child;
    }
    
    /**
     * Creates a node
     * 
     * @param children The list with children
     * @param parent The parent reference
     * @param element The element of that position
     * @return The created node
     */   
    protected Node<T> createNode(ArrayList<Position<T>> children, Node<T> parent, T element){
        return new Node<>(children, parent, element);
    }
    
     /**
     * Attach a tree in a leave of other tree
     * @param p The leave
     * @param lefTree The tree that receives the other
     * @param rightTree The attached tree
     * @throws IllegalArgumentException P must be a leaf
     */
    public void attach(Position<T> p,
            LinkedTree<T> lefTree,
            LinkedTree<T> rightTree) throws IllegalArgumentException {
        Node<T> newNode = validate(p);

        if (numChilds(p)>0) {
            throw new IllegalArgumentException("P must be a leaf");
        }
        
        size += lefTree.size() + rightTree.size();
        
        if (!lefTree.isEmpty()) {
            lefTree.root.setParent(newNode);
            ArrayList<Position<T>> actualChildren=new ArrayList<>();
            if(newNode.getChildren()!=null){
                actualChildren=newNode.getChildren();
            }
            actualChildren.add(lefTree.root);
            newNode.setChildren(actualChildren);
            lefTree.root = null;
            lefTree.size = 0;
        }

        if (!rightTree.isEmpty()) {
            rightTree.root.setParent(newNode);
            ArrayList<Position<T>> actualChildren= newNode.getChildren();
            actualChildren.add(rightTree.root);
            newNode.setChildren(actualChildren);
            rightTree.root = null;
            rightTree.size = 0;
        }
    }
    
     /**
     * Allows see the size of a tree
     * @return An integer with the size of the tree
     */
    @Override
    public int size() {
        return size;
    }
    
     /**
     * Returns the parent node of a position
     * @param p The input position
     * @return The parent node
     * @throws IllegalArgumentException Is a root
     */
    @Override
    public Position parent(Position p) throws IllegalArgumentException {
        Node<T> newnode = validate(p);
        return newnode.getParent();
    }
    
     /**
     * Determines if the position is the root of the tree
     * @param p The input position
     * @return True if is the root false isn't 
     * @throws IllegalArgumentException ??
     */
    @Override
    public boolean isRoot(Position p) throws IllegalArgumentException {
       Node<T> nde=validate(p);
       return nde.getParent()==null;
    }
    
    /**
     * Returns the list with all children of a position 
     * @param p The input position
     * @return A list with all children of the position
     * @throws IllegalStateException The position p hasn't children
     */
    public ArrayList<Position<T>> Children(Position<T> p)throws IllegalStateException{
        Node<T> nde=validate(p);
        if (nde.getChildren()==null) {
            throw new IllegalStateException("The position p hasn't children");
        }
        return nde.getChildren();
    }
    
    
    
    /**
     * Allows to know how many children has the position
     * 
     * @param p The input position
     * @return An integer with the number of the children
     * @throws IllegalArgumentException Hasn't children
     */
    public int numChilds(Position<T> p) throws IllegalArgumentException {
       Node<T> nde=validate(p);
        if (nde.getChildren()!=null) {
            return nde.getChildren().size();
        }
        else{
            return 0;
        }
    }
    
  
    
    /**
     * Gets the siblings of a specified child
     * @param p The specified child
     * @return A list with the siblings
     * @throws IllegalStateException The position p hasn't siblings
     */
    public ArrayList<Position<T>> siblings(Position<T> p)throws IllegalStateException{
         Node<T> nde=validate(p);
         
         if (nde.getParent()!=null) {
           if (nde.getParent().getChildren()==null) {
            throw new IllegalStateException("The position p hasn't siblings");
        } 
         ArrayList<Position<T>> siblings=nde.getParent().getChildren();
         siblings.remove(p);
         return siblings; 
           
        }
         else{
             throw new IllegalStateException("The position p is a root");        
         } 
    }
        
}
