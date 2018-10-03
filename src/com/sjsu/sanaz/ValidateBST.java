package com.sjsu.sanaz;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by sanazk on 9/15/18.
 */
public class ValidateBST {

    // Approach 1
    boolean isValidBST(TreeNode root){
        ArrayList<Integer> res = new ArrayList<>();

        inOrderTraversal(root, res);

        for(int i = 0; i < res.size() - 1; i++){
            // Some implementation needs >=
            if(res.get(i) > res.get(i + 1)){
                return false;
            }
        }
        return true;
    }

    void inOrderTraversal(TreeNode root, ArrayList<Integer> result){
        if(root != null){
            inOrderTraversal(root.left, result);
            result.add(root.key);
            inOrderTraversal(root.right, result);
        }
    }

    // Approach 2
    // The use of array is not necessary. we can just keep track of last element added and then compare it and return the result

    Integer lastValue = null;
    boolean isValidBstversion2(TreeNode root){
       if(root == null){
           return true;
       }
       if(!isValidBstversion2(root.left)){
           return false;
       }

       // < for some implementation
       if(lastValue != null && root.key <= lastValue){
           return false;
       }
       lastValue = root.key;
       if(!isValidBstversion2(root.right)){
           return false;
       }
       return true;
    }



    // Approach 3
    boolean isValidBSTVersion3(TreeNode root){
        return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE );
    }

    boolean helper(TreeNode root, int low, int high){

        if( root != null && root.key > low && root.key < high){
            return true;
        }
        if(root.left != null && !helper(root.left,low,root.key)){
            return false;
        }
        if(root.right != null && !helper(root.right, root.key, high)){
            return false;
        }
        return true;
    }
}
