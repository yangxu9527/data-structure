package com.bailiny.sort;

/**
 * 插入排序
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] arr = {2, 1, 4, 3, 2, 99, 32, 44};
        insertSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void insertSort(int[] arr) {
        // 从左向右遍历，当前值从右向左依次和前面一个值和前前个值进行比较，如果小于前面的值则依次后移
        int insetVal;
        int insertIndex;
        for (int i = 1; i < arr.length; i++) {
            // 1.定义待插入的值和索引
            insetVal = arr[i];
            insertIndex = i - 1;
            // 2.依次和前面的进行比较，寻找插入的位置
            while (insertIndex >= 0 && insetVal < arr[insertIndex]) {
                // 当待插入的值小于当前值时表示没有找到待插入的位置,则后移
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            // 退出循环时表示找到了位置
            arr[insertIndex + 1] = insetVal;
        }
    }

}
