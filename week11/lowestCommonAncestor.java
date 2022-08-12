import java.util.*;
import java.io.*;
import java.util.Scanner;
import java.util.Arrays;

public class lowestCommonAncestor {

    // A binary tree node
    // Node Class
    public static class Node {
        //int data;
        int key;
        Node left, right;

        public Node(int data) {
            key = data;
            left = right = null;
        }
    }

    // Root Node
    Node root;

    // Constructor for Binary Search Tree
    Solution() {
        root = null;
    }

    
    Node lca(Node node, int n1, int n2) {
        if (node == null)
            return null;

        if (node.key > n1 && node.key > n2)
            return lca(node.left, n1, n2);

        if (node.key < n1 && node.key < n2)
            return lca(node.right, n1, n2);

        return node;
    }

    void insert(int key) {
        root = insert_Recursive(root, key);
    }

    Node insert_Recursive(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }
        if (key < root.key)
            root.left = insert_Recursive(root.left, key);
        else if (key > root.key)
            root.right = insert_Recursive(root.right, key);
        return root;
    }

    public static void main(String[] args) {
        //int n1 = 4, n2 = 8;
        Scanner in = new Scanner(System.in);
        int numTests = in.nextInt();
        int num1 = in.nextInt();
        int num2 = in.nextInt();
        lowestCommonAncestor tree = new lowestCommonAncestor();
        for (int i = 0; i < numTests; ++i) {
            tree.insert(in.nextInt());
        }

        Node t = tree.lca(tree.root, num1, num2);
        System.out.println(t.key);

    }

}
