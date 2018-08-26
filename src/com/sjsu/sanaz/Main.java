package com.sjsu.sanaz;

public class Main {

    public static void main(String[] args) {

        BinaryTree bt = new BinaryTree();
        bt.root = new TreeNode(1);
        bt.root.left = new TreeNode(2);
        bt.root.right = new TreeNode(2);
        bt.root.right.left = new TreeNode(9);
        bt.root.right.right = new TreeNode(4);


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
        TreeNode tr = new TreeNode(bt.root, bt.root.left.key, bt.root.right.key);
        tr.root = new TreeNode(1);
        tr.root.left = new TreeNode(2);
        tr.root.right = new TreeNode(2);
        tr.root.right.left = new TreeNode(9);
        tr.root.right.right = new TreeNode(4);
        bt.isValidBST(tr);

    }
}
