package algorithms.DynamicProgrammingAlgorithm;

import java.util.Arrays;

public class CountSubsetSum {
    public int countSubsetSum(int[] elements,int target){
        Integer[][] memo = new Integer[elements.length][target + 1];
        return helper(0,memo,elements,target);
    }

    private int helper(int index,Integer[][] memo,int[] elements,int target){
        if(target == 0)
            return 1;
        else if(target < 0 || index == elements.length)
            return 0;
        else if(memo[index][target] != null)
            return memo[index][target];
            
        int count1 = helper(index+1, memo, elements, target - elements[index]);
        int count2 = helper(index+1,memo,elements,target);
        
        memo[index][target] = count1 + count2;
        System.out.println(Arrays.deepToString(memo));

        return memo[index][target];
    }
    
}
