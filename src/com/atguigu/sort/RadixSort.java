package com.atguigu.sort;

import java.util.Arrays;

public class RadixSort {
    public static void main(String[] args) {
        int[] arr = {53,3,542,748,14,214};
        radixSort(arr);
    }

    public static void radixSort(int[] arr){
        int max = arr[0];
        for(int i=1; i<arr.length; i++){
            if(arr[i]>max){
               max = arr[i];
            }
        }
        //得到最大的是几位数
        int maxLength = (max+"").length();

        for(int i=0,n=1; i<maxLength; i++,n*=10){
            int[][] bucket = new int[10][arr.length];

            int[] bucketElementCounts = new int[10];

            //第1轮（针对每个元素的个位进行处理）
            for(int j=0; j<arr.length; j++){
                //取出每个元素的个位的值
                int digitOfElement = arr[j] / n % 10;
                //放到对应的桶中
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
                bucketElementCounts[digitOfElement]++;
            }
            //按照桶的顺序放回原来的数组
            int index = 0;
            //遍历每一个桶，并将桶中的数据，放入到原数组
            for(int k=0; k<bucketElementCounts.length; k++){
                //如果桶中有数据，才放到原数组
                if(bucketElementCounts[k] != 0){
                    for(int l=0; l<bucketElementCounts[k]; l++){
                        //取出元素放到arr
                        arr[index++] = bucket[k][l];
                    }
                }
                //每一轮处理后，都需要将每个bucketElementCount[k] = 0
                bucketElementCounts[k] = 0;
            }
            System.out.println("第"+i+"轮，排序后数组:"+ Arrays.toString(arr));
        }

    }
}
