package com.bailiny.stack;

public class Calculator {
    public static void main(String[] args) {
        String expression = "3+2*9-6";
        char[] chars = expression.toCharArray();
        ArrayStack2 numStack = new ArrayStack2(10);
        ArrayStack2 operStack = new ArrayStack2(10);
        int num1 = 0;
        int num2 = 0;
        char oper = ' ';
        for (char aChar : chars) {
            if (operStack.isOper(aChar)) {
                // 如果是符号并且为空时直接放入
                if (operStack.isEmpty()) {
                    operStack.push(aChar);
                } else {
                    if (operStack.priority(aChar) <= operStack.priority(operStack.peek())) {
                        // 优先级小于等于栈顶的符号，则把数字栈中的数取出两个，符号栈中取出一个进行运算，并将运算后的结果放入数字栈中
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = (char) operStack.pop();
                        numStack.push(numStack.cal(num1, num2, oper));

                    } else {
                        // 直接入栈
                        operStack.push(aChar);
                    }
                }
            }
        }

        System.out.println(numStack.pop());
    }
}

class ArrayStack2 {
    private int maxSize;
    private int[] stack;
    private int top = -1;

    public ArrayStack2(int maxSize) {
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

    public int peek() {
        if (isEmpty()) {
            System.out.println("没有数据");
            return -1;
        }
        return stack[top];
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

    public int priority(int oper) {
        if (oper == '*' || oper == '/') {
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;
        } else {
            return -1;
        }
    }

    public boolean isOper(char val) {
        return val == '*' || val == '/' || val == '*' || val == '-';
    }

    public int cal(int num1, int num2, char oper) {
        switch (oper) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                return num1 / num2;
            default:
                return 0;
        }
    }
}