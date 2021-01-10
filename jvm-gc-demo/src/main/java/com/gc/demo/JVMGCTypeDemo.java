package com.gc.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author JianhuiChen
 * @version 1.1
 * @description JVM 垃圾回收器类型示例
 * @date 2020-07-06
 */
public class JVMGCTypeDemo {
    public static void main(String[] args) {
        JVMUtils.printJVMInfo();

        final long cacheTotal = (long) (Runtime.getRuntime().maxMemory() * 0.9);

        final long singleSize = JVMUtils.parseBitSize("512b");
        final long bitTotal = JVMUtils.parseBitSize("10g");

        final int cacheAllotCnt = (int) Math.ceil(cacheTotal / (double) singleSize);
        final int bitAllotCnt = (int) Math.ceil(bitTotal / (double) singleSize);
        byte[][] mermory = new byte[cacheAllotCnt][];
        for (long i = 0; i < bitAllotCnt; i++) {
            if (i == cacheAllotCnt) {
                mermory = new byte[cacheAllotCnt][];
            }
            mermory[Math.toIntExact(i % cacheAllotCnt)] = new byte[(int) singleSize];
        }

        JVMUtils.printJVMGCInfo();
    }
}
