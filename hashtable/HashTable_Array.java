package com.algo.hashtable;

import java.util.Arrays;

public class HashTable_Array {
    int[] hashTable;
    public HashTable_Array(int size){
        hashTable = new int[size];
        Arrays.fill(hashTable,-1);
    }

    public void put(int key,int value){
        hashTable[key] = value;
    }

    public void remove(int key){
        hashTable[key] = -1;
    }

    public int get(int key){
        return hashTable[key];
    }

    @Override
    public String toString(){
        return Arrays.toString(hashTable);
    }
}
