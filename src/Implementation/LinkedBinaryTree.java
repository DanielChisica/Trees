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
 * @author Daniel Jiménez
 */
public class LinkedBinaryTree<T> extends AbstractBinaryTree<T> {

    @Override
    public Position brother(Position p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Class Node
     *
     * @param <T>
     */
    protected static class Node<T> implements Position<T> {

        private T element;
        private Node<T> father, left, right;

        public Node(T element, Node<T> above, Node<T> leftChild, Node<T> rightChild) {
            this.element = element;
            this.father = above;
            this.left = leftChild;
            this.right = rightChild;
        }

        public T getElement() {
            return element;
        }

        public void setElement(T element) {
            this.element = element;
        }

        public Node<T> getFather() {
            return father;
        }

        public void setFather(Node<T> father) {
            this.father = father;
        }

        public Node<T> getLeft() {
            return left;
        }

        public void setLeft(Node<T> left) {
            this.left = left;
        }

        public Node<T> getRight() {
            return right;
        }

        public void setRight(Node<T> right) {
            this.right = right;
        }

    }

    protected Node<T> root = null;
    int size;

    public LinkedBinaryTree() {
    }
    
    /**
     * A factory of nodes
     * @param element The element of the node
     * @param father The parent node
     * @param left The node placed in its left
     * @param right The node placed in its right
     * @return 
     */
    protected Node<T> createNode(T element, Node<T> father,
            Node<T> left, Node<T> right) {
        return new Node<>(element, father, left, right);
    }
    
    /**
     * Determines if a position is really one of them
     * @param p The position to be tested
     * @return The same node
     * @throws IllegalArgumentException The exceptions that could be 
     */
    protected Node<T> validate(Position<T> p)throws IllegalArgumentException{
        if (!(p instanceof Node)) {
            throw new IllegalArgumentException("Isn't a valid position");
        }
        
        Node<T> e=(Node<T>) p;
        
        if (e.getFather()==e){
            throw new IllegalArgumentException("p isn't in the tree");
        }
        return e;
    }
    
    

    @Override
    public Position right(Position p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Position left(Position p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Position root() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Position parent(Position p) throws IllegalArgumentException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isInternal(Position p) throws IllegalArgumentException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isExternal(Position p) throws IllegalArgumentException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isRoot(Position p) throws IllegalArgumentException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int size() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterator iterator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterable positions() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   

    @Override
    public void forEach(Consumer action) {
        super.forEach(action); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Spliterator spliterator() {
        return super.spliterator(); //To change body of generated methods, choose Tools | Templates.
    }

}
