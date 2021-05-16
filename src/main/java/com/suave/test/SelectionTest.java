package com.suave.test;

import com.suave.sort.Selection;

import java.util.Arrays;

/**
 * @author shunxin.jin
 * @date 2021/5/16 4:17 下午
 */
public class SelectionTest {

    public static void main(String[] args) {
        Integer[] arr = {4,1,7,2,65,8};
        Selection.sort(arr);
        System.out.println("Arrays.toString(arr) = " + Arrays.toString(arr));
    }

}
