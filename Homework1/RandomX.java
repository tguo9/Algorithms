import java.util.*;

public class RandomX {

	protected int [][] board = new int[9][9];

	
	public int random() {
		Random r = new Random();
		return r.nextInt(9);
		
	}
	
	public void fill(){
		
		for(int r = 0; r < 9; r++) {
			
			for(int c = 0; c < 9; c++){
				
				placeNum(r, c);
			}
		}
	}
	
	protected boolean safeToPlace(int row, int col, int num) {
		
		for (int i = 0; i < 9; i++)    
            if (board[row][i] == num)
            	return false;
		
		for (int i = 0; i < 9; i++)   
            if (board[i][col] == num)
                return false;
		
		int remainRow = (row / 3) * 3;
		int remainCol = (col / 3) * 3;
		
		for(int r = remainRow; r < (remainRow + 3); r++) {
			for(int c = remainCol; c < (remainCol + 3); c++) {
				if(board[r][c] == num) {
					return false;
				}
			}
		}
        
		return true;
    }
	
    public boolean placeNum(int row, int col) {
    	
    		if(row == 9) {
    			return true;
    		}
    		
    		if(board[row][col] != 0) {
    			if(placeNum(col == 8? (row + 1):row, (col+1)%9))
    					return true;
    		} else {
    			int num = random();
    			for(int i = 0; i < 9; i++) {
    				if(safeToPlace(row, col, num)) {
    					board[row][col] = num;
    					
    					if(placeNum(col == 8? (row + 1) : row, (col + 1)%9))
    						return true;
    					else {
    						board[row][col] = 0;
    					}
    				}
    			}
    		}
    		return false;
    }
	
    public void conclose() {

		for(int r = 0; r < 9; r++) {
			for(int c = 0; c < 9; c++){
				System.out.print(" " + (board[r][c]) + " ");
			}
			System.out.println();
		}
	}
	
	public static void main(String [] args) {
    			RandomX rx = new RandomX();
    			rx.fill();
    			rx.conclose();

    }
}
