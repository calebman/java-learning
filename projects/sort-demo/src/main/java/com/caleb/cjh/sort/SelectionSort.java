package com.caleb.cjh.sort;

import com.caleb.cjh.utils.ArrUtil;

/**
 * @author calebman
 * @date 2018-5-17
 * <p>
 * 选择排序算法实现
 * 最差时间复杂度 O(n^2)
 * 最优时间复杂度 O(n^2)
 * 平均时间复杂度 O(n^2)
 * 空间复杂度 O(1)
 * 不稳定
 * </p>
 */
public class SelectionSort {

    /**
     * 升序排序函数
     *
     * @param arr 数组对象
     */
    public static void ascSort(int arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {        // i为已排序序列的末尾
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {    // 未排序序列
                if (arr[j] < arr[min]) {             // 找出未排序序列中的最小值
                    min = j;
                }
            }
            if (min != i) {
                ArrUtil.swap(arr, min, i);    // 放到已排序序列的末尾，该操作很有可能把稳定性打乱，所以选择排序是不稳定的排序算法
            }
        }
    }
}
