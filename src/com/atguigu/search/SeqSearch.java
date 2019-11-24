package com.atguigu.search;

public class SeqSearch {
    public static void main(String[] args) {
        int arr[] = {1,9,11,-1,34,89};
        int index = seqSearch(arr,100);
        if(index == -1){
            System.out.println("没找到");
        }else {
            System.out.println("下标为:"+index);
        }
    }

    public static int seqSearch(int[] arr,int find){
        for(int i=0; i<arr.length; i++){
            if(arr[i] == find){
                return i;
            }
        }
        return -1;
    }
}
