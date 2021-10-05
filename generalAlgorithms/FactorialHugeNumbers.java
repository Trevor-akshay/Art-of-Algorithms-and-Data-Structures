package algorithms.generalAlgorithms;

import java.util.Arrays;

public class FactorialHugeNumbers {
    int size = 1;
    public String getFact(int n){
        int[] result = new int[500];
        result[0] = 1;

        for(int i = 2;i<=n;i++){
            multiply(result,i);
        }
        StringBuilder s = new StringBuilder();
        while(size >= 0)
            s.append(result[size--]);

        return s.toString();
    }

    private void multiply(int[] result,int n){
        int carry = 0;
        for(int i = 0;i<=size;i++){
            int value = result[i] * n + carry;
            result[i] = value % 10;
            carry = value / 10;
        }
        while (carry != 0){
            size += 1;
            result[size] = carry % 10;
            carry /= 10;
        }
    }
}
