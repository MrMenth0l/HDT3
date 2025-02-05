package org.example;import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Arrays;

public class SortingAlgosTest {

    @Test
    public void testInsertionSort() {
        Integer[] arr = {5, 2, 9, 1, 5, 6};
        Integer[] exp = {1, 2, 5, 5, 6, 9};
        SortingAlgorithms.insertionSort(arr);
        assertArrayEquals(exp, arr);
    }

    @Test
    public void testMergeSort() {
        Integer[] arr = {3, 7, 4, 9, 5, 2, 6, 1};
        Integer[] exp = {1, 2, 3, 4, 5, 6, 7, 9};
        SortingAlgorithms.mergeSort(arr);
        assertArrayEquals(exp, arr);
    }

    @Test
    public void testQuickSort() {
        Integer[] arr = {10, 7, 8, 9, 1, 5};
        Integer[] exp = {1, 5, 7, 8, 9, 10};
        SortingAlgorithms.quickSort(arr);
        assertArrayEquals(exp, arr);
    }

    @Test
    public void testRadixSort() {
        Integer[] arr = {170, 45, 75, 90, 802, 24, 2, 66};
        Integer[] exp = {2, 24, 45, 66, 75, 90, 170, 802};
        SortingAlgorithms.radixSort(arr);
        assertArrayEquals(exp, arr);
    }

    @Test
    public void testBucketSort() {
        Integer[] arr = {42, 32, 33, 52, 37, 47, 51};
        Integer[] exp = {32, 33, 37, 42, 47, 51, 52};
        SortingAlgorithms.bucketSort(arr);
        assertArrayEquals(exp, arr);
    }

    @Test
    public void testHeapSort() {
        Integer[] arr = {12, 11, 13, 5, 6, 7};
        Integer[] exp = {5, 6, 7, 11, 12, 13};
        SortingAlgorithms.heapSort(arr);
        assertArrayEquals(exp, arr);
    }
}
