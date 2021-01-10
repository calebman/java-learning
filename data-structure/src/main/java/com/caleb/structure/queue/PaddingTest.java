package com.caleb.structure.queue;

/**
 * @author JianhuiChen
 * @description 利用填充提高效率
 * 为什么 PaddingItem 比 NormalItem 的效率高出一倍？
 * @date 2020-08-01
 */
public class PaddingTest {
    private static volatile NormalItem[] items = new NormalItem[]{
            new NormalItem(), new NormalItem()
    };
//    private static volatile PaddingItem[] items = new PaddingItem[]{
//            new PaddingItem(), new PaddingItem()
//    };

    private static class Padding {
        private long p1, p2, p3, p4, p5, p6, p7;
    }

    private static class NormalItem {
        private long p;
    }

    private static class PaddingItem extends Padding {
        private long p;
    }

    public static void main(String[] args) throws InterruptedException {
        long startAt = System.currentTimeMillis();
        Thread a = new Thread(() -> {
            for (int i = 0; i < 100000000L; i++) {
                items[0].p = 1;
            }
        });
        Thread b = new Thread(() -> {
            for (int i = 0; i < 100000000L; i++) {
                items[1].p = 2;
            }
        });
        a.start();
        b.start();
        a.join();
        b.join();
        System.out.println("耗时：" + (System.currentTimeMillis() - startAt) + "ms");
    }
}
