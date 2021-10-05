package algorithms.searchingTechniques;

public class LinearSearch {
    public boolean linearSearch_Iterative(int[] array,int target){
        for(int item : array)
            if(item == target)
                return true;

        return false;
    }

    public boolean linearSearch_Recursive(int[] array,int index,int target){
        if(index == array.length)
            return false;
        else if(array[index] == target)
            return true;
        else
            return linearSearch_Recursive(array,index+1,target);
    }
}
