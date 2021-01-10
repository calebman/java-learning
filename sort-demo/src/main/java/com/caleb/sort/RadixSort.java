package com.caleb.sort;

import java.util.Random;

/**
 * @author JianhuiChen
 * @description 基数排序示例
 * @date 2020-08-11
 */
public class RadixSort {

    private static final int[] arr = new int[10];

    static {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1 + new Random().nextInt(1000);
        }
    }

    public static void sort(int arr[]) {
        // 寻找最大值
        int max = Integer.MIN_VALUE;
        for (int a : arr) {
            max = Math.max(max, a);
        }
        // 获得比较轮数 跟最大值的位数有关
        int rounds = (int) Math.log10(max);
        // 循环比较个、十、百、千...
        int[] temp = new int[arr.length];
        for (int i = 0; i <= rounds; i++) {
            // 对其中的位数使用计数排序
            int[] count = new int[10];
            int digits = (int) Math.pow(10, i);
            for (int a : arr) {
                count[a / digits % 10]++;
            }
            // 构建累加数组
            for (int j = 1; j < count.length; j++) {
                count[j] = count[j] + count[j - 1];
            }
            // 利用临时数组记录结果
            for (int j = arr.length - 1; j >= 0; j--) {
                temp[--count[arr[j] / digits % 10]] = arr[j];
            }
            // 回写原数组
            System.arraycopy(temp, 0, arr, 0, temp.length);
        }
    }

    public static void main(String[] args) {
        for (int a : arr) System.out.print(a + " ,");
        System.out.println();
        RadixSort.sort(arr);
        for (int a : arr) System.out.print(a + " ,");
    }
}
