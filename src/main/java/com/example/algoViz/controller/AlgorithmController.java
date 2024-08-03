package com.example.algoViz.controller;

import com.example.algoViz.service.AlgorithmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class AlgorithmController {

    @Autowired
    private AlgorithmService algorithmService;

    @GetMapping("/algorithm/bubbleSort")
    public int[][] bubbleSort(@RequestParam int[] array) {
        return algorithmService.bubbleSort(array);
    }

    @GetMapping("/algorithm/mergeSort")
    public int[][] mergeSort(@RequestParam int[] array) {
        return algorithmService.mergeSort(array);
    }

    @GetMapping("/algorithm/quickSort")
    public int[][] quickSort(@RequestParam int[] array) {
        return algorithmService.quickSort(array);
    }

//    @GetMapping("/algorithm/aStar")
//    public int[][] aStar(@RequestParam int[][] grid, @RequestParam int[] start, @RequestParam int[] goal) {
//        return algorithmService.aStar(grid, start, goal);
//    }
//
//    @GetMapping("/algorithm/dijkstra")
//    public int[][] dijkstra(@RequestParam int[][] graph, @RequestParam int source) {
//        return algorithmService.dijkstra(graph, source);
//    }
}

