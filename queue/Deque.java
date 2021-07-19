package com.datastructures.queue;

public class Deque {
    int size;

    public Deque(int size) {
        this.size = size;
    }

    private class Node{
        int val;
        Node previous;
        Node next;

        public Node(int val){
            this.val = val;
        }
        public Node(int val, Node previous, Node next) {
            this.val = val;
            this.previous = previous;
            this.next = next;
        }
    }

    Node front;
    Node rear;
    int dequeSize = 0;
    public void insertLast(int value){
        if(isFull()){
            throw new IllegalArgumentException();
        }
        Node node  = new Node(value);
        if(rear == null){
            rear = front = node;
            dequeSize++;
            return;
        }
        node.previous = rear;
        rear.next = node;
        rear = node;
        dequeSize++;
    }

    public void insertFirst(int value){
        if(isFull()){
            throw new IllegalArgumentException();
        }
        Node node = new Node(value);
        if(front == null){
            rear = front = node;
            dequeSize++;
            return;
        }
        node.next = front;
        front.previous = node;
        front = node;
        dequeSize++;
    }

    public int removeFirst(){
        if(isEmpty())
            throw new IllegalStateException();

        int temp =front.val;
        front = front.next;
        front.previous = null;
        dequeSize--;

        return temp;
    }

    public int removeLast(){
        if(isEmpty())
            throw new IllegalStateException();

        int temp = rear.val;
        rear = rear.previous;
        rear.next = null;
        dequeSize--;

        return temp;
    }

    public void clear(){
        if(isEmpty())
            throw new IllegalStateException();

        front = rear = null;
        dequeSize = 0;
    }

    public int getFirst(){
        if(isEmpty())
            throw new IllegalStateException();

        return front.val;
    }

    public int getLast(){
        if(isEmpty())
            throw new IllegalStateException();

        return rear.val;
    }

    public int getSize(){
        if(isEmpty())
            throw new IllegalStateException();

        return dequeSize;
    }

    public boolean isEmpty(){
        return dequeSize == 0;
    }

    public boolean isFull(){
        return dequeSize == size;
    }

    public void print(){
        var current = front;
        while (current != null){
            System.out.print(current.val + "->");
            current = current.next;
        }
        System.out.println("null");
    }

    public void printReversed(){
        var current = rear;
        while (current!=null){
            System.out.print(current.val +"->");
            current = current.previous;
        }
        System.out.println("null");
    }
}
