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
        int i = start;
        int j = end;
        if (i > j) {
            return;
        }
        boolean flag = true;
        while(i < j){
            if(a[i] > a[j]){
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                flag = !flag;
            }
            if(flag){
                i++;
            }else {
                j--;
            }
        }
        i--;
        j++;
        quicksort01(a,start,i);
        quicksort01(a,j,end);
    }
}
