package com.example.algoViz.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class BubbleSort {

    public int[][] sort(int[] array) {
        List<int[]> steps = new ArrayList<>();
        int n = array.length;
        int[] arrCopy = Arrays.copyOf(array, n);

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arrCopy[j] > arrCopy[j + 1]) {
                    int temp = arrCopy[j];
                    arrCopy[j] = arrCopy[j + 1];
                    arrCopy[j + 1] = temp;
                    steps.add(Arrays.copyOf(arrCopy, arrCopy.length));
                }
            }
        }
        return convertStepsToArray(steps);
    }

    private int[][] convertStepsToArray(List<int[]> steps) {
        int[][] stepsArray = new int[steps.size()][];
        for (int i = 0; i < steps.size(); i++) {
            stepsArray[i] = steps.get(i);
        }
        return stepsArray;
    }
}
