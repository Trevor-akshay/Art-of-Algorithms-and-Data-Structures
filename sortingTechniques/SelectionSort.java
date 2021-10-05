package algorithms.sortingTechnique;

public class SelectionSort {
    public int[] sort(int[] array){
        for(int i = 0;i<array.length;i++){
            int min = array[i];
            int index = i;
            for(int j = i+1;j<array.length;j++){
                if(min > array[j]){
                    min = array[j];
                    index = j;
                }
            }
            if(index != i){
                swap(array,i,index);
            }
        }
        return array;
    }

    private void swap(int[] array,int index1,int index2){
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
