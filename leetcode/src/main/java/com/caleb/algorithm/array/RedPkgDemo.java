package com.caleb.algorithm.array;

import java.util.Random;

/**
 * @author JianhuiChen
 * @description
 * @date 2020-09-15
 */
public class RedPkgDemo {

    // 红包数量
    private static final int redPkgCnt = 100;

    // 红包总额
    private static final int money = 1000;

    // 最小金额
    private static final int min = 1;

    // 剩余金额
    private static volatile int surplus = money;
    private static volatile int surplusCnt = redPkgCnt;

    public static void main(String[] args) {
        for (int i = 0; i < redPkgCnt; i++) {
            new Thread(new RedPkgRunnable()).start();
        }
    }

    static class RedPkgRunnable implements Runnable {

        @Override
        public void run() {
            synchronized (RedPkgRunnable.class) {
                int m = 0;
                if (surplus > surplusCnt * min) {
                    m = surplusCnt > 1 ? min + new Random().nextInt(Math.max(surplus - min, 0)) : surplus;
                } else {
                    m = min;
                }

                surplus -= m;
                surplusCnt--;
                System.out.println(Thread.currentThread().getName() + " " + m);
            }
        }
    }
}
