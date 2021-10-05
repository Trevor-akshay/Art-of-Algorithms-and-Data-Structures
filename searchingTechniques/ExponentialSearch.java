package algorithms.searchingTechniques;

public class ExponentialSearch {
    public int search(int[] array,int target){
        int bound = 1;
        while (bound < array.length && array[bound] > target){
            bound *= 2;
        }
        int low = bound / 2;
        int high = bound;

        while (low <= high){
            int mid = (low + high) << 1;
            if(array[mid] == target)
                return mid;
            else if(array[mid] > target)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -1;
    }
}
