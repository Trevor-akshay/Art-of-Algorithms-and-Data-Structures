package com.datastructures.tree;

import java.util.Arrays;

public class SegmentTree {
    static private int SIZE;
    int[] segments;
    public SegmentTree(int n){
        int height = (int)(Math.ceil(Math.log(n)/Math.log(2)));
        SIZE = 2 * (int)(Math.pow(2,height)) - 1;
        segments = new int[SIZE];
    }

    public int buildSegmentTree(int[] array,int start,int end,int index){
        if(start == end){
            segments[index] = array[start];
            return segments[index];
        }
        int mid = (start + end)  >> 1;

        segments[index] = buildSegmentTree(array,start,mid,getLeftChildIndex(index)) +
                            buildSegmentTree(array,mid+1,end,getRightChildIndex(index));

        return segments[index];
    }

    public void print(){
        System.out.println(Arrays.toString(segments));
    }

    private int getLeftChildIndex(int index){
        return 2 * index + 1;
    }

    private int getRightChildIndex(int index){
        return 2 * index + 2;
    }
}
