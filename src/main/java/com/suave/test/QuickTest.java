package com.suave.test;

import com.suave.sort.Quick;

import java.util.Arrays;

/**
 * @author shunxin.jin
 * @date 2021/5/31 8:45 下午
 */
public class QuickTest {
    public static void main(String[] args) {
        Integer[] arr = {4,1,14,55,13,51,3};
        Quick.sort(arr);
        System.out.println("Arrays.toString(arr) = " + Arrays.toString(arr));
    }
}
