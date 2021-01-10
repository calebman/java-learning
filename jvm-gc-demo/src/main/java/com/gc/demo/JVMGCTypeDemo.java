package com.gc.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author JianhuiChen
 * @version 1.1
 * @description JVM 垃圾回收示例
 * @date 2020-07-06
 */
public class JVMMSDemo {
    public static void main(String[] args) {
        JVMUtils.printJVMInfo();

        Scanner scan = new Scanner(System.in);
        System.out.println("请输入平均流量，支持 b、k、m、g 作为单位");
        final long singleSize = JVMUtils.parseBitSize(scan.next());
        System.out.println("请输入总流量，支持 b、k、m、g 作为单位");
        final long bitSize = JVMUtils.parseBitSize(scan.next());
        final int allotCnt = (int) Math.ceil(bitSize / (double) singleSize);

        long startAt = System.currentTimeMillis();

        List<byte[]> cache = new ArrayList<>();
        // 涌入订单
        for (int i = 0; i < allotCnt; i++) {
            try {
                cache.add(new byte[(int) singleSize]);
                i++;
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // 处理订单
        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(3);
                    if (cache.isEmpty()) {
                        break;
                    }
                    cache.remove(0);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        JVMUtils.printJVMGCInfo();

        System.out.println(String.format("运行耗时 %dms", System.currentTimeMillis() - startAt));
    }
}
