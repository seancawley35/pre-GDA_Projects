import java.util.*;
import java.io.*;
import java.util.Scanner;
import java.util.Arrays;

public class bfs {

    public static class Node { 
        int key; 
        Node left, right; 
   
        public Node(int data){ 
            key = data; 
            left = right = null; 
        } 
    } 
    Node root; 
  
    Solution(){ 
        root = null; 
    } 
  
    void deleteKey(int key) { 
        root = delete_Recursive(root, key); 
    } 
   

    Node delete_Recursive(Node root, int key)  { 
        //tree is empty
        if (root == null)  return root; 
        if (key < root.key)     
            root.left = delete_Recursive(root.left, key); 
        else if (key > root.key)  
            root.right = delete_Recursive(root.right, key); 
        else  { 
            if (root.left == null) 
                return root.right; 
            else if (root.right == null) 
                return root.left; 
            root.key = minValue(root.right); 
            root.right = delete_Recursive(root.right, root.key); 
        } 
        return root; 
    } 
   
    int minValue(Node root)  { 
        int minval = root.key; 
        while (root.left != null)  { 
            minval = root.left.key; 
            root = root.left; 
        } 
        return minval; 
    } 
   

    void insert(int key)  { 
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

    int height(Node root)
    {
        if (root == null)
            return 0;
        else {
            int lheight = height(root.left);
            int rheight = height(root.right);
            if (lheight > rheight)
                return (lheight + 1);
            else
                return (rheight + 1);
        }
    }
 
    public void inorder() { 
        inorder_Recursive(root); 
    } 
  
    public void inorder_Recursive(Node root) { 
        if (root != null) { 
            inorder_Recursive(root.left); 
            System.out.print(root.key + " "); 
            inorder_Recursive(root.right); 
        } 
    } 
     
    boolean search(int key)  { 
        root = search_Recursive(root, key); 
        if (root!= null)
            return true;
        else
            return false;
    } 
   

    Node search_Recursive(Node root, int key)  { 
        if (root==null || root.key==key) 
            return root; 
        if (root.key > key) 
            return search_Recursive(root.left, key); 
        return search_Recursive(root.right, key); 
    } 


     void printCurrentLevel(Node root, int level)
     {
         if (root == null)
             return;
         if (level == 1)
             System.out.print(root.key + " ");
         else if (level > 1) {
             printCurrentLevel(root.left, level - 1);
             printCurrentLevel(root.right, level - 1);
         }
     }

    void printLevelOrder()
    {
        int h = height(root);
        int i;
        for (i = 1; i <= h; i++)
            printCurrentLevel(root, i);
    }




    public static void main(String[] args)  { 
        Scanner in = new Scanner(System.in);
        int numTests = in.nextInt();
        bfs tree = new bfs(); 
        for (int i = 0; i < numTests; ++i){
            tree.insert(in.nextInt());
        }
      
        tree.printLevelOrder();
        
    
     } 



}
