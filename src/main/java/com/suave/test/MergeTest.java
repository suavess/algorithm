package com.suave.test;

import com.suave.sort.Merge;

import java.util.Arrays;

/**
 * @author shunxin.jin
 * @date 2021/5/14 4:39 下午
 */
public class MergeTest {

    public static void main(String[] args) {
        Integer[] arr = {4,1,14,55,13,51,3};
        Merge.sort(arr);
        System.out.println("Arrays.toString(arr) = " + Arrays.toString(arr));
    }

}
