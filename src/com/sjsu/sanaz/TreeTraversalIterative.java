package com.sjsu.sanaz;

import apple.laf.JRSUIUtils;

import java.util.Stack;

/**
 * Created by sanazk on 9/13/18.
 */
public class TreeTraversalIterative {

    // Pre-order Traversal
    void preOrderTraversalIterative(TreeNode root){
        Stack<TreeNode> s = new Stack<>();
        s.push(root);

        while (!s.isEmpty()){
            TreeNode currentRoot = s.pop();
            System.out.print(currentRoot.key + " ");
            if(currentRoot.right != null){
                s.push(currentRoot.right);
            }
            if(currentRoot.left != null){
                s.push(currentRoot.left);
            }
        }

    }

    // Post Order Traversal
    // Left, right, root

    // Using two stacks
    void postOrderTraversalIterative(TreeNode root){
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();

        s1.push(root);
        while (!s1.isEmpty()){
            TreeNode current = s1.pop();
            s2.push(current);
            if(current.left != null){
                s1.push(current.left);
            }
            if(current.right != null){
                s1.push(current.right);
            }
        }

        while (!s2.isEmpty()){
            System.out.print(s2.pop() + " ");
        }
    }

    // Using one stack
    void postOrderIterativeTraversal(TreeNode root){
        Stack<TreeNode> s1 = new Stack<>();
        while(!s1.isEmpty()){
            while (root != null){
                if(root.right != null){
                    s1.push(root.right);
                }
                if(root.left != null){
                    s1.push(root.left);
                }
                root = root.left;
            }
            root = s1.pop();
            if(root.right != null && root.right == s1.peek()){
                TreeNode temp = s1.pop();
                s1.push(root);
                root = temp;
            }else{
                System.out.print(root.key + " ");
                root = null;
            }
        }
    }


    // In-Order Traversal
    // Left, root, right

    void inOrderIterativeTraversal(TreeNode root){
        Stack<TreeNode> s = new Stack<>();
        TreeNode current = root;

        while (current != null || !s.isEmpty()){
            while (current != null){
                s.push(current);
                current = current.left;
            }
            current = s.pop();
            System.out.print(current.key + " ");
            current = current.right;
        }
    }


}
