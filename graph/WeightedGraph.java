package com.algo.graph;

import java.util.*;

public class WeightedGraph {
    private class Node{
        private String label;
        private List<Edge> edges = new ArrayList<>();

        Node(String label){
            this.label = label;
        }

        public void addEdge(String to,int weight){
            edges.add(new Edge(this.label,to,weight));
        }

        @Override
        public String toString() {
            return edges.toString();
        }
    }
    private class Edge{
        String to;
        String from;
        int weight;

        Edge(String from,String to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "from='" + from + '\'' +
                    ", to='" + to + '\'' +
                    ", weight=" + weight +
                    '}';
        }
    }

    Map<String,Node> nodeMap = new HashMap<>();
    //Map<Node,List<Edge>> adjacencyList = new LinkedHashMap<>();

    public void addVertex(String label){
        var node = new Node(label);
        nodeMap.putIfAbsent(label,node);
      //  adjacencyList.putIfAbsent(node,new ArrayList<>());
    }

    public void addEdge(String from,String to,int weight){
        var fromNode = nodeMap.get(from);
        var toNode = nodeMap.get(to);

        if(fromNode == null || toNode == null)
            throw new IllegalArgumentException();

        fromNode.addEdge(to,weight);
        toNode.addEdge(from,weight);
    }
    public boolean hasCycle(){
        Set<Node> visited = new HashSet<>();
        for(var vertexes : nodeMap.values()){
            if(!visited.contains(vertexes) && hasCycle(vertexes,null,visited))
                return true;
        }
        return false;
    }

    private boolean hasCycle(Node vertex,Node parent,
                             Set<Node> visited){
        visited.add(vertex);
        for(var edge : vertex.edges){
            var node = nodeMap.get(edge.to);
            if(node == parent)
                continue;

            if(visited.contains(node) || hasCycle(node,vertex,visited))
                return true;
        }

        return false;
    }

    private class EdgePriority{ // Used for finding shortestPath
        Node node;
        int priority;

        public EdgePriority(Node node,int priority) {
            this.node = node;
            this.priority = priority;
        }
    }

    public Path dijkstraShortestPath(String source,String destination){
        var sourceNode = nodeMap.get(source);
        var destNode = nodeMap.get(destination);

        if(sourceNode == null || destNode == null)
            throw new IllegalArgumentException();

        Map<Node,Integer> distances = new HashMap<>();
        for(var vertex : nodeMap.values())
            distances.put(vertex,Integer.MAX_VALUE);
        distances.replace(sourceNode,0);

        Map<Node,Node> previousNodes = new HashMap<>(); // to return the path
        Set<Node> visited = new HashSet<>();

        PriorityQueue<EdgePriority> queue = new PriorityQueue<>(
                (a,b) -> a.priority - b.priority);
        queue.offer(new EdgePriority(sourceNode,0));

        while(!queue.isEmpty()){ // bfs with heap
            var node = queue.poll().node;
            visited.add(node);

            for(var edges : node.edges){
                var temp = nodeMap.get(edges.to);
                if(!visited.contains(temp)){
                    int distance = distances.get(node) + edges.weight;
                    if(distance < distances.get(temp)){ // if smaller tha before distance
                        distances.replace(temp,distance);
                        previousNodes.put(temp,node);
                        queue.offer(new EdgePriority(temp,distance));
                    }
                }
            }
        }

        return buildPath(destNode,previousNodes);
    }

    private Path buildPath(Node destNode,Map<Node,Node> previousNodes){
        Stack<Node> stack = new Stack<>();
        stack.push(destNode);
        var previous = previousNodes.get(destNode);
        while (previous != null){
            stack.push(previous);
            previous = previousNodes.get(previous);
        }

        var path = new Path();
        while(!stack.isEmpty()){
            path.add(stack.pop().label);
        }

        return path;
    }

    public WeightedGraph minimumSpanningTree(){
        var tree = new WeightedGraph();

        PriorityQueue<Edge> queue = new PriorityQueue<>(
                (a,b) -> a.weight - b.weight
        );
        var startNode = nodeMap.values().iterator().next();
        queue.addAll(startNode.edges);
        tree.addVertex(startNode.label);

        while(tree.nodeMap.size() < nodeMap.size()){
            var minEdge = queue.poll();
            var tempNode = new Node(minEdge.to);
            if(!tree.nodeMap.containsKey(minEdge.to)){
                tree.addVertex(minEdge.to);
                tree.addEdge(minEdge.from,minEdge.to,minEdge.weight);

                for(var edge : nodeMap.get(minEdge.to).edges){
                    if(!tree.nodeMap.containsKey(edge.to))
                        queue.offer(edge);
                }
            }
        }

        return tree;
    }


    public void print(){
        for(var vertex : nodeMap.keySet()){
            if(!(nodeMap.get(vertex) == null)){
                System.out.println(vertex  +" is connected to " + nodeMap.get(vertex));
            }
        }
    }

}
