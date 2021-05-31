package com.suave.sort;

/**
 * 快速排序
 *
 * @author shunxin.jin
 * @date 2021/5/30 3:04 下午
 */
@SuppressWarnings("all")
public class Quick {
    private static Comparable[] assist;

    /**
     * 排序
     *
     * @param a -
     */
    public static void sort(Comparable[] a) {
        assist = new Comparable[a.length];
        int lo = 0, hi = a.length - 1;
        sort(a, lo, hi);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int partition = partition(a, lo, hi);
        sort(a, lo, partition - 1);
        sort(a, partition + 1, hi);
    }

    private static int partition(Comparable[] a, int lo, int hi) {
        Comparable key = a[lo];
        int left = lo;
        int right = hi + 1;
        while (left < right) {
            while (greater(a[--right], key) && right != lo) {
            }
            while (greater(key, a[++left]) && left != hi) {
            }
            if (left >= right) {
                break;
            }
            exchange(a, left, right);
        }
        exchange(a, lo, right);
        return right;
    }

    /**
     * 判断v是否大于w
     *
     * @param v -
     * @param w -
     * @return -
     */
    private static boolean greater(Comparable v, Comparable w) {
        return v.compareTo(w) > 0;
    }

    /**
     * 交换a数组中i和j位置的元素
     *
     * @param a -
     * @param i -
     * @param j -
     */
    private static void exchange(Comparable[] a, int i, int j) {
        Comparable tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
