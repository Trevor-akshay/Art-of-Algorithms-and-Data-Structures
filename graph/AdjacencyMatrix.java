package com.algo.graph;

import java.util.*;

public class AdjacencyMatrix {
    int[][] adjacencyMatrix;
    public AdjacencyMatrix(int vertex){
        adjacencyMatrix = new int[vertex][vertex];
    }

    public void addEdge(int x,int y){
        if(x > adjacencyMatrix.length || y > adjacencyMatrix[0].length)
            throw new IllegalArgumentException();

        adjacencyMatrix[x][y] = 1;
        adjacencyMatrix[y][x] = 1; // if Bi-Directional

    }

    public void removeEdge(int x,int y){
        if(x > adjacencyMatrix.length || y > adjacencyMatrix[0].length)
            throw new IllegalArgumentException();

        adjacencyMatrix[x][y] = 0;
        adjacencyMatrix[y][x] = 0; // if Bi-Directional

    }

    public void print(){
        for(int i = 0;i<adjacencyMatrix.length;i++){
            System.out.print(i + " is connected to  : ");
            for(int j = 0;j<adjacencyMatrix[i].length;j++){
                if(adjacencyMatrix[i][j] == 1){
                    System.out.print(j +" ");
                }
            }
            System.out.println();
        }
    }



}
