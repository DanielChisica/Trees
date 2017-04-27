/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implementation;

import AbstractTrees.AbstractTree;
import Interfaces.*;
import java.util.List;
/**
 *
 * @author SALA309
 * @param <T>
 */
public class LinkedTree<T> extends AbstractTree{


    
    protected Node<T> root=null;
    int size;
    
    protected class Node<T>  implements Position{
        private List<Position<T>> children;
        private Node<T> parent;
        private T element;

        public Node(List<Position<T>> children, Node<T> parent, T element) {
            this.children = children;
            this.parent = parent;
            this.element = element;
        }
        
        
        
        public List<Position<T>> getChildren() {
            return children;
        }

        public void setChildren(List<Position<T>> children) {
            this.children = children;
        }

        public Node<T> getParent() {
            return parent;
        }

        public void setParent(Node<T> parent) {
            this.parent = parent;
        }

        public T getElement() {
            return element;
        }

        public void setElement(T element) {
            this.element = element;
        }
        
        
        
    }
    
    public Position<T> addRoot(T element){
          if (!isEmpty()) {
            throw new IllegalStateException("El arbol no esta vacio");
        }
        root = createNode(null, null, element);
        size = 1;
        return root;
        
    }
    
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
      
       public Position<T> add(T element, Position<T> p) throws IllegalArgumentException {
        Node<T> parent = validate(p);
      

        //Node<T> child = createNode(element, parent, null, null);

        size++;

        //parent.setLeft(child);

        //return child;
    }
    
    protected Node<T> createNode(List<Position<T>> children, Node<T> parent, T element){
        return new Node<>(children, parent, element);
    }
    
    
     
    
}
