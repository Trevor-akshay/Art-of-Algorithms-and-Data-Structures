package algorithms.DynamicProgrammingAlgorithm;

import java.util.Arrays;

public class KnapSack {
    /*
        Calculate max profit using dp;
        dp , ROW = Elements to consider;
        dp , COL = Increasing capacity upto max;
    */

    public int solve01KnapSack(int[] profit,int[] weight,int capacity){
        int[][] dp = new int[profit.length][capacity + 1];
        return tabularBuilder(dp,profit,weight,capacity);
    }

    private int tabularBuilder(int[][] dp,int[] profit,int[] weight,int capacity){
        for(int col = 0;col < dp[0].length;col++){
            if(col >= weight[0])
                dp[0][col] = profit[0];
        }
        for(int i = 1;i<dp.length;i++){
            for(int j = 1;j<dp[0].length;j++){
                if(weight[i] > j)
                    dp[i][j] = dp[i-1][j];
                else                    
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j - weight[i]] + profit[i]);
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return dp[dp.length-1][dp[0].length-1];
    }
    
}
