package com.bailiny.linkedlist;

public class DoubleLinkedListDemo {

    public static void main(String[] args) {
        HeroNode2 hero1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 hero2 = new HeroNode2(2, "卢俊义", "玉麒麟");
        HeroNode2 hero3 = new HeroNode2(3, "吴用", "吴用");
        HeroNode2 hero4 = new HeroNode2(4, "林冲", "豹子头");
        DoubleLinkedList linkedList = new DoubleLinkedList();
        linkedList.add(hero1);
        linkedList.add(hero2);
        linkedList.add(hero3);
        linkedList.add(hero4);
        System.out.println("添加后~~~");
        linkedList.list();
    }


}

/**
 * @author Yang Xu
 * @date 2020/8/30 9:00
 * @description:
 */
class DoubleLinkedList {

    /**
     * 先初始化一个头结点，头结点不要动，不存放具体的数据
     */
    private HeroNode2 head = new HeroNode2(0, "", "");

    public HeroNode2 getHead() {
        return head;
    }

    /**
     * 添加节点
     * 思路：当不考虑编号的顺序时
     * 1.找到当前链表的最后节点
     * 2.将最后这个节点的next指向新的节点
     *
     * @param heroNode
     */
    public void add(HeroNode2 heroNode) {
        HeroNode2 temp = head;
        while (true) {
            if (temp.next == null) {
                temp.next = heroNode;
                heroNode.pre = temp;
                break;
            }
            temp = temp.next;
        }
        //temp.next = heroNode;
    }

    /**
     * 第二种添加方式，按照顺序添加
     *
     * @param heroNode
     */
    public void addByOrder(HeroNode heroNode) {

    }

    /**
     * 根据英雄编号修改
     *
     * @param newHeroNode
     */
    public void update(HeroNode2 newHeroNode) {
    }

    public void delete(int no) {

    }

    /**
     * 遍历显示
     */
    public void list() {
        if (head.next == null) {
            System.out.println("链表为空");
        }
        HeroNode2 temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
            System.out.println(temp);
        }
    }
}

/**
 * @author Yang Xu
 * @date 2020/8/30 8:53
 * @description: 双向链表
 */
class HeroNode2 {

    public int no;
    public String name;
    public String nickname;
    public HeroNode2 next;
    public HeroNode2 pre;

    public HeroNode2(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
