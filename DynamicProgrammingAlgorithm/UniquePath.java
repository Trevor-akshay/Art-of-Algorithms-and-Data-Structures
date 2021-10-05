package algorithms.DynamicProgrammingAlgorithm;

import java.util.Arrays;

public class UniquePath {
    public int uniquePathWithoutObstacles(int n,int m){
        int[][] dp = new int[n][m];
        for(int i = 0;i < n;i++){
            for(int j = 0;j < m;j++){
                if(i == 0 || j == 0)
                    dp[i][j] = 1;
                else
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]) + 1;
            }
        }
        return dp[n-1][m-1];
    }

    public int uniquePathWithObstacles(int[][] grid){
        // 1 = Obstacles , 0 = valid path
        int n = grid.length;
        int m = grid[0].length;
        if(grid[0][0] == 1 || grid[n-1][m-1] == 1)
            return 0;

        int[][] dp = new int[n][m];
        for(int i = 0;i<n;i++){
            if(grid[i][0] == 1)
                break;
            dp[i][0] = 1;
        }

        for(int j = 0;j<m;j++){
            if(grid[0][j] == 1)
                break;
            dp[0][j] = 1;
        }

        for(int i = 1;i<n;i++){
            for(int j = 1;j<m;j++){
                if(grid[i][j] == 1)
                    dp[i][j] = 0;
                else
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        return dp[n-1][m-1];
    }
}
