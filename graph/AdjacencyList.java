package com.algo.graph;
import java.util.*;

public class AdjacencyList {
    boolean isBidirectional;
    public class Node{
        String label;
        public Node(String label){
            this.label = label;
        }

        @Override
        public String toString() {
            return label;
        }
    }
    public AdjacencyList(boolean isBidirectional){
        this.isBidirectional = isBidirectional;
    }
    Map<String,Node> nodeMap = new LinkedHashMap<>();
    Map<Node,Set<Node>> adjacencyList = new LinkedHashMap<>();

    public void addVertex(String label){
        var node = new Node(label);
        nodeMap.putIfAbsent(label,node);
        adjacencyList.putIfAbsent(node,new HashSet<>());
    }

    public void addEdges(String from,String to){
        var fromNode = nodeMap.get(from);
        var toNode = nodeMap.get(to);
        if(fromNode == null || toNode == null)
            throw new IllegalArgumentException();

        adjacencyList.get(fromNode).add(toNode);
        if(isBidirectional)
            adjacencyList.get(toNode).add(fromNode);
    }

    public void removeVertex(String label){
        var node = nodeMap.get(label);
        if(node == null)
            return;

        for(var nodes : adjacencyList.keySet())
            adjacencyList.get(nodes).remove(node);

        adjacencyList.remove(node);
        nodeMap.remove(label);
    }

    public void removeEdge(String from,String to){
        var fromNode = nodeMap.get(from);
        var toNode = nodeMap.get(to);

        if(fromNode == null || toNode == null)
            return;

        adjacencyList.get(fromNode).remove(toNode);
        if(isBidirectional)
            adjacencyList.get(toNode).remove(fromNode);
    }

    public Set<String> depthFirstSearch(String root){
        Set<String> set = new LinkedHashSet<>();
        var node = nodeMap.get(root);
        if(node == null)
            return set;
        depthFirstSearch(node,set);

        return set;
    }

    private void depthFirstSearch(Node root,Set<String> set){
        set.add(root.label);
        for(var edge : adjacencyList.get(root)){
            if(!set.contains(edge.label))
                depthFirstSearch(edge,set);
        }
    }

    public Set<String> breadthFirstSearch(String root){
        Set<String> set = new LinkedHashSet<>();
        var node = nodeMap.get(root);
        if(node == null)
            return set;

        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(node);
        while (!queue.isEmpty()){
            int n = queue.size();
            var temp = queue.poll();
            for(var item : adjacencyList.get(temp)) {
                if (!set.contains(item.label))
                    queue.offer(item);
            }

            set.add(temp.label);
        }
        return set;
    }

    public Set<String> depthFirstSearch_Iterative(String value){
        Set<String> set = new LinkedHashSet<>();
        var node = nodeMap.get(value);
        if(node == null)
            return set;

        Stack<Node> stack = new Stack<>();
        stack.push(node);

        while(!stack.empty()){
            var temp = stack.pop();
            for(var item : adjacencyList.get(temp)){
                if(!set.contains(item.label))
                    stack.push(item);
            }
            set.add(temp.label);
        }

        return set;
    }


}
