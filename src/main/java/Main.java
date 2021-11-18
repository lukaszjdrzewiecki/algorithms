import sorting.Sorting;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

public class Main {
    Sorting sorting = new Sorting();
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



    public static void main(String[] args) {
        System.out.println("Algorithms");

        Main sortPerfTest = new Main();
        sortPerfTest.runSetOfTests(10000, 100000, 10000);
    }
}
