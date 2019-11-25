package com.atguigu.search;

import java.util.ArrayList;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 8, 9, 1000, 1000, 1000, 1234};
//        int i = binarySearch(arr, 0, arr.length - 1, 1100);
//        System.out.println("找到了，位置：" + i);

        ArrayList<Integer> integers = binarySearch2_1(arr, 0, arr.length - 1, 1000);
        for (Integer integer : integers) {
            System.out.println(integer);
        }
    }

    public static int binarySearch(int[] arr, int left, int right, int findVal) {
        int mid = (left + right) / 2;
        if (arr[mid] > findVal) {
            return binarySearch(arr, left, mid - 1, findVal);
        } else if (arr[mid] < findVal) {
            return binarySearch(arr, mid + 1, right, findVal);
        } else {
            return mid;
        }
    }

    public static ArrayList<Integer> binarySearch2(int[] arr, int left, int right, int findVal) {
        if (left > right) {
            return new ArrayList<Integer>();
        }

        int mid = (left + right) / 2;
        if (findVal > arr[mid]) {
            return binarySearch2(arr, mid + 1, right, findVal);
        } else if (findVal < arr[mid]) {
            return binarySearch2(arr, left, mid - 1, findVal);
        } else {
            ArrayList<Integer> list = new ArrayList();
            list.add(mid);

            int temp = mid - 1;
            while (true) {
                if (temp < 0 || arr[temp] != findVal) {
                    break;
                }
                list.add(temp);
                temp--;
            }

            temp = mid + 1;
            while (true) {
                if (temp > arr.length - 1 || arr[temp] != findVal) {
                    break;
                }
                list.add(temp);
                temp++;
            }
            return list;
        }
    }


    public static ArrayList<Integer> binarySearch2_1(int[] arr, int left, int right, int findVal) {
        if (left > right) {
            return new ArrayList<>();
        }
        int mid = (left + right) / 2;
        if (findVal > arr[mid]) {
            return binarySearch2_1(arr, mid + 1, right, findVal);
        } else if (findVal < arr[mid]) {
            return binarySearch2_1(arr, left, mid - 1, findVal);
        } else {
            ArrayList<Integer> list = new ArrayList<>();
            int temp = mid;
            while (true) {
                if (temp < 0 || arr[temp - 1] != findVal) {
                    break;
                }
                list.add(temp);
                temp--;
            }
            list.add(mid);
            temp = mid + 1;

            while (true) {
                if (temp > arr.length || arr[temp] != findVal) {
                    break;
                }
                list.add(temp);
                temp++;
            }
            return list;
        }
    }
}
