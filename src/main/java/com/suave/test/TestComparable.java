package com.suave.test;

import com.suave.sort.Student;

/**
 * @author shunxin.jin
 * @date 2021/5/14 4:14 下午
 */
@SuppressWarnings("all")
public class TestComparable {

    public static void main(String[] args) {
        Student s1 = new Student();
        s1.setUsername("张三");
        s1.setAge(18);
        Student s2 = new Student();
        s2.setUsername("李四");
        s2.setAge(20);
        System.out.println("getMax(s1,s2) = " + getMax(s1, s2));
    }

    public static Comparable getMax(Comparable c1, Comparable c2) {
        // result > 0 c1大
        // result < 0 c2大
        // result = 0 一样大
        int result = c1.compareTo(c2);
        if (result >= 0) {
            return c1;
        }
        return c2;
    }
}
