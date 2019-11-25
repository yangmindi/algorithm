package com.atguigu.search;

public class InsertValueSearch {
    public static void main(String[] args) {
        int[] arr = new int[100];
        for (int i = 1; i <= 100; i++) {
            arr[i-1] = i;
        }
        int i = insertValueSearch(arr, 0, arr.length - 1, 100);
        System.out.println(i);
    }

    public static int insertValueSearch(int[] arr, int left, int right, int findValue) {
        if (left > right || findValue < arr[0] || findValue > arr[arr.length - 1]) {
            return -1;
        }
        int mid = left + (findValue - arr[left]) / (arr[right] - arr[left]) * (right - left);
        if (findValue > arr[mid]) {
            return insertValueSearch(arr,mid+1,right,findValue);
        }else if(findValue < arr[mid]){
            return insertValueSearch(arr,left,mid-1,findValue);
        }else {
            return mid;
        }
    }
}
