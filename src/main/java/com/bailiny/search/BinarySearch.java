package com.bailiny.search;

import java.util.ArrayList;

/**
 * @author Yang Xu
 * @date 2020/9/30 10:05
 * @description: 二分查找
 */
public class BinarySearch {


    public static void main(String[] args) {
        int[] arr = {1, 1, 2};
        System.out.println(binarySearch2(arr, 0, arr.length - 1, 1));
    }

    /**
     * @param arr     数组
     * @param left    左边的索引
     * @param right   右边的索引
     * @param findVal 要查找的值，找不到为-1
     * @return
     */
    public static int binarySearch(int[] arr, int left, int right, int findVal) {
        if (left > right) {
            return -1;
        }

        int mid = (left + right) / 2;
        int midVal = arr[mid];
        if (findVal > midVal) {
            // 向右递归
            return binarySearch(arr, mid + 1, right, findVal);
        } else if (findVal < midVal) {
            return binarySearch(arr, left, mid - 1, findVal);
        } else {
            return mid;
        }
    }

    /**
     * 当有多个相同的数值时，将所有的值都查找到
     *
     * @param arr
     * @param left
     * @param right
     * @param findVal
     * @return
     */
    public static ArrayList<Integer> binarySearch2(int[] arr, int left, int right, int findVal) {
        if (left > right) {
            return null;
        }

        int mid = (left + right) / 2;
        int midVal = arr[mid];
        if (findVal > midVal) {
            // 向右递归
            return binarySearch2(arr, mid + 1, right, findVal);
        } else if (findVal < midVal) {
            return binarySearch2(arr, left, mid - 1, findVal);
        } else {
            // 找到mid索引时，向左边和右边寻找，加入到arrayList
            ArrayList resIndexList = new ArrayList<Integer>();
            resIndexList.add(mid);
            int temp = mid - 1;
            while (true) {
                if (temp < 0 || arr[temp] != findVal) {
                    break;
                }
                resIndexList.add(temp);
                temp -= 1;
            }
            temp = mid + 1;
            while (true) {
                if (temp >= arr.length || arr[temp] != findVal) {
                    break;
                }
                resIndexList.add(temp);
                temp += 1;
            }
            return resIndexList;
        }
    }
}
