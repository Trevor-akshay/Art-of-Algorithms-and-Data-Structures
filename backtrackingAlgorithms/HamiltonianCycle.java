package algorithms.backtrackingAlgorithms;

import java.util.*;

public class HamiltonianCycle {
    Map<Integer,Set<Integer>> adjList = new HashMap<>();
    int n;
    public HamiltonianCycle(int n,int[][] edges){
        this.n = n;
        for(int i = 0;i<n;i++)
            adjList.put(i,new HashSet<>());
        for(var edge : edges){
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
    }

    public void solve(){
        List<Integer> path = new ArrayList<>();
        boolean[] visited = new boolean[n];
        path.add(0);
        visited[0] = true;
        if (hasCycle(0,0,visited,path))
               printPath(path);
        else
            System.out.println("No Cycle Found");
    }
    private boolean hasCycle(int node,int parent,boolean[] visited,List<Integer> path){
        if(path.size() == n && adjList.get(node).contains(parent)){
            path.add(parent);
            return true;
        }
        for(var edge : adjList.get(node)){
            if(!visited[edge]){
                path.add(edge);
                visited[edge] = true;
                if(hasCycle(edge,0,visited,path))
                    return true;
                else{
                    visited[edge] = false;
                    path.remove(path.size()-1);
                }
            }
        }
        return false;
    }


    private void printPath(List<Integer> path){
        System.out.println(path);
    }
}
