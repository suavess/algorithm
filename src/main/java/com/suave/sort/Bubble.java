package com.suave.sort;

/**
 * @author shunxin.jin
 * @date 2021/5/14 4:28 下午
 */
@SuppressWarnings("all")
public class Bubble {

    /**
     * 对数组中的元素进行排序
     *
     * @param a -
     */
    public static void sort(Comparable[] a) {
        for (int i = a.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                // 升序
                if (greater(a[j], a[j + 1])) {
                    exchange(a, j, j + 1);
                }
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
