package com.datastructures.tree;
import java.util.*;
public class AVL {
    private class Node{
        int value;
        int height;
        Node left;
        Node right;
        public Node(int value){
            this.value = value;
        }
    }
    Node root;

    public void insert(int value){
        root = insert(root,value);
    }
    private Node insert(Node root,int value){
        if(root == null) {
            root = new Node(value);
            return root;
        }
        if(root.value > value)
            root.left = insert(root.left,value);
        else
            root.right = insert(root.right,value);

        return balance(root);
    }

    private int getHeight(Node root){
        return root == null ? -1 : root.height;
    }

    public boolean search(int value){
        return search(root,value);
    }

    private Node balance(Node root){
        assignHeight(root);
        int balanceFactor = balanceFactor(root);
        if(balanceFactor < -1) {
            if(balanceFactor(root.right) > 0)
                root.right = rightRotate(root);
            root = leftRotate(root);
            return root;
        }
        else if(balanceFactor > 1) {
            if(balanceFactor(root.left) < 0)
                root.left = leftRotate(root);
            root = rightRotate(root);
            return root;
        }
        return root;
    }

    private int balanceFactor(Node node){
        return getHeight(node.left) - getHeight(node.right);
    }
    // 30
    //   40        ->     40
    //      50          30   50
    private Node leftRotate(Node root){
        Node new_root = root.right;
        root.right = new_root.left;
        new_root.left = root;

        assignHeight(root);
        assignHeight(new_root);

        return new_root;
    }
    //     30
    //   20     ->          20
    //10                 10     30
    private Node rightRotate(Node root){
        var new_root = root.left;
        root.left = new_root.right;
        new_root.right = root;

        assignHeight(root);
        assignHeight(new_root);

        return new_root;
    }

    private void assignHeight(Node root){
        root.height = Math.max(getHeight(root.left),getHeight(root.right)) + 1;
    }

    private boolean search(Node root,int value){
        if(root == null)
            return false;
        else if(root.value == value)
            return true;
        else if(root.value > value)
            return search(root.left,value);
        else
            return search(root.right,value);
    }

    public List<List<Integer>> bfs(){
        return bfs(root);
    }
    private List<List<Integer>> bfs(Node root){
        List<List<Integer>> result = new ArrayList<>();
        Queue<Node> q = new ArrayDeque<>();
        q.offer(root);
        while (!q.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            int n = q.size();
            for(int i = 0;i<n;i++){
                var poll = q.poll();
                temp.add(poll.value);
                if(poll.left != null)
                    q.offer(poll.left);

                if(poll.right != null)
                    q.offer(poll.right);
            }
            result.add(temp);
        }
        return result;
    }
}
