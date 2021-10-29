package algorithms.generalAlgorithms;

public class SQRT {
    public float sqrt(int x,int precision){
        int left = 1,
              right = x;

        double result = 0.0;
        while(left <= right){
            long mid = left + (right - left) / 2;
            long product = mid * mid;
            if(product == x)
                return product;
            else if(product > x)
                right = (int)mid - 1;
            else {
                result = mid;
                left = (int)mid + 1;
            }
        }
        double temp = 0.1;
        for(int i = 0;i<precision;i++){
            while (result * result <= x){
                result += temp;
            }
            result -= temp;
            temp /= 10;
        }

        // why float ? to match upto the precision
        return (float) result;
    }
}
