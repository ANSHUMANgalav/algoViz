package com.example.algoViz.service;

import org.springframework.stereotype.Service;

@Service
public class QuickSort {

    public int[][] sort(int[] array) {
        int[][] steps = new int[1000][array.length]; // Adjust the size based on expected steps
        int[] stepIndex = {0};
        quickSort(array, 0, array.length - 1, steps, stepIndex);
        return steps;
    }

    private void quickSort(int[] array, int low, int high, int[][] steps, int[] stepIndex) {
        if (low < high) {
            int pi = partition(array, low, high, steps, stepIndex);
            quickSort(array, low, pi - 1, steps, stepIndex);
            quickSort(array, pi + 1, high, steps, stepIndex);
        }
    }

    private int partition(int[] array, int low, int high, int[][] steps, int[] stepIndex) {
        int pivot = array[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                steps[stepIndex[0]++] = array.clone();
            }
        }
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        steps[stepIndex[0]++] = array.clone();
        return i + 1;
    }
}
