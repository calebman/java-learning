package com.caleb.cjh.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定两个数组，写一个方法来计算它们的交集。
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
 * 我们可以不考虑输出结果的顺序。
 */
public class Leetcode26 {

    public static int[] intersect(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int i = 0;
        int k = 0;
        List<Integer> l = new ArrayList<Integer>();
        if (len1 > len2) {
            while (i < len1) {
                while (k < len2) {
                    if (nums1[i] == nums2[k]) {
                        i++;
                        k++;
                        l.add(nums2[k]);
                    } else {
                        k = 0;
                        i++;
                        continue;
                    }
                }
            }
        } else {
            while (i < len2) {
                while (k < len1) {
                    if (nums2[i] == nums1[k]) {
                        i++;
                        k++;
                        l.add(nums2[k]);
                    } else {
                        k = 0;
                        i++;
                        continue;
                    }
                }
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {

    }
}
