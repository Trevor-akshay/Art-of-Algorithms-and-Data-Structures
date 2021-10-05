package algorithms.StringAlgorithms;

import java.util.ArrayList;
import java.util.List;

public class RabinKarp {//Rolling hash
    static private final int MULTIPLIER = 19;
    public List<Integer> findAllOccurenceOfPattern(String s, String pattern) {
        s = s.replaceAll("\\s","").toLowerCase();
        pattern = pattern.toLowerCase();

        List<Integer> result = new ArrayList<>();
        int hashCode = buildCode(pattern);
        int tempCode = buildCode(s.substring(0,pattern.length()));
        if(hashCode == tempCode && isValid(s,pattern,0))
            result.add(0);

        int leftPointer = 0;
        int rightPointer = pattern.length();

        while (rightPointer < s.length()){
            tempCode -= s.charAt(leftPointer++) * MULTIPLIER;
            tempCode += s.charAt(rightPointer) * MULTIPLIER;
            if(hashCode == tempCode && isValid(s,pattern,leftPointer))
                result.add(leftPointer);
            rightPointer++;
        }

        return result;
    }

    private int buildCode(String pattern){
        int result = 0;
        for(int i = 0;i<pattern.length();i++)
            result += pattern.charAt(i) * MULTIPLIER;

        return result;
    }

    private boolean isValid(String s,String pattern,int sPointer){
        if(s.length() - sPointer < pattern.length())
            return false;

        int patternPointer = 0;
        while(patternPointer < pattern.length()){
            if(pattern.charAt(patternPointer) != s.charAt(sPointer))
                return false;
            patternPointer++;
            sPointer++;
        }
        return true;
    }
}
