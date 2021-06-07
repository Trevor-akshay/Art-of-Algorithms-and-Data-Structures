package com.algo.queue;

public class Queue {
    int[] queue;
    int front;
    int end;
    public Queue(int size){
        queue = new int[size];
        front = 0;
        end = 0;
    }

    public void push(int value){
        if(end == queue.length){
            System.out.println("Queue is Full");
            return;
        }

        queue[end++] = value;
    }

    public int pop(){
        if(end == queue.length){
            System.out.println("Queue is Empty");
            return -1;
        }
        return queue[front++];
    }

    public int peek(){
        if(end == 0){
            System.out.println("Queue is Empty");
            return -1;
        }
        return queue[front];
    }

    public void printQueue(){
        for(int i = front;i<end;i++)
            System.out.print(queue[i] +"  ");

        System.out.println();
    }
}
