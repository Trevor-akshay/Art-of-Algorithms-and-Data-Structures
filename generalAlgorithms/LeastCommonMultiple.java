package algorithms.generalAlgorithms;

public class LeastCommonMultiple {
    /**
     * Method to return LCM of two numbers
     * @param x -> first parameter
     * @param y -> second parameter
     * @return LCM of x and y
     */
    public int LCM(int x,int y){
        return (x * y) / GCD(x,y);
    }

    public int LCM_array(int[] A){
        int result = A[0];
        for(int i = 1;i<A.length;i++){
            result = LCM(result,A[i]);
        }

        return result;
    }

    private int GCD(int x,int y){
        if(x > y)
            return GCD(y,x);
        else if(x == 0)
            return y;
        return GCD(y % x,x);
    }
}
