/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implementation;

import AbstractTrees.AbstractBinaryTree;
import Interfaces.Position;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * The implementation of a linked binary tree
 *
 * @author Daniel Jiménez
 * @since 20 April 2017
 */
public class LinkedBinaryTree<T> extends AbstractBinaryTree<T> {
    
    /**
     * Class Node
     *
     * @param <T> Generic Data Type
     */
    protected static class Node<T> implements Position<T> {

        private T element;
        public Node<T> father, left, right;
        
        /**
         * Constructor method of a node
         * 
         * @param element The element of the position
         * @param above The parent of this position
         * @param leftChild The left child of the position
         * @param rightChild The right child of the position
         */
        public Node(T element, Node<T> above, Node<T> leftChild, Node<T> rightChild) {
            this.element = element;
            this.father = above;
            this.left = leftChild;
            this.right = rightChild;
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
        
        /**
         * Gets the parent of a node
         * @return The parent node
         */
        public Node<T> getFather() {
            return father;
        }
        
        /**
         * Sets the parent of a node
         * @param father The input parent
         */
        public void setFather(Node<T> father) {
            this.father = father;
        }
        
        /**
         * Gets the left child of a node
         * @return The left child
         */
        public Node<T> getLeft() {
            return left;
        }
        
        /**
         * Sets the left child of a node
         * @param left The input left child
         */
        public void setLeft(Node<T> left) {
            this.left = left;
        }
        
        /**
         * Gets the right children of a node
         * @return The right child of a node
         */
        public Node<T> getRight() {
            return right;
        }
        
        /**
         * Sets the right child to a node
         * @param right The input right child
         */
        public void setRight(Node<T> right) {
            this.right = right;
        }

    }

    protected Node<T> root = null;
    int size=0;
    
    /**
     * Constructor method of a Linked Binary Tree
     */
    public LinkedBinaryTree() {
    }

    /**
     * A factory of nodes
     *
     * @param element The element of the node
     * @param father The parent node
     * @param left The node placed in its left
     * @param right The node placed in its right
     * @return The created node
     */
    protected Node<T> createNode(T element, Node<T> father,
            Node<T> left, Node<T> right) {
        return new Node<>(element, father, left, right);
    }

    /**
     * Determines if a position is really one of them
     *
     * @param p The position to be tested
     * @return The same node
     * @throws IllegalArgumentException The exceptions that could be
     */
    protected Node<T> validate(Position<T> p) throws IllegalArgumentException {

        Node<T> e = (Node<T>) p;

        if (e.getFather() == e) {
            throw new IllegalArgumentException("p isn't in the tree");
        }
        return e;
    }
    
    /**
     * Adds the root to the Binary Tree
     * 
     * @param element The element to be the root
     * @return The position of the root
     * @throws IllegalStateException The tree isn't empty
     */
    public Position<T> addRoot(T element) throws IllegalStateException {
        if (!isEmpty()) {
            throw new IllegalStateException("The tree isn't empty");
        }
        root = createNode(element, null, null, null);
        size = 1;
        return root;
    }
        
        /**
         * Receives a position and puts in its left side an element
         * 
         * @param element The input element
         * @param p The position of the insertion
         * @return The position of the inserted element
         * @throws IllegalArgumentException There's a left
         */
        public Position<T> addLeft(T element, Position<T> p) throws IllegalArgumentException {
        Node<T> parent = validate(p);
        if (parent.getLeft() != null) {
            throw new IllegalArgumentException("There's a left");
        }

        Node<T> child = createNode(element, parent, null, null);

        size++;

        parent.setLeft(child);

        return child;
    }
    
    /**
     * Receives a position and puts in its left side an element
     * 
     * @param element The element to be placed on the right of the node
     * @param p The position of the insertion
     * @return The position of the inserted element
     * @throws IllegalArgumentException There's a right
     */    
    public Position<T> addRight(T element, Position<T> p) throws IllegalArgumentException {
        Node<T> parent = validate(p);
        if (parent.getRight() != null) {
            throw new IllegalArgumentException("There's a right");
        }

        Node<T> child = createNode(element, parent, null, null);

        size++;

        parent.setRight(child);

        return child;
    }
    
    /**
     * Places an element in a specific position
     * @param p The position
     * @param element The element
     * @return The element placed
     */
    public T set(Position<T> p, T element) {
        Node<T> position = validate(p);

        T temporal = position.getElement();
        position.setElement(element);

        return temporal;

    }
    
    /**
     * Attach a tree in a leave of other tree
     * @param p The leave
     * @param lefTree The tree that receives the other
     * @param rightTree The attached tree
     * @throws IllegalArgumentException P must be a leaf
     */
    public void attach(Position<T> p,
            LinkedBinaryTree<T> lefTree,
            LinkedBinaryTree<T> rightTree) throws IllegalArgumentException {
        Node<T> newNode = validate(p);

        if (numChild(p) > 0) {
            throw new IllegalArgumentException("P must be a leaf");
        }

        size += lefTree.size() + rightTree.size();

        if (!lefTree.isEmpty()) {
            lefTree.root.setFather(newNode);
            newNode.setLeft(lefTree.root);
            lefTree.root = null;
            lefTree.size = 0;
        }

        if (!rightTree.isEmpty()) {
            rightTree.root.setFather(newNode);
            newNode.setRight(rightTree.root);
            rightTree.root = null;
            rightTree.size = 0;
        }

    }
    
    /**
     * Removes an element of the three
     * @param p The position that contains the element
     * @return The element
     * @throws IllegalArgumentException p has 2 children
     */
    public T remove(Position<T> p) throws IllegalArgumentException {
        Node<T> newNode = validate(p);
        if (numChild(p) == 2) {
            throw new IllegalArgumentException("p has 2 children");
        }

        Node<T> child = (newNode.getLeft() != null
                ? newNode.getLeft() : newNode.getRight());

        if (child != null) {
            child.setFather(newNode.getFather());
        }

        if (newNode == root) {
            root = child;
        } else {
            Node<T> parent = newNode.getFather();
            if (newNode == parent.getLeft()) {
                parent.setLeft(child);
            } else {
                parent.setRight(child);
            }
        }
        size--;
        T retorno = newNode.getElement();
        newNode.setElement(null);
        newNode.setLeft(null);
        newNode.setRight(null);
        newNode.setFather(newNode);
        return retorno;
    }
    
    /**
     * Returns the right node of a position
     * @param p The input position 
     * @return The position in the right side
     */
    @Override
    public Position right(Position p) {
        Node<T> newnode = validate(p);
        return newnode.getRight();
    }
    
    /**
     * Returns the left node of a position
     * @param p The input position
     * @return The position in the left side
     */
    @Override
    public Position left(Position p) {
        Node<T> newnode = validate(p);
        return newnode.getLeft();
    }
    
    /**
     * Returns the root of the tree
     * @return The root of the tree
     */
    @Override
    public Position<T> root() {
        return root;
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
        return newnode.getFather();
    }
    
    /**
     * Determines if the position is the root of the tree
     * @param p The input position
     * @return True if is the root false isn't 
     * @throws IllegalArgumentException Isn't a position
     */
    @Override
    public boolean isRoot(Position p) throws IllegalArgumentException {
       Node<T> nde=validate(p);
       return nde.getFather()==null;
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
     * An iterator about the tree
     * @return The iterator with the tree positions
     */
    @Override
    public Iterator iterator() {
       throw new UnsupportedOperationException("Not supported yet.");
    }
    
    /**
     * I don't know
     * @param action Neither 
     */
    @Override
    public void forEach(Consumer action) {
        super.forEach(action); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * Much less
     * @return ¿?
     */
    @Override
    public Spliterator spliterator() {
        return super.spliterator(); //To change body of generated methods, choose Tools | Templates.
    }

}
