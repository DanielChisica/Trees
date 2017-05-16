/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AbstractTrees;

import Interfaces.Position;
import java.util.Iterator;
import Interfaces.Tree;
import java.util.ArrayList;
import java.util.List;
import Implementation.LinkedTree;


/**
 * Represents an abstract tree and its methods
 * @author Daniel Jiménez
 * @param <T> Generic Data Type
 */
public abstract class AbstractTree<T> implements Tree<T> {
    
    /**
     * Returns the integer with the depth of the tree
     * @param p The position to evaluates its depth
     * @return  An integer with its depth
     */
    public int depth(Position<T> p) {
        if (isRoot(p)) {
            return 0;
        } else {
            return 1 + depth(parent(p));
        }
    }
    
    /**
     * Returns an integer with the height value of the tree
     * @param p The position
     * @return An integer with the height
     */
    public int height(Position<T> p){
        int h=0;
        for(Position<T> c: children(p)){
            h=Math.max(h, 1+height(c));
        }
        return h;
    }
    
    private class ElementIterator implements Iterator<T>{
        Iterator<Position<T>>posIterator=positions().iterator();

        @Override
        public boolean hasNext() {
           return posIterator.hasNext();
        }

        @Override
        public T next() {
           return posIterator.next().getElement();
        }

        @Override
        public void remove() {
            Iterator.super.remove(); //To change body of generated methods, choose Tools | Templates.
        }
    }
    
    public Iterable<Position<T>> preOrder(){
        List<Position<T>> snapshot= new ArrayList<>();
        if(!isEmpty()){
            preorderSubTree(root(), snapshot);
        }
        return snapshot;
                
    }
    
    public Iterable<Position<T>> postOrder(){
        List<Position<T>> snapshot= new ArrayList<>();
        if(!isEmpty()){
            posOrderSubTree(root(), snapshot);
        }
        return snapshot;
                
    }
    
    private void posOrderSubTree(Position<T> p, List<Position<T>> snapshot){
        for (Object child: children(p)) {
            posOrderSubTree((Position<T>)child, snapshot);
        }
        snapshot.add(p);
    }
    
    private void preorderSubTree(Position<T> p, List<Position<T>> snapshot){
        snapshot.add(p);
        for (Object child: children(p)) {
            preorderSubTree((Position<T>)child, snapshot);
        }
    }
    
    
    @Override
    public Position<T> root() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Position<T> parent(Position<T> p) throws IllegalArgumentException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterable<Position<T>> children(Position<T> p) throws IllegalArgumentException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int numChildren(Position<T> p) throws IllegalArgumentException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * Asks if a position is internal
     * @param p The position asked
     * @return A boolean
     * @throws IllegalArgumentException A exception
     */
    @Override
    public boolean isInternal(Position<T> p) throws IllegalArgumentException {
        return numChildren(p) > 0;
    }
    
    /**
     * Asks if a position is external
     * @param p The position asked
     * @return A boolean
     * @throws IllegalArgumentException A exception
     */
    @Override
    public boolean isExternal(Position<T> p) throws IllegalArgumentException {
        return numChildren(p) == 0;
    }
    
    /**
     * Ask whether a position is a root or not
     * @param p The asked position
     * @return A boolean with the answer
     * @throws IllegalArgumentException A exception
     */
    @Override
    public boolean isRoot(Position<T> p) throws IllegalArgumentException {
        return p == this.root();
    }

    @Override
    public int size() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * Ask if the tree is empty
     * @return True if is empty false isn't
     */
    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    @Override
    public Iterator<T> iterator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterable<Position<T>> positions() {
      return preOrder();
    }

  

}
