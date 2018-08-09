package com.caleb.sort;

import com.caleb.core.utils.ArrUtils;
import com.caleb.core.utils.RunningTime;
import com.caleb.core.utils.TextTable;
import com.caleb.sort.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class SortTest {

    static final int ARR_SIZE = 10 * 1000;

    int srcArr[] = null;

    SortInterface[] sortInterfaces = null;

    // 显示表格的列名称
    List<String> columnNameList;
    // 显示表格的数据
    List<List<String>> columnValueList;

    @Before
    public void before() {
        initArr();
        sortInterfaces = new SortInterface[]{
                new BubbleSort(),
                new CocktailSort(),
                new InsertionSort(),
                new InsertionSortDichotomy(),
                new SelectionSort()
        };
        initConsole();
    }

    void initArr() {
        srcArr = ArrUtils.generatorRandomArr(ARR_SIZE, 1, 10000);
        System.out.println("Sorting an array of size " + ARR_SIZE);
    }

    void initConsole() {
        columnNameList = new ArrayList<String>();
        columnValueList = new ArrayList<List<String>>();
        columnNameList.add("/");
        columnNameList.add("class");
        columnNameList.add("len");
        columnNameList.add("sorting");
    }

    void insertData(int size, String type, String sortRunningTime) {
        List<String> value = new ArrayList<String>();
        value.add((columnValueList.size() + 1) + "");
        value.add(type);
        value.add(size + "");
        value.add(sortRunningTime);
        columnValueList.add(value);
    }

    @Test
    public void sortTest() {
        RunningTime running = RunningTime.generator();
        for (SortInterface sortInterface : sortInterfaces) {
            int arr[] = ArrUtils.cloneArr(srcArr);
            running.reComplete();
            sortInterface.ascSort(arr);
            insertData(arr.length, sortInterface.getClass().getSimpleName(), running.getFormatTime());
        }
        TextTable textTable = new TextTable(columnNameList, columnValueList);
        System.out.println(textTable.printTable());
    }
}
