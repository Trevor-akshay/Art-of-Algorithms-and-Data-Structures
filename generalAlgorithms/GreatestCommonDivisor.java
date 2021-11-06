package algorithms.generalAlgorithms;

public class GreatestCommonDivisor {
    /**
     * Method to return GCD of two numbers in O(log(N))
     * @param x -> smaller number
     * @param y -> greater number
     * @return -> GCD
     */
    public int GCD(int x,int y){
        if(x > y)
            return GCD(y,x);
        else if(x == 0)
            return y;
        return GCD(y % x,x);
    }

    public int GCD_array(int[] A){
        int result = A[0];
        for(int i = 1;i<A.length;i++){
            result = GCD(result,A[i]);
        }
        return result;
    }
}
