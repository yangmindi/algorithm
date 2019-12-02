package com.atguigu.tree;

class ArrayBinaryTree{
    private int[] arr;

    public ArrayBinaryTree(int[] arr) {
        this.arr = arr;
    }

    public void preOrder(){
        preOrder(0);
    }

    public void preOrder(int index){
        if(arr == null || arr.length == 0){
            System.out.println("二叉树为空");
            return ;
        }
        System.out.println(arr[index]);

        if((index * 2 + 1) < arr.length){
            preOrder(index * 2 +1 );
        }

        if((index * 2 + 2) < arr.length){
            preOrder(index * 2 + 2);
        }
    }
}

public class ArrBinaryTreeDemo {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        ArrayBinaryTree arrayBinaryTree = new ArrayBinaryTree(arr);
        arrayBinaryTree.preOrder();
    }
}
