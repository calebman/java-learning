package com.caleb.cjh;

import com.caleb.cjh.sort.*;
import com.caleb.core.utils.ArrUtil;
import com.caleb.core.utils.RunningTime;
import org.junit.Test;

public class SortTest {

    static final int ARR_SIZE = 10 * 1000;

    static final int SRC_ARR[] = ArrUtil.generatorRandomArr(ARR_SIZE, 1, 10000);

    static {
        System.out.println("Sorting an array of size " + ARR_SIZE);
    }

    @Test
    public void bubbleSortTest() {
        int arr[] = ArrUtil.cloneArr(SRC_ARR);
        RunningTime running = RunningTime.generator();
        BubbleSort.ascSort(arr);
        running.printInfo("use BubbleSort");
    }

    @Test
    public void cocktailSortTest() {
        int arr[] = ArrUtil.cloneArr(SRC_ARR);
        RunningTime running = RunningTime.generator();
        CocktailSort.ascSort(arr);
        running.printInfo("use CocktailSort");
    }

    @Test
    public void selectionSortTest() {
        int arr[] = ArrUtil.cloneArr(SRC_ARR);
        RunningTime running = RunningTime.generator();
        SelectionSort.ascSort(arr);
        running.printInfo("use SelectionSort");
    }

    @Test
    public void insertionSortTest() {
        int arr[] = ArrUtil.cloneArr(SRC_ARR);
        RunningTime running = RunningTime.generator();
        InsertionSort.ascSort(arr);
        running.printInfo("use InsertionSort");
    }

    @Test
    public void insertionSortDichotomyTest() {
        int arr[] = ArrUtil.cloneArr(SRC_ARR);
        RunningTime running = RunningTime.generator();
        InsertionSortDichotomy.ascSort(arr);
        running.printInfo("use InsertionSortDichotomy");
    }
}
