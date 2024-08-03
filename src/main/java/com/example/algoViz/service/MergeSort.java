package com.example.algoViz.service;

import org.springframework.stereotype.Service;

@Service
public class MergeSort {

    public int[][] sort(int[] array) {
        int[][] steps = new int[1000][array.length]; // Adjust the size based on expected steps
        int[] stepIndex = {0};
        mergeSort(array, 0, array.length - 1, steps, stepIndex);
        return steps;
    }

    private void mergeSort(int[] array, int left, int right, int[][] steps, int[] stepIndex) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(array, left, mid, steps, stepIndex);
            mergeSort(array, mid + 1, right, steps, stepIndex);
            merge(array, left, mid, right, steps, stepIndex);
        }
    }

    private void merge(int[] array, int left, int mid, int right, int[][] steps, int[] stepIndex) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        System.arraycopy(array, left, L, 0, n1);
        System.arraycopy(array, mid + 1, R, 0, n2);

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                array[k] = L[i];
                i++;
            } else {
                array[k] = R[j];
                j++;
            }
            steps[stepIndex[0]++] = array.clone();
            k++;
        }

        while (i < n1) {
            array[k] = L[i];
            steps[stepIndex[0]++] = array.clone();
            i++;
            k++;
        }

        while (j < n2) {
            array[k] = R[j];
            steps[stepIndex[0]++] = array.clone();
            j++;
            k++;
        }
    }
}

