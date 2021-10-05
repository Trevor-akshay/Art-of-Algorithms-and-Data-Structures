package algorithms.backtrackingAlgorithms;

import java.util.*;

public class HamiltonianPath {
    Map<Integer, Set<Integer>> adjList = new HashMap<>();
    int n;
    public HamiltonianPath(int n,int[][] edges){
        this.n = n;
        for(int i = 0;i<n;i++)
            adjList.put(i,new HashSet<>());
        for(var edge : edges){
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
    }

    public void solve(){
       // for(int i = 0;i<adjList.size();i++) {
            List<Integer> path = new ArrayList<>();
            boolean[] visited = new boolean[n];
            visited[0] = true;
            path.add(0);
            hasCycle(0,visited,path,0);
    }
    private void hasCycle(int node,boolean[] visited,List<Integer> path,int nodes){
        if(path.size() == n){
            printPath(path);
            return;
        }
        for(var edge : adjList.get(node)){
            if(!visited[edge]){
                path.add(edge);
                visited[edge] = true;
                hasCycle(edge,visited,path,nodes+1);
                visited[edge] = false;
                path.remove(path.size()-1);
            }
        }
    }


    private void printPath(List<Integer> path){
        System.out.println(path);
    }
}
