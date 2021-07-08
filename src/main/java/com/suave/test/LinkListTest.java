package com.suave.test;

import com.suave.liner.LinkList;

/**
 * @author shunxin.jin
 * @date 2021/7/8 11:11 上午
 */
public class LinkListTest {
    public static void main(String[] args) {
        // 创建单向链表测试
        LinkList<String> linkList = new LinkList<>();
        linkList.insert("姚明");
        linkList.insert("科比");
        linkList.insert("麦迪");
//        linkList.insert(1, "詹姆斯");
        // Iterator遍历
        for (String s : linkList) {
            System.out.println(s);
        }
        // 测试获取
        System.out.println("index为1的元素:" + linkList.get(1));
        // 测试删除
        System.out.println("删除的元素:" + linkList.remove(0));
        // Iterator遍历
        for (String s : linkList) {
            System.out.println(s);
        }
        // 测试清空
        linkList.clear();
        System.out.println("清空后元素数量:" + linkList.length());
    }
}
