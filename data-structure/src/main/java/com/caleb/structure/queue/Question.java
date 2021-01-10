package com.caleb.structure.queue;

import org.openjdk.jol.info.ClassLayout;

import java.util.concurrent.locks.LockSupport;

/**
 * @author JianhuiChen
 * @description
 * @date 2020-08-04
 */
public class Question {

    private static final int NUM_START = 1;
    private static final char WORD_START = 'A';
    private static final Object OBJ = new Object();
    private static Thread numThread, wordTread;

    public static void main(String[] args) {
        numThread = new Thread(() -> {
            int i = 0;
            while (i < 26) {
                synchronized (OBJ) {
                    System.out.print(NUM_START + i);
                    i++;
                    try {
//                        OBJ.notify();
//                        for (int j = 0; j < 1000000000L; j++) ;
//                        System.out.print(ClassLayout.parseInstance(OBJ).toPrintable());
                        OBJ.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        wordTread = new Thread(() -> {
            int i = 0;
            while (i < 26) {
                synchronized (OBJ) {
                    System.out.print((char) (WORD_START + i));
                    i++;
                    try {
//                        OBJ.notify();
                        OBJ.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        wordTread.start();
        numThread.start();
    }
}
