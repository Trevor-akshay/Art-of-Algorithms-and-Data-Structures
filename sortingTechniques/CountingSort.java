package algorithms.sortingTechnique;

import java.util.*;

public class CountingSort {
    public int[] sort_Arrays(int[] array){
        int[] counts = new int[100];// Change this value to the maximum value in the array
        for(var num : array)
            counts[num]++;

        int index = 0;
        for(int i = 0;i<counts.length;i++){
            int k = counts[i];
            while (k-- > 0) {
                array[index++] = i;
            }
        }

        return array;
    }

    public int[] sort_TreeMap(int[] array){
        TreeMap<Integer,Integer> counts = new TreeMap<>();
        for(var num : array)
            counts.merge(num,1,Integer::sum);

        int index = 0;
        while (!counts.isEmpty()){
            var set = counts.pollFirstEntry();
            int k = set.getValue();
            while (k-- > 0){
                array[index++] = set.getKey();
            }
        }

        return array;
    }
}
