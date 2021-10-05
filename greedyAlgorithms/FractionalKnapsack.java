package algorithms.greedyAlgorithms;

import java.util.Arrays;

public class FractionalKnapsack {
    int[][] products;
    int totalWeight;
    public FractionalKnapsack(int totalWeight,int[][] products){
        this.totalWeight = totalWeight;
        this.products = products;
    }
    //products[0] = profit && products[1] = weight
    public double getMaximumProfit(){
        double maximum = 0;
        Arrays.sort(products,(a,b) -> (b[0] / b[1]) - (a[0]/a[1]));

        for(var product : products){
            if(totalWeight >= product[1])
                maximum += product[0];
            else{
                double fractionalProfit = (double)product[0] / (double)product[1];
                maximum += fractionalProfit * totalWeight;
                break;
            }
            totalWeight -= product[1];
        }

        return maximum;
    }
}
