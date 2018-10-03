package com.sjsu.sanaz;

import java.util.Random;

/**
 * Created by sanazk on 10/2/18.
 */
public class GetRandomNode {
    class TreeNode{
        private int size = 0;
        private int data;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int d){
            data = d;
            size = 1;
        }

        public int size(){
            return size;
        }

        public int data(){
            return data;
        }

        public void insert(int d){
            if(d <= data){
                if(left == null){
                    left = new TreeNode(d);
                }else{
                    left.insert(d);
                }
            }else if(d > data){
                if(right == null){
                    right = new TreeNode(d);
                }else{
                    right.insert(d);
                }
            }
            size++;
        }

        public TreeNode find(int d){
            if(d == data){
                return this;
            }else if(d < data){
                if(left != null){
                    return left.find(d);
                }else{
                    return null;
                }
            }else if(d > data){
                if(right != null){
                    return right.find(d);
                }else{
                    return null;
                }
            }
            return null;
        }

        public TreeNode getRandom(){
            int leftSize = 0;
            if(left != null){
                leftSize = left.size();
            }
            Random r = new Random();
            int index = r.nextInt(size);

            if(index < leftSize){
                return left.getRandom();
            }else if(index > leftSize){
                return right.getRandom();
            }else{
                return this;
            }

        }
    }
}
