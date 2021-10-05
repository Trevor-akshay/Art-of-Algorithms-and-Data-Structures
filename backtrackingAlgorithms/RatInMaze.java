package algorithms.backtrackingAlgorithms;

import java.util.Arrays;

public class RatInMaze {
    // considered 1 = valid path , 0 = invalid path
    int[][] maze;
    int n;
    int m;
    int[][] resultPath;
    public RatInMaze(int[][] maze){
        n = maze.length;
        m = maze[0].length;
        this.maze = maze;
        resultPath = new int[n][m];
    }

    static final int[][] DIRECTIONS = {{-1,0},{1,0},{0,-1},{0,1}};
    public void solve(){
        if(maze[0][0] == 0 || maze[n-1][m-1] == 0)
            System.out.println("No path");
        else if(helper(0,0))
            printPath();
        else
            System.out.println("No Path");
    }

    private boolean helper(int i,int j){
        resultPath[i][j] = 1;
        if(i == n-1 && j == m-1)
            return true;
        maze[i][j] = 0;
        for(int k = 0;k<4;k++){
            int x = i + DIRECTIONS[k][0];
            int y = j + DIRECTIONS[k][1];
            if(isValid(x,y)){
                if(helper(x,y))
                    return true;
                else{
                    maze[x][y] = 1;
                    resultPath[x][y] = 0;
                }
            }
        }
        return false;
    }
    private boolean isValid(int i,int j){
        return i >= 0 && j >=0 && i < n && j < m && maze[i][j] == 1;
    }

    private void printPath(){
        for(var inner : resultPath){
            System.out.println(Arrays.toString(inner));
        }
    }
}
