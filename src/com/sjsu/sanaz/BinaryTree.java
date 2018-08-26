package com.sjsu.sanaz;

import apple.laf.JRSUIUtils;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by sanazk on 6/24/18.
 */
public class BinaryTree {

    TreeNode root;
    public BinaryTree(){
        root = null;
    }

    public BinaryTree(int key){
        root = new TreeNode(key);
    }

    public void printPostOrder(TreeNode node ){

        if(node != null){

            printInOrder(node.left);
            printInOrder(node.right);
            System.out.print(node.key + " ");
        }
    }

    public void printPreOrder(TreeNode node){
        if(node != null){
            System.out.print(node.key+ " ");
            printInOrder(node.left);
            printInOrder(node.right);
        }
    }

    public void printInOrder(TreeNode node){

        if(node != null){
            printInOrder(node.left);
            System.out.print(node.key + " ");
            printInOrder(node.right);
        }
    }

    void printPostOrder()  {
        printPostOrder(root);
    }
    void printInOrder()    {
        printInOrder(root);
    }
    void printPreOrder()   {
        printPreOrder(root);
    }


    int calcHeight(TreeNode root){
        if(root == null){
            return 0;
        }else{
            int lHeight = calcHeight(root.left);
            int rHeight = calcHeight(root.right);
            if(lHeight > rHeight){
                return lHeight+1;
            }else {
                return rHeight+1;
            }
        }
    }


    void levelOrderTraversal(){
        int height = calcHeight(root);
        for(int i = 1; i <= height; i++){
            printEachLevel(root, i);
        }
    }

    void printEachLevel(TreeNode root, int level){
        if(root == null){
            return;
        }
        if(level == 1){
            System.out.print(root.key + " ");
        }else if(level > 1){
            printEachLevel(root.left, level-1);
            printEachLevel(root.right, level-1);
        }
    }


    TreeNode invertTree(TreeNode root){
        if(root == null){
            return null;
        }

        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    public boolean isSysmmetricRec(TreeNode root){
        return isMirror(root, root);
    }

    public boolean isMirror(TreeNode leftRoot, TreeNode rightRoot){
        if(leftRoot == null && rightRoot == null){
            return true;
        }
        if(leftRoot == null || rightRoot == null){
            return false;
        }

        return (leftRoot.key == rightRoot.key) && isMirror(leftRoot.right, rightRoot.left) && isMirror(leftRoot.left, rightRoot.right);
    }


    public boolean isSysmmetricIterative(TreeNode root){
        Queue<TreeNode> tracker = new LinkedList<>();
        tracker.add(root);
        tracker.add(root);

        while ( !tracker.isEmpty()){
            TreeNode leftRoot = tracker.poll();
            TreeNode rightRoot = tracker.poll();

            if(leftRoot == null && rightRoot == null){
                continue;
            }
            if(leftRoot == null || rightRoot == null){
                return false;
            }

            if(leftRoot.key != rightRoot.key){
                return false;
            }

            tracker.add(leftRoot.left);
            tracker.add(rightRoot.right);
            tracker.add(leftRoot.right);
            tracker.add(rightRoot.left);
        }

        return true;

    }


    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        if(left == 0 || right == 0){
            return left + right + 1;
        }else{
            return Math.min(left,right) + 1;
        }

    }


    //4.5
    //O(n) time
    //O(log n) space
    public boolean isValidBST(TreeNode root){
        if(root == null){
           return true;
        }

        return helper(root, Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    boolean helper(TreeNode root, int low, int high){
        if(root.key < low || root.key > high){
            return false;
        }
        if(root.left != null && !helper(root.left, low, root.key)){
            return false;
        }
        if(root.right != null && !helper(root.right, root.key, high)){
            return false;
        }

        return true;
    }

    public void inOrderTraversalIterative(TreeNode root){
        if (root == null)
            return;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while(current != null || stack.size() > 0){
            while (current != null){
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            System.out.print(current.key + "*");
            current = current.right;
        }
    }


    // 4.2
    TreeNode createMinBST(int[] array){
        return createMINBST(array, 0, array.length-1);
    }

    TreeNode createMINBST(int[] array, int start, int end){
        if(start > end){
            return null;
        }

        int middle = (start + end)/2;
        TreeNode n = new TreeNode(array[middle]);
        n.left = createMINBST(array, start, middle-1);
        n.right = createMINBST(array, middle+1, end);
        return n;
    }


    // 4.4 Check Balanced
    int calculateHeight(TreeNode root){
        int min = Integer.MIN_VALUE;

        if(root == null){
            return -1;
        }

        int leftHeight = calculateHeight(root.left);
        if(leftHeight == min){
            return min;
        }
        int rightHeight = calculateHeight(root.right);
        if(rightHeight == min){
            return min;
        }
        int difference = Math.abs(rightHeight - leftHeight);

        if(difference > 1){
            return min;
        }else{
            return Math.max(leftHeight, rightHeight)+1;
        }
    }

    boolean isbalanced(TreeNode root){
        return calculateHeight(root) != Integer.MIN_VALUE;
    }


}
