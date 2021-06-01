/*
 * author: Annie Hayes
 * class: CPSC 2150
 * section: 004
 * date: 03/24/21
 * project: project 3
 */

package cpsc2150.extendedConnectX;
  /**
   * This object will hold all the information about the gameboard, and will handle all interactions with the board
   *
   * Defines:     MAX_COLUMN: Z - the maximum number of columns in the board
   *              MAX_ROW: Z - the maximum number of rows in the board
   *              numToWin: Z - the number of markers it takes to win
   *              row: Z - the row in BoardPosition
   *              column: Z - the column in BoardPosition
   *
   *
   * Initialization Ensures: [board is initialized to " "]
   *                         [board is correct size]
   *
   * Constraints: [BoardPosition is implemented]
   *              [GameScreen is implemented]
   *              0 < column < MAX_COLUMN
   *              0 < row < MAX_ROW
   *
   */
public interface IGameBoard

{
        /**
         * returns the max number of rows
         *
         * @return      the number of rows
         * @post        getNumRow <= 100
         */
        public int getNumRows();

        /**
         * returns the max number of columns
         *
         * @return      the number of columns
         * @post        getNumColumns <= 100
         */
        public int getNumColumns();

        /**
         * returns the number of markers in a row it takes to win
         *
         * @return      numToWin the number of tokens it takes to win
         * @post        numToWin < 25
         */
        public int getNumToWin();

        /**
         * returns true if column can take another token
         *
         * @param       c he int for the column
         *              0 < c < MAX_COLUMN
         * @return      boolean true OR false
         * @post        checkIfFree iff (pos = " ")
         */
        default boolean checkIfFree(int c)
        {
                int r = getNumRows() - 1;
                BoardPosition pos = new BoardPosition(r, c);
                return (whatsAtPos(pos) == ' ');
        }


        /**
         * returns true if last placed token results in a win
         *
         * @param       c the int for the column
         *              0 < c < MAX_COLUMN
         * @return      boolean true OR false
         * @post       checkForWin iff (checkVerWin = true OR checkHorizWin = true OR checkDiagWin = true)
         */
        default public boolean checkForWin(int c)
        {
                //initialize variables
                int r = getNumRows();
                int col = getNumColumns();
                int currentRow = 0;
                char player = ' ';

                //find row position
                for (int i = 0; i < r; i++)
                {
                        if (whatsAtPos(new BoardPosition(i, c)) != ' ')
                        {
                                currentRow = i;
                        }
                }
                BoardPosition currentPos = new BoardPosition(currentRow, c);
                player = whatsAtPos(currentPos);

                //pass board position to checkVertWin
                if (checkVertWin(currentPos, player) == true)
                {
                        return true;
                }
                //pass board position to checkHorizWin
                if (checkHorizWin(currentPos, player) == true)
                {
                        return true;
                }
                //pass board position to checkDiagWin
                if (checkDiagWin(currentPos, player) == true)
                {
                        return true;
                }

                return false;
        }

        /**
         * returns true if GameBoard is full, which is a tie
         *
         * @return      boolean true OR false
         * @post        checkTie iff (row = " ")
         */
        default boolean checkTie()
        {
                int c = getNumColumns();
                int r = getNumRows();
                int count = 0;
                for (int i = 0; i < c; i++)
                {
                        if (checkIfFree(i) == false)
                        {
                                count++;
                        }
                }
                if (count == c)
                {
                        return true;
                }
                return false;
        }

        /**
         * places token for player in specified column
         * @param       p the char for the player
         *              p = [char value]
         * @param       c the int for the column
         *              0 < c < MAX_COLUMN
         * @return      void
         * @post        [token is placed in the lowest empty row of column c]
         */
        public void placeToken(char p, int c);

        /**
         * returns true if player has a horizontal win
         *
         * @param       pos the current BoardPosition
         *              [0,0] < pos < [MAX_ROW,MAX_COLUMN]
         * @param       p the char for the player
         *              p = [char value]
         * @return      boolean true OR false
         * @post        checkHorizWin iff (numToWin = 5)
         */
        default boolean checkHorizWin(BoardPosition pos, char p)
        {
                int numToWin = getNumToWin();
                int col = getNumColumns();
                int r = pos.getRow();
                int streak = 0;

                for (int i = 0; i < col; i++)
                {
                        if (isPlayerAtPos(new BoardPosition(r, i), p))
                        {
                                streak++;
                                if (streak == numToWin)
                                {
                                        return true;
                                }
                        } else
                        {
                                streak = 0;
                        }

                }
                return (streak == numToWin);
        }

        /**
         * returns true if player has a vertical win
         *
         * @param       pos the current BoardPosition
         *              [0,0] < pos < [MAX_ROW,MAX_COLUMN]
         * @param       p the char for the player
         *              [char value]
         * @return      boolean true OR false
         * @post        checkVertWin iff (numToWin = 5)
         */
        default boolean checkVertWin(BoardPosition pos, char p)
        {
                //initialize max values
                int numToWin = getNumToWin();
                int max_r = getNumRows();

                //initialize current column values
                int col = pos.getColumn();

                //variable for winning streak
                int streak = 0;

                for (int i = 0; i < max_r; i++) {
                        if (isPlayerAtPos(new BoardPosition(i, col), p)) {
                                streak++;
                        }
                }
               return (streak >= numToWin);

        }


        /**
         * returns true if player has a vertical win
         *
         * @param       pos the current BoardPosition
         *              [0,0] < pos < [MAX_ROW,MAX_COLUMN]
         * @param       p the char for the player
         *              [char value]
         * @return      boolean true OR false
         * @post        checkDiagWin iff (numToWin = 5)
         */
        default boolean checkDiagWin(BoardPosition pos, char p) {

                //initialize variables
                int maxRows = getNumRows();
                int maxCols = getNumColumns();
                int wins = getNumToWin();
                int r = pos.getRow();
                int c = pos.getColumn();
                int streak = 1;
                char currentPlayer;

                //check up & right side
                for (int i = r + 1, j = c + 1; i < maxRows && j < maxCols; i++, j++) {
                        currentPlayer = whatsAtPos(new BoardPosition(i, j));
                        if (currentPlayer == p) {
                                streak++;
                        } else {
                                break;
                        }
                }
                if (streak == wins) {
                        return true;
                }
                //check down & left
                for (int i = r - 1, j = c - 1; i >= 0 && j >= 0; i--, j--) {
                        currentPlayer = whatsAtPos(new BoardPosition(i, j));
                        if (currentPlayer == p){
                                streak++;
                        } else {
                                break;
                        }
                }
                if (streak == wins) {
                        return true;
                }
                //check up & left
                streak = 1;
                for (int i = r + 1, j = c - 1; i < maxRows && j >= 0; i++, j--)
                {
                        currentPlayer = whatsAtPos(new BoardPosition(i, j));
                        if (currentPlayer == p){
                                streak++;
                        } else
                                {
                                break;
                        }
                }
                if (streak == wins)
                {
                        return true;
                }
                //check down & right
                for (int i = r - 1, j = c + 1; i >= 0 && j < maxCols; i--, j++)
                {
                        currentPlayer = whatsAtPos(new BoardPosition(i, j));
                        if (currentPlayer == p){
                                streak++;
                                if (streak == wins) {
                                        return true;
                                }
                        } else {
                                break;
                        }
                }
                return (streak == wins);
        }


        /**
         * returns what is at specified BoardPosition
         *
         * @param       pos the BoardPositon
         *              [0,0] < pos < [MAX_ROW,MAX_COLUMN]
         * @return      char the character that is at position
         *              [char value]
         * @post        [the return char] = [char at BoardPosition pos]
         *              p = #p
         *              c = #c
         */
        public char whatsAtPos(BoardPosition pos);

        /**
         * returns true if BoardPosition char is the same as player
         *
         * @param       pos the BoardPositon
         *              [0,0] < pos < [MAX_ROW,MAX_COLUMN]
         * @param       player the char for the player
         *              [char value]
         * @return      boolean true OR false
         * @post        pos = pos AND player = player
         *              return boolean = true OR false
         *              pos = #pos
         *              player = #player
         *              self = #self
         */
        default boolean isPlayerAtPos(BoardPosition pos, char player)
        {
                if (player == whatsAtPos(pos))
                {
                        return true;
                }
                else
                {
                        return false;
                }

        }


    }

