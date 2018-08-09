package com.caleb.sort;

/**
 * @author calebman
 * @date 2018-5-17
 * <p>
 * 插入排序算法实现
 * 最差时间复杂度 O(n^2)
 * 最优时间复杂度 O(n)
 * 平均时间复杂度 O(n^2)
 * 空间复杂度 O(1)
 * 稳定
 * </p>
 */
public class InsertionSort implements SortInterface{
    /**
     * 升序排序函数
     *
     * @param arr 数组对象
     */
    public void ascSort(int arr[]) {
        for (int i = 1; i < arr.length; i++) {         // 类似抓扑克牌排序
            int get = arr[i];                 // 右手抓到一张扑克牌
            int j = i - 1;                  // 拿在左手上的牌总是排序好的
            while (j >= 0 && arr[j] > get) {    // 将抓到的牌与手牌从右向左进行比较
                arr[j + 1] = arr[j];            // 如果该手牌比抓到的牌大，就将其右移
                j--;
            }
            arr[j + 1] = get; // 直到该手牌比抓到的牌小(或二者相等)，将抓到的牌插入到该手牌右边(相等元素的相对次序未变，所以插入排序是稳定的)
        }
    }
}
