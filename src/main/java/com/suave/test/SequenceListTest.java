package com.suave.test;

import com.suave.liner.SequenceList;

/**
 * @author shunxin.jin
 * @date 2021/6/18 8:48 下午
 */
public class SequenceListTest {
    public static void main(String[] args) {
        SequenceList<String> sequenceList = new SequenceList<>(10);
        // 测试插入
        sequenceList.insert("姚明");
        sequenceList.insert("科比");
        sequenceList.insert("麦迪");
        sequenceList.insert(1, "詹姆斯");
        // Iterator遍历
        for (String s : sequenceList) {
            System.out.println(s);
        }
        // 测试获取
        System.out.println("index为1的元素:" + sequenceList.get(1));
        // 测试删除
        System.out.println("删除的元素:" + sequenceList.remove(0));
        // 测试清空
        sequenceList.clear();
        System.out.println("清空后元素数量:" + sequenceList.length());

    }
}
