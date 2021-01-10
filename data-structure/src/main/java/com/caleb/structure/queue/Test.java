package com.caleb.structure.queue;

import org.openjdk.jol.info.ClassLayout;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author JianhuiChen
 * @description
 * @date 2020-08-04
 */
public class Test {

    public static void main(String[] args) {
        Object[] obis = new Object[]{};
        System.out.print(ClassLayout.parseInstance(obis).toPrintable());
    }
}
