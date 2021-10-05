package algorithms.greedyAlgorithms;

import java.util.Arrays;
import java.util.HashSet;

public class JobScheduling {
    int[][] jobProfit;

    public JobScheduling(int[][] jobProfit) {
        this.jobProfit = jobProfit;
    }
    //jobProfit[0] = deadline && jobProfit[1] = profit
    public int getMaximumProfit(){
        var taskScheduled = new HashSet<Integer>();
        int maximumProfit = 0;
        Arrays.sort(jobProfit,(a,b) -> b[1] == a[1] ? a[0] - b[0] : b[1] - a[1]);

        for(var jobs : jobProfit){
            var deadLine = jobs[0];
            var profit = jobs[1];
            for(int i = deadLine;i>=1;i--){
                if(!taskScheduled.contains(i)) {
                    taskScheduled.add(i);
                    maximumProfit += profit;
                    break;
                }
            }
        }
        return maximumProfit;
    }
}
