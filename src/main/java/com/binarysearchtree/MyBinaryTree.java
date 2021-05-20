package com.binarysearchtree;

public class MyBinaryTree<K extends Comparable<K>> {

    private MyBinaryNode<K> root;

    public void add(K key) {
        this.root = this.addRecursively(root, key);
    }

    private MyBinaryNode<K> addRecursively(MyBinaryNode<K> current, K key) {
        if (current == null)
            return new MyBinaryNode<>(key);
        int compareResult = key.compareTo(current.key);
        if (compareResult == 0) return current;
        if (compareResult < 0) {
            current.left = addRecursively(current.left, key);
        } else {
            current.right = addRecursively(current.right, key);
        }
        return current;
    }

    public int getSize() {
        return this.getSizeRecursive(root);
    }

    private int getSizeRecursive(MyBinaryNode<K> current) {
        return current == null ? 0 : 1 + this.getSizeRecursive(current.left)
                                       + this.getSizeRecursive(current.right);
    }

    public void traverseInOrder(MyBinaryNode node) {
        if (node != null) {
            traverseInOrder(node.left);
            System.out.print(" " + node.key);
            traverseInOrder(node.right);
        }
    }

    public void print() {
        traverseInOrder(root);
    }

    public boolean search(K key) {
        return searchRecursive(root, key);
    }

    private boolean searchRecursive(MyBinaryNode<K> current, K key) {
        if (current == null)
            return false;
        else if (current.key.compareTo(key) == 0)
            return true;
        else if (current.key.compareTo(key) < 0)
            return searchRecursive(current.right, key);
        else
            return searchRecursive(current.left, key);
    }
}

