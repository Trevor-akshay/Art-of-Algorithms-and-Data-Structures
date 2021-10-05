package algorithms.sortingTechnique;

import java.util.Arrays;

public class QuickSort {
    public int[] sort(int[] array,int left,int right){
        if(left >= right)
            return array;

        int index = partition(array,left,right);

        sort(array,0,index-1);
        sort(array,index+1,right);

        return array;
    }
    // 5 3
    private int partition(int[] array,int left,int right){
        int boundary = left-1;
        int pivot = array[right];
        for(int i = left;i<=right;i++){
            if(array[i] <= pivot){
                boundary++;
                swap(array,boundary,i);
            }
        }
        return boundary;
    }

    private void swap(int[] array,int idx1,int idx2){
        int temp = array[idx1];
        array[idx1] = array[idx2];
        array[idx2] = temp;
    }
}
