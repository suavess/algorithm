package com.suave.test;

import com.suave.liner.SequenceList;

/**
 * @author shunxin.jin
 * @date 2021/6/18 9:28 下午
 */
public class SequenceListTest2 {
    public static void main(String[] args) {
        SequenceList<String> sequenceList = new SequenceList<>(3);
        sequenceList.insert("张三");
        sequenceList.insert("李四");
        sequenceList.insert("王五");
        sequenceList.insert("赵六");
    }
}
