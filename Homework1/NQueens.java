/**
 * CS 245 - Recursion: Example using Eight Queens
 * This class places N queens on an NxN virtual chessboard.
 * If a solution exists, it is printed. Otherwise, a message is printed.
 * @author dbrizan
 *
 */

public class NQueens {
    protected int n;
    protected int [][] board;

    /**
     * Constructor: create a board of any size.
     * @param size
     */
    public NQueens(int size) {
        n = size;
        board = new int[n][n];
    }

    /**
     * Is it safe to place a queen in the row & col proposed?
     * Checks the column above, the upper left diagonal and upper right diagonal.
     * @param row
     * @param col
     * @return true if safe to place; false otherwise.
     */
    protected boolean safeToPlace(int row, int col) {
        for (int i = 0; i < col; i++)    // Check row
            if (board[row][i] == 1)
                return false;
        // Check upper left diagonal
        for (int i = row, j = col; i >=0 && j >= 0; i--, j--)
            if (board[i][j] == 1)
                return false;
        // Check lower left diagonal
        for (int i = row, j = col; i < this.n && j >= 0; i++, j--)
            if (board[i][j] == 1)
                return false;
        return true;        // Otherwise, all good:
    }

    /**
     * Prints the board, with the location of the queens, to console.
     */
    public void printToConsole() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) 
                System.out.print(" " + (board[i][j]==1?"Q" : "_") + " ");
            System.out.println();
        }
    }

    /**
     * Place a queen in the column. Recursively place a queen in subsequent columns.
     * (This function is where the magic happens.)
     * @param col
     * @return true if the placement works for this column and subsequent columns.
     */
    protected boolean placeNQueens(int col) {
        // Base case: if you’ve run out of columns, you win
        if (col >= this.n)
            return true;
        // Otherwise, check, place a queen if safe and fill next col
        for (int i = 0; i < this.n; i++) {
            if (safeToPlace(i, col)) {
                board[i][col] = 1;
                if (placeNQueens(col+1))
                    return true;
                // Otherwise, this failed. Backtrack
                board[i][col] = 0;
            }
        }
        return false;
    }

    /**
     * This is the "placeNQueens" function, but for external callers.
     * @return true if the queens can be placed; false otherwise.
     */
    public boolean placeNQueens() {
        return placeNQueens(0);
    }

    /**
     * main: Instantiates NQueens with some size (8?) and calls "placeNQueens"
     * If successful, prints the board to the console.
     * (If unsuccessful, prints a "too bad..." message.)
     * TODO: Change this function so that the size of the board is a parameter.
     * @param args
     */
    public static void main(String [] args) {
    	NQueens nq = new NQueens(8);
        if (nq.placeNQueens())
            nq.printToConsole();
        else
        	System.out.println("Solution does not exist.");
    }

}
