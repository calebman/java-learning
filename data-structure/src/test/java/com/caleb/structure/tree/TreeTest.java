package com.caleb.structure.tree;

import com.caleb.core.utils.ArrUtils;
import com.caleb.structure.tree.bst.BinarySearchTree;
import com.caleb.structure.tree.rbt.RedBlackTree;
import com.caleb.core.utils.RunningTime;
import com.caleb.core.utils.TextTable;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TreeTest {

    // 待测试的数据长度
    int[] arrSizes = new int[]{10 * 1000, 100 * 1000, 1000 * 1000, 10 * 1000 * 1000};

    // 理想的查询二叉树插入顺序
    int[] bestInsertOrderArr = null;
    // 最不理想的查询二叉树插入顺序
    int[] worstInsertOrderArr = null;
    // 随机的数组
    int[] insertDisorderArr = null;
    // 显示表格的列名称
    List<String> columnNameList;
    // 显示表格的数据
    List<List<String>> columnValueList;
    // 二叉搜索树
    BinarySearchTreeInterface binarySearchTree;
    // 红黑树
    RedBlackTree redBlackTree;

    void initArr(int arrSize) {
        System.out.printf("generator arr...");
        RunningTime runningTime = RunningTime.generator();
        bestInsertOrderArr = new int[]{9, 5, 13, 2, 7, 11, 15, 1, 3, 6, 8, 10, 12};
        worstInsertOrderArr = ArrUtils.generatorRepeatArr(arrSize);
        insertDisorderArr = ArrUtils.generatorNotRepeatArr(arrSize);
        System.out.println(" with size " + arrSize + " using " + runningTime.getRunningTime() + "ms");
    }

    void initConsole() {
        columnNameList = new ArrayList<String>();
        columnValueList = new ArrayList<List<String>>();
        columnNameList.add("/");
        columnNameList.add("class");
        columnNameList.add("type");
        columnNameList.add("len");
        columnNameList.add("insert");
        columnNameList.add("search");
    }

    void insertData(int size, String tree, String type, String insertRunningTime, String searchRunningTime) {
        List<String> value = new ArrayList<String>();
        value.add((columnValueList.size() + 1) + "");
        value.add(tree);
        value.add(type);
        value.add(size + "");
        value.add(insertRunningTime);
        value.add(searchRunningTime);
        columnValueList.add(value);
    }

    @Test
    public void testBinarySearchTreeInterface() {
        initConsole();
        for (int arrSize : arrSizes) {
            initArr(arrSize);
            RunningTime runningTime = RunningTime.generator();
            System.out.printf("Running testBinarySearchTreeInterface...");
            binarySearchTree = new BinarySearchTree();
            insertAndSearch(binarySearchTree, "Disorder", insertDisorderArr);
            insertAndSearch(binarySearchTree, "WorstOrder", worstInsertOrderArr);

            redBlackTree = new RedBlackTree();
            insertAndSearch(redBlackTree, "Disorder", insertDisorderArr);
            insertAndSearch(redBlackTree, "WorstOrder", worstInsertOrderArr);
            System.out.println(" using " + runningTime.getRunningTime() + "ms\n");

        }
        TextTable textTable = new TextTable(columnNameList, columnValueList);
        System.out.println(textTable.printTable());
    }


    /**
     * 插入并搜索
     *
     * @param arr 待插入的数据
     */
    void insertAndSearch(BinarySearchTreeInterface tree, String type, int arr[]) {
        RunningTime runningTime = RunningTime.generator();
        for (int num : arr) {
            tree.insert(num);
        }
        String insertRunningTime = runningTime.getFormatTime();
        runningTime.reComplete();
        for (int i = 0; i < arr.length; i++) {
            tree.search(i);
        }
        String searchRunningTime = runningTime.getFormatTime();
        insertData(arr.length, tree.getClass().getSimpleName(), type, insertRunningTime, searchRunningTime);
    }
}
