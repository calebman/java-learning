package com.caleb.cjh.sort;

import com.caleb.cjh.utils.ArrUtil;

/**
 * @author calebman
 * @date 2018-5-17
 * <p>
 * 冒泡排序算法实现
 * 最差时间复杂度 O(n^2)
 * 最优时间复杂度 O(n)
 * 平均时间复杂度 O(n^2)
 * 空间复杂度 O(1)
 * 稳定
 * </p>
 */
public class BubbleSort {

    /**
     * 升序排序函数
     *
     * @param arr 数组对象
     */
    public static void ascSort(int arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    ArrUtil.swap(arr, j, j + 1);
                }
            }
        }
    }
}
