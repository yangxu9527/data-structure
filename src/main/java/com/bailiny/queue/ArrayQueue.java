package com.bailiny.queue;

/**
 * @author Yang Xu
 * @date 2020/8/27 13:37
 * @description: 该队列的问题是不能重复使用用过的位置。针对这种情况做了调整
 */
public class ArrayQueue {
    // 最大容量
    private int maxSize;
    // 队列头
    private int front;
    // 队列尾
    private int rear;
    // 存放数据
    private int[] arr;

    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        this.front = 0;
        this.rear = 0;
        this.arr = new int[maxSize];
    }

    public boolean isFull() {
        return rear == maxSize - 1;
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public void push(int value) {
        if (isFull()) {
            throw new RuntimeException("队列已满");
        }
        arr[rear] = value;
        rear++;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("队列没有数据");
        }
        int value = arr[front];
        front++;
        return value;
    }

    /**
     * 遍历打印队列
     */
    public void showQueue() {
        for (int i = front; i <= rear; i++) {
            System.out.printf("arr[%d]=%d\t", i, arr[i]);
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
}
