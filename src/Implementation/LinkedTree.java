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
            throw new IllegalStateException("The tree isn't empty");
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
      

        Node<T> child = createNode(null,null,element);

        size++;

        List<Position<T>>actualchildren= parent.getChildren();
        actualchildren.add(child);
        parent.setChildren(actualchildren);
        return child;
    }
    
    protected Node<T> createNode(List<Position<T>> children, Node<T> parent, T element){
        return new Node<>(children, parent, element);
    }
    
    public void attach(Position<T> p,
            LinkedTree<T> lefTree,
            LinkedTree<T> rightTree) throws IllegalArgumentException {
        Node<T> newNode = validate(p);

        if (isInternal(p)) {
            throw new IllegalArgumentException("P must be a leaf");
        }
        
        size += lefTree.size() + rightTree.size();
        
        if (!lefTree.isEmpty()) {
            lefTree.root.setParent(newNode);
            List<Position<T>> actualChildren= newNode.getChildren();
            actualChildren.add(lefTree.root);
            newNode.setChildren(actualChildren);
            lefTree.root = null;
            lefTree.size = 0;
        }

        if (!rightTree.isEmpty()) {
            rightTree.root.setParent(newNode);
            List<Position<T>> actualChildren= newNode.getChildren();
            actualChildren.add(rightTree.root);
            newNode.setChildren(actualChildren);
            rightTree.root = null;
            rightTree.size = 0;
        }
    }
    
    @Override
    public int size() {
        return size;
    }
    
    @Override
    public Position parent(Position p) throws IllegalArgumentException {
        Node<T> newnode = validate(p);
        return newnode.getParent();
    }
    
    @Override
    public boolean isRoot(Position p) throws IllegalArgumentException {
       Node<T> nde=validate(p);
       return nde.getParent()==null;
    }
    
    public List<Position<T>> Children(Position<T> p)throws IllegalStateException{
        Node<T> nde=validate(p);
        if (nde.getChildren()==null) {
            throw new IllegalStateException("The position p hasn't children");
        }
        return nde.getChildren();
    }
     
    public Position<T> child(Position<T> p){
        Node parent=validate(p);
        List<Position<T>> actualChildren=parent.getChildren();
        
        
        Position<T> child=null;
        for (Position<T> position : actualChildren) {
            if (position==actualChildren) {
                child=position;
            }
        }
        return child;
    } 
    
    
    public int numChilds(Position<T> p) throws IllegalArgumentException {
       Node<T> nde=validate(p);
        return nde.getChildren().size();
    }
    
    public List<Position<T>> siblings(Position<T> p)throws IllegalStateException{
         Node<T> nde=validate(p);
         if (nde.getParent().getChildren()==null) {
            throw new IllegalStateException("The position p hasn't siblings");
        }
         List<Position<T>> siblings=nde.getParent().getChildren();
         siblings.remove(p);
         return siblings;
    }
    
    public Position<T> sibling(Position<T> p)throws IllegalStateException{
      Node<T> nde=validate(p);
      List<Position<T>> siblings=nde.getParent().getChildren();
      if (nde.getParent().getChildren()==null) {
            throw new IllegalStateException("The position p hasn't siblings");
        }
      return siblings.get(siblings.indexOf(p));
    } 
    
}
