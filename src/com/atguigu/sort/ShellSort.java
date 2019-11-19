package com.atguigu.sort;

import java.util.Arrays;

public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        shellSort1(arr);
    }

    public static void shellSort(int[] arr) {
        int temp;
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                for (int j = i - gap; j >= 0; j -= gap) {
                    if (arr[j] > arr[j + gap]) {
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
            System.out.println(Arrays.toString(arr));
        }
    }

    //int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
    public static void shellSort1(int[] arr) {
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                int insertvalue = arr[i];
                int insertIndex = i - gap;
                while (insertIndex >= 0 && insertvalue < arr[insertIndex]) {
                    arr[insertIndex + gap] = arr[insertIndex];
                    insertIndex -= gap;
                }
                arr[insertIndex + gap] = insertvalue;
                System.out.println("第"+i+"轮插入");
                System.out.println("插入之后的数组为："+ Arrays.toString(arr));
            }
        }
    }
}
