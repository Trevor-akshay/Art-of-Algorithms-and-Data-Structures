package com.algo.list;

public class SinglyLinkedList {
    private class Node{
        Node next;
        int value;
        Node(int value){
            this.value = value;
        }
    }

    Node head;

    public void addLast(int value){
        var node = new Node(value);
        if(isEmpty()){
            head = node;
            return;
        }
        var current = head;
        while (current.next != null)
            current = current.next;

        current.next = node;
    }

    public void addFirst(int value){
        var node = new Node(value);
        if(isEmpty()){
            head = node;
            return;
        }
        var temp = head;
        head = node;
        head.next = temp;

    }

    public void addNode(int value,int index){
        var node = new Node(value);
        if(isEmpty()){
            head = node;
            return;
        }
        else if(index == 0){
            var temp = head;
            head = node;
            head.next = temp;
            return;
        }
        var current = head;
        while (index > 1 && current.next != null){
            current = current.next;
            index--;
        }
//1 2 4
        var temp = current.next;
        current.next = node;
        current.next.next = temp;
    }

    public void removeFirst(){
        if(isEmpty())
            return;

        head = head.next;
    }

    public void removeLast(){
        if(isEmpty())
            return;

        var current = head;
        while (current.next.next != null){
            current = current.next;
        }

        current.next = null;
    }

    public void removeNode(int value){
        if(isEmpty())
            return;
        else if(head.value == value){
            head = head.next;
            return;
        }
        var current = head;
        var temp = head;

        while (current != null && current.value != value){  //  1  2  3
            temp = current;
            current = current.next;
        }

        if(current != null){
            temp.next = current.next;
        }
    }

    public boolean contains(int value){
        if(isEmpty())
            return false;
        var current = head;

        while (current != null){
            if(current.value == value)
                return true;

            current = current.next;
        }

        return false;
    }

    public boolean isEmpty(){
        return head == null;
    }

    public void printList(){
        var cur = head;
        while (cur != null){
            System.out.print(cur.value + "->");
            cur = cur.next;
        }
        System.out.println("null");
    }
}
