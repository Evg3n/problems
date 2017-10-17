package com.hackerrank.datastructure.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/swap-nodes-algo
 */
public class SwapNodes {
    public static void main(String[] args) {
        Scanner in = new Scanner(SwapNodes.class.getClassLoader().getResourceAsStream(
                "hackerrank/datastructure/tree/swap_nodes.txt"));
        int nodesCount = in.nextInt();

        Node root = new Node(1, 1);

        Queue<Node> nodesQueue = new LinkedList<>();
        nodesQueue.add(root);

        int treeDepth = 0;
        for (int i = 0; i < nodesCount; i++) {
            Node currentRoot = nodesQueue.poll();

            Node left = new Node(in.nextInt(), currentRoot.level + 1);
            Node right = new Node(in.nextInt(), currentRoot.level + 1);
            if (left.data != -1) {
                currentRoot.left = left;
                nodesQueue.add(left);
            }
            if (right.data != -1) {
                currentRoot.right = right;
                nodesQueue.add(right);
            }
            treeDepth = currentRoot.level;
        }

        int operationsCount = in.nextInt();

        for (int i = 0; i < operationsCount; i++) {
            int levelToSwap = in.nextInt();

            int currentLevelToSwap = levelToSwap;
            int iteration = 1;
            while (currentLevelToSwap <= treeDepth) {
                swapNodesAtLevel(root, currentLevelToSwap);

                iteration++;
                currentLevelToSwap = levelToSwap * iteration;
            }
            inOrderTraversal(root);
            System.out.println();
        }
    }

    private static void swapNodesAtLevel(Node root, int level) {
        if (root == null) {
            return;
        }
        if (root.level == level) {
            Node tempLeft = root.left;
            root.left = root.right;
            root.right = tempLeft;
            return;
        }

        swapNodesAtLevel(root.left, level);
        swapNodesAtLevel(root.right, level);
    }

    private static void inOrderTraversal(Node root) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.left);
        System.out.print(root.data + " ");
        inOrderTraversal(root.right);
    }

    static class Node {
        int data;
        int level;
        Node left;
        Node right;

        Node(int data, int level) {
            this.data = data;
            this.level = level;
        }
    }
}