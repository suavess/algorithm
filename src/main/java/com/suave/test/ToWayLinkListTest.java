package com.suave.test;

import com.suave.liner.TowWayLinkList;

/**
 * @author shunxin.jin
 * @date 2021/7/11 2:17 下午
 */
public class ToWayLinkListTest {
    public static void main(String[] args) {
        // 创建双向链表测试
        TowWayLinkList<String> toWayLinkList = new TowWayLinkList<>();
        toWayLinkList.insert("姚明");
        toWayLinkList.insert("科比");
        toWayLinkList.insert("麦迪");
        toWayLinkList.insert(1, "詹姆斯");
        // Iterator遍历
        for (String s : toWayLinkList) {
            System.out.println(s);
        }
        // 测试获取
//        System.out.println("index为1的元素:" + toWayLinkList.get(1));
        // 测试删除
//        System.out.println("删除的元素:" + toWayLinkList.remove(0));
        // Iterator遍历
//        for (String s : toWayLinkList) {
//            System.out.println(s);
//        }
        // 测试清空
//        toWayLinkList.clear();
//        System.out.println("清空后元素数量:" + toWayLinkList.length());

        toWayLinkList.reverse();
        for (String s : toWayLinkList) {
            System.out.println(s);
        }
    }
}
