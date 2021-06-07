package com.algo.heap;

import java.util.Arrays;

public class MaxHeap {
    int[] maxHeap;
    int count;
    public MaxHeap(int size){
        count = 0;
        maxHeap = new int[size];
    }

    public void insert(int value){
        if(isFull()){
            System.out.println("Heap full");
            return;
        }
        maxHeap[count++] = value;
        var index = count - 1;
        bubbleUp(index);
    }


    /*
            4               6
         2      3 ->   4        3
      5    6        5     2
               */
    private void bubbleUp(int index){
        int parentIndex = getParentIndex(index);

        while (index > 0 && maxHeap[index] > maxHeap[parentIndex]){
            swap(index,parentIndex);

            // Recalculating parent and child index
            index = parentIndex;
            parentIndex = getParentIndex(parentIndex);
        }
    }

    public int pop(){
        if(isEmpty())
            throw new IllegalStateException();
        int item = maxHeap[0];
        maxHeap[0] = maxHeap[--count];
        bubbleDown();

        return item;
    }

    private void bubbleDown(){
        int index = 0;
        int leftChildIndex = getLeftChildIndex(index);
        int rightChildIndex = getRightChildIndex(index);

        while(index <= count && !isValidParent(index)){
            var largerItemIndex = getLargerItemIndex(index);
            swap(index,largerItemIndex);

            index = largerItemIndex;
            leftChildIndex = getLeftChildIndex(index);
            rightChildIndex = getRightChildIndex(index);

        }
    }

    public int peek(){
        if(isEmpty())
            return -1;

        return maxHeap[0];
    }

    public boolean isEmpty(){
        return count == 0;
    }

    public boolean isFull(){
        return count == maxHeap.length;
    }

    public void printHeap(){
        System.out.println(Arrays.toString(maxHeap));
    }

    private boolean isValidParent(int index){
        if(!hasLeftChild(index))
            return true;
        else if(!hasRightChild(index))
            return maxHeap[index] >= maxHeap[getLeftChildIndex(index)];

        return maxHeap[index] >= maxHeap[getLeftChildIndex(index)] &&
                maxHeap[index] >= maxHeap[getRightChildIndex(index)];
    }

    private int getLargerItemIndex(int index){
        if(!hasLeftChild(index))
            return index;
        else if(!hasRightChild(index))
            return getLeftChildIndex(index);

        return maxHeap[getLeftChildIndex(index)] > maxHeap[getRightChildIndex(index)] ?
                getLeftChildIndex(index) : getRightChildIndex(index);
    }

    private boolean hasLeftChild(int index){
        return getLeftChildIndex(index) <= count;
    }

    private boolean hasRightChild(int index){
        return getRightChildIndex(index) <= count;
    }

    private void swap(int index1,int index2){
        int temp = maxHeap[index1];
        maxHeap[index1] = maxHeap[index2];
        maxHeap[index2] = temp;
    }


    private int getParentIndex(int index){
        return index / 2;
    }

    private int getLeftChildIndex(int index){
        return index * 2 + 1;
    }

    private int getRightChildIndex(int index){
        return index * 2 + 2;
    }

}
