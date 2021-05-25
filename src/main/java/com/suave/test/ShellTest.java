package com.suave.test;

import com.suave.sort.Shell;

import java.util.Arrays;

/**
 * @author shunxin.jin
 * @date 2021/5/14 4:39 下午
 */
public class ShellTest {

    public static void main(String[] args) {
        Integer[] arr = {4,1,7,2,65,8};
        Shell.sort(arr);
        System.out.println("Arrays.toString(arr) = " + Arrays.toString(arr));
    }

}
