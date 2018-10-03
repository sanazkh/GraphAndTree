package com.sjsu.sanaz;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by sanazk on 9/30/18.
 */
public class LevelOrderTraversal {

    List<List<Integer>> levelOrder(TreeNode root){
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null){
            return result;
        }

        Queue<TreeNode> myQ = new LinkedList<>();
        myQ.add(root);

        int qSize = 0;
        while (!myQ.isEmpty()){
            List<Integer> levelResult = new ArrayList<>();
            qSize = myQ.size();
            for(int i = 0; i < qSize; i++){
                TreeNode currentNode = myQ.remove();
                levelResult.add(currentNode.key);
                if(currentNode.left != null){
                    myQ.add(currentNode.left);
                }
                if(currentNode.right != null){
                    myQ.add(currentNode.right);
                }
            }
            result.add(levelResult);
        }
        return result;
    }

}


