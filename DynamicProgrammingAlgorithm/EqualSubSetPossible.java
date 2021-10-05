package algorithms.DynamicProgrammingAlgorithm;

import java.util.*;
public class EqualSubSetPossible {
    public boolean checksubset(int[] elements){
        int sum = Arrays.stream(elements).sum();
        if((sum & 1) == 1)
            return false;
        int capacity = sum / 2;
        boolean[][] dp = new boolean[elements.length][capacity + 1];
        for(int row = 0;row<dp.length;row++)
            dp[row][0] = true;
        for(int col = 1;col<dp[0].length;col++)
            dp[0][col] = elements[0] == col;    

        for(int i = 1;i<dp.length;i++){
            for(int j = 1;j<dp[0].length;j++){
                dp[i][j] = dp[i-1][j] || dp[i-1][j - elements[i]];
            }
        }    
        for(var d : dp)    
        System.out.println(Arrays.toString(d));    

        return dp[dp.length-1][dp[0].length-1];
    }
}
