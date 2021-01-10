package com.caleb.sort;

/**
 * @author JianhuiChen
 * @description 堆排序示例
 * @date 2020-08-11
 */
public class HeapSort {

    private static final int[] arr = new int[]{
            9, 6, 11, 3, 5, 12, 8, 7, 10, 1, 2
    };

    public static void sort(int arr[]) {
        int len = arr.length;
        while (len > 0) {
            // 从最后的非叶子节点开始调整 从下往上 从左到右
            for (int i = len / 2 - 1; i >= 0; i--) {
                adjustHeap(arr, i, len);
            }
            // 沉底交换
            swap(arr, 0, len - 1);
            len--;
        }
    }

    /**
     * 调整为大顶堆 将较大值交换到顶部节点
     *
     * @param arr        原数组信息
     * @param nodePos    顶部节点下标
     * @param rightBound 数组右边界
     */
    private static void adjustHeap(int arr[], int nodePos, int rightBound) {
        // 左右节点的位置下标
        int left = 2 * nodePos + 1;
        int right = 2 * nodePos + 2;
        // 寻找最大值的节点
        int maxPos = nodePos;
        if (arr[left] > arr[maxPos]) maxPos = left;
        if (right < rightBound && arr[right] > arr[maxPos]) maxPos = right; // 注意判断右边界
        // 与根节点进行交换
        swap(arr, nodePos, maxPos);
    }

    private static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        HeapSort.sort(arr);
        for (int a : arr) System.out.print(a + " ,");
    }
}
