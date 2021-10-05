package algorithms.sortingTechnique;

import java.util.*;


public class BucketSort {
    public int[] sort(int[] array){
        List[] buckets = new ArrayList[3];//Increase the size for better time complexity

        for(var num : array){
            int index = num / buckets.length;
            if(buckets[index] == null)
                buckets[index] = new ArrayList();
            buckets[index].add(num);
        }
        System.out.println(Arrays.toString(buckets));
        int index = 0;
        for(var bucket : buckets) {
            if(bucket == null)
                continue;
            Collections.sort(bucket);
            for(var num : bucket)
                array[index++] = (Integer) num;
        }

        return array;
    }
}
