package tictactoe;

public class MyBoard {
	private int boardRowSize;
	private int boardColSize;
	private char[][] board;
	private String name;
	
	MyBoard(){
		// sets the board name and size
		this(3, 3, "TTT Game with 2 dimensional array");
	}
	
	// sets the row and col size and creates the array
	MyBoard(int row, int col, String name){
		this.setName(name);
		this.setSizeBoard(row, col);
		init();
	}
	
	private void init() {
		this.board = new char[boardRowSize][boardColSize];
		// goes through the double array and sets each value to dash
		int count = 48;
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[i].length; j++) {
				// sets the value at each index to number value (0,1,2,...)
				board[i][j] = (char) count;
				count++;
			}
		}
	}
	
	public void print() {
		// goes through the double array and prints the value at that position
		for(int i = 0; i < board.length; i++) {
			System.out.print("| ");
			for(int j = 0; j < board[i].length; j++) {
				System.out.print(board[i][j] + " | ");
			}
			System.out.println();
		}
	}

	public int getRowSize() {
		return boardRowSize;
	}


	public int getColSize() {
		return boardColSize;
	}

	public void setSizeBoard(int boardRowSize, int boardColSize) {
		this.boardColSize = boardColSize;
		this.boardRowSize = boardRowSize;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getMark(int row, int col) {
		// converts the char into a string
		return String.valueOf(board[row][col]);
	}
	
	public boolean boxToMark(String player, int row, int col) {
		// if the spot is open then set the mark, if not then it returns a false
		// checks for the number value(0,1,2,3...) or for an * as you can still put it in those spots
		if(board[row][col] == (char)(col+(row*3))+48 || (board[row][col] == (char)42)) {
			board[row][col] = player.charAt(0);
			return true;
		}
		else
			return false;
		
	}
	
	public int emptyCells(){
		// counts the amount of the empty spots by comparing it to the number value (0,1,2,..) or the *
		int count = 0;
		int value = 48;
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[i].length; j++) {
				if(board[i][j] == (char) value || board[i][j] == (char)42) 
					count++;
				value++;
			}
		}
		return count;
	}
	
	public boolean isFull() {
		// checks if there is any empty cells if there is then the board is not full (false) if there are then it returns a true
		if(emptyCells() == 0) {
			return true;
		}
		return false;
	}
	
	public boolean checkDiagRL(String Mark) {
		// this method checks the diagonal going from the bottom left to the top right
		int count = 0;
		// for this diagonal the row starts at the max value and the column starts at the lowest, it then goes through and decrements the row while incrementing the column
		for(int row = (boardRowSize-1), col = 0; col < boardColSize && row < boardRowSize; row--, col++) {
			// if the mark in that box is equal to the current players mark then increment count
			if(getMark(row, col).equals(Mark))
				count++;
		}
		// if the count of that diagonal for that player is equal to the score to win, then return true
		if(count == 3) {
			return true;
		}
		// otherwise return false
		return false;
	}

	public boolean checkDiagLR(String Mark) {
		// this method checks the diagonal going from the top left to the bottom right
		int count = 0;
		// for this diagonal, the row and column are equal so they both start at the same number and then incremented together
		for(int row = 0, col = 0; col < boardColSize && row < boardRowSize; row++, col++ ) {
			// if the mark in that box is equal to the current players mark then increment count
			if(getMark(row, col).equals(Mark))
				count++;				
		}
		// if the count of that diagonal for that player is equal to the score to win, then return true
		if(count == 3) {
			return true;
		}
		return false;
	}

	public boolean checkCol(String Mark) {
		// this method checks the columns of the board
		int count = 0;
		int col = 0;
		// this for loop is for each row on one selected column
		for(int row = 0; col < boardColSize && row < boardRowSize; row++) {
			// if the mark in that box is equal to the current players mark then increment count
			if(getMark(row, col).equals(Mark)) 
				count++;
			// if it is not then the method will skip this iteration by moving to the next column and checking that instead
			else {
				col++;
				// row is made to be -1 here because it will be incremented by the for loop after, the desired value when starting the loop is for the row to be the first row for each column
				row = -1;
				count = 0;
			}
			if(count == 3) {
				return true;
			}
		}
		return false;
	}

	public boolean checkRow(String Mark) {
		// this method checks the rows of the board
		int count = 0;
		int row = 0;
		// this for loop is for each column on one selected row
		for(int col = 0; col < boardColSize && row < boardRowSize; col++) {
			// if the mark in that box is equal to the current players mark then increment count
			if(getMark(row, col).equals(Mark)) 
				count++;
			// if it is not then the method will skip this iteration by moving to the next row and checking that instead
			else {
				row++;
				// col is made to be -1 here because it will be incremented by the for loop after, the desired value when starting the loop is for the column to be the first column for each row
				col = -1;
				count = 0;
			}
			if(count == 3) {
				return true;
			}
		}

		return false;
		
	}
}
