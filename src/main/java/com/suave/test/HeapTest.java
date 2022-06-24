package com.suave.test;

import com.suave.heap.Heap;

/**
 * @author shunxin.jin
 * @date 2022/6/24 11:07
 */
public class HeapTest {
    public static void main(String[] args) {
        Heap<Integer> heap = new Heap<>(10);
        heap.insert(5);
        heap.insert(2);
        heap.insert(8);
        heap.insert(1);
        heap.insert(3);
        heap.insert(7);
        heap.insert(6);
        Integer result;
        while ((result = heap.delMax()) != null) {
            System.out.println(result);
        }
    }
}
