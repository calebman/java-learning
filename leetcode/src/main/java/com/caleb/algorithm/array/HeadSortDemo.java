package com.caleb.algorithm.array;

/**
 * @author JianhuiChen
 * @description
 * @date 2020-09-15
 */
public class HeadSortDemo {

    private static final int[] arr = new int[]{
            9, 6, 11, 3, 5, 12, 8, 7, 10, 1, 2
    };

    public static void main(String[] args) {
        HeadSortDemo.sort(arr);
        for (int a : arr) System.out.print(a + " ,");
    }

    private static void sort(int[] arr) {
        int len = arr.length;
        while (len > 0) {
            // 构造大顶堆
            adjustHead(arr, len);
            // 交换位置
            swap(arr, 0, len - 1);
            len--;
        }
    }

    private static void adjustHead(int[] arr, int len) {
        // 从最后的非叶子结点开始 自底向上 自左向右 调整为大顶堆
        int pos = len / 2 - 1;
        for (int i = pos; i >= 0; i--) {
            // 左右子结点
            int leftPos = i * 2 + 1;
            int rightPos = i * 2 + 2;
            // 找到最大结点
            int maxPos = i;
            if (arr[leftPos] > arr[maxPos]) maxPos = leftPos;
            if (rightPos < len && arr[rightPos] > arr[maxPos]) maxPos = rightPos;
            // 交换结点
            swap(arr, i, maxPos);
        }
    }

    private static void swap(int arr[], int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
