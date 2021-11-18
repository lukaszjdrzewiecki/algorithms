package sorting;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

import static org.junit.Assert.assertTrue;

public class SortingTest {

    Sorting sorting = new Sorting();
    int[] input = {2, 4, 1, 0};

    @Test
    public void testQuickSort() {

        int[] result = sorting.quickSort(input);
        assertTrue(isSorted(result));
    }

    @Test
    public void testBoubleSort() {
        int[] result = sorting.boubleSort(input);
        assertTrue(isSorted(result));
    }

    @Test
    public void testSelectionSort() {
        int[] result = sorting.selectionSort(input);
        assertTrue(isSorted(result));
    }

    @Test
    public void testInsertionSort() {
        int[] result = sorting.insertionSort(input);
        assertTrue(isSorted(result));
    }

    @Test
    public void testMergeSort() {
        int[] result = sorting.mergeSort(input);
        assertTrue(isSorted(result));
    }

    boolean isSorted(int[] array) {
        for (int i = 0; i < array.length - 1; ++i) {
            if (array[i] > array[i + 1])
                return false;
        }
        return true;
    }
}
