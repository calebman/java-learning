package com.caleb.cjh.tree;


import com.caleb.cjh.tree.btn.BinarySearchTree;
import com.caleb.cjh.tree.rbt.RedBlackTree;
import com.caleb.core.utils.ArrUtil;
import com.caleb.core.utils.RunningTime;
import org.junit.Test;

import java.util.Random;

public class TreeTest {

    // 数组长度
    static final int COUNT = 50000000;
    // 标准的查询二叉树查询顺序
    static final int[] BEST_INSERT_ORDER = {9, 5, 13, 2, 7, 11, 15, 1, 3, 6, 8, 10, 12};
    // 最不理想的查询二叉树插入顺序
    static final int[] WORST_INSERT_ORDER = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
    // 随机的数组
    static final int[] INSERT_DISORDER = ArrUtil.generatorNotRepeatArr(COUNT);

    @Test
    public void BestInsertOrer() {
        insert(BEST_INSERT_ORDER, "BEST INSERT ORDER", 1);
    }

    @Test
    public void WorstInsertOrder() {
        insert(WORST_INSERT_ORDER, "WORST INSERT ORDER", 1);
    }

    @Test
    public void InsertDisorder() {
        insert(INSERT_DISORDER, "INSERT DISORDER", new Random().nextInt(COUNT));
    }


    void insert(int arr[], String flag, int searchNum) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        RedBlackTree redBlackTree = new RedBlackTree();

        RunningTime runningTime = RunningTime.generator();
        for (int num : arr) {
            binarySearchTree.insert(num);
        }
        runningTime.printInfo(flag + " BST INSERT");
        runningTime.reComplete();
        binarySearchTree.search(searchNum);
        runningTime.printInfo(flag + " BST SEARCH " + searchNum);

        runningTime.reComplete();
        for (int num : arr) {
            redBlackTree.insert(num);
        }
        runningTime.printInfo(flag + " RBT INSERT");
        runningTime.reComplete();
        redBlackTree.search(searchNum);
        runningTime.printInfo(flag + " RBT SEARCH " + searchNum);
    }
}
