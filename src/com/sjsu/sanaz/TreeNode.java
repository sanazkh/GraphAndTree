package com.sjsu.sanaz;

/**
 * Created by sanazk on 6/24/18.
 */
public class TreeNode {
    int key;
    TreeNode root;
    TreeNode right;
    TreeNode left;

    public TreeNode(int item){
        key = item;
        right = left = null;
    }

    public TreeNode(TreeNode n, int left, int right){
        root = n;
        this.right.key = right;
        this.left.key = left;
    }
}
