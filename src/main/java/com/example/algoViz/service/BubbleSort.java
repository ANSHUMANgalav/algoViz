package com.example.algoViz.service;
import org.springframework.stereotype.Service;

@Service
public class BubbleSort {

    public int[][] sort(int[] array) {
        int n = array.length;
        int[][] steps = new int[n * (n - 1) / 2][n];
        int stepIndex = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
                steps[stepIndex++] = array.clone();
            }
        }
        return steps;
    }
}

