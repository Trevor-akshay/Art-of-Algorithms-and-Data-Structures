package com.algo.queue;

public class Queue_List {
    int size;
    int count;
    private class Node{
        int value;
        Node next;
        private Node(int value){
            this.value = value;
        }
    }
        public Queue_List(int size){
            this.size = size;
            count = 0;
        }

    Node rear;
    Node front;

    public void add(int value){
        if(isFull()){
            System.out.println("Queue full");
            return;
        }
        var node = new Node(value);
        count++;
        if(rear == null){
            rear = node;
            front = node;
            return;
        }

        rear.next = node;
        rear = rear.next;
    }

    public void remove(){
        if(isEmpty()){
            System.out.println("Queue Empty");
            return;
        }

        front = front.next;
        count--;
    }

    public boolean contains(int value){
        if(isEmpty())
            return false;
        var temp = front;
        while (temp != null){
            if(temp.value == value)
                return true;

            temp = temp.next;
        }
        return false;
    }

    public void printQueue(){
        var temp = front;
        while (temp != null){
            System.out.print(temp.value +" ");
            temp = temp.next;
        }
        System.out.println();
    }

    public boolean isEmpty(){
        return count == 0;
    }

    public boolean isFull(){
        return count == size;
    }
}
