package algorithms.StringAlgorithms;

import java.util.*;
public class NaivePatternMatching {
    public List<Integer> findAllOccurenceOfPattern(String s,String pattern){
        int sPointer = 0;
        List<Integer> result = new ArrayList<>();
        while(sPointer < s.length()){
            if(s.charAt(sPointer) == pattern.charAt(0) && isValid(s,pattern,sPointer))
                result.add(sPointer);
            sPointer++;
        }

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
