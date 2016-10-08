/*
 * Nilanshu Sharma
 * https://leetcode.com/problems/design-tic-tac-toe/ 
 */ 

public class TicTacToe {
    int[] rowArr;
    int[] colArr;
    int diagonal, antiDiagonal, n;
    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        rowArr = new int[n];
        colArr = new int[n];
        diagonal =  0;
        antiDiagonal = 0;
        this.n = n;
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        if(player == 1){
            rowArr[row]++; ; 
            colArr[col]++;
            if(row == col)
                diagonal++; 
            if(row+col == n-1)
                antiDiagonal++;
        } else {
            rowArr[row]--; 
            colArr[col]--;
            if(row == col)
                diagonal--; 
            if(row+col == n-1)
                antiDiagonal--;
        }
        if(rowArr[row] == n || colArr[col] == n || diagonal == n || antiDiagonal == n){
            return 1; 
        } else if(rowArr[row] == -n || colArr[col] == -n || diagonal == -n || antiDiagonal == -n){
            return 2; 
        } else {
            return 0; 
        }
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */