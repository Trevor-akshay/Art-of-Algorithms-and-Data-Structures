package algorithms.generalAlgorithms;

public class DivideTwoNumbers {
    public int divideNumbers(int dividend,int divisor){
        int sign = 1;
        if(dividend < 0 && divisor < 0)
            sign = 1;
        else if(dividend < 0 || divisor < 0)
            sign = -1;

        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        int quotient = 0;

        while (dividend >= divisor){
            dividend -= divisor;
            quotient++;
        }

        return quotient * sign;
    }
}
