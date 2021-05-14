package com.suave.sort;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author shunxin.jin
 * @date 2021/5/14 4:10 下午
 */
@Getter
@Setter
@ToString
public class Student implements Comparable<Student> {
    private String username;
    private Integer age;

    /**
     * 实现排序接口，重写排序方法
     *
     * @param o -
     * @return -
     */
    @Override
    public int compareTo(Student o) {
        return this.getAge() - o.getAge();
    }

}
