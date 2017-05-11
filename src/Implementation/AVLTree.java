/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implementation;

import Interfaces.Position;

/**
 *
 * @author Daniel Jiménez Chísica
 */
public class AVLTree<T> extends LinkedBinaryTree<T>{
        
    public boolean itHolds(Position pos){
       Node<T> p= validate(pos);
       return (height(p.getLeft())-height(p.getRight()))>-2 && (height(p.getLeft())-height(p.getRight()))<2;
    }
    
    public void simpleLeftRotation(Position p){
        Node<T> pos= validate(p);
        Node<T> parent=pos.getFather();
        Node<T> child=pos.getLeft();
        
        pos.setLeft(pos.getLeft().getRight());
        child.setRight(pos);
        
        if(parent.getLeft()==pos){
            parent.setLeft(pos.getLeft());
        }
        
        else
            parent.setRight(pos.getRight());
            pos.right.father=parent;
    }
    
    public void simpleRightRotation(Position p){
        Node<T> pos= validate(p);
        Node<T> parent=pos.father;
        Node<T> child=pos.right;
        
        pos.right=pos.right.left;
        child.left=pos;
        
        if(parent.left==pos){
            parent.left=pos.right;
        }
        
        else{
            parent.right=pos.right;
            pos.right.father=parent;
        }
    }
    
    public void DoubleRightRotation(Position p){
        Node<T> pos= validate(p);
        simpleLeftRotation(pos.right);
        simpleRightRotation(p);
    }
    
    public void DoubleLeftRotation(Position p){
        Node<T> pos= validate(p);
        simpleRightRotation(pos.left);
        simpleLeftRotation(p);
    }
    
    /**
    public void Insert(Position p, T element){
       Node<T> position=validate(p);
        if (element>position) {
            
        }
        else{
            
        }
       
    }
    */
    
    public void balance(Position p){
        Node<T> pos=validate(p);
        if (!itHolds(p)) {
            if(height(pos.left)-height(pos.right)==-2){
                Node<T> child=pos.right;
                if(height(child.left)-height(child.right)==-1){
                    simpleRightRotation(p);
                }
                else{
                    DoubleRightRotation(p);
                }
            }
            else if(height(pos.left)-height(pos.right)==2){
                Node<T> child=pos.left;
                if(height(child.left)-height(child.right)==1){
                    simpleLeftRotation(p);
                }
                else{
                    DoubleLeftRotation(p);
                }
            }
        }
  
    }
    
}




