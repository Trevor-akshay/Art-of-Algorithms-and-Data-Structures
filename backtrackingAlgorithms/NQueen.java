package algorithms.backtrackingAlgorithms;

import java.util.Arrays;

public class NQueen {
    int[][] board;
    int n;
    public NQueen(int n){
        this.n = n;
        board = new int[n][n];
    }


    public void solve(){
        boolean[] columns = new boolean[n];
        boolean[] diagonals1 = new boolean[2 * n];
        boolean[] diagonals2 = new boolean[2 * n];
        helper(0,columns,diagonals1,diagonals2);
    }
    private void helper(int row,boolean[] columns,boolean[] diagonals1,boolean[] diagonals2){
        if(row == n){
            printPath();
        }

        for(int col = 0;col<n;col++){
            int id1 = col - row + n;//bottom left to top right , any value having the same sum will be invalid
            int id2 = col + row;// top left to bottom right.
            if(columns[col] || diagonals1[id1] || diagonals2[id2])
                continue;

            board[row][col] = 1;
            columns[col] = true;
            diagonals1[id1] = true;
            diagonals2[id2] = true;

            helper(row+1,columns,diagonals1,diagonals2);

            columns[col] = false;
            diagonals1[id1] = false;
            diagonals2[id2] = false;
            board[row][col] = 0;

        }
    }
    private void printPath(){
        for(var inner : board)
            System.out.println(Arrays.toString(inner));
        System.out.println();
    }

}
