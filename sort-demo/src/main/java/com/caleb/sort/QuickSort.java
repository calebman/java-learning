package com.caleb.sort;

/**
 * @author JianhuiChen
 * @description 快速排序示例
 * @date 2020-08-11
 */
public class QuickSort {

    private static final int[] arr = new int[]{
            9, 6, 11, 3, 5, 12, 8, 7, 10
    };

    public static void sort(int arr[]) {
        partition(arr, 0, arr.length - 1);
    }

    private static void partition(int arr[], int leftBound, int rightBound) {
        if (leftBound >= rightBound) {
            if (leftBound == rightBound) {
                return;
            }
            return;
        }
        // 将数组最右边的数字作为基准点
        int pivot = arr[rightBound];
        int left = leftBound;
        int right = rightBound - 1;
        while (left < right) {
            while (left < rightBound && arr[left] <= pivot) left++;
            while (right > 0 && arr[right] > pivot) right--;
            if (left < right) swap(arr, left, right);
        }
        // 将基准点归位
        if (arr[left] > arr[rightBound]) swap(arr, left, rightBound);
        // 基于基准点左右分区
        partition(arr, leftBound, left - 1);
        partition(arr, left + 1, rightBound);
    }

    private static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        QuickSort.sort(arr);
        for (int a : arr) System.out.print(a + " ,");
    }
}
