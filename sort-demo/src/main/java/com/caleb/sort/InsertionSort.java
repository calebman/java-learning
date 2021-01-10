package com.caleb.sort;

/**
 * @author JianhuiChen
 * @description 插入排序示例
 * @date 2020-08-11
 */
public class InsertionSort {

    private static final int[] arr = new int[]{
            9, 6, 11, 3, 5, 12, 8, 7, 10
    };

    public static void sort(int arr[]) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j >= 1; j--) { // 手里只有一张牌的时候不用做插入
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j, j - 1);
                }
            }
        }
    }

    private static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        InsertionSort.sort(arr);
        for (int a : arr) System.out.print(a + " ,");
    }
}
