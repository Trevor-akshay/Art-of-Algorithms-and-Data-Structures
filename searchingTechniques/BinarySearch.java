package algorithms.searchingTechniques;

public class BinarySearch {
    public boolean binarySearch_Iterative(int[] array,int target){
        int left = 0,
                right = array.length-1;

        while (left <= right){
            int middle = (left + right) >> 1;
            if(array[middle] == target)
                return true;
            else if(array[middle] < target)
                left = middle + 1;
            else
                right = middle - 1;
        }

        return false;
    }

    public boolean binarySearch_Recursive(int[] array,int target){
        return helper(array,target,0,array.length-1);
    }

    private boolean helper(int[] array,int target,int left,int right){
        if(left > right)
            return false;

        int middle = (left + right) >> 1;
        if(array[middle] == target)
            return true;
        else if(array[middle] < target)
            return helper(array,target,middle+1,right);
        else
            return helper(array,target,left,middle-1);
    }
}
