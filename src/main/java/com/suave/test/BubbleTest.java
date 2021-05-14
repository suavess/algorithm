package com.suave.test;

import com.suave.sort.Bubble;

import java.util.Arrays;

/**
 * @author shunxin.jin
 * @date 2021/5/14 4:39 下午
 */
public class BubbleTest {

    public static void main(String[] args) {
        Integer[] arr = {4,1,7,2,65,8};
        Bubble.sort(arr);
        System.out.println("Arrays.toString(arr) = " + Arrays.toString(arr));
    }

}
