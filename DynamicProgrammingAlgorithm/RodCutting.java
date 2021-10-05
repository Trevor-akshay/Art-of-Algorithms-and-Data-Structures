package algorithms.DynamicProgrammingAlgorithm;

import java.util.Arrays;

public class RodCutting {
    public int calculateMaxPriceOfRot(int[] length,int[] prices,int rodLength,boolean wantMemo){
        if(wantMemo){
            Integer[][] memo = new Integer[prices.length][rodLength + 1];
            return helper(0, memo, prices, length, rodLength);
        }
        int[][] dp = new int[length.length][rodLength + 1];

        for(int i = 0;i<dp.length;i++){
            for(int j = 1;j<dp[0].length;j++){
                int p1 = 0;
                int p2 = 0;
                if(i > 0)
                    p1 = dp[i-1][j];
                if(length[i] <= j)
                    p2 = prices[i] + dp[i][j - length[i]];    
                dp[i][j] = Math.max(p1,p2);
            }
        }
        
        return dp[dp.length-1][rodLength];
    }

    private int helper(int index,Integer[][] memo,int[] prices,int[] length,int rodLength){
        if(rodLength <= 0 || index == prices.length)
            return 0;
        if(memo[index][rodLength] == null){
            int p1 = 0;
            if(length[index] <= rodLength)
                p1 = prices[index] + helper(index,memo,prices,length,rodLength - length[index]);
            int p2 = helper(index + 1,memo,prices,length,rodLength);

            memo[index][rodLength] = Math.max(p1,p2);
        }    

        return memo[index][rodLength];
    }
    
}
