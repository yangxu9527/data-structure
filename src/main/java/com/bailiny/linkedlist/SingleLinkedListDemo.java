package com.bailiny.linkedlist;

public class SingleLinkedListDemo {

    public static void main(String[] args) {
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "吴用");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

        SingleLinkedList linkedList = new SingleLinkedList();
        /*linkedList.add(hero1);
        linkedList.add(hero2);
        linkedList.add(hero3);
        linkedList.add(hero4);*/

        linkedList.addByOrder(hero1);
        linkedList.addByOrder(hero4);
        linkedList.addByOrder(hero3);
        linkedList.addByOrder(hero2);
        linkedList.addByOrder(hero2);
        linkedList.list();

        HeroNode hero2update = new HeroNode(2, "小卢", "玉麒麟~~");
        linkedList.update(hero2update);
        System.out.println("修改后~~~~~");
        linkedList.list();
        /*System.out.println("删除后~~~~~");
        linkedList.delete(1);
        linkedList.delete(4);
        linkedList.list();*/
        // 测试求链表的长度
        System.out.println("单链表的长度：" + getLength(linkedList.getHead()));
        // 测试查找倒数第k的节点
        System.out.println("倒数第一个节点为：" + findLastIndexNode(linkedList.getHead(), 1));
        // 测试反转
        System.out.println("反转后~~~~~");
        reverse(linkedList.getHead());
        linkedList.list();
    }

    /**
     * 合并两个有序链表，合并后依然有序
     * @param headNode1
     * @param headNode2
     */
    public static void merge(HeroNode headNode1, HeroNode headNode2) {

    }

    /**
     * TODO 从尾到头打印链表
     * @param headNode
     */
    public static void reversePrint(HeroNode headNode) {

    }

    /**
     * 获取单链表的长度
     *
     * @param headNode
     * @return
     */
    public static int getLength(HeroNode headNode) {
        if (headNode.next == null) {
            return 0;
        }
        int len = 0;
        HeroNode temp = headNode.next;
        while (temp != null) {
            len++;
            temp = temp.next;
        }
        return len;
    }

    /**
     * 查找倒数第k个节点
     *
     * @param head
     * @param index
     * @return
     */
    public static HeroNode findLastIndexNode(HeroNode head, int index) {
        if (head.next == null) {
            return null;
        }
        int size = getLength(head);
        if (index <= 0 || index > size) {
            return null;
        }
        HeroNode cur = head.next;
        for (int i = 0; i < size - index; i++) {
            cur = cur.next;
        }
        return cur;
    }

    /**
     * 反转链表
     *
     * @param head
     */
    public static void reverse(HeroNode head) {
        if (head.next == null || head.next.next == null) {
            System.out.println("链表为空，不能反转");
            return;
        }
        HeroNode newHeroNode = new HeroNode(0, "", "");
        HeroNode temp;
        while (head.next != null) {
            temp = head.next;
            head.next = temp.next;
            temp.next = newHeroNode.next;
            newHeroNode.next = temp;
        }
        head.next = newHeroNode.next;
    }
}

/**
 * @author Yang Xu
 * @date 2020/8/30 9:00
 * @description: 定义singleLinkedList来管理英雄
 */
class SingleLinkedList {

    /**
     * 先初始化一个头结点，头结点不要动，不存放具体的数据
     */
    private HeroNode head = new HeroNode(0, "", "");

    public HeroNode getHead() {
        return head;
    }

    /**
     * 添加节点到单向链表
     * 思路：当不考虑编号的顺序时
     * 1.找到当前链表的最后节点
     * 2.将最后这个节点的next指向新的节点
     *
     * @param heroNode
     */
    public void add(HeroNode heroNode) {
        // 因为head节点不能动，因此我们需要一个辅助变量temp
        HeroNode temp = head;
        // 遍历链表，找到最后
        while (true) {
            // 找到链表的最后
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        // 当退出while循环时，temp指向链表的最后
        temp.next = heroNode;
    }

    /**
     * 第二种添加方式，按照顺序添加
     *
     * @param heroNode
     */
    public void addByOrder(HeroNode heroNode) {
        // 因为头结点不能动，因此我们仍然通过一个辅助变量（指针）来帮助找到添加的位置
        // 的temp是位于添加位置的前一个节点
        HeroNode temp = head;
        // 标志添加的编号是否存在，默认为false
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                // 说明temp已经到链表最后
                break;
            }
            if (temp.next.no > heroNode.no) {
                // 位置找到，就在temp后面插入
                break;
            } else if (temp.next.no == heroNode.no) {
                // 说明编号存在
                flag = true;
                break;
            }
            temp = temp.next;
        }
        // 判断flag的值
        if (flag) {
            // 说明编号存在
            System.out.printf("准备插入的英雄的编号%d 已经存在，不能加入\n", heroNode.no);
        } else {
            heroNode.next = temp.next;
            temp.next = heroNode;
        }


    }

    /**
     * 根据英雄编号修改
     *
     * @param newHeroNode
     */
    public void update(HeroNode newHeroNode) {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }

        HeroNode temp = head.next;
        boolean flag = false;
        while (true) {
            if (temp == null) {
                // 已经遍历完毕
                break;
            }
            if (temp.no == newHeroNode.no) {
                // 找到了
                flag = true;
                break;
            }
            temp = temp.next;
        }
        // 根据flag判断是否找到要修改的节点
        if (flag) {
            temp.nickname = newHeroNode.nickname;
            temp.name = newHeroNode.name;
        } else {
            System.out.printf("没有找到编号%d的英雄", newHeroNode.no);
        }
    }

    public void delete(int no) {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }

        HeroNode temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no == no) {
                // 找到要被删除的节点
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.next = temp.next.next;
        } else {
            System.out.println("节点不存在");
        }

    }

    /**
     * 遍历显示
     */
    public void list() {
        if (head.next == null) {
            System.out.println("链表为空");
        }
        HeroNode temp = head;
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
 * @description: 通过单链表实现水浒英雄榜
 */
class HeroNode {

    public int no;
    public String name;
    public String nickname;
    public HeroNode next;

    public HeroNode(int no, String name, String nickname) {
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
