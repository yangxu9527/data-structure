package com.bailiny.queue;

/**
 * 1.front变量的含义调整：front指向队列的第一个元素，也就是说arr[front]就是队列的第一个元素。初始值为0.
 * 2.rear变量的含义调整：rear指向队列的最后一个元素的后一个位置，因为希望空出一个空间作为约定。rear的初始值为0.
 * 3.当队列满时，条件是(rear+1)%maxSize=front.
 * 4.队列为空的条件，rear==front。
 * 5.队列中有效的数据的个数(rear+maxSize-front)%maxSize
 *
 * @author Yang Xu
 * @date 2020/8/27 13:37
 * @description: 调整后的队列-环形队列
 */
public class CircleArrayQueue {

    // 最大容量
    private int maxSize;
    // 队列头
    private int front;
    // 队列尾
    private int rear;
    // 存放数据
    private int[] arr;

    public CircleArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        this.front = 0;
        this.rear = 0;
        this.arr = new int[maxSize];
    }

    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public void push(int value) {
        if (isFull()) {
            throw new RuntimeException("队列已满");
        }
        arr[rear] = value;
        // 将rear往后取，但这里必须考虑取模
        rear = (rear + 1) % maxSize;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("队列没有数据");
        }
        // 这里需要分析出front是指向队列的第一个元素
        // 1.先把front对应的值保存到一个临时变量
        // 2.将front后移，考虑取模
        // 3.将临时变量返回
        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;
    }

    /**
     * 遍历打印队列
     */
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列没有数据~~");
            return;
        }
        // 思路：从front开始遍历，遍历多少个元素
        for (int i = front; i <= front + size(); i++) {
            System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
        }
    }

    /**
     * 显示头部数据
     *
     * @return
     */
    public int showFront() {
        return arr[front];
    }

    // 求出当前队列的有效数据的个数
    public int size() {
        return (rear + maxSize - front) % maxSize;
    }
}
