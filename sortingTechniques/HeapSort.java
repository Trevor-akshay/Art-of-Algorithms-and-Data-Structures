package algorithms.sortingTechnique;

import com.datastructures.heap.MaxHeap;
import com.datastructures.heap.MinHeap;

public class HeapSort {
    public int[] heapSort_MaxHeap(int[] array){
        int n = array.length;
        MaxHeap maxHeap = new MaxHeap(n);
        for(var item : array)
            maxHeap.insert(item);

        for(int i = n-1;i>=0;i--)
            array[i] = maxHeap.pop();

        return array;
    }

    public int[] heapSort_MinHeap(int[] array){
        int n = array.length;
        MinHeap minHeap = new MinHeap(n);
        for(var item : array)
            minHeap.insert(item);

        for(int i = 0;i<n;i++)
            array[i] = minHeap.pop();

        return array;
    }
}
