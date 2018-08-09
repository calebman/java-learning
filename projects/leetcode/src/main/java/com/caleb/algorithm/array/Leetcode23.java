package com.caleb.algorithm.array;

import com.caleb.core.utils.ArrUtils;

/**
 * 旋转数组
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 */
public class Leetcode23 {

    /*
    解法一 可能会超时
     */
//    public static void rotate(int[] nums, int k) {
//        int len = nums.length;
//        // 计算真实旋转次数
//        k = k % len;
//        if (len > 1) {
//            for (int i = 0; i < k; i++) {
//                for (int j = 1; j < len; j++) {
//                    int temp = nums[0];
//                    nums[0] = nums[j];
//                    nums[j] = temp;
//                }
//            }
//        }
//    }

    /*
    解法二 不会超时
     */
    public static void rotate(int[] nums, int k) {
        int len = nums.length;
        // 计算真实旋转次数
        k = k % len;
        if (k <= 0) {
            return;
        }
        if (len > 1) {
            for (int i = k; i > 0; i--) {
                int temp = nums[len - i];
                nums[len - i] = nums[k - i];
                nums[k - i] = temp;
            }
            // 计算需要冒泡次数
            int r = (2 * k - len) % (len - k);
            if (r > 0) { // 正数前移
                for (int j = r; j > 0; j--) {
                    for (int i = len - j; i > k + r - j; i--) {
                        int temp = nums[i];
                        nums[i] = nums[i - 1];
                        nums[i - 1] = temp;
                    }
                }
            } else { // 负数后移
                r = -r;
                for (int j = 0; j < r; j++) {
                    for (int i = k; i < len - 1; i++) {
                        int temp = nums[i];
                        nums[i] = nums[i + 1];
                        nums[i + 1] = temp;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int nums[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19};
        int k = 8;
        rotate(nums, k);
        ArrUtils.printArr(nums);
    }
}
