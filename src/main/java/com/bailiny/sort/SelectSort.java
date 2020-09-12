package com.bailiny.sort;

/**
 * 选择排序
 */
public class SelectSort {

    public static void main(String[] args) {
        int[] arr = {2, 1, 4, 3, 2, 99, 32, 44};
        selectSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void selectSort(int[] arr) {
        // 从左向右遍历，如果发现最小的值则与遍历的当前值进行交换
        int min;
        int minIndex;
        for (int i = 0; i < arr.length; i++) {
            min = arr[i];
            minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
        }
    }

}
