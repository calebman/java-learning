package com.caleb.sort;

import java.util.Arrays;

/**
 * @author JianhuiChen
 * @description 双轴快速排序示例
 * @date 2020-08-11
 */
public class JavaArraysSort {

    private static final int[] arr = new int[]{
            9, 6, 11, 3, 5, 12, 8, 7, 10
    };

    public static void sort(int arr[]) {
        Arrays.sort(arr);
    }

    public static void main(String[] args) {
        JavaArraysSort.sort(arr);
        for (int a : arr) System.out.print(a + " ,");
    }
}
