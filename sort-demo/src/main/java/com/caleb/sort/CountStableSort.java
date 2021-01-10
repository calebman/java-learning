package com.caleb.sort;

import java.util.Random;

/**
 * @author JianhuiChen
 * @description 稳定版的计数排序示例
 * @date 2020-08-11
 */
public class CountStableSort {

    private static final int[] arr = new int[10];

    static {
        for (int i = 0; i < arr.length; i++) {
            // 18 - 70 岁
            arr[i] = 18 + new Random().nextInt(52);
        }
    }

    public static void sort(int arr[]) {
        // 寻找边界值
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int a : arr) {
            min = Math.min(min, a);
            max = Math.max(max, a);
        }
        // 设置计数数组
        int[] count = new int[max - min + 1];
        for (int a : arr) {
            count[a - min]++;
        }
        // 构建累加数组
        for (int i = 1; i < count.length; i++) {
            count[i] = count[i] + count[i - 1];
        }
        // 利用临时数组记录结果
        int[] temp = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            temp[--count[arr[i] - min]] = arr[i];
        }
        // 回写原数组
        System.arraycopy(temp, 0, arr, 0, temp.length);
    }

    public static void main(String[] args) {
        for (int a : arr) System.out.print(a + " ,");
        System.out.println();
        CountStableSort.sort(arr);
        for (int a : arr) System.out.print(a + " ,");
    }
}
