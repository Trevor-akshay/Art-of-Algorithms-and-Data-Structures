package com.algo.tries;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tries_Array {
    private class TrieNode{
        TrieNode[] children;
        boolean isLeaf;
        char value;
        TrieNode(char value){
            value = this.value;
            children = new TrieNode[26];
            isLeaf = false;
        }
    }

    TrieNode root = new TrieNode(' ');

    public void insert(String word){
        var current = root;
        for(char c : word.toCharArray()){
            int index = c - 'a';
            if(current.children[index] == null){
                current.children[index] = new TrieNode(c);
            }
            current = current.children[index];
        }
        current.isLeaf = true;
    }

    public void remove(String word){
        remove(root,word);
    }

    private void remove(TrieNode root,String word){
       for(char c : word.toCharArray()){
           int index = c - 'a';
           if(root.children[index] == null)
               return;

           root = root.children[index];
       }

       if(root.isLeaf)
           root.isLeaf = false;
    }

    private boolean hasChildren(TrieNode current){
        for(int i = 0;i<26;i++){
            if(current.children[i] != null)
                return true;
        }
        return false;
    }

    public boolean search(String word){
        var current = root;

        for(char c : word.toCharArray()){
            var index = c - 'a';
            if(current.children[index] == null)
                return false;

            current = current.children[index];
        }
        return current.isLeaf;
    }

    public boolean startsWith(String prefix){
        var current = root;

        for(char c : prefix.toCharArray()){
            var index = c - 'a';
            if(current.children[index] == null)
                return false;
            current = current.children[index];
        }

        return true;
    }

    public List<String> preorderTraversal(){
        var current = root;
        List<String> list = new ArrayList<>();
        preorderTraversal(current,list," ");

        return list;
    }

    private void preorderTraversal(TrieNode current,List<String> list,String s){
        if(current.isLeaf){
            list.add(s);
        }

        for(int i = 0;i<26;i++){
            if(current.children[i] != null){
               preorderTraversal(current.children[i],list,s+(char)(i + 97));
            }
        }
    }

    public List<String> postorderTraversal(){
        var current = root;
        List<String> list = new ArrayList<>();
        postorderTraversal(current,list," ");

        return list;
    }

    private void postorderTraversal(TrieNode current,List<String> list,String s) {
        if (current.isLeaf) {
            list.add(s);
        }

        for (int i = 25; i >= 0; i--) {
            if (current.children[i] != null) {
                postorderTraversal(current.children[i], list,  (char) (i + 97)+s);
            }
        }
    }



}
