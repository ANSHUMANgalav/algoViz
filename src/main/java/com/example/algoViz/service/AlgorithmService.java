package com.example.algoViz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlgorithmService {

    @Autowired
    private BubbleSort bubbleSort;

    @Autowired
    private MergeSort mergeSort;

    @Autowired
    private QuickSort quickSort;
//
//    @Autowired
//    private AStar aStar;
//
//    @Autowired
//    private Dijkstra dijkstra;

    public int[][] bubbleSort(int[] array) {
        return bubbleSort.sort(array);
    }

    public int[][] mergeSort(int[] array) {
        return mergeSort.sort(array);
    }

    public int[][] quickSort(int[] array) {
        return quickSort.sort(array);
    }

//    public int[][] aStar(int[][] grid, int[] start, int[] goal) {
//        return aStar.findPath(grid, start, goal);
//    }
//
//    public int[][] dijkstra(int[][] graph, int source) {
//        return dijkstra.findShortestPaths(graph, source);
//    }
}
