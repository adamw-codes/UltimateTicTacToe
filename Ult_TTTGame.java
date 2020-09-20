package tictactoe;
import java.util.Scanner; 

public class Ult_TTTGame {
	private MainBoard board = new MainBoard();
	private MyBoard winnerTable = new MyBoard();
	private Player[] players = new Player[2];
	private Player cPlayer;
	private int currentPlayerIndex = -1;
	private String[] marks = {"X" , "O"};
	private int scoreToWin = 3;
	private int row = 3;
	private int col = 3;
	private int currentBoard = -1;
	
	public Ult_TTTGame() {
		setPlayers();
		start();
	}
	
	private void start() {
		System.out.println("===== WELCOME TO THE ULTIMATE TIC-TAC-TOE GAME!! =====");
		board.print();
		do {
			boolean CPUorPlayer = switchPlayers();
			cPlayer = players[currentPlayerIndex];
			// checks if it is the player's or CPU's turn
			if(CPUorPlayer) {
				playerMove();
			} else {
				cpuMove();
			}
			System.out.println();
			board.print();
			System.out.println();
		}while(!gameOver());
		
	}
	
	private boolean gameOver() {
		return isWinner() || allFull();
	}
	
	private boolean allFull() {
		// checks if one of the boards is empty
		for(int i = 0; i < (row*col); i++) {
			if(!board.isFull(i)) {
				return false;
			}
		}
		return true;		
	}
	
	private boolean isWinner() {
		isWinnerOfEach();
		// each if statement is used to check each individual way that a player could win
		// if any of those are met, then the method returns a true and a winner is given
		if(winnerTable.checkRow(players[currentPlayerIndex].getMark())) { 
			System.out.println("Winner is " + players[currentPlayerIndex].getMark());
			return true;
		}
		else if(winnerTable.checkCol(players[currentPlayerIndex].getMark())) {
			System.out.println("Winner is " + players[currentPlayerIndex].getMark());
			return true;
		}
		else if(winnerTable.checkDiagLR(players[currentPlayerIndex].getMark())) {
			System.out.println("Winner is " + players[currentPlayerIndex].getMark());
			return true;
		}
		else if(winnerTable.checkDiagRL(players[currentPlayerIndex].getMark())) {
			System.out.println("Winner is " + players[currentPlayerIndex].getMark());
			return true;
		}
		// if the board is full then return a true to indicate the game is over and that it is a tie
		else if(winnerTable.isFull()) {
			System.out.println("It's a tie!");
			return true;
		}
		// if no winner is found then it returns a false and the game continues
		else 
			return false;
	}
	
	private void isWinnerOfEach() {
		for(int i = 0; i < 9; i++) {
			// each if statement is used to check each individual way that a player could win the boards
			// if any of those are met, then the method returns a true the program inserts that player's mark in the winnerTable and then empties the board
			if(board.checkRow(i, players[currentPlayerIndex].getMark())) { 
				winnerTable.boxToMark(players[currentPlayerIndex].getMark(), i/3, i%3);
				board.emptyBoard(i);
			}
			else if(board.checkCol(i, players[currentPlayerIndex].getMark())) {
				winnerTable.boxToMark(players[currentPlayerIndex].getMark(), i/3, i%3);
				board.emptyBoard(i);
			}
			else if(board.checkDiagLR(i, players[currentPlayerIndex].getMark())) {
				winnerTable.boxToMark(players[currentPlayerIndex].getMark(), i/3, i%3);
				board.emptyBoard(i);
			}
			else if(board.checkDiagRL(i, players[currentPlayerIndex].getMark())) {
				winnerTable.boxToMark(players[currentPlayerIndex].getMark(), i/3, i%3);
				board.emptyBoard(i);
			}
			// if the board is full then it sets a dash in the spot to indicate that no one has won that spot
			else if(board.isFull(i)) {
				winnerTable.boxToMark("-", i/3, i%3);
			}
			// if no winner is found then it returns a false and the game continues
			else 
				continue;
		}
		// this goes through and checks if any of the boards has been won, if there are theya re displayed with the player
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 2; j++) {
				if(winnerTable.getMark(i/3, i%3).equals(players[j].getMark())){
					System.out.println("Winner of board " + i + " is " + players[j].getMark());
				}
			}
		}		
	}
	

	private void cpuMove() {
		int boardNum = currentBoard;
		// generates a random row and col to play on
		int rowNum = cPlayer.randomNumber(row);
		int colNum = cPlayer.randomNumber(col);
		System.out.println("Current Player: " + players[currentPlayerIndex].getMark());
		// checks if the board that is current is full or not, if it is, then a new board is picked
		while(true) {
			if(!board.isFull(boardNum)) {
				break;
			}
			System.out.println("The board picked from before was full! Playing on a different board.");
			boardNum = cPlayer.randomNumber(8);
		}
		// this while loop will try putting the mark in the spot given, if it does not work, then a new row and new col is given
		while(!board.boxToMark(boardNum, cPlayer.getMark(), rowNum, colNum)) {
			rowNum = cPlayer.randomNumber(row);
			colNum = cPlayer.randomNumber(col);
		}
		// currentBoard is set for the next turn
		currentBoard = colNum + (rowNum * board.getRowSize(boardNum));
		System.out.println(players[currentPlayerIndex].getMark() + " played on board: " + boardNum + " Spot: " + currentBoard);
	}
	
	
	private void playerMove() {
		Scanner in = new Scanner(System.in);
		int boardNum = currentBoard;
		System.out.println("Current Player: " + players[currentPlayerIndex].getMark());
		// this first if statement will only be triggered when the game starts as the baordNum will only equal -1 at the beginning
		// this is used to set the first board
		if(boardNum == -1) {
			System.out.println("Enter in a board number to get started: ");
			boardNum = in.nextInt();
		} else
			System.out.println("You must play on board: " + boardNum);
		// this while loop is used to check if board picked is already full, if it is then the program asked the user for a new input
		while(true) {
			if(!board.isFull(boardNum)) {
				break;
			}
			System.out.println("The board picked from before was full! Enter in a new board with available spaces: ");
			boardNum = in.nextInt();
		}
		
		System.out.println("Enter in a spot: ");
		int squareChoice = in.nextInt();
		// this while loop will continue trying to enter the spot, if the returned value from boxToMark is false (meaning the spot is taken) then the program asks the user for a new spot 
		while(!board.boxToMark(boardNum, cPlayer.getMark(), squareChoice / 3 , squareChoice % 3)) {
			System.out.println("Looks the spot you picked isn't free. Pick another spot: ");
			squareChoice = in.nextInt();
		}
		System.out.println("You played on board " + boardNum + " on the spot " + squareChoice);
		currentBoard = squareChoice;
	}
	
	private void setPlayers() {
		// runs a for loop the create each player based on position i
		for(int i = 0; i <  players.length; i++) {
			Player p = new Player("player" + i, marks[i]);
			// stores the current instance of player to the array
			players[i] = p;	
		}
	}
	
	private boolean switchPlayers() {
		// checks if the player index is -1 (the beginning value) or if its equal to 1)
		if(this.currentPlayerIndex == -1  || this.currentPlayerIndex == 1) {
			// if it is then it switches it to 0
			this.currentPlayerIndex = 0;
			return true;
		}
		else {
			this.currentPlayerIndex = 1;
			return false;
		}
		
	}
}
