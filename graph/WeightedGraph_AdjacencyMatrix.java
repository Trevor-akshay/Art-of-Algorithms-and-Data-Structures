package com.datastructures.graph;

import java.util.Arrays;

public class WeightedGraph_AdjacencyMatrix {
    int[][] adjacencyMatrix;
    public WeightedGraph_AdjacencyMatrix(int row){
        adjacencyMatrix = new int[row][row];
        for(int i=0;i<row;i++){
            for(int j = 0;j<row;j++){
                adjacencyMatrix[i][j] = i == j ? 0 : 99999;
            }
        }
    }
    public void addEdge(int i,int j,int weight){
        adjacencyMatrix[i-1][j-1] = weight;
    }

    public void floydWarshallAlgorithm(){
        int n = adjacencyMatrix.length;
        int[][] shortestPathBuiltMatrix = new int[n][n];

        for (int i = 0;i<n;i++) {
            for(int j = 0;j<n;j++){
                shortestPathBuiltMatrix[i][j] = adjacencyMatrix[i][j];
            }
        }

        for(int k = 0 ;k<n;k++){
            for(int i = 0;i<n;i++){
                for(int j = 0;j<n;j++){
                 int sum = shortestPathBuiltMatrix[i][k] + shortestPathBuiltMatrix[k][j];
                    if(shortestPathBuiltMatrix[i][j] > sum)
                        shortestPathBuiltMatrix[i][j] = sum;
                }
            }
        }
        System.out.println(Arrays.deepToString(shortestPathBuiltMatrix));
    }

    public void printMatrix(){
        for (int[] matrix : adjacencyMatrix) {
            for (int j = 0; j < adjacencyMatrix[0].length; j++) {
                System.out.print(matrix[j] + "  ");
            }
            System.out.println();
        }
    }
}
