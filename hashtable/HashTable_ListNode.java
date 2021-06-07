package com.algo.hashtable;

import java.util.ArrayList;
import java.util.List;

public class HashTable_ListNode {
    private class Node{
        int key;
        int value;

        private Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    // HERE SIZE IS TAKEN AS 5 FOR SIMPLICITY
    // GREATER THE VALUE THE FASTER THE IMPLEMENTATION IS!
    List<Node>[] entries = new ArrayList[5];

    public void put(int key,int value){
        int index = hashCode(key);
        if(isEmptyEntry(index))
            entries[index] = new ArrayList<>();

        for(var entry : entries[index]){
            if(entry.key == key){
                entry.value = value;
                return;
            }
        }
        var entryNode = new Node(key,value);
        entries[index].add(entryNode);
    }

    public void remove(int key,int value){
        int index = hashCode(key);
        if(isEmptyEntry(index))
            return;

        entries[index].removeIf(entry -> entry.key == key && entry.value == value);
    }

    public int get(int key){
        int index = hashCode(key);
        if(isEmptyEntry(index))
            return -1;

        for(var entry : entries[index]){
            if(entry.key == key)
                return entry.value;
        }

        return -1;
    }

    public boolean containsKey(int key){
        int index = hashCode(key);
        if(isEmptyEntry(index))
            return false;

        for(var entry : entries[index]){
            if(entry.key == key)
                return true;
        }

        return false;
    }

    public boolean containsValue(int key,int value){
        int index = hashCode(key);
        if(isEmptyEntry(index))
            return false;

        for(var entry : entries[index]){
            if(entry.value == value)
                return true;
        }

        return false;
    }

    private int hashCode(int key){
        return key % entries.length;
    }

    private boolean isEmptyEntry(int index){
        return entries[index] ==  null;
    }
}
