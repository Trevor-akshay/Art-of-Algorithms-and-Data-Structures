package algorithms.DynamicProgrammingAlgorithm;

import java.util.Arrays;

public class LongestIncreasingSubsequnce {
    public int LIS(int[] array,boolean wantMemo){
       if(wantMemo) {
            Integer[][] memo = new Integer[array.length][array.length + 1];
            return helper(0,memo,array,-1);
       }
       return dp(array);
    }
    private int helper(int index,Integer[][] memo,int[] array,int previous){
        if(index == array.length)
            return 0;

        if(previous == -1 || memo[index][previous + 1] == null){
            int included = 0;
            if(previous == -1 || array[index] > array[previous])
                included = 1 + helper(index + 1,memo,array,index);
            int excluded = helper(index + 1,memo,array,previous);
            memo[index][previous + 1] = Math.max(excluded, included);
        }    
        return memo[index][previous + 1];
    }
    // 1 3 5 4 7 
    // 1 3 4 7 , 1 3 5 7
    // [1 2 3 3 4]
    private int dp(int[] array){
        int[] dp = new int[array.length];
        Arrays.fill(dp, 1);
        int max = 1;
        for(int i = 1;i<dp.length;i++){
            for(int j = 0;j<i;j++){
                if(array[j] < array[i]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    max = Math.max(dp[i],max);
                }
            }
        }    
        System.out.println(Arrays.toString(dp));
        return max;
    }
    
}
