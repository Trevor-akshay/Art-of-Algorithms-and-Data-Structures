package algorithms.searchingTechniques;

public class JumpSearch {
    public int search(int[] array,int target){
        int upperBound = (int)(Math.sqrt(array.length));
        int lowerBound = 0;
        int step = upperBound;

        while(upperBound < array.length && array[upperBound] < target) {
            lowerBound = upperBound;
            upperBound += step;
        }

        for(;lowerBound < array.length && array[lowerBound] <= target;lowerBound++){
            if(array[lowerBound] == target)
                return lowerBound;
        }
        return -1;
    }
}
