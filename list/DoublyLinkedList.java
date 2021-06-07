package com.algo.list;

public class DoublyLinkedList {
    private class Node{
        int value;
        Node next;
        Node prev;
        private Node(int value){
            this.value = value;
        }
    }

    Node head;
    Node tail;
    int size = 0;

    public void insertFront(int value){
        var node = new Node(value);
        size++;
        if(isEmpty()){
            head = tail = node;
            return;
        }
        var current = head;
        head = node;
        head.next = current;
        head.next.prev = node;
    }

    public void insertLast(int value){
        var node = new Node(value);
        size++;
        if(isEmpty()){
            head = tail = node;
            return;
        }
        var current = tail;
        tail.next = node;
        tail = tail.next;
        tail.prev = current;
    }

    public void remove(int index){
        if(isEmpty()){
            System.out.println("List is Empty!");
            return;
        }
        else if(index > size){
            throw new IndexOutOfBoundsException();
        }
        else if(index == 0){
            size--;
            head = head.next;
            head.prev = null;
            return;
        }
        else if(index == size - 1){
            size--;
            var current = tail.prev;
            tail = current;
            tail.next = null;
            return;
        }
        var current = head;
        var previous = head;
        while(index != 0){
            previous = current;
            current = current.next;
            index--;
        }
        previous.next = current.next;
        previous.next.prev = previous;

        size--;
    }

    public boolean contains(int value){
        if(isEmpty())
            return false;
        var current = head;
        for(;current!=null;current = current.next){
            if(current.value == value)
                return true;
        }

        return false;
    }

    public void printHead(){
        var current = head;
        while (current != null){
            System.out.print(current.value +"->");
            current  = current.next;
        }
        System.out.println("null");
    }

    public void printTail(){
        var current = tail;
        while (current != null){
            System.out.print(current.value + "->");
            current = current.prev;
        }
        System.out.println("null");
    }
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return head == null;
    }
}
