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
        this.items = (T[]) new Object[capacity];
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
     * @param k -
     */
    private void swim(int k){

    }
}
