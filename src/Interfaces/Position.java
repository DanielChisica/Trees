/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

/**
 * A position of a tree, this can be a parent or a child, including leaves,
 * branches or roots
 * @author Daniel Jiménez
 */
public interface Position<T> {
    T getElement() throws IllegalStateException;
}
