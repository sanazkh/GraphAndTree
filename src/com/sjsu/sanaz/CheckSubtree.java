package com.sjsu.sanaz;

/**
 * Created by sanazk on 9/26/18.
 */
public class CheckSubtree {

   // Solution 1 using pre-order traversal
    boolean checkSubtree(TreeNode s, TreeNode t){
        String sTree = preOrder(s, true);
        String tTree = preOrder(t, true);
        return sTree.contains(tTree);
    }


    String preOrder(TreeNode node, boolean left){
        if(node == null){
            if(left){
                return "lnull";
            }else{
                return "rnull";
            }
        }

        return "#" + node.key + " "+ preOrder(node.left, true) + " "+ preOrder(node.right, false);
    }

    // Comparing nodes

    boolean checkSubtreeV2(TreeNode s, TreeNode t){
        return traverse(s, t);
    }

    boolean equals(TreeNode s, TreeNode t){
        if(s == null && t == null){
            return true;
        }
        if(s == null || t == null){
            return false;
        }
        return s.key == t.key && equals(s.left, t.left) && equals(s.right, s.left);
    }

    public boolean traverse(TreeNode s,TreeNode t)
    {
        return  s!=null && ( equals(s,t) || traverse(s.left,t) || traverse(s.right,t));
    }
}
