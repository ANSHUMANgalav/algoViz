package com.example.algoViz.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class QuickSort {

    public int[][] sort(int[] array) {
        List<int[]> steps = new ArrayList<>();
        if (array != null && array.length > 0) {
            int[] arrCopy = Arrays.copyOf(array, array.length);
            quickSortHelper(arrCopy, 0, arrCopy.length - 1, steps);
        }
        return convertStepsToArray(steps);
    }

    private void quickSortHelper(int[] array, int low, int high, List<int[]> steps) {
        if (low < high) {
            int pi = partition(array, low, high, steps);
            quickSortHelper(array, low, pi - 1, steps);
            quickSortHelper(array, pi + 1, high, steps);
        }
    }

    private int partition(int[] array, int low, int high, List<int[]> steps) {
        int pivot = array[high];
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                steps.add(Arrays.copyOf(array, array.length));
            }
        }

        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        steps.add(Arrays.copyOf(array, array.length));

        return i + 1;
    }

    private int[][] convertStepsToArray(List<int[]> steps) {
        int[][] stepsArray = new int[steps.size()][];
        for (int i = 0; i < steps.size(); i++) {
            stepsArray[i] = steps.get(i);
        }
        return stepsArray;
    }
}
