package com.suave.tree;

/**
 * 循环查找实现的二叉树
 *
 * @author suave
 * @date 2022-06-18 16:21
 */
public class BinaryTree<Key extends Comparable<Key>, Value> {
    /**
     * 根节点
     */
    private TreeNode<Key, Value> root;
    /**
     * 树中元素个数
     */
    private int n;

    /**
     * 返回树中元素个数
     *
     * @return -
     */
    public int size() {
        return n;
    }

    /**
     * 插入节点
     */
    public void put(Key key, Value value) {
        put(root, key, value);
    }

    /**
     * 向指定的树下添加节点
     *
     * @param x     指定的树节点
     * @param key   插入的节点的键
     * @param value 插入节点的值
     */
    public void put(TreeNode<Key, Value> x, Key key, Value value) {
        if (x == null) {
            n++;
            root = new TreeNode<>(key, value, null, null);
            return;
        }
        TreeNode<Key, Value> node = x;
        while (true) {
            // 当前节点
            if (node.key.compareTo(key) > 0) {
                if (node.left == null) {
                    node.left = new TreeNode<>(key, value, null, null);
                    break;
                }
                node = node.left;
            } else {
                if (node.right == null) {
                    node.right = new TreeNode<>(key, value, null, null);
                    break;
                }
                node = node.right;
            }
        }
        n++;
    }

    /**
     * 查找节点
     *
     * @param key -
     * @return -
     */
    public Value get(Key key) {
        TreeNode<Key, Value> node = root;
        while (true) {
            if (node == null) {
                return null;
            }
            if (node.key.compareTo(key) > 0) {
                node = node.left;
            } else if (node.key.compareTo(key) < 0) {
                node = node.right;
            } else {
                return node.value;
            }
        }
    }

    public void delete(Key key) {
        TreeNode<Key, Value> node = root;
        TreeNode<Key, Value> parent = null;
        // 找到要删除的节点以及其父节点
        while (true) {
            if (node == null) {
                return;
            }
            if (node.key.compareTo(key) > 0) {
                parent = node;
                node = node.left;
            } else if (node.key.compareTo(key) < 0) {
                parent = node;
                node = node.right;
            } else {
                break;
            }
        }
        if (parent == null && root.key == key) {
            // 父节点为空,且根节点的key与传进来的相等,说明需要删除根节点
            root = null;
            n--;
            return;
        }
        if (node.left == null && node.right == null) {
            // 如果要删除的节点没有子节点,直接删除
            assert parent != null;
            if (parent.left.key == node.key) {
                parent.left = null;
            } else {
                parent.right = null;
            }
            n--;
            return;
        }
        // 找右子树的最左侧节点用于替换当前节点
        TreeNode<Key, Value> replace = node.right;
        TreeNode<Key, Value> replaceParent = node;
        while (replace.left != null) {
            replaceParent = replace;
            replace = replace.left;
        }
        // 当node.right下没有节点时,replace就不为replaceParent的左子节点
        if (replaceParent.key.compareTo(replace.key) > 0) {
            replaceParent.left = null;
        } else {
            replaceParent.right = null;
        }
        replace.left = node.left;
        replace.right = node.right;
        assert parent != null;
        if (parent.key.compareTo(node.key) > 0) {
            parent.left = replace;
        } else {
            parent.right = replace;
        }
        n--;
    }

    /**
     * 找出key最小的节点
     *
     * @return 节点的值
     */
    public Value min() {
        TreeNode<Key, Value> node = root;
        while (node.left != null) {
            node = node.left;
        }
        return node.value;
    }

    /**
     * 找出key最大的节点
     *
     * @return 节点的值
     */
    public Value max() {
        TreeNode<Key, Value> node = root;
        while (node.right != null) {
            node = node.right;
        }
        return node.value;
    }
}
