package algorithms.sortingTechnique;

import java.util.Arrays;

public class ShellSort {
    public int[] sort(int[] array){
        int gap = array.length / 2;
        while (gap > 0){
            helper(array,gap);
            System.out.println(Arrays.toString(array));
            gap /= 2;
        }
        return array;
    }

    private void helper(int[] array,int gap){
      int left = 0;
      int right = gap;
      while (right < array.length){
          if(array[right] < array[left])
              swap(array,left,right);
          int k = left;
          while (k - gap >= 0){
              if(array[k] < array[k-gap])
                swap(array,k,k-gap);
              k -= gap;
          }
          left++;
          right++;
      }
    }

    private void swap(int[] array,int i1,int i2){
        int temp = array[i1];
        array[i1] = array[i2];
        array[i2] = temp;
    }

    // 7 4 5 8 2   5/2 = 2
    // l   r
}
