package com.caleb.sort;

/**
 * @author JianhuiChen
 * @description 归并排序示例
 * @date 2020-08-11
 */
public class MergeSort {

    private static final int[] arr = new int[]{
            1, 11, 7, 9, 6, 4, 2
    };

    public static void sort(int arr[]) {
        sort(arr, 0, arr.length - 1);
    }

    public static void sort(int arr[], int left, int right) {
        if (left == right) return;
        // 寻找中值，此处使用 (left + right) / 2 可能会出现 int 溢出问题
        int mid = left + (right - left) / 2;
        // 左数组排序
        sort(arr, left, mid);
        // 右数组排序
        sort(arr, mid + 1, right);
        // 此时左右子数组均为有序 执行归并
        merge(arr, left, mid + 1, right);
    }

    /**
     * 归并排序的实现核心
     * 可以为两个有序的左右子数组执行归并逻辑
     * 如数组 { 1, 4, 7, 2, 3, 6, 9 } 区间 [0 - 2] 与 [3 - 6] 有序
     * 那么传递 leftPos = 0, rightPos = 3, rightBound = 6 可归并得到一个有序数组
     *
     * @param arr        待排数组
     * @param leftPos    左子数组起始位置
     * @param rightPos   右子数组起始位置
     * @param rightBound 子数组右边界
     */
    private static void merge(int arr[], int leftPos, int rightPos, int rightBound) {
        if (leftPos == rightPos) return;
        int[] temp = new int[rightBound - leftPos + 1]; // 用于收集归并排序后的结果
        int i = leftPos;
        int j = rightPos;
        int k = 0;

        // 左右子数组归并
        while (i < rightPos && j <= rightBound) {
            if (arr[i] < arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        // 归并完后多出来的那截数组
        while (i < rightPos) temp[k++] = arr[i++];
        while (j <= rightBound) temp[k++] = arr[j++];

        // 将归并结果赋给原数组
        for (int l = 0; l < temp.length; l++) {
            arr[leftPos + l] = temp[l];
        }
    }

    public static void main(String[] args) {
        MergeSort.sort(arr);
        for (int a : arr) System.out.print(a + " ,");
    }
}
