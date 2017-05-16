/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implementation;

import Interfaces.Position;

/**
 * The AVL Tree is named like this due to Georgy Adelson-Velsky and Evgenii
 * Landis its inventors. This tree was the first data structure to be invented,
 * is a self-balancing binary tree.
 *
 * @author Daniel Jiménez Chísica
 * @since 12 May 2017
 */
public class AVLTree<T> extends LinkedBinaryTree<T> {

    /**
     * This method determines if a position is able to hold charges, no matter
     * whether it's charged on the left or right
     *
     * @param pos The position to be tested
     * @return True if the position endures more children
     */
    public boolean itHolds(Position pos) {
        Node<T> p = validate(pos);
        return (height(p.getLeft()) - height(p.getRight())) > -2 && (height(p.getLeft()) - height(p.getRight())) < 2;
    }

    /**
     * Makes a simple rotation to the left side, focusing on the unbalanced
     * position
     *
     * @param p The unbalanced position
     */
    public void simpleLeftRotation(Position p) {
        Node<T> pos = validate(p);
        Node<T> parent = pos.getFather();
        Node<T> child = pos.getLeft();

        if (child != null) {
            pos.setLeft(pos.getLeft().getRight());
            child.setRight(pos);
        }

        if (parent.getLeft() == pos) {
            parent.setLeft(pos.getLeft());
        } else {
            parent.setRight(pos.getRight());
        }
        pos.right.father = parent;
    }

    /**
     * Makes a simple rotation to the right side, focusing on the unbalanced
     * position
     *
     * @param p The unbalanced position
     */
    public void simpleRightRotation(Position p) {
        Node<T> pos = validate(p);
        Node<T> parent = pos.father;
        Node<T> child = pos.right;

        pos.right = pos.right.left;
        child.left = pos;

        if (parent.left == pos) {
            parent.left = pos.right;
        } else {
            parent.right = pos.right;
            pos.right.father = parent;
        }
    }

    /**
     * Makes a double rotation to the right side, focusing on the unbalanced
     * position
     *
     * @param p The unbalanced position
     */
    public void DoubleRightRotation(Position p) {
        Node<T> pos = validate(p);
        simpleLeftRotation(pos.right);
        simpleRightRotation(p);
    }

    /**
     * Makes a double rotation to the left side, focusing on the unbalanced
     * position
     *
     * @param p The unbalanced position
     */
    public void DoubleLeftRotation(Position p) {
        Node<T> pos = validate(p);
        simpleRightRotation(pos.left);
        simpleLeftRotation(p);
    }


    /**
     * Inserts a number on the AVL Tree according if is higher or smaller to the
     * positions already placed
     * 
     * @param p initial position of the method
     * @param element The number to be placed
     * @return The position with the node of the element
     */
    public Position<T> Insert(Position p, T element) {
        Node<T> position = validate(p);
        if (Integer.parseInt(element.toString()) > Integer.parseInt(position.getElement().toString())) {
            if (position.right == null) {
                return addRight(element, position);
            } else {
                Insert(position.right, element);
            }
        } else {
            if (Integer.parseInt(element.toString()) < Integer.parseInt(position.getElement().toString())) {
                if (position.left == null) {
                    return addLeft(element, position);
                } else {
                    Insert(position.left, element);
                }
            }
        }
        size++;
        return position;
    }

    /**
     * Finds a element on the AVL Tree and returns its position
     *
     * @param p The initial position of the search
     * @param element The element to be searched
     * @return The node with the found element
     */
    public Position<T> search(Position p, T element) {
        Node<T> position = validate(p);
        if (Integer.parseInt(element.toString()) > Integer.parseInt(position.getElement().toString())) {
            if (position.right.getElement() == element) {
                return position.right;
            } else {
                search(position.right, element);
            }
        } else {
            if (Integer.parseInt(element.toString()) < Integer.parseInt(position.getElement().toString())) {
                if (position.left.getElement() == element) {
                    return position.left;
                } else {
                    search(position.left, element);
                }
            }
        }
        return p;
    }

    /**
     * Finds the input element and delete it
     *
     * @param p The initial position of the search
     * @param element The input element to be deleted
     */
    public void delete(Position p, T element) {
        Node<T> position = validate(p);
        if (Integer.parseInt(element.toString()) > Integer.parseInt(position.getElement().toString())) {
            if (position.right.getElement() == element) {
                position.right = null;
            } else {
                delete(position.right, element);
            }
        } else {
            if (Integer.parseInt(element.toString()) < Integer.parseInt(position.getElement().toString())) {
                if (position.left.getElement() == element) {
                    position.left = null;
                } else {
                    delete(position.left, element);
                }
            }
        }
    }

    /**
     * If a position is unbalanced, the next algorithm decides what rotation
     * apply
     *
     * @param p The unbalanced position
     */
    public void balance(Position p) {
        Node<T> pos = validate(p);
        if (!itHolds(p)) {
            if (height(pos.left) - height(pos.right) == -2) {
                Node<T> child = pos.right;
                if (height(child.left) - height(child.right) == -1) {
                    simpleRightRotation(p);
                } else {
                    DoubleRightRotation(p);
                }
            } else if (height(pos.left) - height(pos.right) == 2) {
                Node<T> child = pos.left;
                if (height(child.left) - height(child.right) == 1) {
                    simpleLeftRotation(p);
                } else {
                    DoubleLeftRotation(p);
                }
            }
        }

    }

}
