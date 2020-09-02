package com.bailiny.linkedlist;

/**
 * 约瑟夫问题
 */
public class Josepfu {
    public static void main(String[] args) {
        CircleSingleLinkedList linkedList = new CircleSingleLinkedList();
        linkedList.addBoy(5);
        // 2->4->1->5->3
        linkedList.countBoy(1, 2, 5);
    }
}

class CircleSingleLinkedList {
    private Boy first = new Boy(-1);

    public void addBoy(int nums) {
        if (nums < 1) {
            System.out.println("nums数量不正确");
            return;
        }
        Boy cur = null;
        for (int i = 1; i <= nums; i++) {
            Boy boy = new Boy(i);
            if (i == 1) {
                // 构成环
                first = boy;
                first.setNext(first);
                cur = first;
            } else {
                cur.setNext(boy);
                boy.setNext(first);
                cur = cur.getNext();
            }
        }
    }

    /**
     * 约瑟夫问题的实现
     *
     * @param startNo  表示从第几个小孩开始数数
     * @param countNum 表示数几下
     * @param nums     表示最初有多少小孩在圈中
     */
    public void countBoy(int startNo, int countNum, int nums) {
        if (first == null || startNo < 1 || startNo > nums) {
            System.out.println("参数输入有误！");
            return;
        }

        Boy helper = first;
        // 辅助指针变量应该指向环形链表二点最后一个节点
        while (helper.getNext() != first) {
            helper = helper.getNext();
        }

        // 1.报数前先让first和helper移动k-1次
        for (int i = 1; i < startNo; i++) {
            first = first.getNext();
            helper = helper.getNext();
        }
        // 2.开始报数，first移动k-1时，出圈：
        while (first != null) {
            for (int i = 0; i < countNum; i++) {
                if (i == countNum - 1) {
                    // 找到要出圈的小孩
                    System.out.println(first.getNo() + "号出圈！");
                    if (first.getNext() == first) {
                        // 最后一个直接出圈
                        first = null;
                        break;
                    }
                    helper.setNext(first.getNext());
                    first = first.getNext();
                } else {
                    first = first.getNext();
                    helper = helper.getNext();
                }
            }
        }
    }
}

class Boy {
    private int no;
    private Boy next;

    public Boy(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public int getNo() {
        return no;
    }

    public void setNext(Boy next) {
        this.next = next;
    }

    public void setNo(int no) {
        this.no = no;
    }
}
