package com.example.algoViz.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class MergeSort {

    public int[][] sort(int[] array) {
        List<int[]> steps = new ArrayList<>();
        if (array != null && array.length > 0) {
            int[] arrCopy = Arrays.copyOf(array, array.length);
            mergeSortHelper(arrCopy, 0, arrCopy.length - 1, steps);
        }
        return convertStepsToArray(steps);
    }

    private void mergeSortHelper(int[] array, int left, int right, List<int[]> steps) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSortHelper(array, left, mid, steps);
            mergeSortHelper(array, mid + 1, right, steps);
            merge(array, left, mid, right, steps);
        }
    }

    private void merge(int[] array, int left, int mid, int right, List<int[]> steps) {
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
            steps.add(Arrays.copyOf(array, array.length));
            k++;
        }

        while (i < n1) {
            array[k] = L[i];
            i++;
            k++;
            steps.add(Arrays.copyOf(array, array.length));
        }

        while (j < n2) {
            array[k] = R[j];
            j++;
            k++;
            steps.add(Arrays.copyOf(array, array.length));
        }
    }

    private int[][] convertStepsToArray(List<int[]> steps) {
        int[][] stepsArray = new int[steps.size()][];
        for (int i = 0; i < steps.size(); i++) {
            stepsArray[i] = steps.get(i);
        }
        return stepsArray;
    }
}
