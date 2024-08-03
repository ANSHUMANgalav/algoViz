package com.example.algoViz.controller;

import com.example.algoViz.service.AlgorithmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/algorithm")
@CrossOrigin(origins = "http://localhost:3000")
public class AlgorithmController {

    @Autowired
    private AlgorithmService algorithmService;

    @GetMapping("/bubbleSort")
    public int[][] bubbleSort(@RequestParam int[] array) {
        return algorithmService.bubbleSort(array);
    }

    @GetMapping("/mergeSort")
    public int[][] mergeSort(@RequestParam int[] array) {
        return algorithmService.mergeSort(array);
    }

    @GetMapping("/quickSort")
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

