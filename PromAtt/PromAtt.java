package org.example;

import java.util.Scanner;

class Node {
    int data;
    Node left, right;
    boolean isRed;

    Node(int data) {
        this.data = data;
        this.left = this.right = null;
        this.isRed = true; 
    }
}

class RedBlackTree {
    private Node root;

    public RedBlackTree() {
        root = null;
    }

    public void insert(int data) {
        root = insert(root, data);
        root.isRed = false;
    }

    private Node insert(Node node, int data) {
        if (node == null) {
            return new Node(data);
        }

        if (data < node.data) {
            node.left = insert(node.left, data);
        } else {
            node.right = insert(node.right, data);
        }

        // Балансировка
        if (isRed(node.right) && !isRed(node.left)) {
            node = rotateLeft(node);
        }
        if (isRed(node.left) && isRed(node.left.left)) {
            node = rotateRight(node);
        }
        if (isRed(node.left) && isRed(node.right)) {
            flipColors(node);
        }

        return node;
    }

    private boolean isRed(Node node) {
        return node != null && node.isRed;
    }

    private Node rotateLeft(Node node) {
        Node x = node.right;
        node.right = x.left;
        x.left = node;
        x.isRed = node.isRed;
        node.isRed = true;
        return x;
    }

    private Node rotateRight(Node node) {
        Node x = node.left;
        node.left = x.right;
        x.right = node;
        x.isRed = node.isRed;
        node.isRed = true;
        return x;
    }

    private void flipColors(Node node) {
        node.isRed = !node.isRed;
        if (node.left != null) node.left.isRed = false;
        if (node.right != null) node.right.isRed = false;
    }

    public void displayTree() {
        displayTree(root, "", true);
    }

    private void displayTree(Node node, String prefix, boolean isTail) {
        if (node != null) {
            System.out.println(prefix + (isTail ? "└── " : "├── ") + (node.isRed ? "RED" : "BLACK") + ": " + node.data);
            displayTree(node.left, prefix + (isTail ? "    " : "│   "), false);
            displayTree(node.right, prefix + (isTail ? "    " : "│   "), true);
        }
    }

    public void userInteraction() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите числа для добавления в красно-чёрное дерево (введите 'exit' для выхода):");
        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("exit")) {
                break;
            }
            try {
                int data = Integer.parseInt(input);
                insert(data);
                System.out.println("Число " + data + " добавлено.");
                displayTree(); // Отображение дерева после добавления
            } catch (NumberFormatException e) {
                System.out.println("Пожалуйста, введите корректное число.");
            }
        }
        scanner.close();
    }

    public static void main(String[] args) {
        RedBlackTree tree = new RedBlackTree();
        tree.userInteraction();
    }
}
