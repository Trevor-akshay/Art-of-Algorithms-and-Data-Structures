package com.algo.stack;

public class Stack {
    int top;
    int[] stack;
    public Stack(int size){
        stack = new int[size];
        top = 0;
    }

    public void push(int value){
        if(top == stack.length){
            System.out.println("Stack is full");
            return;
        }
        stack[top++] = value;
    }

    public int pop(){
        if(top == 0){
            System.out.println("Stack is Empty!");
            return -1;
        }
        return stack[--top];
    }

    public int peek(){
        if(top == 0){
            System.out.println("Stack is Empty!");
            return -1;
        }
        return stack[top-1];
    }

    public void printStack(){
        for(int i = top-1;i>=0;i--)
            System.out.print(stack[i] +" ");

        System.out.println();
    }
}
