package com.suave.liner;

import java.util.Iterator;

/**
 * @author shunxin.jin
 * @date 2021/7/9 9:48 上午
 */
public class TowWayLinkList<T> implements Iterable<T> {
    /**
     * 头结点
     */
    private Node head;
    /**
     * 尾节点
     */
    private Node last;
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
         * 上一个节点
         */
        Node pre;
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
        public Node(T item, Node pre, Node next) {
            this.item = item;
            this.pre = pre;
            this.next = next;
        }
    }

    /**
     * 链表的构造方法
     */
    public TowWayLinkList() {
        // 初始化头结点
        this.head = new Node(null, null, null);
        // 初始化尾节点
        this.last = null;
        this.count = 0;
    }

    /**
     * 清空链表
     */
    public void clear() {
        this.head.pre = null;
        this.head.next = null;
        this.head.item = null;
        this.last = null;
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
     * 获取第一个节点
     *
     * @return -
     */
    public T getFirst() {
        return isEmpty() ? null : head.next.item;
    }

    /**
     * 获取最后一个元素
     * @return -
     */
    public T getLast() {
        return isEmpty() ? null : last.item;
    }

    /**
     * 插入元素
     * @param item -
     */
    public void insert(T item) {
        if (isEmpty()) {
            last = new Node(item, head, null);
            head.next = last;
            count++;
            return;
        }
        this.last.next = new Node(item, this.last, null);
        this.last = last.next ;
        count++;
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
        Node next = pre.next;
        pre.next = new Node(item, pre, next);
        next.pre = pre.next;
        count++;
    }

    /**
     * 获取第i个位置的元素
     * @param index -
     * @return -
     */
    public T get(int index) {
        Node node = head.next;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node.item;
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

    public void reverse(){
        if (isEmpty()){
            return;
        }
        reverse(head.next);
    }

    public Node reverse(Node curr){
        if (curr.next == null){
            head.next = curr;
            return curr;
        }
        Node pre = reverse(curr.next);
        pre.next = curr;
        curr.next = null;
        return curr;
    }
}
