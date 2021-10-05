package algorithms.graphAlgorithms;

import java.util.ArrayDeque;
import java.util.Queue;

public class LeeShortestPathMaze {
    private class Node{
        int x;
        int y;
        int distance;

        public Node(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }

        @Override
        public String toString() {
            return "Node{" + "x=" + x + ", y=" + y + ", distance=" + distance + '}';
        }
    }

    // left top right and bottom respectively
    static private final int[] XDIRECTION = {0,-1,0,1};
    static private final int[] YDIRECTION = {-1,0,1,0};

    int[][] maze;
    int N;
    int M;
    public LeeShortestPathMaze(int[][] maze){
        this.maze = maze;
        N = maze.length;
        M = maze[0].length;
    }

    public int shortestDistanceSourceToDestination(int[] source,int[] destination){
        boolean[][] visited = new boolean[N][M];
        return helper(visited,source[0],source[1],destination[0],destination[1]);
    }

    private int helper(boolean[][] visited,int row,int col,int destRow,int destCol){
        visited[row][col] = true;
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(row,col,0));
        while (!queue.isEmpty()){
            var tempDistance = queue.poll();
            row = tempDistance.x;
            col = tempDistance.y;
            if(row == destRow && col == destCol){
                return tempDistance.distance;
            }
            for(int i = 0;i<4;i++){
                int newRow = row + XDIRECTION[i];
                int newCol = col + YDIRECTION[i];
                if(isValid(newRow,newCol,visited)){
                    visited[newRow][newCol] = true;
                    queue.offer(new Node(newRow,newCol,tempDistance.distance+1));
                }
            }
        }
        return -1;
    }

    private boolean isValid(int row,int col,boolean[][] visited){
        return row >= 0 && row < N && col >= 0 && col < M &&
                !visited[row][col] && maze[row][col] == 1;
    }

}
