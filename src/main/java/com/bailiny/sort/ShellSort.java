package com.bailiny.sort;

/**
 * 希尔排序
 * 在插入排序的基础上增加步长，在实际写的过程中可以先实现插入排序，再对算法进行改进即可。
 */
public class ShellSort {

    public static void main(String[] args) {
        int[] arr = {2, 1, 4, 3, 2, 99, 32, 44};
        shellSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void shellSort(int[] arr) {
        int gap = arr.length;
        int insetVal;
        int insertIndex;
        while (gap > 1) {
            gap = gap / 2;
            for (int k = 0; k <= gap; k++) {
                for (int i = k + 2 * gap - 1; i < arr.length; i += gap) {
                    // 1.定义待插入的值和索引
                    insetVal = arr[i];
                    insertIndex = i - gap;
                    // 2.依次和前面的进行比较，寻找插入的位置
                    while (insertIndex >= 0 && insetVal < arr[insertIndex]) {
                        // 当待插入的值小于当前值时表示没有找到待插入的位置,则后移
                        arr[insertIndex + gap] = arr[insertIndex];
                        insertIndex -= gap;
                    }
                    // 退出循环时表示找到了位置
                    arr[insertIndex + gap] = insetVal;
                }
            }
        }
    }

}
