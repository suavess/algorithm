package com.suave.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 递归实现的二叉树
 *
 * @author suave
 * @date 2022-06-18 23:11
 */
public class RecursionBinaryTree<Key extends Comparable<Key>, Value> {
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
        root = put(root, key, value);
    }

    /**
     * 添加节点
     *
     * @param node  指定的树节点
     * @param key   插入的节点的键
     * @param value 插入节点的值
     * @return 返回树的根节点
     */
    private TreeNode<Key, Value> put(TreeNode<Key, Value> node, Key key, Value value) {
        if (node == null) {
            n++;
            return new TreeNode<>(key, value, null, null);
        }
        if (node.key.compareTo(key) > 0) {
            // 当前节点大于插入的节点
            node.left = put(node.left, key, value);
        } else {
            node.right = put(node.right, key, value);
        }
        return node;
    }

    /**
     * 查找节点
     *
     * @param key -
     * @return -
     */
    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(TreeNode<Key, Value> node, Key key) {
        if (node == null) {
            return null;
        }
        if (node.key.compareTo(key) > 0) {
            return get(node.left, key);
        } else if (node.key.compareTo(key) < 0) {
            return get(node.right, key);
        }
        return node.value;
    }

    public void delete(Key key) {
        delete(root, key);
    }

    private TreeNode<Key, Value> delete(TreeNode<Key, Value> node, Key key) {
        if (node == null) {
            return null;
        }
        if (node.key.compareTo(key) > 0) {
            // 继续向左查找
            node.left = delete(node.left, key);
        } else if (node.key.compareTo(key) < 0) {
            // 继续向右查找
            node.right = delete(node.right, key);
        } else {
            // 找到了要删除的节点
            n--;
            if (node.right == null) {
                // 删除的节点没有右子树,就把左子树返回,直接绑在要删除节点的父节点即可
                return node.left;
            }
            if (node.left == null) {
                // 删除的节点没有左子树,就把左子树返回,直接绑在要删除节点的父节点即可
                return node.right;
            }
            // 再去找一下右树中的最左侧节点及其父节点
            TreeNode<Key, Value> replaceParent = node.right;
            TreeNode<Key, Value> replace = node.right;
            while (replace.left != null) {
                replaceParent = replace;
                replace = replace.left;
            }
            // 删除右子树取出的最小节点,注意不能直接赋null,可能replace还有右子树
            replaceParent.left = replace.right;
            // replace节点替换到node节点的位置
            replace.left = node.left;
            if (replace != replaceParent) {
                // 当删除节点的右节点就是需要替换的节点时,不需要替换
                replace.right = node.right;
            }
            node = replace;
        }
        return node;
    }

    /**
     * 找出key最小的节点
     *
     * @return 节点的值
     */
    public Value min() {
        return root == null ? null : min(root).value;
    }

    private TreeNode<Key, Value> min(TreeNode<Key, Value> node) {
        if (node.left == null) {
            return node;
        }
        return min(node.left);
    }

    /**
     * 找出key最大的节点
     *
     * @return 节点的值
     */
    public Value max() {
        return root == null ? null : max(root).value;
    }

    private TreeNode<Key, Value> max(TreeNode<Key, Value> node) {
        if (node.right == null) {
            return node;
        }
        return max(node.right);
    }

    public List<Key> preErgodic() {
        List<Key> result = new ArrayList<>();
        preErgodic(root, result);
        return result;
    }

    private void preErgodic(TreeNode<Key, Value> node, List<Key> list) {
        if (node == null) {
            return;
        }
        list.add(node.key);
        if (node.left != null) {
            preErgodic(node.left, list);
        }
        if (node.right != null) {
            preErgodic(node.right, list);
        }
    }

    public List<Key> midErgodic() {
        List<Key> result = new ArrayList<>();
        midErgodic(root, result);
        return result;
    }

    private void midErgodic(TreeNode<Key, Value> node, List<Key> result) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            midErgodic(node.left, result);
        }
        result.add(node.key);
        if (node.right != null) {
            midErgodic(node.right, result);
        }
    }

    public List<Key> afterErgodic() {
        List<Key> result = new ArrayList<>();
        afterErgodic(root, result);
        return result;
    }

    private void afterErgodic(TreeNode<Key, Value> node, List<Key> result) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            afterErgodic(node.left, result);
        }
        if (node.right != null) {
            afterErgodic(node.right, result);
        }
        result.add(node.key);
    }

    public List<Key> layerErgodic() {
        List<List<Key>> list = new ArrayList<>();
        List<Key> result = new ArrayList<>();
        layerErgodic(root, 0, list);
        for (List<Key> keys : list) {
            result.addAll(keys);
        }
        return result;
    }

    private void layerErgodic(TreeNode<Key, Value> node, int level, List<List<Key>> list) {
        if (node == null) {
            return;
        }
        if (list.size() < level + 1) {
            List<Key> tmp = new ArrayList<>();
            tmp.add(node.key);
            list.add(tmp);
        } else {
            list.get(level).add(node.key);
        }
        if (node.left != null) {
            layerErgodic(node.left, level + 1, list);
        }
        if (node.right != null) {
            layerErgodic(node.right,level + 1, list);
        }
    }
}
