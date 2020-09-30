package com.bailiny.search;

/**
 * @author Yang Xu
 * @date 2020/9/30 10:05
 * @description: 插值查找算法，与二分查找的区别主要在于mid的计算公式是按照比例来计算
 */
public class InsertValueSearch {


    public static void main(String[] args) {
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        System.out.println(intsertSearch(arr, 0, arr.length - 1, 99));
    }

    /**
     * @param arr     数组
     * @param left    左边的索引
     * @param right   右边的索引
     * @param findVal 要查找的值，找不到为-1
     * @return
     */
    public static int intsertSearch(int[] arr, int left, int right, int findVal) {
        System.out.println("search ~");
        if (left > right || findVal < arr[left] || findVal > arr[right]) {
            return -1;
        }

//        int mid = (left + right) / 2;
        int mid = left + (right - left) * (findVal - arr[left]) / (arr[right] - arr[left]);

        int midVal = arr[mid];
        if (findVal > midVal) {
            // 向右递归
            return intsertSearch(arr, mid + 1, right, findVal);
        } else if (findVal < midVal) {
            return intsertSearch(arr, left, mid - 1, findVal);
        } else {
            return mid;
        }
    }
}
