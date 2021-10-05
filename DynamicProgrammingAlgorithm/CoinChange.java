package algorithms.DynamicProgrammingAlgorithm;

import java.util.Arrays;

public class CoinChange {
    public int CoinChangePossibilities(int[] coins,int amount,boolean wantMemo){
        if(wantMemo){
            Integer[][] memo = new Integer[coins.length][amount + 1];
            return helper(0,memo,coins,amount);
        }

        return tabulation(coins, amount);
    }

    private int helper(int index,Integer[][] memo,int[] coins,int amount){
        if(amount == 0)
            return 1;
        else if(index == coins.length || amount < 0)
            return 0;
        else if(memo[index][amount] != null)    
            return memo[index][amount];
        int including = helper(index,memo,coins,amount - coins[index]);
        int excluding = helper(index + 1,memo,coins,amount);
        
        memo[index][amount] = including + excluding;

        return memo[index][amount];
    }

    private int tabulation(int[] coins,int amount){
        int[][] dp = new int[coins.length+1][amount+1];
        dp[0][0] = 1;
        
        for (int i = 1; i <= coins.length; i++) {
            dp[i][0] = 1;
            for (int j = 1; j <= amount; j++) {
                dp[i][j] = dp[i-1][j] + (j >= coins[i-1] ? dp[i][j-coins[i-1]] : 0);
            }
        }
        return dp[coins.length][amount];
    }
    
}
