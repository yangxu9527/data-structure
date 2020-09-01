package com.bailiny.linkedlist;

/**
 * 约瑟夫问题
 */
public class Josepfu {
    public static void main(String[] args) {
        CircleSingleLinkedList linkedList =new CircleSingleLinkedList();
        linkedList.addBoy(1);
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