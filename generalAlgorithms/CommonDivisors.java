package algorithms.generalAlgorithms;

public class CommonDivisors {
    public int getCommonDivisors(int a,int b){
        int gcd = GCD(a,b);
        int commonDivisors = 0;

        for(int i = 1;i<=gcd;i++){
            if(gcd % i == 0)
                ++commonDivisors;
        }

        return commonDivisors;
    }

    private int GCD(int a,int b){
        if(b > a)
            return GCD(b,a);
        if(b == 0)
            return a;
        return GCD(b,a % b);
    }
}
