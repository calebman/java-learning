package com.caleb.question;

/**
 * @author JianhuiChen
 * @description
 * @date 2020-09-08
 */
public class Finder {
    public static int findKth(int[] a, int n, int K) {
        // write code here
        int p = n - K;
        partition(a, 0, n - 1, p);
        return a[p];
    }

    /**
     * 子区域快速排序
     *
     * @param a          等待排序的数组信息
     * @param leftBound  左边界
     * @param rightBound 右边界
     */
    private static boolean partition(int[] a, int leftBound, int rightBound, int K) {
        if (leftBound >= rightBound) return false;
        int povit = a[rightBound]; // 基准点
        int left = leftBound;
        int right = rightBound - 1;
        while (left < right) {
            while (left < rightBound && a[left] <= povit) left++;
            while (right > 0 && a[right] > povit) right--;
            if (left < right) swap(a, left, right);
        }
        // 归位基准点
        if (a[left] > a[rightBound]) swap(a, left, rightBound);
        if (left == K) return false;
        // 左右数组分别进行排序
        return partition(a, leftBound, left - 1, K) &&
                partition(a, left + 1, rightBound, K);
    }

    private static void swap(int a[], int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void main(String[] args) {
        int r = Finder.findKth(new int[]{1332802, 1177178, 1514891, 871248, 753214, 123866, 1615405, 328656, 1540395, 968891, 1884022, 252932, 1034406, 1455178, 821713, 486232, 860175, 1896237, 852300, 566715, 1285209, 1845742, 883142, 259266, 520911, 1844960, 218188, 1528217, 332380, 261485, 1111670, 16920, 1249664, 1199799, 1959818, 1546744, 1904944, 51047, 1176397, 190970, 48715, 349690, 673887, 1648782, 1010556, 1165786, 937247, 986578, 798663}, 49, 24);
        System.out.println(r);
    }
}