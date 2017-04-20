/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import java.util.Iterator;

/**
 * A tree is a data structure that simulates a hierarchical tree structure, 
 * with a root value and subtrees of children with a parent node, 
 * represented as a set of linked nodes.
 * @author Daniel Jiménez
 */
public interface Tree<T> extends Iterable<T> {

    Position<T> root();

    Position<T> parent(Position<T> p) throws IllegalArgumentException;

    Iterable<Position<T>> children(Position<T> p) throws IllegalArgumentException;

    int numChildren(Position<T> p) throws IllegalArgumentException;

    boolean isInternal(Position<T> p) throws IllegalArgumentException;

    boolean isExternal(Position<T> p) throws IllegalArgumentException;

    boolean isRoot(Position<T> p) throws IllegalArgumentException;

    int size();

    boolean isEmpty();

    Iterator<T> iterator();

    Iterable<Position<T>> positions();
}
