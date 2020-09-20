package tictactoe;

public class MainBoard {
	private MyBoard[] boards = new MyBoard[9];
	
	public MainBoard() {
		// sets each of the MyBoard
		for(int i = 0; i < boards.length; i++) {
			boards[i] = new MyBoard();
		}
	}
	
	void print() {
		int runner = 0;
		// this for loop is for each row of boards (3)
		for(int i = 0; i < 3; i++) {
			// sets count equal to runner as it needs to increase after every row of board but it should stay the same value in each row of board
			int count = runner;
			// this for loop goes through each row in each board (3 because the whole row is printed)
			for(int j = 0; j < 3; j++) {
				while(true) {
					System.out.print(" Board#" + count + " | ");
					// goes through each column in each board
					// this needs to be called 3 times in each row
					for(int k = 0; k < 3; k++) {
						System.out.print(boards[count].getMark(j,k) + " | ");
					}
					count++;
					// once count gets to 3 then the full row of 3 boards is done
					if(count == 3 || count == 6 || count == 9) {
						System.out.println();
						break;
					}
				}
				// resets the count to make sure it stays the same if all the rows of the 3 boards are not done
				if(j < 2) {
					count = runner;
				} else {
					// once the whole rows of boards is printed, then the program can move to the next row of boards
					runner += 3;
				}
			}
		}
	}
	
	public boolean boxToMark(int boardNum, String player, int row, int col ) {
		return boards[boardNum].boxToMark(player, row, col);
	}
	
	public String getMark(int boardNum, int row, int col) {
		return boards[boardNum].getMark(row, col);
	}
	
	public void setSizeBoard() {
		for(int i = 0; i < boards.length; i++) {
			boards[i].setSizeBoard(3, 3);
		}
	}
	
	public int emptyCells(int boardNum) {
		return boards[boardNum].emptyCells();
	}
	
	public int getColSize(int boardNum) {
		return boards[boardNum].getColSize();
	}
	
	public int getRowSize(int boardNum) {
		return boards[boardNum].getRowSize();
	}
	
	public boolean isFull(int boardNum) {
		return boards[boardNum].isFull();
	}
	
	public void emptyBoard(int boardNum) {
		// goes through each of the boards and sets the values equal to * if the value at that spot is equal to number value (0,1,2...)
		for(int i = 0; i < (boards[boardNum].getColSize() * boards[boardNum].getRowSize()); i++) {
			if(boards[boardNum].getMark(i/3, i%3).equals(""+(char)(i+48))){
				boards[boardNum].boxToMark("*", i/3, i%3);
			}
		}
	}
	
	public boolean checkDiagRL(int boardNum, String Mark) {
		return boards[boardNum].checkDiagRL(Mark);
	}

	public boolean checkDiagLR(int boardNum, String Mark) {
		return boards[boardNum].checkDiagLR(Mark);
	}
	
	public boolean checkCol(int boardNum, String Mark) {
		return boards[boardNum].checkCol(Mark);
	}
	
	public boolean checkRow(int boardNum, String Mark) {
		return boards[boardNum].checkRow(Mark);
	}
}
	
	
