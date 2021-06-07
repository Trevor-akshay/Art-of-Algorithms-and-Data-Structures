package com.algo.tries;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tries_Map {
    private class TrieNode{
        Map<Character,TrieNode> children;
        boolean isLeaf;
        char value;
        TrieNode(char value){
            value = this.value;
            children = new HashMap<>();
            isLeaf = false;
        }
    }

    TrieNode root = new TrieNode(' ');

    public void insert(String word){
        var current = root;
        for(char c : word.toCharArray()){
            int index = c - 'a';
            if(current.children.get(c) == null){
                current.children.put(c,new TrieNode(c));
            }
            current = current.children.get(c);
        }
        current.isLeaf = true;
    }

    public void remove(String word){
        remove(root,word);
    }

    private void remove(TrieNode root, String word){
        TrieNode deleteBelow = null;
        char deleteChar = '\0';
        for(char c : word.toCharArray()){
            int index = c - 'a';
            if(root.children.get(c) == null)
                return;

            if(root.children.size() > 1 || root.isLeaf){
                deleteBelow = root;
                deleteChar = c;
            }

            root = root.children.get(c);
        }
        if(!root.isLeaf)
            return;

        if(root.children.isEmpty())
            deleteBelow.children.remove(deleteChar);
        else
            root.isLeaf = false;
    }

    private boolean hasChildren(TrieNode current){
       return current.children.size() == 0;
    }

    public boolean search(String word){
        var current = root;

        for(char c : word.toCharArray()){
            var index = c - 'a';
            if(current.children.get(c) == null)
                return false;

            current = current.children.get(c);
        }
        return current.isLeaf;
    }

    public boolean startsWith(String prefix){
        var current = root;

        for(char c : prefix.toCharArray()){
            var index = c - 'a';
            if(current.children.get(c) == null)
                return false;
            current = current.children.get(c);
        }

        return true;
    }

    public List<String> preorderTraversal(){
        var current = root;
        List<String> list = new ArrayList<>();
        preorderTraveral(current,list," ");

        return list;
    }

    private void preorderTraveral(TrieNode current, List<String> list, String s){
        if(current.isLeaf){
            list.add(s);
        }

        for(var child : current.children.keySet()){
            preorderTraveral(current.children.get(child),list,s+child);
        }
    }

    public List<String> postorderTraversal(){
        var current = root;
        List<String> list = new ArrayList<>();
        postorderTraveral(current,list," ");

        return list;
    }

    private void postorderTraveral(TrieNode current, List<String> list, String s){
        if(current.isLeaf){
            list.add(s);
        }

        for(var child : current.children.keySet()){
            postorderTraveral(current.children.get(child),list,child+s);
        }
    }
}
