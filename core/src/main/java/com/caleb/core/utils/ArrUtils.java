package com.caleb.core.utils;

import java.util.Random;

/**
 * @author calebman
 * @Date 2018-5-17
 * <p>
 * 数组工具类
 * </p>
 */
public class ArrUtils {
    /**
     * 打印数组
     *
     * @param arr 数组
     */
    public static void printArr(int[] arr) {
        if (arr.length > 1000) {
            System.out.println("arr length is too long");
            return;
        }
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static int[] generatorRandomArr(int n) {
        return generatorRandomArr(n, 1, 100);
    }

    /**
     * 生成一个大小为n的随机内容的整形数组，数值可能相同
     *
     * @param n 数组大小
     * @param r 随机值的左边界
     * @param l 随机值的右边界
     * @return 数组对象
     */
    public static int[] generatorRandomArr(int n, int l, int r) {
        int[] arr = new int[n];
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            arr[i] = rand.nextInt(r) + l;
        }
        return arr;
    }

    /**
     * 生成一个大小为n的不重复内容的乱序整形数组
     *
     * @param n 数组大小
     * @return 数组对象
     */
    public static int[] generatorNotRepeatArr(int n) {
        int[] arr = new int[n];
        // 顺序生成
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        // 乱序
        int randCount = 0;
        int position = 0;
        int k = 0;
        do {
            Random rand = new Random();
            int r = n - randCount;
            position = rand.nextInt(r);
            arr[k++] = arr[position];
            randCount++;
            arr[position] = arr[r - 1];
        } while (randCount < n);
        return arr;
    }

    /**
     * 生成一个大小为n的有序数组
     *
     * @param n 数组大小
     * @return 数组对象
     */
    public static int[] generatorRepeatArr(int n) {
        int[] arr = new int[n];
        // 顺序生成
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        return arr;
    }

    /**
     * 克隆数组
     *
     * @param srcArr 原数组
     * @return 克隆数组
     */
    public static int[] cloneArr(int[] srcArr) {
        int[] arr = new int[srcArr.length];
        System.arraycopy(srcArr, 0, arr, 0, srcArr.length);
        return arr;
    }

    /**
     * 交换函数
     *
     * @param arr 数组对象
     * @param i   数组下标
     * @param j   数组下标
     */
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
