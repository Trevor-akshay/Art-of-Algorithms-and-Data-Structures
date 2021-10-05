package algorithms.StringAlgorithms;

import java.util.ArrayList;
import java.util.List;

public class KMP {
    int[] dp;
    public List<Integer> KMP(String text, String pattern){
        List<Integer> result = new ArrayList<>();
        dp = new int[pattern.length()];
        buildTable(pattern);

        for(int i = 0,j = 0;i<text.length();){
            if(text.charAt(i) == pattern.charAt(j)){
                j++;
                i++;
            }else{
                j = j == 0 ? 0 : dp[j - 1];
                i++;
            }
            if(j == pattern.length()){
                result.add(i - j);
                j = dp[j - 1];
            }
        }
        return result;
    }

    private void buildTable(String pattern){
        int patternPointer = 1;
        int length = 0;
        while (patternPointer < dp.length){
            if(pattern.charAt(patternPointer) == pattern.charAt(length)){
                length++;
                dp[patternPointer++] = length;
            }else{
                if(length != 0)
                    length = dp[length - 1];
                else{
                    dp[patternPointer++] = length;
                }
            }
        }
    }
}
