package algorithms.sortingTechnique;

import java.util.Arrays;

public class MergeSort {
    public int[] sort(int[] array){
        if(array.length < 2)
            return array;

        int mid = array.length / 2;

        int[] left = new int[mid];
        for(int i = 0;i<mid;i++)
            left[i] = array[i];

        int[] right = new int[array.length - mid];
        for(int i = mid; i < array.length;i++)
            right[i - mid] = array[i];

        sort(left);
        sort(right);

       return merge(left,right,array);
    }

    private int[] merge(int[] array1,int[] array2,int[] result){
        int n = array1.length;
        int m = array2.length;
        int i = 0, j = 0, k = 0;

        while (i < n && j < m){
            if(array1[i] < array2[j])
                result[k++] = array1[i++];
            else
                result[k++] = array2[j++];
        }

        while (i < n)
            result[k++] = array1[i++];

        while (j < m)
            result[k++] = array2[j++];

        return result;
    }

}
