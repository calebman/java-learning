package com.caleb.sort;

/**
 * @author JianhuiChen
 * @description 冒泡排序示例
 * @date 2020-08-11
 */
public class BubbleSort {

    private static final int[] arr = new int[]{
            9, 6, 11, 3, 5, 12, 8, 7, 10
    };

    public static void sort(int arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    swap(arr, i, j);
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
        BubbleSort.sort(arr);
        for (int a : arr) System.out.print(a + " ,");
    }
}
