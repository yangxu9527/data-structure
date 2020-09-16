package com.bailiny.sort;

import java.util.Arrays;

/**
 * 归并排序
 */
public class MergeSort {

    public static void main(String[] args) {
        /*int[] arr = {2, 1, 4, 3, 2, 99, 32, 44};
        mergeSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }*/

        int[] arr1 = {1,2,3,4};
        int[] arr2 = {1,4,5,7};
        System.out.println(Arrays.toString(mergeArr(arr1, arr2)));
    }

    public static void mergeSort(int[] arr) {

    }

    /**
     * 合并两个长度相等的有序数组
     *
     * @param arr1
     * @param arr2
     */
    public static int[] mergeArr(int[] arr1, int[] arr2) {
        int indexLeft = 0;
        int indexRight = 0;
        int[] temp = new int[2 * arr1.length];
        int indexTemp = 0;
        while (indexLeft < arr1.length && indexRight < arr2.length) {
            if (arr1[indexLeft] < arr2[indexRight]) {
                temp[indexTemp] = arr1[indexLeft];
                indexLeft++;
            } else {
                temp[indexTemp] = arr2[indexRight];
                indexRight++;
            }
            indexTemp++;
        }
        // 合并剩下没有合并完的数组
        for (; indexLeft < arr1.length; indexLeft++) {
            temp[indexTemp] = arr1[indexLeft];
            indexTemp++;
        }
        for (; indexRight < arr2.length; indexRight++) {
            temp[indexTemp] = arr2[indexRight];
            indexTemp++;
        }
        return temp;
    }

}
