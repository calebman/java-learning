package com.gc.demo;

import java.util.Scanner;

/**
 * @author JianhuiChen
 * @description JVM 垃圾回收示例
 * @date 2020-07-06
 * @version 1.1
 */
public class JVMGCDemo {
    public static void main(String[] args) {
        JVMUtils.printJVMInfo();

        // 单个对象大小 100k
        final long singleSize = JVMUtils.parseBitSize("100k");

        Scanner scan = new Scanner(System.in);
        System.out.println("请输入平均流量，支持 b、k、m、g 作为单位");
        final long occupySize = JVMUtils.parseBitSize(scan.next());
        System.out.println("请输入总流量，支持 b、k、m、g 作为单位");
        final long bitSize = JVMUtils.parseBitSize(scan.next());

        long startAt = System.currentTimeMillis();

        final int allotCnt = (int) Math.ceil(occupySize / (double) singleSize);
        byte[][] mermory = new byte[allotCnt][];
        final int total = (int) Math.ceil(bitSize / (double) singleSize);
        for (int i = 0; i < total; i++) {
            mermory[i % allotCnt] = new byte[(int) singleSize];
        }

        JVMUtils.printJVMGCInfo();

        System.out.println(String.format("运行耗时 %dms", System.currentTimeMillis() - startAt));
    }
}
