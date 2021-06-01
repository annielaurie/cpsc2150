/*
 * author: Annie Hayes
 * class: CPSC 2150
 * section: 004
 * date: 03/24/21
 * project: project 3
 */
package cpsc2150.extendedConnectX;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class GameScreen {
    /**
     * @invariants      0 < row < MAX_ROW
     *                  0 < column < MAX_COLUMN
     *
     * @preconditions   [GameBoard is implemented]
     *                  [BoardPosition is implemented]
     *                  [BoardPosition is formatted [<row>,<column>]]
     *
     * @postconditions  [functions return correct data type with above constraints]
     *                  checkForWin = true OR checkForTie = true
     */

    //initialize final variables
    public static final int MIN = 3;
    public static final int MAX = 100;
    public static final int MAX_WINS = 25;
    public static final int PLAYER_MIN = 2;
    public static final int PLAYER_MAX = 10;

    public static void main(String[] args) {

        //initialize varaibles & objects
        Scanner scanner = new Scanner(System.in);
        int row, col, win, playerCount;
        int currentPlayer = 0;
        IGameBoard gameBoard = new GameBoard(0, 0, 0);
        boolean gameOn = true;

        System.out.println("Welcome to Your Game." +
                "To win you must get 5 in a row either vertically, horizontally or diagonally.\n" +
                "Enter the row then the column of where you would like to place your mark.");

        while(gameOn) {

            boolean GameWon = false;
            do {
                //prompt for the number of players
                System.out.print("How many players?\n");
                playerCount = scanner.nextInt();
                scanner.nextLine();

                //check player count is valid
                if (playerCount < PLAYER_MIN) {
                    System.out.print("Must be at least 2 players\n");
                }
                if (playerCount > PLAYER_MAX) {
                    System.out.print("Must be 10 players or fewer\n");
                }
            } while (playerCount < PLAYER_MIN || playerCount > PLAYER_MAX);

            //prompt for player chars
            List<Character> playerList = new ArrayList<>(playerCount);

            for (int i = 1; i <= playerCount; i++) {
                System.out.print("Enter the character to represent player " + i + "\n");
                char token = Character.toUpperCase(scanner.next().charAt(0));

                //check that char hasn't already been chosen
                while (playerList.contains(token)) {
                    System.out.print(token + " is already taken as a player token!\n");
                    System.out.print("Enter the character to represent player " + i + "\n");
                    token = Character.toUpperCase(scanner.next().charAt(0));
                }
                playerList.add(token);
            }

            //prompt for number of rows for board
            do {
                System.out.print("How many rows should be on the board?\n");
                row = scanner.nextInt();
                scanner.nextLine();
                //check row number is valid
                if(row < MIN) {
                    System.out.print("Must be at least 3 rows\n");
                }
                if(row > MAX) {
                    System.out.print("Must be 100 rows or fewer\n");
                }
            } while (row < MIN || row > MAX);

            //prompt for number of columns for board
            do {
                System.out.print("How many columns should be on the board?\n");
                col = scanner.nextInt();
                scanner.nextLine();
                //check column number is valid
                if(col < MIN) {
                    System.out.print("Must be at least 3 columns\n");
                }
                if(col > MAX) {
                    System.out.print("Must be 100 columns or fewer\n");
                }
            } while (col < MIN || col > MAX);


            //prompt for number of tokens it takes to win
            int maxWins = 0;

            if(col >= row) {
                maxWins = col;
            }
            else if(col < row) {
                maxWins = row;
            }
            do {
                System.out.print("How many in a row to win?\n");
                win = scanner.nextInt();
                scanner.nextLine();
                //check that number is between max & min values
                if(win > maxWins) {
                    System.out.print("Must be less than or equal to the largest number of rows or columns\n");
                }
                else if(win < MIN) {
                    System.out.print("The minimum acceptable value here is 3\n");
                }
                else if(win > MAX_WINS) {
                    System.out.print("The maximum acceptable value here is 25\n");
                }
            }
            while ((win > maxWins) || (win > row) || (win > col));



            System.out.print("Would you like a Fast Game (F/f) or a Memory Efficient Game (M/m)?\n");
            char typeInput = Character.toUpperCase(scanner.next().charAt(0));
            //check that char is valid
            if (typeInput != 'F' && typeInput != 'M') {
                do {
                    System.out.print("Must be either F, f, M, m\n");
                    typeInput = Character.toUpperCase(scanner.next().charAt(0));
                } while (typeInput != 'F' && typeInput != 'M');
            }

            //initialize board for fast game
            if (typeInput == 'F') {
                gameBoard = new GameBoard(row, col, win);
            }
            //initialize board for memory-efficient game
            if (typeInput == 'M')
            {
                gameBoard = new GameBoardMem(row, col, win);
            }

            System.out.println(gameBoard.toString());

            //while the game is still being played
            while (!GameWon || gameBoard.checkTie()) {
                System.out.print("Player " + playerList.get(currentPlayer) + ", what column do you want to place your marker in?\n");
                int columnPicked = scanner.nextInt();
                do {
                    if (columnPicked < 0) {
                        System.out.print("Column cannot be less than 0\n");
                        System.out.print("Player " + playerList.get(currentPlayer) + ", what column do you want to place your marker in?\n");
                        columnPicked = scanner.nextInt();
                    }
                    if (columnPicked > col) {
                        System.out.print("Column cannot be greater than " + (col - 1) + "\n");
                        System.out.print("Player " + playerList.get(currentPlayer) + ", what column do you want to place your marker in?\n");
                        columnPicked = scanner.nextInt();
                    }
                    if (!gameBoard.checkIfFree(columnPicked)) {
                        System.out.print("Column is full\n");
                        System.out.print("Player " + playerList.get(currentPlayer) + ", what column do you want to place your marker in?\n");
                        columnPicked = scanner.nextInt();
                    }
                }while (columnPicked < 0 || columnPicked > col || !gameBoard.checkIfFree(columnPicked));

                //place token & print game board
                gameBoard.placeToken(playerList.get(currentPlayer), columnPicked);
                System.out.println(gameBoard.toString());

                //check for win
                GameWon = gameBoard.checkForWin(columnPicked);

                //if game has been won or ended in a tie
                if (GameWon || gameBoard.checkTie()) {

                    //if game is won
                    if (gameBoard.checkForWin(columnPicked)) {
                        System.out.print("Player " + playerList.get(currentPlayer) + " won the game!\n");
                    }
                    //if game is a tie
                    if (gameBoard.checkTie()) {
                        System.out.print("The game was a tie.\n");
                    }

                    //prompt to play again
                    boolean correctInput = false;
                    while (!correctInput){
                        System.out.print("Would you like to play again? Y/N\n");
                        String answer = scanner.next();
                        //string variables for playing again
                        String yes = "y";
                        String no = "n";

                        //if the user wants to end the game, quit
                        if (answer.equalsIgnoreCase(no)) {
                            System.out.print("Game has ended\n");
                            gameOn = false;
                            correctInput = true;
                        }
                        //if the user wants to play again reset variables
                        if (answer.equalsIgnoreCase(yes)) {
                            currentPlayer = -1;
                            gameOn = true;
                            correctInput = true;
                        }
                    }
                }
                //change player turn
                if ((currentPlayer + 1) == playerCount)
                {
                    currentPlayer = 0;
                } else {
                    currentPlayer++;
                }
            }
        }
    }
}

