package com.bailiny.queue;

import java.util.Scanner;

/**
 * @author Yang Xu
 * @date 2020/8/26 8:37
 * @description:
 */
public class ArrayQueueMain {

    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(5);
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.println("s(show): 显示队列");
            System.out.println("e(exit): 退出程序");
            System.out.println("p(push): 添加数据到队列");
            System.out.println("g(pop): 从队列取数据");
            System.out.println("h(head): 查看队列头的数据");
            key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    queue.showQueue();
                    break;
                case 'e':
                    System.out.println("退出...");
                    loop = false;
                    break;
                case 'p':
                    System.out.println("输入一个数");
                    int value = scanner.nextInt();
                    try {
                        queue.push(value);
                    } catch (Exception e) {
                        System.out.println("队列已满...");
                    }
                    break;
                case 'g':
                    int v = 0;
                    try {
                        v = queue.pop();
                    } catch (Exception e) {
                        System.out.println("队列为空...");
                    }
                    System.out.println("取出的数据为：" + v);
                    break;
                case 'h':
                    int front = queue.showFront();
                    System.out.println("队列头的数据：" + front);
                    break;
            }
        }
    }

}
