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
 */
public class LinkedBinaryTree<T> extends AbstractBinaryTree<T> {
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
     *
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

        if (e.getFather() == e) {
            throw new IllegalArgumentException("p isn't in the tree");
        }
        return e;
    }

    public Position<T> addRoot(T element) throws IllegalStateException {
        if (!isEmpty()) {
            throw new IllegalStateException("The tree isn't empty");
        }
        root = createNode(element, null, null, null);
        size = 1;
        return root;
    }

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

    public Position<T> addRight(T element, Position<T> p) throws IllegalArgumentException {
        Node<T> parent = validate(p);
        if (parent.getRight() != null) {
            throw new IllegalArgumentException("Ya hay un derecho");
        }

        Node<T> child = createNode(element, parent, null, null);

        size++;

        parent.setRight(child);

        return child;
    }

    public T set(Position<T> p, T element) {
        Node<T> position = validate(p);

        T temporal = position.getElement();
        position.setElement(element);

        return temporal;

    }

    public void attach(Position<T> p,
            LinkedBinaryTree<T> lefTree,
            LinkedBinaryTree<T> rightTree) throws IllegalArgumentException {
        Node<T> newNode = validate(p);

        if (isInternal(p)) {
            throw new IllegalArgumentException("P debe ser hoja");
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

    public T remove(Position<T> p) throws IllegalArgumentException {
        Node<T> newNode = validate(p);
        if (numChild(p) == 2) {
            throw new IllegalArgumentException("p tiene 2 hijos");
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

    @Override
    public Position right(Position p) {
        Node<T> newnode = validate(p);
        return newnode.getRight();
    }

    @Override
    public Position left(Position p) {
        Node<T> newnode = validate(p);
        return newnode.getLeft();
    }

    @Override
    public Position<T> root() {
        return root;
    }

    @Override
    public Position parent(Position p) throws IllegalArgumentException {
        Node<T> newnode = validate(p);
        return newnode.getFather();
    }
    
    @Override
    public boolean isRoot(Position p) throws IllegalArgumentException {
       Node<T> nde=validate(p);
       return nde.getFather()==null;
    }

    @Override
    public int size() {
        return size;
    }
    
    @Override
    public Iterator iterator() {
       throw new UnsupportedOperationException("Not supported yet.");
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
