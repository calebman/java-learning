package com.caleb.algorithm.array;

import org.junit.Assert;

/**
 * 给定一个整数数组，判断是否存在重复元素。
 * 如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
 */
public class Leetcode24 {

    /*
    冒泡法 存在超时问题
     */
//    public static boolean containsDuplicate(int[] nums) {
//        int len = nums.length;
//        for (int i = 0; i < len - 1; i++) {
//            for (int j = i + 1; j < len; j++) {
//                if (nums[i] == nums[j]) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }

    /*
    解法二 利用集合对象 需要使用额外的空间
     */
//    public static boolean containsDuplicate(int[] nums) {
//        int len = nums.length;
//        Set<Integer> set = new HashSet<Integer>(len);
//        for (int i = 0; i < len; i++) {
//            if (!set.add(nums[i])) {
//                return true;
//            }
//        }
//        return false;
//    }

    /*
    解法三 目前最优解 利用boolean数组的下标来确定是否存在相同的数字
     */
    public static boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length == 1) {
            return false;
        }

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num > max) {
                max = num;
            }
            if (num < min) {
                min = num;
            }
        }

        boolean[] bool = new boolean[max - min + 1];
        for (int num : nums) {
            if (bool[num - min]) {
                return true;
            } else {
                bool[num - min] = true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Assert.assertTrue("错误的结果，此数组应当存在重复", containsDuplicate(new int[]{1, 2, 3, 1}));
        Assert.assertTrue("错误的结果，此数组应当存在重复", containsDuplicate(new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2}));
        Assert.assertTrue("错误的结果，此数组应当不存在重复", !containsDuplicate(new int[]{1, 3, 5, 6, 2}));
        Assert.assertTrue("错误的结果，此数组应当不存在重复", !containsDuplicate(new int[]{1, 2, 3, 4}));
    }
}
