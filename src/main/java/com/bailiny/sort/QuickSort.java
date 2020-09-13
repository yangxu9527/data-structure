package com.bailiny.sort;

/**
 * 快速排序
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {5, 3, 6, 2, 1, 7, 6, 1};
        quickSort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static int partition(int[] arr, int start, int end) {
        int num = arr[start];
        int left = start;
        int right = end;
        while (left < right) {
            // 在左侧找比基数大的，右边找比基数小的
            while (left < end && arr[left] <= num) {
                left++;
            }
            while (right > start && arr[right] > num) {
                right--;
            }
            if (left < right) {
                swap(arr, left, right);
            }
        }
        swap(arr, start, right);
        return right;
    }

    public static void quickSort(int[] arr, int start, int end) {
        int partition = partition(arr, start, end);
        if (end - start <= 1) {
            return;
        }
        if (start < partition - 1) {
            quickSort(arr, start, partition - 1);
        }
        if (partition + 1 < end) {
            quickSort(arr, partition + 1, end);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
