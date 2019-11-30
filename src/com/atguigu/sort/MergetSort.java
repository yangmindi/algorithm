package com.atguigu.sort;

import java.util.Arrays;

public class MergetSort {
    public static void main(String[] args) {
        int[] arr = {8, 4, 5, 7, 1, 3, 6, 2};
        int[] temp = new int[arr.length];
        mergetSort(arr, 0, arr.length - 1, temp);
        System.out.println(Arrays.toString(arr));
    }

    //拆分
    /*public static void mergetSort(int[] arr, int left, int right, int[] temp) {
        int i = left;
        int j = right;
        int mid = (left + right) / 2;
        if (left < right) {
            mergetSort(arr, left, mid, temp);
            mergetSort(arr, mid + 1, right, temp);
            mergetsort01(arr, left, mid, right, temp);
        }
    }*/

    public static void mergetSort(int[] arr, int left, int right, int[] temp) {
        int mid = (left + right) / 2;
        if (left < right) {
            mergetSort(arr, left, mid, temp);
            mergetSort(arr, mid + 1, right, temp);
            mergetsort01(arr, left, mid, right, temp);
        }
    }

    //合并
    /*public static void mergetsort(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid + 1;
        int t = 0;
        //排序直到其中一边的数组为空
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[t] = arr[i];
                i++;
                t++;
            } else {
                temp[t] = arr[j];
                t++;
                j++;
            }
        }

        //如果左面数组不为空
        while (i <= mid) {
            temp[t] = arr[i];
            t++;
            i++;
        }

        //如果右面不为空
        while (j <= right) {
            temp[t] = arr[j];
            t++;
            j++;
        }

        //把排序好的数组移回原来的数组中
        t = 0;
        int pleft = left;
        while (pleft <= right) {
            arr[pleft] = temp[t];
            t++;
            pleft++;
        }
    }*/

    public static void mergetsort01(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid + 1;
        int index = 0;
        while (i <= mid && j <= right) {
            if (arr[i] < arr[j]) {
                temp[index++] = arr[i++];
            } else {
                temp[index++] = arr[j++];
            }
        }

        while (i <= mid) {
            temp[index++] = arr[i++];
        }

        while (j <= right) {
            temp[index++] = arr[j++];
        }

        index = 0;
        while (left <= right) {
            arr[left++] = temp[index++];
        }
    }
}
