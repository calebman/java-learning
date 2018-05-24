package com.caleb.cjh.sort;

import com.caleb.cjh.utils.ArrUtil;

/**
 * @author calebman
 * @date 2018-5-17
 * <p>
 * 定向冒泡排序算法实现
 * 最差时间复杂度 O(n^2)
 * 最优时间复杂度 O(n)
 * 平均时间复杂度 O(n^2)
 * 空间复杂度 O(1)
 * 稳定
 * </p>
 */
public class CocktailSort {

    /**
     * 升序排序函数
     *
     * @param arr 数组对象
     */
    public static void ascSort(int arr[]) {
        // 初始化边界
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            for (int i = left; i < right; i++)   // 前半轮,将最大元素放到后面
            {
                if (arr[i] > arr[i + 1]) {
                    ArrUtil.swap(arr, i, i + 1);
                }
            }
            right--;
            for (int i = right; i > left; i--)   // 后半轮,将最小元素放到前面
            {
                if (arr[i - 1] > arr[i]) {
                    ArrUtil.swap(arr, i - 1, i);
                }
            }
            left++;
        }
    }
}
