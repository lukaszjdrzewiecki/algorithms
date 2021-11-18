package sorting;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

import static org.junit.Assert.assertTrue;

public class SortingTest {
    Sorting sorting = new Sorting();

    int[] generateArray(int size) {
        Random rand = new Random();
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = rand.nextInt(100);
        }
        return result;
    }

    public long runTest(int size, Sorting.SortingType sortingType) {
        int[] input = generateArray(size);
        long start = System.currentTimeMillis();
        sorting.sort(input, sortingType);
        long processingTime = System.currentTimeMillis() - start;
        addResult(sortingType.toString(), size, processingTime);
        //System.out.println(String.format("Sorting %s %d, time = %d", sortingType, size, processingTime));
        return processingTime;


    }

    Map<String, TreeMap<Integer, Long>> results = new HashMap<>();

    private void addResult(String type, int size, long time) {
        results.computeIfAbsent(type, k -> new TreeMap<>());
        results.get(type).put(size, time);
    }

    private void printResults() {
        Map.Entry<String, TreeMap<Integer, Long>> firstRow = results.entrySet().iterator().next();
        System.out.printf("%15s\t", "");
        for (Map.Entry<Integer, Long> column : firstRow.getValue().entrySet()) {
            System.out.printf("%6d\t", column.getKey());
        }
        System.out.println();

        for (Map.Entry<String, TreeMap<Integer, Long>> row : results.entrySet()) {
            System.out.printf("%15s\t", row.getKey());
            for (Map.Entry<Integer, Long> column : row.getValue().entrySet()) {
                System.out.printf("%6d\t", column.getValue());
            }
            System.out.println();
        }
    }

    public void runSetOfTests(int minSize, int maxSize, int step) {

        for (int size = minSize; size <= maxSize; size = size + step) {
            runTest(size, Sorting.SortingType.MergeSort);
            runTest(size, Sorting.SortingType.QuickSort);
            runTest(size, Sorting.SortingType.SelectionSort);
            runTest(size, Sorting.SortingType.BoubleSort);
            runTest(size, Sorting.SortingType.InsertionSort);


        }
        printResults();
    }


    @Test
    public void testSorting() {
        runSetOfTests(10000, 100000, 10000);
    }

    @Test
    public void testQuickSort() {
        int[] input = generateArray(10);
        int[] result = sorting.quickSort(input);
        assertTrue(isSorted(result));
    }

    @Test
    public void testBoubleSort() {
        int[] input = generateArray(10);
        int[] result = sorting.boubleSort(input);
        assertTrue(isSorted(result));
    }

    @Test
    public void testSelectionSort() {
        int[] input = generateArray(10);
        int[] result = sorting.selectionSort(input);
        assertTrue(isSorted(result));
    }

    @Test
    public void testInsertionSort() {
        int[] input = generateArray(10);
        int[] result = sorting.insertionSort(input);
        assertTrue(isSorted(result));
    }

    @Test
    public void testMergeSort() {
        int[] input = generateArray(10);
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
