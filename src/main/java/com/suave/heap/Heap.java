package com.suave.heap;

/**
 * @author shunxin.jin
 * @date 2022/6/23 16:08
 */

public class Heap<T extends Comparable<T>> {
    /**
     * 堆中的元素
     */
    private T[] items;
    /**
     * 堆中元素的个数
     */
    private int n;

    public Heap(int capacity) {
        this.items = (T[]) new Comparable[capacity + 1];
        this.n = 0;
    }

    /**
     * 判断i索引处的元素是否小于j索引处的元素
     *
     * @param i -
     * @param j -
     * @return -
     */
    public boolean less(int i, int j) {
        return items[i].compareTo(items[j]) < 0;
    }

    /**
     * 交换i索引处的元素和j索引处的元素
     *
     * @param i -
     * @param j -
     * @return -
     */
    public void exch(int i, int j) {
        T temp = items[i];
        items[i] = items[j];
        items[j] = temp;
    }

    /**
     * 向堆中插入元素
     *
     * @param item -
     * @return -
     */
    public void insert(T item) {
        items[++n] = item;
        swim(n);
    }

    /**
     * 使k处的元素上浮到一个合适的位置
     *
     * @param k -
     */
    private void swim(int k) {
        while (k > 1) {
            // 比较当前节点和其父节点
            if (less(k / 2, k)) {
                // 如果父节点值小于当前节点值,则交换
                exch(k / 2, k);
            }
            k /= 2;
        }
    }

    /**
     * 删除堆中的最大元素并返回该元素
     *
     * @return -
     */
    public T delMax() {
        T max = items[1];
        // 将堆尾部的节点与头结点交换
        exch(1, n);
        // 删除最大索引处的元素
        items[n] = null;
        // 元素个数减一
        n--;
        // 通过下沉调整,让堆有序
        sink(1);
        return max;
    }

    private void sink(int k) {
        while (k * 2 <= n) {
            // 先取出当前节点子节点中大的那个
            int max;
            if (k * 2 + 1 <= n) {
                if (less(k * 2, k * 2 + 1)) {
                    max = k * 2 + 1;
                } else {
                    max = k * 2;
                }
            } else {
                max = k * 2;
            }
            // 如果父节点比大的那个子节点大,就跳出循环
            if (less(max, k)) {
                break;
            }
            // 否则交换位置
            exch(k, max);
            k = max;
        }
    }
}
