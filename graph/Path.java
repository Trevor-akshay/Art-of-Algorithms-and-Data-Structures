package com.algo.graph;

import java.util.ArrayList;
import java.util.List;

public class Path { // to return the shortest path in Dijkstra
    List<String> path;

    Path(){
        path = new ArrayList<>();
    }

    public void add(String vertex){
        path.add(vertex);
    }

    @Override
    public String toString() {
        return path.toString();
    }
}
