package com.algo.list;

public class CircularList {
    private class Node{
        int value;
        Node next;
        private Node(int value){
            this.value = value;
        }
    }

    Node head;
    Node tail;
    int size = 0;

    public void insert(int value){
       var node = new Node(value);
       size++;
       if(isEmpty()){
         head = tail = node;
         return;
       }
       tail.next = node;
       tail = tail.next;
       tail.next = head;
    }

    public void remove(int value){
        if(isEmpty()){
            System.out.println("List Empty");
            return;
        }
        else if(head.value == value){
            head = head.next;
            tail.next = head;
            size--;
            return;
        }
        var current = head;
        var previous = head;
        while (current.value != tail.value && current.value != value){
            previous = current;
            current = current.next;
        }
        if(current.value == value){
            previous.next = current.next;
            size--;
        }else{
            System.out.println("Not found");
        }
    }

    public void printList(){ // this produces infinite loop  , but WHY?
        var current = head;
        int count = 0;
        while (count !=  size){
            System.out.print(current.value +"->");
            current = current.next;
            count++;
        }
        System.out.println("Head");
    }

    public boolean isEmpty(){
        return head == null;
    }
}
