package algorithms.backtrackingAlgorithms;

import java.util.Arrays;

public class SudokuSolver {
    int[][] board;
    public SudokuSolver(int[][] board){
        this.board = board;
    }
    public void SudokuSolution(){
        if(solve(0,0))
            print();
        else
            System.out.println("No Solution");
    }

    public boolean solve(int row,int col){
        for (int i = row; i < 9; i++, col = 0) { // note: must reset col here!
            for (int j = col; j < 9; j++) {
                if (board[i][j] != 0) continue;
                for (int num = 1; num <= 9; num++) {
                    if (isValid(i, j, num)) {
                        board[i][j] = num;
                        if (solve(i, j + 1))
                            return true;
                        board[i][j] = 0;
                    }
                }
                return false;
            }
        }
        return true;
    }

    private boolean isValid(int i,int j,int value){
        int row = i-1;
        while (row >= 0){
            if(board[row][j] == value)
                return false;
            row--;
        }
        row = i+1;
        while (row < board.length){
            if(board[row][j] == value)
                return false;
            row++;
        }
        int col = j-1;
        while (col >= 0){
            if(board[i][col] == value)
                return false;
            col--;
        }
        col = j+1;
        while (col < board[0].length){
            if(board[i][col] == value)
                return false;
            col++;
        }
        int startRow = i - i % 3;
        int startCol = j - j % 3;
        for(row = 0;row < 3;row++){
            for(col = 0;col < 3;col++){
                if(board[startRow + row][startCol + col] == value)
                    return false;
            }
        }
        return true;
    }

    private void print(){
        for(var iner : board)
            System.out.println(Arrays.toString(iner));
    }
}
