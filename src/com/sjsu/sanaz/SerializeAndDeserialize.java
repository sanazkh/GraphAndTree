package com.sjsu.sanaz;

import java.util.Stack;

/**
 * Created by sanazk on 8/25/18.
 */
public class SerializeAndDeserialize {

    public String serialize(TreeNode root){
        if(root == null){
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        stack.push(root);

        while (!stack.isEmpty()){
            TreeNode n = stack.pop();
            if(n != null){
                sb.append(n.key + ",");
                stack.push(n.right);
                stack.push(n.left);
            }else{
                sb.append("#,");
            }
        }
        return sb.toString().substring(0, sb.length()-1);
    }

    public TreeNode deserialize(String data){
        if(data == null){
            return null;
        }

        int[] t = {0};
        String[] s = data.split(",");
        return helper(s, t);
    }

    TreeNode helper(String[] data, int[] index){
        if(data[index[0]].equals("#")){
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(data[index[0]]));
        index[0] = index[0]+1;
        root.left = helper(data, index);
        index[0] = index[0]+1;
        root.right = helper(data, index);
        return root;
    }
}
