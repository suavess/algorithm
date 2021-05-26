package com.suave.sort;

/**
 * 归并排序
 *
 * @author shunxin.jin
 * @date 2021/5/25 2:53 下午
 */
@SuppressWarnings("all")
public class Merge {

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
        int mid = (lo + hi) / 2;
        sort(a, lo, mid);
        sort(a, mid + 1, hi);
        merge(a, lo, mid, hi);
    }

    private static void merge(Comparable[] a, int lo, int mid, int hi) {
        // 定义指针
        int p1 = lo, p2 = mid + 1, i = lo;
        // 指针移动
        while (p1 <= mid && p2 <= hi) {
            if (greater(a[p1], a[p2])) {
                assist[i++] = a[p2++];
            } else {
                assist[i++] = a[p1++];
            }
        }
        // 某一指针先到头
        while (p1 <= mid) {
            assist[i++] = a[p1++];
        }
        while (p2 <= hi) {
            assist[i++] = a[p2++];
        }
        // 把归并好的临时数组复制到原始数组中
        for (int j = lo; j <= hi; j++) {
            a[j] = assist[j];
        }
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
