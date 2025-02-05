package org.example;

import java.util.*;

import java.util.*;

public class SortingAlgos {

    public static <T extends Comparable<T>> void insertionSort(T[] arr) {
        for (int i = 1; i < arr.length; i++) {
            T key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j].compareTo(key) > 0) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    public static <T extends Comparable<T>> void mergeSort(T[] arr) {
        if (arr == null || arr.length < 2) return;
        T[] aux = arr.clone();
        mergeSort(arr, aux, 0, arr.length - 1);
    }

    private static <T extends Comparable<T>> void mergeSort(T[] arr, T[] aux, int low, int high) {
        if (low >= high) return;
        int mid = low + (high - low) / 2;
        mergeSort(arr, aux, low, mid);
        mergeSort(arr, aux, mid + 1, high);
        merge(arr, aux, low, mid, high);
    }

    private static <T extends Comparable<T>> void merge(T[] arr, T[] aux, int low, int mid, int high) {
        for (int i = low; i <= high; i++) {
            aux[i] = arr[i];
        }
        int i = low, j = mid + 1;
        for (int k = low; k <= high; k++) {
            if (i > mid) arr[k] = aux[j++];
            else if (j > high) arr[k] = aux[i++];
            else if (aux[i].compareTo(aux[j]) <= 0) arr[k] = aux[i++];
            else arr[k] = aux[j++];
        }
    }

    public static <T extends Comparable<T>> void quickSort(T[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static <T extends Comparable<T>> void quickSort(T[] arr, int low, int high) {
        if (low < high) {
            int p = partition(arr, low, high);
            quickSort(arr, low, p - 1);
            quickSort(arr, p + 1, high);
        }
    }

    private static <T extends Comparable<T>> int partition(T[] arr, int low, int high) {
        T pivot = arr[high];
        int i = low;
        for (int j = low; j < high; j++) {
            if (arr[j].compareTo(pivot) <= 0) {
                T temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
            }
        }
        T temp = arr[i];
        arr[i] = arr[high];
        arr[high] = temp;
        return i;
    }

    public static void radixSort(Integer[] arr) {
        if (arr == null || arr.length == 0) return;
        int max = Arrays.stream(arr).max(Integer::compareTo).orElse(0);
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(arr, exp);
        }
    }

    private static void countingSort(Integer[] arr, int exp) {
        int n = arr.length;
        Integer[] output = new Integer[n];
        int[] count = new int[10];
        for (int i = 0; i < n; i++) {
            count[(arr[i] / exp) % 10]++;
        }
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }
        for (int i = n - 1; i >= 0; i--) {
            int idx = (arr[i] / exp) % 10;
            output[count[idx] - 1] = arr[i];
            count[idx]--;
        }
        System.arraycopy(output, 0, arr, 0, n);
    }

    public static void bucketSort(Integer[] arr) {
        if (arr == null || arr.length == 0) return;
        int min = Arrays.stream(arr).min(Integer::compareTo).orElse(0);
        int max = Arrays.stream(arr).max(Integer::compareTo).orElse(0);
        int bucketCount = arr.length;
        ArrayList<ArrayList<Integer>> buckets = new ArrayList<>(bucketCount);
        for (int i = 0; i < bucketCount; i++) {
            buckets.add(new ArrayList<>());
        }
        for (Integer num : arr) {
            int bucketIndex = (int) (((long)(num - min) * bucketCount) / (max - min + 1));
            buckets.get(bucketIndex).add(num);
        }
        int index = 0;
        for (ArrayList<Integer> bucket : buckets) {
            Collections.sort(bucket);
            for (Integer num : bucket) {
                arr[index++] = num;
            }
        }
    }

    public static <T extends Comparable<T>> void heapSort(T[] arr) {
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
        for (int i = n - 1; i >= 0; i--) {
            T temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i, 0);
        }
    }

    private static <T extends Comparable<T>> void heapify(T[] arr, int n, int i) {
        int largest = i, l = 2 * i + 1, r = 2 * i + 2;
        if (l < n && arr[l].compareTo(arr[largest]) > 0) largest = l;
        if (r < n && arr[r].compareTo(arr[largest]) > 0) largest = r;
        if (largest != i) {
            T temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            heapify(arr, n, largest);
        }
    }
}
