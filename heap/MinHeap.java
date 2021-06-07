package com.algo.heap;

import java.util.Arrays;

public class MinHeap {
        int[] minHeap;
        int count;
        public MinHeap(int size){
            count = 0;
            minHeap = new int[size];
        }

        public void insert(int value){
            if(isFull()){
                System.out.println("Heap full");
                return;
            }
            minHeap[count++] = value;
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

            while (index > 0 && minHeap[index] < minHeap[parentIndex]){
                swap(index,parentIndex);

                // Recalculating parent and child index
                index = parentIndex;
                parentIndex = getParentIndex(parentIndex);
            }
        }

        public int pop(){
            if(isEmpty())
                throw new IllegalStateException();
            int item = minHeap[0];
            minHeap[0] = minHeap[--count];
            bubbleDown();

            return item;
        }

        private void bubbleDown(){
            int index = 0;
            int leftChildIndex = getLeftChildIndex(index);
            int rightChildIndex = getRightChildIndex(index);

            while(index <= count && !isValidParent(index)){
                var smallerItemIndex = getSmallerItemIndex(index);
                swap(index,smallerItemIndex);

                index = smallerItemIndex;
                leftChildIndex = getLeftChildIndex(index);
                rightChildIndex = getRightChildIndex(index);

            }
        }

        public int peek(){
            if(isEmpty())
                return -1;

            return minHeap[0];
        }

        public boolean isEmpty(){
            return count == 0;
        }

        public boolean isFull(){
            return count == minHeap.length;
        }

        public void printHeap(){
            System.out.println(Arrays.toString(minHeap));
        }

        private boolean isValidParent(int index){
            if(!hasLeftChild(index))
                return true;
            else if(!hasRightChild(index))
                return minHeap[index] < minHeap[getLeftChildIndex(index)];

            return minHeap[index] < minHeap[getLeftChildIndex(index)] &&
                    minHeap[index] < minHeap[getRightChildIndex(index)];
        }

        private int getSmallerItemIndex(int index){
            if(!hasLeftChild(index))
                return index;
            else if(!hasRightChild(index))
                return getLeftChildIndex(index);

            return minHeap[getLeftChildIndex(index)] < minHeap[getRightChildIndex(index)] ?
                    getLeftChildIndex(index) : getRightChildIndex(index);
        }

        private boolean hasLeftChild(int index){
            return getLeftChildIndex(index) <= count;
        }

        private boolean hasRightChild(int index){
            return getRightChildIndex(index) <= count;
        }

        private void swap(int index1,int index2){
            int temp = minHeap[index1];
            minHeap[index1] = minHeap[index2];
            minHeap[index2] = temp;
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


