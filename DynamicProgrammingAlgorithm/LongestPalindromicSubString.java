package algorithms.DynamicProgrammingAlgorithm;

public class LongestPalindromicSubString {
    Integer[][] memo;
    public int LPS(String s){
        memo = new Integer[s.length()][s.length()];
        return helper(0,s.length()-1,s);
    }

    private int helper(int i,int j,String s){
        if(i == j)
            return 1;
        if(i > j)
            return 0;

        if(memo[i][j] == null) {
            if (isPalindrome(s,i,j))
                return j - i + 1;

            int p1 = helper(i + 1, j, s);
            int p2 = helper(i, j - 1, s);
            memo[i][j] = Math.max(p1,p2);
        }
        return memo[i][j];
    }

    private boolean isPalindrome(String s,int i,int j){
        while (i < j){
            if(s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}
