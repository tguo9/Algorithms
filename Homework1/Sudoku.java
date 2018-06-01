/* This is a class start by randomly generating   
 * one or more proposed numbers in the correct 
 * range (1-9) for each cell. Called as Sudoku.
 * @author Tao Guo
 * Partly reference from NQueens.
*/

import java.util.Random;

public class Sudoku {
	
	//Set up the Sudoku board.
	protected int [][] board = new int[9][9];
	
	//Create random number.
	public int random() {
		Random r = new Random();
		return r.nextInt(9) + 1;
		
	}

	//Check if the number can put in that cell.
	protected boolean safeToPlace(int row, int col, int num) {
		
		//Check each col.
		for (int i = 0; i < 9; i++)    
            if (board[row][i] == num)
            	return false;
		
		//Check each row.
		for (int i = 0; i < 9; i++)   
            if (board[i][col] == num)
                return false;
		
		//Check each 3*3 block.
		int remainRow = (row / 3) * 3;
		int remainCol = (col / 3) * 3;
		
		for(int r = remainRow; r < (remainRow + 3); r++) {
			for(int c = remainCol; c < (remainCol + 3); c++) {
				if(board[r][c] == num) {
					return false;
				}
			}
		}
        
        //Otherwise, all good.
		return true;
    }
	
	//Place the number, if doesn't work, backtrack.
	protected boolean placeNum(int row, int col) {
    	
    	//Base case.
		if(row == 9) {
			return true;
		}
		
		//Setp case. Check if the cell need to be fill.
		if(board[row][col] != 0) {
			
			//Boundray check. Also, fancy way to make col from the top.
			if(col == 8) {
				if(placeNum((row + 1), (col + 1) % 9) == true) {
					return true;
				}
			} else {
				if(placeNum(row, (col + 1) % 9) == true) {
					return true;
				}
			}
			
		} else {

			//Call random method.
			int num = random();
			
			//Loop check, and fill the number.
			for(int i = 0; i < 9; i++) {

				//Fill the number.
				if(safeToPlace(row, col, num)) {
					board[row][col] = num;

					//Boundray check. Also, fancy way to make col from the top.
					if(col == 8) {
						if(placeNum((row + 1), (col + 1) % 9) == true) {
							return true;
						} else {
							//Backtracking.
							board[row][col] = 0;
						}
					} else {
						if(placeNum(row, (col + 1) % 9) == true) {
							return true;
						} else {
							//Backtracking.
							board[row][col] = 0;
						}
					}
				} 
			}
		}
		//Otherwise, return false.
		return false;
	}
	
	//Fill the board.
	public void fill(){
		
		for(int r = 0; r < 9; r++) {
			
			for(int c = 0; c < 9; c++){
				
				placeNum(r, c);
			}
		}
	}
	
	//Print the board.
	public void conclose() {

		for(int r = 0; r < 9; r++) {
			if(r % 3 == 0) {
				System.out.println("-------------------------------");
			}
			for(int c = 0; c < 9; c++){
				if(c % 3 == 0) {
					System.out.print("|");
				}
				System.out.print(" " + (board[r][c]) + " ");
			}
			System.out.println("|");
		}
		System.out.println("-------------------------------");
	}
	
	//Main method.
	public static void main(String [] args) {
		 Sudoku sudoku = new Sudoku();
		 	sudoku.fill();
		 	sudoku.conclose();
	    }
}
