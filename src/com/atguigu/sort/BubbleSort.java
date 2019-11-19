package com.atguigu.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class BubbleSort {
    public static void main(String[] args) {
        int arr[] = {3,9,-1,10,-2};
        bubboSort(arr);
        System.out.println("排序之后");
        System.out.println(Arrays.toString(arr));

//        int[] arr = new int[80000];
//
//        for(int i=0; i<80000; i++){
//            arr[i] = (int) (Math.random() * 80000);
//        }
//        Date date = new Date();
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String format1 = format.format(date);
//        System.out.println("排序前："+format1);
//        bubboSort(arr);
//        Date date1 = new Date();
//        SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String format3 = format2.format(date1);
//        System.out.println("排序前："+format3);

    }

    public static void bubboSort(int []arr){
//        int temp;
//        boolean flag = false;
//        for(int i=0; i<arr.length-1; i++){
//            for(int j=0; j<arr.length-1-i; j++){
//                if(arr[j]>arr[j+1]){
//                    flag = true;
//                    temp = arr[j];
//                    arr[j] = arr[j+1];
//                    arr[j+1] = temp;
//                }
//            }
//            if(!flag){
//                break;
//            }else {
//                flag = false;
//            }
//
//        }


        int temp;
        for(int i=0; i<arr.length; i++){
            boolean flag = false;
            for(int j=0; j<arr.length-i-1; j++){
                if(arr[j] > arr[j+1]){
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
            if(!flag){
                break;
            }
        }


    }
}
