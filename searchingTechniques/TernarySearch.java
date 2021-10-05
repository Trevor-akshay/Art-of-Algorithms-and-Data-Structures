package algorithms.searchingTechniques;

public class TernarySearch {
    public int search(int[] array,int target){
        int low = 0;
        int high = array.length-1;
        while (low <= high){
            int mid1 = low + (high - low)/ 3;
            int mid2 = high - (high - low) / 3;
            if(array[mid1] == target){
                return mid1;
            }else if(array[mid2] == target){
                return mid2;
            }else if(array[mid1] > target){
                high = mid1 - 1;
            }else if(array[mid1] < target && array[mid2] > target){
                low = mid1+1;
                high = mid2-1;
            }else
                low = mid2+1;
        }

        return -1;
    }

    public int recursiveTernarySearch(int[] array,int target){
        return helper(array,target,0,array.length-1);
    }

    private int helper(int[] array,int target,int low,int high){
        if(low > high)
            return -1;
        int mid1 = low + ( high - low ) / 3;
        int mid2 = high - ( high - low ) / 3;
        if(array[mid1] == target)
            return mid1;
        else if(array[mid2] == target)
            return mid2;
        else if(array[mid1] > target)
            return helper(array,target,low,mid1-1);
        else if(array[mid1] < target && array[mid2] > target)
            return helper(array,target,mid1+1,mid2-1);
        else
            return helper(array,target,mid2+1,high);
    }
}
