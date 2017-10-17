package com.hackerrank.datastructure.trie;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/contacts
 */
public class Contacts {
    private static final String ADD_OPERATION = "add";
    private static final String FIND_OPERATION = "find";

    private static final char ZERO_CHAR = '\0';

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(Contacts.class.getClassLoader().getResourceAsStream(
                "hackerrank/datastructure/trie/contacts.txt"));
        int n = in.nextInt();

        Trie trie = new Trie();
        for (int a0 = 0; a0 < n; a0++) {
            String op = in.next();
            String contact = in.next();

            switch (op) {
                case ADD_OPERATION:
                    trie.add(contact);
                    break;
                case FIND_OPERATION:
                    System.out.println(trie.find(contact));
                    break;
            }
        }
    }

    private static class Trie {
        private HashMap<Character, Node> roots;

        Trie() {
            roots = new HashMap<>();
        }

        void add(String value) {
            char[] chars = value.toCharArray();

            Node root = roots.computeIfAbsent(chars[0], k -> new Node(chars[0]));
            addInTree(root, Arrays.copyOfRange(chars, 1, chars.length));
        }

        int find(String value) {
            char[] chars = value.toCharArray();

            if (!roots.containsKey(chars[0])) {
                return 0;
            }

            Node traverseRoot = roots.get(chars[0]);
            for (int i = 1; i < chars.length; i++) {
                Map<Character, Node> children = traverseRoot.getChildren();
                if (!children.containsKey(chars[i])) {
                    return 0;
                }
                traverseRoot = children.get(chars[i]);
            }

            return traverseRoot.getEndingsCount();
        }

        private void addInTree(Node root, char[] chars) {
            Node currentNode = root;
            for (char c : chars) {
                Map<Character, Node> children = currentNode.getChildren();
                if (!children.containsKey(c)) {
                    children.put(c, new Node(c));
                }
                currentNode.incrementEndingsCount();
                currentNode = children.get(c);
            }
            currentNode.incrementEndingsCount();
            currentNode.getChildren().put(ZERO_CHAR, new Node(ZERO_CHAR));
        }

        private class Node {
            private Character value;
            private int endingsCount;

            private Map<Character, Node> children;

            Node(Character value) {
                this.value = value;
                endingsCount = 0;
                children = new HashMap<>();
            }

            Character getValue() {
                return value;
            }

            Map<Character, Node> getChildren() {
                return children;
            }

            @Override
            public int hashCode() {
                return super.hashCode();
            }

            @Override
            public boolean equals(Object obj) {
                return value.equals(((Node) obj).getValue());
            }

            int getEndingsCount() {
                return endingsCount;
            }

            void incrementEndingsCount() {
                endingsCount++;
            }
        }
    }
}