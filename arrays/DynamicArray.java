package com.algo.arrays;

import java.util.Arrays;

public class DynamicArray {
    int[] array;
    int size;
    public DynamicArray(int size){
        array = new int[size];
        this.size = 0;
    }

    public void add(int value){
        if(size == array.length){
            int[] temp = new int[size * 2];
            System.arraycopy(array,0,temp,0,size);
            array = temp;
        }
        array[size++] = value;
    }

    public boolean contains(int value){
        for(int i = 0;i<size;i++){
            if(value == array[i])
                return true;
        }
        return false;
    }

    public void remove(int value){
        int[] temp = new int[array.length];
        int index = 0;
        for(int i = 0;i<size;i++){
            if(value == array[i]){
                continue;
            }
            temp[index++] = array[i];
        }
        size--;
        array = temp;
    }

    public void printArray(){
        for(int i = 0;i<size;i++)
            System.out.print(array[i] +" ");

        System.out.println();
    }
}
