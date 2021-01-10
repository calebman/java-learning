package com.caleb.sort;

import java.util.Random;

/**
 * @author JianhuiChen
 * @description 计数排序示例
 * @date 2020-08-11
 */
public class CountSort {

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
        // 回写原数组
        int k = 0;
        for (int i = 0; i < count.length; i++) {
            for (int j = 0; j < count[i]; j++) {
                arr[k++] = min + i;
            }
        }
    }

    public static void main(String[] args) {
        for (int a : arr) System.out.print(a + " ,");
        System.out.println();
        CountSort.sort(arr);
        for (int a : arr) System.out.print(a + " ,");
    }
}
