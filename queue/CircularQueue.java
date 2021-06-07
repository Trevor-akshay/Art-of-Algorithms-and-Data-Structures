package com.algo.queue;

import java.util.Arrays;

public class CircularQueue {
    int[] circularQueue;
    int currentSizeOfQueue;
    public CircularQueue(int size){
        circularQueue = new int[size];
        currentSizeOfQueue = 0;
    }
    int front = 0;
    int rear = 0;

    public void push(int value){
        if(isFull()){
            System.out.println("Queue is already full");
            return;
        }

        rear = front == 0 ? rear : rear % circularQueue.length;
        circularQueue[rear++] = value;
        currentSizeOfQueue++;
    }

    public int peek(){
        if(isEmpty())
            return -1;

        return circularQueue[front];
    }

    public int pop(){
        if(isEmpty())
            return -1;

        currentSizeOfQueue--;
        return circularQueue[front++];
    }

    public boolean isFull(){
        return currentSizeOfQueue == circularQueue.length;
    }
    public boolean isEmpty(){
        return currentSizeOfQueue == 0;
    }

    public void printQueue(){
        System.out.println(Arrays.toString(circularQueue));
    }
}
