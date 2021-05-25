package com.suave.sort;

/**
 * 希尔排序
 *
 * @author shunxin.jin
 * @date 2021/5/18 3:26 下午
 */
@SuppressWarnings("all")
public class Shell {

    /**
     * 对数组中的元素进行排序
     *
     * @param a -
     */
    public static void sort(Comparable[] a) {
        // 分组
        for (int step = a.length / 2; step > 0; step /= 2) {
            for (int i = step; i < a.length; i++) {
                for (int j = i - step; j >= 0; j -= step) {
                    if (greater(a[j], a[j + step])) {
                        exchange(a, j, j + step);
                    }
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
