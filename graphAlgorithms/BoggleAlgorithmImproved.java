package algorithms.graphAlgorithms;

import com.datastructures.tries.Tries_Map;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BoggleAlgorithmImproved {
    //static private final int[][] directions = {{0,-1},{-1,-1},{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1}};
    static private final int[][] directions = {{0,-1},{-1,0},{0,1},{1,0}};
    Tries_Map tries_map = new Tries_Map();
    String[] dictionary;
    char[][] chars;
    public BoggleAlgorithmImproved(String[] dictionary,char[][] chars){
        this.chars = chars;
        this.dictionary = dictionary;
    }

    public void builtTrie(){
        for(var word : dictionary){
            tries_map.insert(word);
        }
    }

    public List<String> boggleAlgorithmImplementation(){
        Set<String> list = new HashSet<>();
        builtTrie();

        for(int i = 0;i<chars.length;i++){
            for(int j = 0;j<chars.length;j++){
                dfs(list,i,j,new StringBuilder(),new boolean[chars.length][chars[0].length]);
            }
        }

        return new ArrayList<>(list);
    }

    private void dfs(Set<String> list,int i,int j,StringBuilder s,boolean[][] visited){
        s.append(chars[i][j]);
        visited[i][j] = true;

        if(!tries_map.startsWith(s.toString())) {
            s.deleteCharAt(s.length()-1);
            visited[i][j] = false;
            return;
        }

        if(contains(s.toString())){
            list.add(s.toString());
        }

        for(int k = 0;k<4;k++){
            if(isValid(i+directions[k][0],j+directions[k][1],visited)){
                dfs(list,i+directions[k][0],j+directions[k][1],s,visited);
            }
        }

        s.deleteCharAt(s.length()-1);
        visited[i][j] = false;
    }

    private boolean isValid(int i,int j,boolean[][] visited){
        return i>= 0 && i < chars.length && j>=0 && j < chars[0].length && !visited[i][j];
    }

    private boolean contains(String word){
        return tries_map.search(word);
    }

}
