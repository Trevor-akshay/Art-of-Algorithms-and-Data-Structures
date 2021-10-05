package algorithms.sortingTechnique;

import java.util.Arrays;

public class BubbleSort {
    public int[] sort(int[] array){
        for(int i = 0;i<array.length;i++){
            boolean sorted = true;
            for(int j = 1;j<array.length - i;j++){
                if(array[j] < array[j-1]){
                    swap(array,j,j-1);
                    sorted = false;
                }
            }
            if(sorted)
                break;
        }
        return array;
    }

    private void swap(int[] array,int index1,int index2){
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
