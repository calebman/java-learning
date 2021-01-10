package com.gc.demo;

import java.util.Scanner;

/**
 * @author JianhuiChen
 * @description JVM 内存分配的示例
 * @date 2020-06-30
 * @version 1.1
 * 以下是 JVM 部分配置描述
 * -XX:+PrintGCDetails                程序运行时输出 GC 日志
 * -Xmx20M                            设置老年代的容量最大为 20M，默认 1/4 物理内存
 * -Xms20M                            设置老年代的容量初始大小为 20M，默认 1/64 物理内存
 * -Xmn6M                             设置新生代的容量初始大小为 6M
 * -XX:SurvivorRatio=8                eden 占新生代的8/10，survivor(from & to) 占 2/10
 * -XX:TargetSurvivorRatio=90         使 from 区使用到 90% 时，再将对象送入年老代
 * -XX:PetenureSizeThreshold=1000000  将 1MB 以上的对象直接在年老代分配
 */
public class JVMMemoryDemo {

    public static void main(String[] args) {
        JVMUtils.printJVMInfo();

        Scanner scan = new Scanner(System.in);
        System.out.println("请输入内存分配的最小单元，支持 b、k、m、g 作为单位");
        final long singleSize = JVMUtils.parseBitSize(scan.next());
        System.out.println("请输入需要分配的内存大小，支持 b、k、m、g 作为单位");
        final long bitSize = JVMUtils.parseBitSize(scan.next());

        // 按照最小单元切割，分多次分配堆空间，考察堆空间的使用情况
        final int allotCnt = (int) Math.ceil(bitSize / (double) singleSize);
        System.out.println(String.format("将进行 %d 次内存分配", allotCnt));

        byte[][] mermory = new byte[allotCnt][];
        for (int i = 0; i < allotCnt - 1; i++) {
            mermory[i] = new byte[(int) singleSize];
        }
        final int lastBitSize = (int) (bitSize - singleSize * (allotCnt - 1));
        mermory[allotCnt - 1] = new byte[lastBitSize];

        JVMUtils.printJVMGCInfo();
    }
}
