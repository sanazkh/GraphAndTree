package com.sjsu.sanaz;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created by sanazk on 9/27/18.
 */
public class PathWithSum {

    // Question 4.12 of Chapter 4
    // O(n log n) for a balanced tree

    // Count the number of paths equals a target value. Not neccesarily started from root

    int numberOfPathWithSum(TreeNode root, int targetSum){
        if(root == null){
            return 0;
        }
        int pathFromRoot = pathFromNode(root, targetSum, 0);

        int pathFromLeft = numberOfPathWithSum(root.left, targetSum);
        int pathFromRight = numberOfPathWithSum(root.right, targetSum);

        return pathFromLeft + pathFromRight + pathFromRoot;

    }

    int pathFromNode(TreeNode node, int targetSum, int runningSum){
        if(node == null){
            return 0;
        }

        runningSum += node.key;
        int totalPath = 0;
        if(runningSum == targetSum){
            totalPath++;
        }

        totalPath += pathFromNode(node.left, targetSum, runningSum);
        totalPath += pathFromNode(node.right, targetSum, runningSum);
        return totalPath;

    }

    // Second version
    int numberOfPath(TreeNode root, int targetSum){
        if(root == null){
            return 0;
        }
        return numberOfPathFromNode(root, targetSum) + numberOfPath(root.left, targetSum) + numberOfPath(root.right, targetSum);
    }

    int numberOfPathFromNode(TreeNode node, int targetSum){
        if(node == null){
            return 0;
        }

        return (node.key == targetSum ? 1 : 0) + numberOfPathFromNode(node.left, targetSum - node.key) +
                numberOfPathFromNode(node.right, targetSum - node.key);
    }


    /* Given a binary tree and a sum, determine if the tree has a root-to-leaf path
    such that adding up all the values along the path equals the given sum. */

    boolean hasPath(TreeNode root, int targetSum){
        if(root == null){
            return false;
        }
        if(targetSum - root.key == 0 && root.left == null && root.right == null){
            return true;
        }

        return hasPath(root.left, targetSum - root.key) || hasPath(root.right, targetSum - root.key);
    }

    /*
    Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
     */
    public List<List<Integer>> pathSum(TreeNode root, int sum){
        List<List<Integer>> result  = new LinkedList<List<Integer>>();
        List<Integer> currentResult  = new LinkedList<Integer>();
        pathSum(root,sum,currentResult,result);
        return result;
    }

    public void pathSum(TreeNode root, int sum, List<Integer> currentResult, List<List<Integer>> result) {

        if (root == null)
            return;

        currentResult.add(root.key);

        if (root.left == null && root.right == null && sum == root.key) {
            result.add(new LinkedList(currentResult));
            currentResult.remove(currentResult.size() - 1);//don't forget to remove the last integer
            return;
        } else {
            pathSum(root.left, sum - root.key, currentResult, result);
            pathSum(root.right, sum - root.key, currentResult, result);
        }
        currentResult.remove(currentResult.size() - 1);
    }


}


