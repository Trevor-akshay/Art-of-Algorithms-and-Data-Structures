package com.algo.tree;

import com.sun.source.tree.Tree;

import java.util.*;

public class BinaryTree {
    private class TreeNode {
        int value;
        TreeNode leftChild;
        TreeNode rightChild;

        private TreeNode(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value+"";
        }
    }

    TreeNode root;

    public void insert(int value) {
        var tempNode = new TreeNode(value);
        if (root == null) {
            root = tempNode;
            return;
        }
        var current = root;
        while (true) {
            if (current.value < value) {
                if (current.rightChild == null) {
                    current.rightChild = tempNode;
                    break;
                }
                current = current.rightChild;
            } else {
                if (current.leftChild == null) {
                    current.leftChild = tempNode;
                    break;
                }
                current = current.leftChild;
            }
        }
    }

    public void delete(int key){
       if(root == null)
           return;
       var current = root;
       var parent = root;
       while (current != null && current.value != key){
           parent = current;
           if(current.value > key)
               current = current.leftChild;
           else
               current = current.rightChild;
       }
       if(current == null) // key not found
           return;
       if(current.leftChild == null && current.rightChild == null){ // key is leaf
               if(parent.leftChild == current)
                   parent.leftChild = null;
               else
                   parent.rightChild = null;
       }else if(current.leftChild != null && current.rightChild != null) { // children are not null
                var successor = getMinimum(current.rightChild);
                delete(successor.value);//recursive call to delete the successor from the tree

                current.value = successor.value;
           }
       else{// if either one child is null and the other is not
               TreeNode node = current.leftChild == null ? current.rightChild : current.leftChild;
               if(current != root) {
                   if (parent.leftChild == current)
                       parent.leftChild = node;
                   else
                       parent.rightChild = node;
               }else
                   root = node;
           }
    }


    private TreeNode getMinimum(TreeNode current){
        while (current.leftChild != null) {
            current = current.leftChild;
        }
        return current;
    }

    public boolean contains(int value){
        var current = root;
        while (current != null){
            if(current.value == value)
                return true;
            else if(current.value > value){
                current = current.leftChild;
            }else
                current = current.rightChild;
        }

        return false;
    }

    public List<Integer> preorderTraversal(){
        List<Integer> list = new ArrayList<>();
        preorderTraversal(list,root);

        return list;
    }

    private void preorderTraversal(List<Integer> list,TreeNode root){
        if(root == null)
            return;
        list.add(root.value);
        preorderTraversal(list,root.leftChild);
        preorderTraversal(list,root.rightChild);
    }
    public List<Integer> inorderTraversal(){
        List<Integer> list = new ArrayList<>();
        inorderTraversal(list,root);

        return list;
    }

    private void inorderTraversal(List<Integer> list,TreeNode root){
        if(root == null)
            return;
        inorderTraversal(list,root.leftChild);
        list.add(root.value);
        inorderTraversal(list,root.rightChild);
    }
    public List<Integer> postorderTraversal(){
        List<Integer> list = new ArrayList<>();
        postorderTraversal(list,root);

        return list;
    }

    private void postorderTraversal(List<Integer> list,TreeNode root){
        if(root == null)
            return;
        postorderTraversal(list,root.leftChild);
        postorderTraversal(list,root.rightChild);
        list.add(root.value);
    }

    public List<List<Integer>> levelOrderTraversal(){
        List<List<Integer>> levelTraversed  = new ArrayList<>();
        levelOrderTraversal(root,levelTraversed);

        return levelTraversed;
    }

    private void levelOrderTraversal(TreeNode root,List<List<Integer>> res){
        if(root == null)
            return;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int n = queue.size();
            for(int i = 0;i<n;i++){
                var temp = queue.poll();
                if(temp.leftChild != null)
                    queue.offer(temp.leftChild);
                if(temp.rightChild != null)
                    queue.offer(temp.rightChild);
                list.add(temp.value);

            }
            res.add(list);
        }
    }

    // Iterative Approach

    public List<Integer> preorderIterative(){
        List<Integer> list = new ArrayList<>();
        preorderIterative(root,list);

        return list;
    }

    private void preorderIterative(TreeNode root,List<Integer> list){
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()){
            var temp = stack.pop();
            if(temp.rightChild != null)
                stack.push(temp.rightChild);
            if(temp.leftChild != null)
                stack.push(temp.leftChild);
            list.add(temp.value);
        }
    }

    public List<Integer> inorderIterative(){
        List<Integer> list = new ArrayList<>();
        inorderIterative(root,list);

        return list;
    }

    private void inorderIterative(TreeNode root,List<Integer> list){
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) { // 7  4  3
            while (root!= null) {
                stack.push(root);
                root = root.leftChild;
            }
            list.add(stack.peek().value);
            root = stack.pop().rightChild;
        }
    }

    public List<Integer> postOrderIterative(){
        List<Integer> list = new ArrayList<>();
        postOrderIterative(root,list);

        return list;
    }

    private void postOrderIterative(TreeNode root,List<Integer> list){
        if(root == null)
            return;

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);
        while(!stack1.empty()){
            var temp = stack1.pop();
            if(temp.leftChild != null)
                stack1.push(temp.leftChild);
            if(temp.rightChild != null)
                stack1.push(temp.rightChild);

            stack2.push(temp);
        }
        while(!stack2.empty())
            list.add(stack2.pop().value);

    }
}
