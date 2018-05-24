package com.caleb.cjh;

import com.caleb.cjh.sort.*;
import com.caleb.cjh.utils.ArrUtil;
import com.caleb.cjh.utils.RunTime;
import org.junit.Test;

public class SortTest {

    static final int ARR_SIZE = 200 * 1000;

    static final int SRC_ARR[] = ArrUtil.generatorArr(ARR_SIZE, 1, 10000);

    static {
        System.out.println("Sorting an array of size " + ARR_SIZE);
    }

    @Test
    public void bubbleSortTest() {
        int arr[] = ArrUtil.cloneArr(SRC_ARR);
        RunTime runTime = RunTime.generatorRunTimeAndstart();
        BubbleSort.ascSort(arr);
        runTime.printRunningTime("use BubbleSort takes ");
    }

    @Test
    public void cocktailSortTest() {
        int arr[] = ArrUtil.cloneArr(SRC_ARR);
        RunTime runTime = RunTime.generatorRunTimeAndstart();
        CocktailSort.ascSort(arr);
        runTime.printRunningTime("use CocktailSort takes ");
    }

    @Test
    public void selectionSortTest() {
        int arr[] = ArrUtil.cloneArr(SRC_ARR);
        RunTime runTime = RunTime.generatorRunTimeAndstart();
        SelectionSort.ascSort(arr);
        runTime.printRunningTime("use SelectionSort takes ");
    }

    @Test
    public void insertionSortTest() {
        int arr[] = ArrUtil.cloneArr(SRC_ARR);
        RunTime runTime = RunTime.generatorRunTimeAndstart();
        InsertionSort.ascSort(arr);
        runTime.printRunningTime("use InsertionSort takes ");
    }

    @Test
    public void insertionSortDichotomyTest() {
        int arr[] = ArrUtil.cloneArr(SRC_ARR);
        RunTime runTime = RunTime.generatorRunTimeAndstart();
        InsertionSortDichotomy.ascSort(arr);
        runTime.printRunningTime("use InsertionSortDichotomy takes ");
    }
}
