package algorithms.backtrackingAlgorithms;

import java.util.*;

public class AllPossiblekWayGraphColoring {
    private class Color{
        int node;
        String color;

        public Color(int node, String color) {
            this.node = node;
            this.color = color;
        }

        @Override
        public String toString() {
            return "Color{" +
                    "node=" + node +
                    ", color='" + color + '\'' +
                    '}';
        }
    }
    static private final String[] colors = { "BLUE", "GREEN", "RED", "YELLOW",
            "ORANGE", "PINK", "BLACK", "BROWN", "WHITE", "PURPLE"};


    Map<Integer,Set<Integer>> graph = new HashMap<>();
    public void solve(int N,int[][] edges,int k){
        Color[] storedColors = new Color[N];
        buildGraph(N,edges,storedColors);
        List<List<String>> result = new ArrayList<>();

        dfs(result,storedColors,k,0);
    }

    private void dfs(List<List<String>> res,Color[] storedColors,
                     int k,int vertex){
        if(res.size() == graph.size()) {
            System.out.println(res);
            return;
        }
        for(int i = 0;i<k;i++){
            if(isSafe(storedColors,vertex,colors[i])){
                storedColors[vertex] = new Color(vertex,colors[i]);
                res.add(Arrays.asList(vertex+"",colors[i]));
                dfs(res,storedColors,k,vertex+1);
                res.remove(res.size()-1);
                storedColors[vertex] = new Color(vertex,"");
            }
        }

    }


    private boolean isSafe(Color[] storedColors,int vertex,String color){
        for(var edge : graph.get(vertex)){
            if(storedColors[edge].color.equals(color))
                return false;
        }
        return true;
    }

    private void buildGraph(int N,int[][] edges,Color[] colors1){
        for(int i = 0;i<N;i++) {
            graph.put(i, new HashSet<>());
            colors1[i] = new Color(i,"");
        }
        for(var edge : edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
    }
}
