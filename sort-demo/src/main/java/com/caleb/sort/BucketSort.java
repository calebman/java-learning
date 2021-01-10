package com.caleb.sort;

/**
 * @author JianhuiChen
 * @description 桶排序示例
 * @date 2020-08-11
 */
public class BucketSort {

    private static final int[] arr = new int[]{
            9, 6, 11, 3, 5, 12, 8, 7, 10
    };

    public static void sort(int arr[]) {

    }

    private static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        BucketSort.sort(arr);
        for (int a : arr) System.out.print(a + " ,");
    }
}
