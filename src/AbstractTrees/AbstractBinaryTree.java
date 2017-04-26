/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AbstractTrees;

import Interfaces.Position;
import java.util.ArrayList;
import java.util.List;
import Interfaces.BinaryTree;

/**
 * Represents an abstract binary tree and its methods
 * @author Daniel Jiménez
 */
public abstract class AbstractBinaryTree<T> extends AbstractTree implements BinaryTree {
    
    /**
     * Returns the brother of a position
     * @param p The position to which its brother is going to get
     * @return
     * @throws IllegalArgumentException 
     */
    public Position<T> brother(Position p) throws IllegalArgumentException {
        Position<T> father = parent(p);
        if (father == null) {
            return null;
        }
        if (p == left(father)) {
            return right(father);
        }
        return left(father);
    }
    
    /**
     * Returns the number of children
     * @param p The position to which its children is going to get
     * @return An integer with the number of children
     */
    public int numChild(Position p) {
        int counter = 0;
        if (left(p) != null) {
            counter++;
        }
        if (right(p) != null) {
            counter++;
        }
        return counter;
    }
    
    /**
     * Return all children of a position
     * @param p The position to which its children is going to get
     * @return All children
     */
    public Iterable<Position<T>> childs(Position p) {
        List<Position<T>> childs = new ArrayList<>(2);
        if (left(p) != null) {
            childs.add(left(p));
        }

        if (right(p) != null) {
            childs.add(right(p));
        }
        return childs;
    }
    
    private void inorderSubTree(Position<T> p, List<Position<T>> snapshot){
        if(left(p)!=null){
            snapshot.add(left(p));
        }
        else{
            snapshot.add(parent(p));
        }
        if(right(p)!=null){
            snapshot.add(right(p));
        }
        
    }
    
}
