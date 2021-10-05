package algorithms.backtrackingAlgorithms;
import java.util.*;

public class AllValidParenthesis {
    public Set<String> removeInvalidParentheses(String s) {
        Set<String> list = new HashSet<>();
        StringBuilder temp = new StringBuilder(s);
        helper(temp,0,list);

        return list;
    }

    private void helper(StringBuilder s,int index,Set<String> list){
        for(int i = index;i<s.length();i++){
            char c = s.charAt(i);
            s.deleteCharAt(i);
            if(isValid(s.toString())){
                list.add(s.toString());
            }
            helper(s,i+1,list);
            s.insert(i,c);
        }
    }

    private boolean isValid(String s){
        int count = 0;
        for(char c : s.toCharArray()){
            count = c == '(' ? count + 1 : c == ')' ? count - 1 : count;
            if(count < 0)
                return false;
        }

        return count == 0;
    }
}
