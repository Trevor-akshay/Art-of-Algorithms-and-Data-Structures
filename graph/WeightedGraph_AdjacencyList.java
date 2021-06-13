package com.datastructures.graph;

import java.util.*;

public class WeightedGraph_AdjacencyList {
    public class Node{
        public String label;
        public List<Edge> edges = new ArrayList<>();

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
        for(var node : nodeMap.values()){
            if(!visited.contains(node) && hasCycle(node,node,visited))
                return true;
        }
        return false;
    }

    private boolean hasCycle(Node node,Node parent,Set<Node> visited){
        visited.add(node);
        for(var vertex : node.edges){
            var vertexNode = nodeMap.get(vertex.to);

            if(vertexNode == parent)
                continue;

            if(visited.contains(vertexNode)  ||
                    hasCycle(vertexNode,node,visited))
                return true;
        }
        return false;
    }

    private class EdgePriority{
        Node node;
        int priority;

        public EdgePriority(Node node, int priority) {
            this.node = node;
            this.priority = priority;
        }
    }

    public Path DijkstraShortestPath(String source,String destination){
        var sourceNode = nodeMap.get(source);
        var destinationNode = nodeMap.get(destination);

        Map<Node,Integer> distances = new HashMap<>(); // to get the initial distance of each node
        for(var node : nodeMap.values())
            distances.put(node,Integer.MAX_VALUE);
        distances.replace(sourceNode,0);

        Map<Node,Node> parentTable = new HashMap<>();

        PriorityQueue<EdgePriority> queue = new PriorityQueue<>(
                (a,b) -> a.priority - b.priority
        );

        queue.offer(new EdgePriority(sourceNode,0));

        while (!queue.isEmpty()){
            var temp = queue.poll();
            var tempNode = temp.node;

            for(var edges : tempNode.edges){
                int distance = temp.priority + edges.weight;
                var toNode = nodeMap.get(edges.to);

                if(distances.get(toNode) > distance){
                    distances.replace(toNode,distance);
                    parentTable.put(toNode,nodeMap.get(edges.from));
                    queue.offer(new EdgePriority(toNode,distance));
                }
            }
        }

        return buildPath(parentTable,destinationNode);


    }

    public Path bellmanFordShortestPath(String source,String destination){
        Map<Node,Integer> distances = new HashMap<>();
        Node sourceNode = nodeMap.get(source);
        Node destinationNode = nodeMap.get(destination);

        for(var node : nodeMap.values())
            distances.put(node,Integer.MAX_VALUE);
        distances.replace(sourceNode,0);

        PriorityQueue<EdgePriority> queue = new PriorityQueue<>(
                Comparator.comparingInt(a -> a.priority)
        );

        Map<Node,Node> parentTable = new HashMap<>();

        int v = 0;
        while (v != nodeMap.size()) {
            boolean foundShortestPath = false;
            queue.offer(new EdgePriority(sourceNode,0));

            while (!queue.isEmpty()) {
                var temp = queue.poll();
                var tempNode = temp.node;

                for (var edges : tempNode.edges) {
                    int distance = temp.priority + edges.weight;
                    var toNode = nodeMap.get(edges.to);

                    if (distances.get(toNode) > distance) {
                        foundShortestPath = true;
                        distances.replace(toNode, distance);
                        parentTable.put(toNode, nodeMap.get(edges.from));
                        queue.offer(new EdgePriority(toNode, distance));
                    }
                }
            }
            if(!foundShortestPath)
                break;
            v++;
        }
        if(v < nodeMap.size())
            return buildPath(parentTable,destinationNode);
        else{
            System.out.println("Negative Edge Cycle found");
            return new Path();
        }
    }

    private Path buildPath(Map<Node,Node> parentTable,Node destinationNode){
        Stack<String> stack = new Stack<>();
        stack.push(destinationNode.label);
        var previous = parentTable.get(destinationNode);

        while (previous != null){
            stack.push(previous.label);
            previous = parentTable.get(previous);
        }

        Path path = new Path();
        while (!stack.isEmpty())
            path.add(stack.pop());

        return path;
    }

    public WeightedGraph_AdjacencyList primMinimumSpanningTree(){
        WeightedGraph_AdjacencyList tree = new WeightedGraph_AdjacencyList();

        PriorityQueue<Edge> queue = new PriorityQueue<>(
                (a,b) -> a.weight - b.weight
        );
        var startNode = nodeMap.values().iterator().next();
        queue.addAll(startNode.edges);
        tree.addVertex(startNode.label);

        while (tree.nodeMap.size() < nodeMap.size()){
           var temp = queue.poll();
           if(tree.nodeMap.containsKey(temp.to))
               continue;

           tree.addVertex(temp.to);
           tree.addEdge(temp.from,temp.to,temp.weight);

           for(var edge : nodeMap.get(temp.to).edges){
               if(!tree.nodeMap.containsKey(edge.to))
                    queue.offer(edge);
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
