package algorithms.generalAlgorithms;

public class MergeTwoSortedArrays {
    /**
     * Method to merge two sorted arrays in-place
     * @param A First array
     * @param B Second array
     */
    public void mergeSortedArrays(int[] A,int[] B){
        if(A == null || A.length == 0 || B == null || B.length == 0)
            return;

        for(int i = 0;i<A.length;i++){
            if(A[i] > B[0]) {
                int temp = A[i];
                A[i] = B[0];
                B[0] = temp;

                int realIndex = 1;
                while (realIndex < B.length && B[realIndex] < temp) {
                    B[realIndex - 1] = B[realIndex];
                    ++realIndex;
                }
                B[--realIndex] = temp;
            }
        }
    }
}
