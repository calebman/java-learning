package com.caleb.cjh.utils;

import java.util.Random;

/**
 * @author calebman
 * @Date 2018-5-17
 * <p>
 * 数组工具类
 * </p>
 */
public class ArrUtil {
    /**
     * 打印数组
     *
     * @param arr 数组
     */
    public static void printArr(int arr[]) {
        if (arr.length > 1000) {
            System.out.println("arr length is too long");
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static int[] generatorArr(int n) {
        return generatorArr(n, 1, 100);
    }

    /**
     * 生成一个随机的整形数组
     *
     * @param n 数组大小
     * @param r 随机值的左边界
     * @param l 随机值的右边界
     * @return 数组对象
     */
    public static int[] generatorArr(int n, int l, int r) {
        int arr[] = new int[n];
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            arr[i] = rand.nextInt(r) + l;
        }
        return arr;
    }

    /**
     * 克隆数组
     *
     * @param srcArr 原数组
     * @return 克隆数组
     */
    public static int[] cloneArr(int srcArr[]) {
        int arr[] = new int[srcArr.length];
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
    public static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
