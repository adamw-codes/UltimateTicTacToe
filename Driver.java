/*Adam Wajahat
 * CS2336.006
 * 
 * 
 * Analysis
 * This project requires that there be an Ultimate tictactoe board with 9 individual boards in which
 * the program manages all of them at the same time. Once the game starts, a board is selected in which the user will
 * then also pick a spot. This starts the game. The next move's board has to be from the same number of the spot from
 * the previous move. The program needs to also needs to clear the board (fill in empty spaces with *) once one of the
 * boards has one. If a board has been called on by the previous move, but it is full, then there should be a choice for
 * a new board with open spaces. The user or the bot has to get three boards in a row to win. If there is no winner, the
 * program needs to tell the user that there has been a tie.
 * 
 *Design
 *To construct this program, I had to break down each of the responsibilities down so I could create individual classes for each
 *I started with the board class. This class has a two dimensional character array that holds in the values. In the constructor, I made a
 *methods that fills in the values for the numbers. This class also has getters, setters, a function to determine if the board is full, 
 *and set the mark in that spot. I also decided to put the check col, check row, checkRL, and check LR methods 
 *
 *I then created another class called MainBoard that was the class that created the board with 9 of the individual boards. I did this by creating
 *a 9 sized MyBoard array. Then, I just used the rest of the functions almost like a wrapper class, calling on that specific index of the array with
 *the function call. This is what was used as the board the Ultimate TTTGame class called on.
 *
 *The next class I made was the player class. I created this class with an overloaded constructor to take in the values for the name of the player and the 
 *mark. Then I had setters and getters for both of these variables. I also created a random int generator in this class as it was needed later on in the code.
 *
 *I used an enum class called Mark which the Player class uses to get the player's marks. 
 *
 *The final class was the Ult_TTTGame class, I created this class by first setting the players and the MainBoard. Then I created a sepearate MyBoard to hold the spots
 *of the winner's table. The main part of the program was a dowhile loop that would switch between players and then depending on which player is called, the program will call
 *on the method for that user. At the beginning of the game, the player method is called so the user can pick the first board and spot to get the game start. Then, I used a while
 *loop that will continue trying to insert the mark in that spot. If it fails, then the program prompts the user to enter in a new spot. Finally, it tells the user which spot and position
 *it played. For the CPU move, the program generates a random number 0 to 8, and then tries putting in the value, if it does not work, then the program plays in a new spot. For both of these 
 *moves, I created a input validation for the number inserted and also if the board that is supposed to be played is full, then it lets the user pick a new one or the bot generates a new number.
 *Once each iteration is done, the players are switched. This is done with the switchPlayers method. This dowhile loop keeps going until the method gameOver returns a true (which is then turned into a 
 *false which ends the game). The gameOver simply returns the boolean value from the method isWinner and allFull. allFull checks if one of the boards is open, if it is then it returns a false. The isWinner method first calls isWinnerOfEach 
 *which goes through each of the boards and checks if there is a winner. If there is a winner then that player is added to the winnerTable in that spot. Then, the program also empties out the board to add in the *.
 *Once each of the boards has been checked with isWinnerOfEach, then the program goes back to the isWinner and checks if winnerTable has any winners or a tie. If it does, then it displays that winner. 
 * 
 * 
 * Tests
 * I tested the program with:
 * player win
 * CPU win
 * a tie
 * full board with no winner
 * I also tried putting in another values other than 0-8 and the program would not let me put in
 * 
 * 
 */

package tictactoe;

public class Driver {

    public static void main(String[] args) {

       Ult_TTTGame game = new Ult_TTTGame();

    }

}
