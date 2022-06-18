package com.suave.tree;

/**
 * @author suave
 * @date 2022-06-18 16:59
 */
public class TreeNode<Key, Value> {
    /**
     * 存储数据
     */
    Key key;

    Value value;
    /**
     * 左节点
     */
    TreeNode<Key, Value> left;

    /**
     * 右节点
     */
    TreeNode<Key, Value> right;

    /**
     * Node的构造方法
     *
     * @param key   -
     * @param value -
     */
    public TreeNode(Key key, Value value, TreeNode<Key, Value> left, TreeNode<Key, Value> right) {
        this.key = key;
        this.value = value;
        this.left = left;
        this.right = right;
    }
}
