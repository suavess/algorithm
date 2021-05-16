package com.suave.sort;

/**
 * @author shunxin.jin
 * @date 2021/5/16 4:11 下午
 */
@SuppressWarnings("all")
public class Selection {

    /**
     * 对数组中的元素进行排序
     *
     * @param a -
     */
    public static void sort(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < a.length; j++) {
                // 升序
                if (greater(a[minIndex], a[j])) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                exchange(a, minIndex, i);
            }
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
