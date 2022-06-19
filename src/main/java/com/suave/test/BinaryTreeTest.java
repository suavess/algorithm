package com.suave.test;


import com.suave.tree.BinaryTree;

/**
 * @author suave
 * @date 2022-06-18 17:00
 */
public class BinaryTreeTest {
    public static void main(String[] args) {
        BinaryTree<Integer, Integer> binaryTree = new BinaryTree<>();
        binaryTree.put(3, 3);
        binaryTree.put(1, 1);
        binaryTree.put(8, 8);
        binaryTree.put(10, 10);
        binaryTree.put(5, 5);
//        System.out.println(binaryTree.get(8));
//        System.out.println(binaryTree.size());
//        binaryTree.delete( 8);
//        System.out.println(binaryTree.get(8));
//        System.out.println(binaryTree.size());
//        System.out.println(binaryTree.min());
//        System.out.println(binaryTree.max());
        System.out.println(binaryTree.preErgodic());
    }
}
