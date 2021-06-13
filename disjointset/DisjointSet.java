package com.datastructures.disjointset;

public class DisjointSet {
    private class Subset{
        int parent;
        int rank;

        public Subset(int parent, int rank) {
            this.parent = parent;
            this.rank = rank;
        }
    }
    Subset[] subsets;
    public DisjointSet(int N){
        subsets = new Subset[N + 1];
        for(int i = 0 ;i<=N;i++){
            subsets[i] = new Subset(i,i);
        }
    }

    public int find(int u){
        if(u == subsets[u].parent)
            return u;

        return subsets[u].parent = find(subsets[u].parent);
    }

    public void union(int x,int y){
        x = find(x);
        y = find(y);

        if(x == y)
            return;

        if(subsets[x].rank > subsets[y].rank){
            subsets[y].parent = x;
            subsets[x].rank += subsets[y].rank;
        }else if(subsets[y].rank > subsets[x].rank){
            subsets[x].parent = y;
            subsets[y].rank += subsets[x].rank;
        }else{
            subsets[y].parent = x;
            subsets[x].rank++;
        }
    }
}
