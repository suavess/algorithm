package com.suave.liner;

import java.util.Iterator;

/**
 * @author shunxin.jin
 * @date 2021/6/18 8:31 下午
 */
public class SequenceList<T> implements Iterable<T> {
    /**
     * 存储元素的数组
     */
    private T[] elements;
    /**
     * 顺序表中的元素个数
     */
    private int count;

    public SequenceList(int capacity) {
        this.elements = (T[]) new Object[capacity];
        this.count = 0;
    }

    public void clear() {
        this.count = 0;
    }

    public boolean isEmpty() {
        return this.count == 0;
    }

    public int length() {
        return count;
    }

    public T get(int index) {
        return elements[index];
    }

    public void insert(T t) {
        if (count == elements.length) {
            resize(count * 2);
        }
        elements[count++] = t;
    }

    public void insert(int index, T t) {
        // 先把i索引的元素及后面的元素向后移动一位
        for (int i = count; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        elements[index] = t;
        count++;
    }

    public T remove(int index) {
        T element = elements[index];
        for (int i = index; i < count - 1; i++) {
            elements[i] = elements[i + 1];
        }
        count--;
        if (count < elements.length) {
            resize(elements.length / 2);
        }
        return element;
    }

    public int indexOf(T t) {
        for (int i = 0; i < count; i++) {
            if (elements[i].equals(t)) {
                return i;
            }
        }
        return -1;
    }

    public void resize(int newSize) {
        T[] temp = elements;
        elements = (T[]) new Object[newSize];
        for (int i = 0; i < temp.length; i++) {
            elements[i] = temp[i];
        }
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an  .
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            private int cursor = 0;

            @Override
            public boolean hasNext() {
                return cursor < count;
            }

            @Override
            public T next() {
                return elements[cursor++];
            }
        };
    }

}
