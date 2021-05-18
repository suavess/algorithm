package com.suave.test;

import com.suave.sort.Insertion;

import java.util.Arrays;

/**
 * @author shunxin.jin
 * @date 2021/5/18 2:39 下午
 */
public class InsertionTest {
    public static void main(String[] args) {
        Integer[] arr = {4, 1, 7, 2, 65, 8};
        Insertion.sort(arr);
        System.out.println("Arrays.toString(arr) = " + Arrays.toString(arr));
    }
}
