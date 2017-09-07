package com.hackerrank.datastructure.tree;

/**
 * https://www.hackerrank.com/challenges/is-binary-search-tree/problem
 */
public class IsThisBST {
    public static void main(String[] args) {
        System.out.println(checkBST(null) ? "YES" : "NO");
    }

    private static boolean checkBST(Node root) {
        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean isBST(Node root, int lowerLimit, int upperLimit) {
        if (root == null) {
            return true;
        }
        if (root.data <= lowerLimit || root.data >= upperLimit) {
            return false;
        }
        return isBST(root.left, lowerLimit, root.data) && isBST(root.right, root.data, upperLimit);
    }

    class Node {
        int data;
        Node left;
        Node right;
    }
}