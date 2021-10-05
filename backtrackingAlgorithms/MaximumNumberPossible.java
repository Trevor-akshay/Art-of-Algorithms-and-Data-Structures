package algorithms.backtrackingAlgorithms;

public class MaximumNumberPossible {
    public String findMaxNumberWithKSwaps(String num,int k) {
        StringBuilder s = new StringBuilder(num);
        for(int i = 0;i<num.length() && k>0;i++){
            int x = Character.getNumericValue(s.charAt(i));
            int max = Integer.MIN_VALUE;
            int index = -1;
            for(int j = i+1;j<num.length();j++){
                int y = Character.getNumericValue(s.charAt(j));
                if(y > x && y > max){
                    max = y;
                    index = j;
                }
            }
            if(index != -1){
                char c = (char)(x + '0');
                char cc = (char)(max + '0');
                s.setCharAt(i, cc);
                s.setCharAt(index,c);
                k--;
            }
        }
        return s.toString();
    }


}
