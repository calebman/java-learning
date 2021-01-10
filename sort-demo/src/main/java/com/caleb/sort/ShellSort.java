package com.caleb.sort;

/**
 * @author JianhuiChen
 * @description 希尔排序示例
 * @date 2020-08-11
 */
public class ShellSort {

    private static final int[] arr = new int[]{
            9, 6, 11, 3, 5, 12, 8, 7, 10, 15, 14, 4, 1, 13, 2
    };

    public static void sort(int arr[]) {
        // 初始间隔取数组长度的一半
        int gap = arr.length / 2;
        while (gap > 0) {
            System.out.println(gap);
            for (int i = 0; i < gap; i++) {
                // 带间隔的插入排序
                gapInsertionSort(arr, i, gap);
                for (int a : arr) System.out.print(a + " ,");
                System.out.println();
            }
            gap = gap / 2;
        }
    }

    private static void gapInsertionSort(int arr[], int start, int gap) {
        for (int i = start + gap; i < arr.length; i += gap) {
            for (int j = i; j >= gap; j -= gap) {
                if (arr[j] < arr[j - gap]) {
                    swap(arr, j, j - gap);
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
        ShellSort.sort(arr);
        for (int a : arr) System.out.print(a + " ,");
    }
}
