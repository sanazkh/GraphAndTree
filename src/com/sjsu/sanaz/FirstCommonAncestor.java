package com.sjsu.sanaz;

import apple.laf.JRSUIUtils;

/**
 * Created by sanazk on 10/2/18.
 */
public class FirstCommonAncestor {
    // 4.8 with nodes to parent
    // Approach 1
  /*  TreeNode firstCommonAncestor1(TreeNode root, TreeNode p, TreeNode q){
        if(root == null || p == null || q == null){
            return null;
        }

        int pDepth = getDepth(p);
        int qDepth = getDepth(q);
        int delta = 0;

        if(pDepth > qDepth){
            delta = pDepth - qDepth;
            for(int i = 0; i < delta; i++){
                p = p.parent;
            }
        }else if(pDepth < qDepth){
            delta = qDepth - pDepth;
            for(int i = 0; i < delta; i++){
                q = q.parent;
            }
        }

        while (p != null && q!= null){
            if(p == q){
                return p;
            }
            p = p.parent;
            q = q.parent;
        }

        return null;

    }

    int getDepth(TreeNode node){
        if(node == null){
            return 0;
        }
        int depth = 0;
        while (node != null){
            node = node.parent;
            depth++;
        }
        return depth;
    } */


    // Approach 2
   /* TreeNode firstCommonAncestor2(TreeNode root, TreeNode p, TreeNode q){
        // One node is not in the tree
        if(!covers(root, p) || !covers(root, q)){
            return null;
        }else if(covers(p, q)){
            return p;
        }else if(covers(q, p)){
            return q;
        }

        TreeNode sibling = getSibling(p);
        TreeNode parent = p.parent;

        while (parent != null){
            sibling = getSibling(parent);
            parent = parent.parent;
        }

        return parent;
    }

    TreeNode getSibling(TreeNode p){
        if(p != null || p.parent == null){
            return null;
        }
        if(p.parent.left == p){
            return p.parent.right;
        }else{
            return p.parent.left;
        }
    }

    boolean covers(TreeNode root, TreeNode p){
        if(root == null){
            return false;
        }
        if(root == p){
            return true;
        }

        return covers(root.left, p) || covers(root.right, p);
    } */

   // Approach 3 - Without links to parents
    TreeNode firstCommonAncestor3(TreeNode root, TreeNode p, TreeNode q){
        if(!covers(root, p) || !covers(root, q)){
            return null;
        }
        return helper(root, p, q);
    }


    TreeNode helper(TreeNode root, TreeNode p, TreeNode q){
        if(root == null || root == p || root == q){
            return root;
        }

        boolean ispOnLeft = covers(root.left, p);
        boolean isqOnLeft = covers(root.left, q);

        if(ispOnLeft != isqOnLeft){
            return root;
        }

        TreeNode childSid = ispOnLeft ? root.left : root.right;
        return helper(childSid, p, q);
    }

    boolean covers(TreeNode root, TreeNode p){
        if(root == null){
            return false;
        }
        if(root == p){
            return true;
        }

        return covers(root.left, p) || covers(root.right, p);
    }
}
