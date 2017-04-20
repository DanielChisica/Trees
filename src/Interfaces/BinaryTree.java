/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

/**
 * A data structure in which a record is linked to two successor records,
 * usually referred
 * @author Daniel Jiménez
 */
public interface BinaryTree<T> extends Tree{
    Position<T> right(Position<T> p);
    Position<T> left(Position<T> p);
    Position<T> brother(Position<T> p);
}
