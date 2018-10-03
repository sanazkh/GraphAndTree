package com.sjsu.sanaz;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        BinaryTree bt = new BinaryTree();
        bt.root = new TreeNode(1);
        bt.root.left = new TreeNode(1);
      //  bt.root.right = new TreeNode(18);

     //   bt.root.right.left = new TreeNode(14);
      //  bt.root.right.right = new TreeNode(20);
      //  bt.root.right.right.right = new TreeNode(22);
       // bt.root.right.right.left = new TreeNode(19);
       // TreeTraversalIterative tti = new TreeTraversalIterative();
       // tti.inOrderTraversalIterative(bt.root);

      //  bt.postOrderIterativeTraversal(bt.root);

      //  bt.linkedListEachLevel(bt.root);



    /*    System.out.println("In Oder");
        bt.printInOrder();
        System.out.println("Post Oder");
        bt.printPostOrder();
        System.out.println("Pre Oder");
        bt.printPreOrder();

        System.out.println("The height is " + bt.calcHeight(bt.root));
        System.out.println("The BFS is ");
        bt.levelOrderTraversal();

       // bt.invertTree(bt.root);
       // System.out.println("The inverted tree is");
      //  bt.printInOrder();

        System.out.println("***************");
        System.out.println("the tree is symmetric? "+bt.isSysmmetricRec(bt.root));

        System.out.println(bt.minDepth(bt.root)); */

      // bt.inOrderTraversalIterative(bt.root);
      /*  TreeNode tr = new TreeNode(bt.root, bt.root.left.key, bt.root.right.key);
        tr.root = new TreeNode(1);
        tr.root.left = new TreeNode(2);
        tr.root.right = new TreeNode(2);
        tr.root.right.left = new TreeNode(9);
        tr.root.right.right = new TreeNode(4);
        bt.isValidBST(tr);*/

       /* ListOfDepth ld = new ListOfDepth();
        List<LinkedList<TreeNode>> res = ld.lisOfDepth(bt.root);

        System.out.print(res.size());

    */

       ValidateBST vb = new ValidateBST();
        System.out.print(vb.isValidBST(bt.root));
        System.out.print(vb.isValidBstversion2(bt.root));
    }

}
