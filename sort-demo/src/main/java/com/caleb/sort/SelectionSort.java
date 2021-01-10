package com.caleb.sort;

/**
 * @author JianhuiChen
 * @description 选择排序示例
 * @date 2020-08-11
 */
public class SelectionSort {

    private static final int[] arr = new int[]{
            9, 6, 11, 3, 5, 12, 8, 7, 10
    };

    public static void sort(int arr[]) {
        int minPos;
        for (int i = 0; i < arr.length - 1; i++) {
            minPos = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minPos] > arr[j]) {
                    minPos = j;
                }
            }
            swap(arr, i, minPos);
        }
    }

    private static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        SelectionSort.sort(arr);
        for (int a : arr) System.out.print(a + " ,");
    }
}
