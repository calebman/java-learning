package com.gc.demo;

import java.util.Scanner;

/**
 * @author JianhuiChen
 * @description
 * @date 2020-09-22
 */
public class JVMDemo {

    public static void main(String[] args) {
        int[] arr = new int[1024 * 1024 / 4];
        Scanner scanner = new Scanner(System.in);
        while (scanner.next() != null) {
            arr = new int[1024 * 1024 / 4];
            System.out.println("分配内存");
        }
    }
}
