package algorithms.graphAlgorithms;

import java.util.*;

public class BoggleAlgorithm {
    // left , top-left , top , top-right , right , bottom-right, bottom & bottom-left
    static private final int[] XDIRECTION = {-1, -1, -1, 0, 0, 1, 1, 1};
    static private final int[] YDIRECTION = {-1, 0, 1, -1, 1, -1, 0, 1};


    public List<String> boggleAlgorithmImplementation(char[][] characters,List<String> dictionary){

        List<String> result = new ArrayList<>();
        boolean[][] visited = new boolean[characters.length][characters[0].length];

        for(int i = 0;i<characters.length;i++){
            for(int j = 0;j<characters[i].length;j++) {
                boggleAlgorithmRecursiveCall(i,j,result,characters,dictionary,new StringBuilder(),visited);
            }
        }

        return result;
        }

    private void boggleAlgorithmRecursiveCall(int row,int col,List<String> result ,
                                              char[][] characters,List<String> dictionary,
                                              StringBuilder s,boolean[][] visited){
        visited[row][col] = true;
        s.append(characters[row][col]);

        if(wordFound(dictionary,s))
            result.add(new String(s.toString()));

        for(int i = 0;i<8;i++){
            int newRow = row + XDIRECTION[i];
            int newCol = col + YDIRECTION[i];
                if (isValid(newRow, newCol, visited))
                    boggleAlgorithmRecursiveCall(newRow, newCol, result, characters, dictionary, s, visited);
        }

        s.deleteCharAt(s.length()-1);
        visited[row][col] = false;

    }

    private boolean isValid(int i,int j,boolean[][] visited){
        return  i>=0 && i < visited.length && j>=0 && j < visited[0].length && !visited[i][j];
    }

    private boolean wordFound(List<String> dictionary,StringBuilder word){
        for(var words : dictionary){
            if(word.toString().equals(words))
                return true;
        }
        return false;
    }
}
