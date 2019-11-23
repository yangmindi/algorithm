package com.atguigu.sort;

import java.util.Arrays;

public class InsertSort {
    static int[] arr = {101, 34, 119, 1, -1, 89};

    public static void main(String[] args) {
        insertSort1(arr);
    }

    public static void insertSort(int[] arr) {
        if (arr == null || arr.length <= 0) {
            return;
        }

        for (int i = 1; i < arr.length; i++) {
            int insertValue = arr[i];
            int insertIndex = i - 1;
            while (insertIndex >= 0 && insertValue < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            arr[insertIndex + 1] = insertValue;
            System.out.println("第" + i + "轮插入");
            System.out.println("插入之后的数组为：" + Arrays.toString(arr));
        }
    }


    public static void insertSort1(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int insertvalue = arr[i];
            int insertIndex = i - 1;
            while(insertIndex>=0 && insertvalue < arr[insertIndex]){
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            arr[insertIndex + 1 ] = insertvalue;
            System.out.println("第" + i + "轮插入");
            System.out.println("插入之后的数组为：" + Arrays.toString(arr));
        }
    }
}
