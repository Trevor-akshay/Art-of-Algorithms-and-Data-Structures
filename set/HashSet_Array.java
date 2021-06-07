package com.algo.set;

import java.util.Arrays;

public class HashSet_Array {
    int[] hashSet;
    public HashSet_Array(int size){
        hashSet = new int[size];
    }

    public void add(int key,int value){
        hashSet[key] = value;
    }

    public void remove(int key){
        hashSet[key] = -1;
    }

    public int get(int key){
        return hashSet[key];
    }


    @Override
    public String toString(){
        return Arrays.toString(hashSet);
    }
}
