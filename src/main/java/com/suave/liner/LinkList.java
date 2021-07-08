package com.suave.liner;

import java.util.Iterator;

/**
 * @author shunxin.jin
 * @date 2021/7/1 3:03 下午
 */
public class LinkList<T> implements Iterable<T> {
    /**
     * 头结点
     */
    private Node head;
    /**
     * 链表长度
     */
    private int count;

    private class Node {
        /**
         * 存储数据
         */
        T item;
        /**
         * 下一个节点
         */
        Node next;

        /**
         * Node的构造方法
         *
         * @param item -
         * @param next -
         */
        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    /**
     * 链表的构造方法
     */
    public LinkList() {
        this.head = new Node(null, null);
        this.count = 0;
    }

    /**
     * 清空链表
     */
    public void clear() {
        this.head = null;
        this.count = 0;
    }

    /**
     * 链表长度
     *
     * @return -
     */
    public int length() {
        return this.count;
    }

    /**
     * 判断链表是否为空
     *
     * @return -
     */
    public boolean isEmpty() {
        return this.count == 0;
    }

    /**
     * 获取指定位置的元素
     *
     * @param index -
     * @return -
     */
    public T get(int index) {
        Node res = head;
        for (int i = 0; i <= index; i++) {
            res = res.next;
        }
        return res.item;
    }

    /**
     * 插入元素
     *
     * @param item -
     */
    public void insert(T item) {
        Node n = head;
        while (n.next != null) {
            n = n.next;
        }
        n.next = new Node(item, null);
        this.count++;
    }

    /**
     * 向指定位置插入元素
     *
     * @param item -
     */
    public void insert(int index, T item) {
        Node pre = head;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        Node current = pre.next;
        pre.next = new Node(item, current);
        count++;
    }

    /**
     * 移除并返回指定位置节点
     *
     * @param index -
     * @return -
     */
    public T remove(int index) {
        if (index == 0) {
            head = head.next;
            count--;
            return this.head.item;
        }
        Node pre = head;
        for (int i = 0; i < index - 1; i++) {
            pre = pre.next;
        }
        Node current = head.next;
        pre.next = current.next;
        count--;
        return current.item;
    }

    /**
     * 查找并返回元素索引位置
     *
     * @param item -
     * @return -
     */
    public int indexOf(T item) {
        Node pre = head;
        for (int i = 0; i < count; i++) {
            if (pre == item) {
                return i;
            }
            pre = pre.next;
        }
        return -1;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            Node n = head;

            @Override
            public boolean hasNext() {
                return n.next != null;
            }

            @Override
            public T next() {
                n = n.next;
                return n.item;
            }
        };
    }
}
