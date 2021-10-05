package algorithms.backtrackingAlgorithms;

import java.util.Arrays;

public class KnightTour {
    int[][] board;

    public KnightTour() {
        board = new int[8][8];// creates the board
        for(var inner : board)
            Arrays.fill(inner,-1);
    }

    private static final int[] XDIRECTION = {-1, 1, 2, 2, -2, -2, -1, 1};
    private static final int[] YDIRECTION = {2, 2, 1, -1, 1, -1, -2, -2};

    public void solve(){
        board[0][0] = 0;
        if(helper(0,0,1))
            printPath();
        else
            System.out.println("No path found");
    }

    private boolean helper(int i,int j,int movement){
        if(movement == 8 * 8){
            return true;
        }
        for(int k = 0;k<8;k++){
            int x = i + XDIRECTION[k];
            int y = j + YDIRECTION[k];
            if(isValid(x,y)){
                board[x][y] = movement;
                if(helper(x,y,movement+1))
                    return true;
                else
                    board[x][y] = -1;
            }
        }
        return false;
    }


    private boolean isValid(int i,int j){
        return i >= 0 && j >= 0 && i < 8 && j < 8 && board[i][j] == -1;
    }

    private void printPath(){
        for(int i = 0;i<8;i++){
            System.out.println(Arrays.toString(board[i]));
        }
    }
}