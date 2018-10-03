package com.sjsu.sanaz;

/**
 * Created by sanazk on 8/26/18.
 */
public class isSameTree {

   // 4.10

    // Space O(log n + log m)
    // time O(nm)
    boolean containtsTree(TreeNode t1, TreeNode t2){
        if(t2 == null){
            return true;
        }
        return sameSubTree(t1, t2);
    }

    boolean sameSubTree(TreeNode t1, TreeNode t2){
        if(t1 == null){
            return false;
        }else if(t1.key == t2.key && match(t1, t2)){
            return true;
        }
        return sameSubTree(t1.left, t2) || sameSubTree(t1.left, t2);
    }

    boolean match(TreeNode t1, TreeNode t2){
        if(t1 == null || t2 == null){
            return false;
        }else if(t1 == null && t2 == null){
            return true;
        }else if(t1.key != t2.key){
            return false;
        }else{
            return match(t1.left, t2.left) && match(t1.right, t2.right);
        }
    }

    // Second method
    // O(n+m) space and O(m + n) time

    boolean containsTree1(TreeNode t1, TreeNode t2){
        if(t1 == null || t2 == null){
            return false;
        }
        StringBuilder string1 = new StringBuilder();
        StringBuilder string2 = new StringBuilder();

        getOrderString(t1, string1);
        getOrderString(t2, string2);

        return string1.indexOf(string2.toString()) != -1;
    }

    void getOrderString(TreeNode a, StringBuilder sb){
        if(a == null){
            sb.append("X");
            return;
        }
        sb.append(a.key + " ");
        getOrderString(a.left, sb);
        getOrderString(a.right, sb);
    }
}
