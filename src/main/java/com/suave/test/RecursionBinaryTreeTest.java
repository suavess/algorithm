package com.suave.test;

import com.suave.tree.RecursionBinaryTree;

/**
 * @author suave
 * @date 2022-06-18 23:20
 */
public class RecursionBinaryTreeTest {
    public static void main(String[] args) {
        RecursionBinaryTree<Integer, Integer> binaryTree = new RecursionBinaryTree<>();
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
        // 前序遍历 3 1 8 5 10
        System.out.println(binaryTree.preErgodic());
        // 中序遍历 1 3 5 8 10
        System.out.println(binaryTree.midErgodic());
        // 后序遍历 1 5 10 8 3
        System.out.println(binaryTree.afterErgodic());
    }
}
