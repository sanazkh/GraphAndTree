package com.sjsu.sanaz;

/**
 * Created by sanazk on 9/30/18.
 */
public class MinimalBST {
    TreeNode createBST(int[] array){
        TreeNode root = createMinimalBST(array, 0, array.length);
        return root;
    }

    TreeNode createMinimalBST(int[] array, int low, int high){
        if(low < high){
           int middleIndex = (low + high) /2;
           TreeNode root = new TreeNode(array[middleIndex]);
           root.left = createMinimalBST(array, low, middleIndex-1);
           root.right = createMinimalBST(array, middleIndex+1, high);
           return root;
        }else{
            return null;
        }
    }
}
