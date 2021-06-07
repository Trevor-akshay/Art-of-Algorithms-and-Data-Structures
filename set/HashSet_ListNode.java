package com.algo.set;

import java.util.ArrayList;
import java.util.List;

public class HashSet_ListNode {
    private class Node{
        int value;
        private Node(int value){
            this.value = value;
        }
    }
    // HERE SIZE IS TAKEN AS 5 FOR SIMPLICITY
    // GREATER THE VALUE THE FASTER THE IMPLEMENTATION IS!
    List<Node>[] entries = new ArrayList[5];

    public void add(int key){
        int index = hashCode(key);
        if(isEmptyEntry(index))
            entries[index] = new ArrayList<>();

        for(var value : entries[index]){
            if(value.value == key)
                return;
        }

        var node = new Node(key);
        entries[index].add(node);
    }

    public void remove(int key){
        int index = hashCode(key);
        if(isEmptyEntry(index))
            return;

        entries[index].removeIf(values -> values.value == key);
    }

    public boolean contains(int key){
        int index = hashCode(key);

        if(isEmptyEntry(index))
            return false;

        for(var value : entries[index]){
            if(value.value == key)
                return true;
        }

        return false;
    }

    private boolean isEmptyEntry(int index){
        return entries[index] == null;
    }
    private int hashCode(int key){
        return key % entries.length;
    }


}
