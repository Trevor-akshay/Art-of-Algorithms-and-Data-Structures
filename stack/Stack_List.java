package com.algo.stack;

public class Stack_List {
    int count;
    int size;
        private class Node{
            int value;
            Node next;
                private Node(int value) {
                this.value = value;
            }
        }
    public Stack_List(int size){
        this.size = size;
        count = 0;
    }

    Node top;

    public void push(int value){
        var node = new Node(value);
        if(isEmpty()){
            top = node;
            count++;
            return;
        }
        else if(isFull()){
            System.out.println("Stack full");
            return;
        }
        var current = top;
        top = node;
        top.next = current;
        count++;
    }

    public int pop(){
        if(isEmpty())
            return -1;

        int value = top.value;
        top = top.next;
        count--;
        return value;
    }

    public int peek(){
        if(isEmpty())
            return -1;

        return top.value;
    }

    public void printStack(){
        var current = top;
        while (current != null){
            System.out.print(current.value +" ");
            current = current.next;
        }

        System.out.println();
    }

    public boolean isEmpty(){
        return count == 0;
    }

    private boolean isFull(){
        return count == size;
    }
}
