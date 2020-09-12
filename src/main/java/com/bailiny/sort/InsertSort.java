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
        // 从左向右遍历，如果发现最小的值则与遍历的当前值进行交换

    }

}
