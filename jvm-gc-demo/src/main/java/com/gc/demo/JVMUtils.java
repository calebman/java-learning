package com.gc.demo;

import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * @author JianhuiChen
 * @description 示例使用到的工具函数
 * @date 2020-07-06
 * @version 1.1
 */
public class JVMUtils {

    /**
     * 新生代 GC 日志带有的标志
     */
    private static final Set<String> yGCAlgorithm = new LinkedHashSet<String>() {
        {
            add("Copy");
            add("ParNew");
            add("PS Scavenge");
            add("G1 Young Generation");
        }
    };

    /**
     * 老年代 GC 日志带有的标志
     */
    private static final Set<String> oGCAlgorithm = new LinkedHashSet<String>() {
        {
            add("MarkSweepCompact");
            add("PS MarkSweep");
            add("ConcurrentMarkSweep");
            add("G1 Old Generation");
        }
    };

    /**
     * 输出 JVM 的配置
     */
    public static void printJVMInfo() {
        // 返回启动参数信息
        List<String> inputArguments = ManagementFactory.getRuntimeMXBean().getInputArguments();
        // 返回java虚拟机中的内存总量
        long totalMemory = Runtime.getRuntime().totalMemory();
        // 返回java虚拟机试图使用的最大内存量
        long maxMemory = Runtime.getRuntime().maxMemory();
        System.out.println(String.format("VM_Options = %s", inputArguments));
        System.out.println(String.format("Total_Memory(-Xms ) =  %dMB", totalMemory / 1024 / 1024));
        System.out.println(String.format("Max_Memory(-Xmx ) =  %dMB", maxMemory / 1024 / 1024));
    }

    /**
     * 输出 GC 信息
     */
    public static void printJVMGCInfo() {
        long gcCount = 0;
        long gcTime = 0;
        long oldGCount = 0;
        long oldGcTime = 0;
        long youngGcCount = 0;
        long youngGcTime = 0;
        for (final GarbageCollectorMXBean garbageCollector :
                ManagementFactory.getGarbageCollectorMXBeans()) {
            gcTime += garbageCollector.getCollectionTime();
            gcCount += garbageCollector.getCollectionCount();
            String gcAlgorithm = garbageCollector.getName();
            if (yGCAlgorithm.contains(gcAlgorithm)) {
                youngGcTime += garbageCollector.getCollectionTime();
                youngGcCount += garbageCollector.getCollectionCount();
            } else if (oGCAlgorithm.contains(gcAlgorithm)) {
                oldGcTime += garbageCollector.getCollectionTime();
                oldGCount += garbageCollector.getCollectionCount();
            }
        }
        System.out.println(String.format("GC: Cnt %d, Cost %dms", gcCount, gcTime));
        System.out.println(String.format("YGC: Cnt %d, Cost %dms", youngGcCount, youngGcTime));
        System.out.println(String.format("OGC: Cnt %d, Cost %dms", oldGCount, oldGcTime));
    }

    /**
     * 解析带单位的容量为 bit 大小
     * 1k => 1024 * 1024
     *
     * @param sizeStr 容量
     * @return bit 数值
     */
    public static long parseBitSize(String sizeStr) {
        if ("".equals(sizeStr) || sizeStr == null) {
            return 1024 * 1024;
        }
        sizeStr = sizeStr.toLowerCase();
        String type = sizeStr.substring(sizeStr.length() - 1);
        long sizeNum = Integer.parseInt(sizeStr.substring(0, sizeStr.length() - 1));
        long bitSize;
        switch (type) {
            case "k":
                bitSize = sizeNum * 1024;
                break;
            case "m":
                bitSize = sizeNum * 1024 * 1024;
                break;
            case "g":
                bitSize = sizeNum * 1024 * 1024 * 1024;
                break;
            default:
                bitSize = sizeNum;
        }
        return bitSize;
    }
}
