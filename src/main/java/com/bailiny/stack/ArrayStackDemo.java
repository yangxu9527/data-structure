package com.bailiny.stack;

public class ArrayStackDemo {
    public static void main(String[] args) {
        ArrayStack2 stack = new ArrayStack2(5);
        stack.push(1);
        stack.push(2);
        stack.show();
        System.out.println(stack.pop());
        stack.show();
    }

}

class ArrayStack {
    private int maxSize;
    private int[] stack;
    private int top = -1;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }

    public void push(int value) {
        if (isFull()) {
            System.out.println("栈已经满了！");
            return;
        }
        stack[++top] = value;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("没有数据");
            return -1;
        }
        return stack[top--];
    }

    public void show() {
        if (isEmpty()) {
            System.out.println("没有数据");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d]=%d\n", i, stack[i]);
        }
    }
}