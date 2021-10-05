package algorithms.sortingTechnique;

import java.util.*;

public class RadixSort {
    public int[] solve(int[] array){
        int digits = getMaxDigits(array);
        int place = 1;
        while(digits-- > 0){
            countingSort(array,place);
            place *= 10;
        }
        return array;
    }

    private int getMaxDigits(int[] array){
        int max = 0;
        for(var num : array)
            max = Math.max(num,max);

        int digits = 0;
        while (max != 0){
            digits++;
            max /= 10;
        }

        return digits;
    }

    //1st digit = (11 / 1) % 10 = 1 && 2nd digit = (123 / 10) % 10 = 2 ...
    private void countingSort(int[] array,int place){
        List<Integer>[] digits = new ArrayList[10];
        for(var num : array){
            int index = (num / place) % 10;
            if(digits[index] == null)
                digits[index] = new ArrayList();
            digits[index].add(num);
        }
        int index = 0;
        for (var list : digits){
            if(list == null)
                continue;
            for(var num : list)
                array[index++] = num;
        }
    }

}
