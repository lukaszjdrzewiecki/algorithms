package sorting;

import java.util.List;
import java.util.stream.Collectors;

public class Sorting {

    public enum SortingType {
        SelectionSort, BoubleSort, MergeSort, QuickSort, InsertionSort;
    }

    public int[] sort(final int[] input, SortingType type) {
        switch (type) {
            case SelectionSort:
                return selectionSort(input);
            case BoubleSort:
                return boubleSort(input);
            case QuickSort:
                return quickSort(input);
            case InsertionSort:
                return insertionSort(input);
            case MergeSort:
                return mergeSort(input);
            default:
                throw new RuntimeException("Selection type " + type + "not defined");
        }
    }

    public int[] mergeSort(int[] input) {
        return mergeSort(input, input.length);
    }

    public int[] mergeSort(int[] input, int n) {
        if (n < 2) {
            return input;
        }
        int mid = n / 2;
        int[] l = new int[mid];
        int[] r = new int[n - mid];

        for (int i = 0; i < mid; i++) {
            l[i] = input[i];
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = input[i];
        }
        mergeSort(l, mid);
        mergeSort(r, n - mid);

        merge(input, l, r, mid, n - mid);
        return input;
    }

    public void merge(
            int[] a, int[] l, int[] r, int left, int right) {

        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                a[k++] = l[i++];
            } else {
                a[k++] = r[j++];
            }
        }
        while (i < left) {
            a[k++] = l[i++];
        }
        while (j < right) {
            a[k++] = r[j++];
        }
    }

    List<Number> stremSorted(List<Integer> input) {
        return input.stream().sorted().collect(Collectors.toList());
    }

    public int[] insertionSort(int[] input) {
        for (int i = 1; i < input.length; i++) {
            int key = input[i];
            int j = i - 1;
            while (j >= 0 && input[j] > key) {
                input[j + 1] = input[j];
                j = j - 1;
            }
            input[j + 1] = key;
        }
        return input;
    }

    public int[] selectionSort(final int[] input) {
        for (int i = 0; i < input.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < input.length; j++) {
                if (input[minIndex] > input[j]) {
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                swap(input, i, minIndex);
            }
        }
        return input;
    }

    public int[] boubleSort(final int[] input) {
        for (int i = 0; i < input.length - 1; i++) {
            for (int j = i + 1; j < input.length; j++) {
                if (input[i] > input[j]) {
                    swap(input, i, j);
                }
            }
        }
        return input;
    }

    public int[] quickSort(int[] input) {
        return quickSort(input, 0, input.length - 1);
    }

    public int[] quickSort(int[] input, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(input, begin, end);

            quickSort(input, begin, partitionIndex - 1);
            quickSort(input, partitionIndex + 1, end);
        }
        return input;
    }

    private int partition(int[] array, int begin, int end) {
        int pivot = array[end];
        int i = (begin - 1);

        for (int j = begin; j < end; j++) {
            if (array[j] <= pivot) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, end);
        return i + 1;
    }


    private void swap(int[] array, int i, int j) {
        int swapTemp = array[i];
        array[i] = array[j];
        array[j] = swapTemp;
    }
}
