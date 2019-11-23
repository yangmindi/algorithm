package com.atguigu.sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {-9, 79, 0, 23, -567, 70, -1, 900, 4561};
        quicksort01(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quicksort(int[] a, int start, int end) {
        int i = start;
        int j = end;
        if (i > j) {
            return;
        }
        boolean flag = true;
        while (i < j) {
            if (a[i] > a[j]) {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                flag = !flag;
            }
            if (flag == true) {
                j--;
            } else {
                i++;
            }
        }
        i--;
        j++;
        quicksort(a, start, i);
        quicksort(a, j, end);
    }

    public static void quicksort01(int[] a, int start, int end) {
        int left = start;
        int right = end;
        boolean flag = true;
        if (left > right) {
            return;
        }
        while (left < right) {
            if (a[left] > a[right]) {
                int temp = a[left];
                a[left] = a[right];
                a[right] = temp;
                flag = !flag;
            }
            if(flag){
                right--;
            }else {
                left++;
            }
        }
        left--;
        right++;
        quicksort01(a,start,left);
        quicksort01(a,right,end);
    }
}
