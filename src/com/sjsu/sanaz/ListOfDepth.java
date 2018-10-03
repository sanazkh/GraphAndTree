package com.sjsu.sanaz;

import apple.laf.JRSUIUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by sanazk on 8/26/18.
 */
public class ListOfDepth {

    // Modifying DFS

    ArrayList<LinkedList<TreeNode>> listOfDepth(TreeNode root){
        ArrayList<LinkedList<TreeNode>> lists = new ArrayList<LinkedList<TreeNode>>();
        createLinkedList(root, lists, 0);
        return lists;
    }

    void createLinkedList(TreeNode root, ArrayList<LinkedList<TreeNode>> lists, int level){
        if(root == null){
            return;
        }

        LinkedList<TreeNode> list = null;
        if(lists.size() == level){
            list = new LinkedList<>();
            lists.add(list);
        }else{
            list = lists.get(level);
        }

        list.add(root);
        createLinkedList(root.left, lists, level+1);
        createLinkedList(root.right, lists, level+1);
    }

    // Modifying BFS

    ArrayList<LinkedList<TreeNode>> createLinkedListLevel(TreeNode root){
        ArrayList<LinkedList<TreeNode>> result = new ArrayList<>();
        LinkedList<TreeNode> current = new LinkedList<>();
        if(root != null){
            current.add(root);
        }

        while (current.size() > 0){
            result.add(current);
            LinkedList<TreeNode> parents = current;
            current = new LinkedList<>();
            for(TreeNode parent : parents){
                if(parent.left != null){
                    current.add(parent.left);
                }
                if(parent.right != null){
                    current.add(parent.right);
                }
            }
        }
        return result;
    }

}
