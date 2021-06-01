/*
 * author: Annie Hayes
 * class: CPSC 2150
 * section: 004
 * date: 02/28/21
 */
package cpsc2150.extendedConnectX;

import java.util.Scanner;

public class GameScreen

/**
 * @invariants      0 < row < MAX_ROW
 *                  0 < column < MAX_COLUMN
 *
 * @preconditions   [GameBoard.java is implemented]
 *                  [BoardPosition.java is implemented]
 *                  [BoardPosition is formatted [<row>,<column>]]
 *                  [Player X goes first]
 *
 * @postconditions  [functions return correct data type with above constraints]
 *                  checkForWin = true OR checkForTie = true
 */

{
    private static GameBoard gameBoard = new GameBoard();
    private static char playerX = 'X';
    private static char playerO = 'O';
    private static char currentPlayer = playerX;

    private static int MAX_COLUMN = 8;
    private static int MAX_ROW = 5;
    private static boolean gameOn = true;
    private static boolean game = true;



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //print opening message
        System.out.println("Welcome to Your Game." +
                "To win you must get 5 in a row either vertically, horizontally or diagonally.\n" +
                "Enter the row then the column of where you would like to place your mark.");
        while (game == true) {

            if (gameOn == true) {
                //print marker input message
                System.out.println("Player " + currentPlayer + ", what column do you want to place your marker in?");

                //store marker input
                int columnEntered = scanner.nextInt();

                //if column is less than zero, display an error message
                if (columnEntered < 0) {
                    while (columnEntered < 0) {
                        System.out.println("Column cannot be less than 0");
                        System.out.println("Player " + currentPlayer + ", what column do you want to place your marker in?");
                        columnEntered = scanner.nextInt();
                    }
                }

                //if column is greater than the maximum number of columns, display an error message
                if (columnEntered > MAX_COLUMN) {
                    while (columnEntered > MAX_COLUMN) {
                        System.out.println("Column cannot be greater than 8");
                        System.out.println("Player " + currentPlayer + ", what column do you want to place your marker in?");
                        columnEntered = scanner.nextInt();
                    }
                }

                //if column is not free, re-prompt for column value
                if (gameBoard.checkIfFree(columnEntered) == false) {
                    //while column is full, re-prompt (this allows for multiple column errors
                    while (gameBoard.checkIfFree(columnEntered) == false) {
                        System.out.println("Column is full");
                        System.out.println("Player " + currentPlayer + ", what column do you want to place your marker in?");
                        columnEntered = scanner.nextInt();
                    }
                }

                //place marker
                gameBoard.placeToken(currentPlayer, columnEntered);

                //print the board
                System.out.println(gameBoard.toString());

                //if the marker placed wins the game, end game
                if (gameBoard.checkForWin(columnEntered) == true) {
                    System.out.println("Player " + currentPlayer + " Won!");
                    gameOn = false;
                }
                //if the game is a tie
                if (gameBoard.checkTie() == true) {
                    System.out.println("Game ends in a tie!");
                    gameOn = false;
                }

                //if the current player is playerX, switch to playerO, otherwise set playerX as the current player
                if (currentPlayer == playerX) {
                    currentPlayer = playerO;
                } else {
                    currentPlayer = playerX;
                }


            }
            //after game has ended
            if (gameOn == false)
            {
                //prompt for another game
                System.out.println("Would you like to play again? Y/N");
                String answer = scanner.next();

                //string variables for playing again
                String yes = "y";
                String no = "n";

                //if the user wants to end the game, quit
                if (answer.equalsIgnoreCase(no)) {
                    game = false;
                    break;
                }
                //if the user wants to play again reset board and set gameOn back to true
                if (answer.equalsIgnoreCase(yes)) {
                    gameBoard = new GameBoard();
                    gameOn = true;
                }
            }
        }
    }
}



