  /*
   * author: Annie Hayes
   * class: CPSC 2150
   * section: 004
   * date: 02/28/21
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
       int MAX_ROW = 5;
       int MAX_COLUMN = 8;
       int numToWin = 5;

        /**
         * places token for player in specified column
         * @param       p the char for the player
         *              p = 'O' OR p = 'X'
         * @param       c the int for the column
         *              0 < c < MAX_COLUMN
         * @return      void
         * @post        [token is placed in the lowest empty row of column c]
         */
        public void placeToken(char p, int c);

        /**
         * returns what is at specified BoardPosition
         *
         * @param       pos the BoardPositon
         *              [0,0] < pos < [MAX_ROW,MAX_COLUMN]
         * @return      char the character that is at position
         *              char = 'O' or char = 'X'
         * @post        [the return char] = [char at BoardPosition pos]
         *              p = #p
         *              c = #c
         */
        public char whatsAtPos(BoardPosition pos);

        /**
         * returns true if column can take another token
         *
         * @param       c he int for the column
         *              0 < c < MAX_COLUMN
         * @return      boolean true OR false
         * @post        checkIfFree iff (pos = " ")
         */
        default public boolean checkIfFree(int c)
        {
                int r = getNumRows();
                BoardPosition pos = new BoardPosition(c, r);
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
                BoardPosition lastPlaced = null;
                char player = ' ';

                //find row position
                for (int i = r; i >= 0; i--)
                {
                        if (whatsAtPos(new BoardPosition(c, i)) != ' ')
                        {
                                lastPlaced = new BoardPosition(c, i);
                                player = whatsAtPos(lastPlaced);
                                break;
                        }
                }

                //pass board position to checkVertWin
                if (checkVertWin(lastPlaced, player) == true)
                {
                        return true;
                }
                //pass board position to checkHorizWin
                if (checkHorizWin(lastPlaced, player) == true)
                {
                        return true;
                }
                //pass board position to checkDiagWin
                if (checkDiagWin(lastPlaced, player) == true)
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
        default public boolean checkTie()
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
         * returns true id player has a horizontal win
         *
         * @param       pos the current BoardPosition
         *              [0,0] < pos < [MAX_ROW,MAX_COLUMN]
         * @param       p the char for the player
         *              p = 'O' OR p = 'X'
         * @return      boolean true OR false
         * @post        checkHorizWin iff (numToWin = 5)
         */
        default public boolean checkHorizWin(BoardPosition pos, char p)
        {
                int numToWin = getNumToWin();
                int max_col = getNumColumns();
                int col = pos.getColumn();
                int r = pos.getRow();
                int streak = 0;
                for(int i = col; i >= 0; i--) {
                        if (whatsAtPos(new BoardPosition(i, r)) == p) {
                                streak++;
                                if (streak >= numToWin)
                                {
                                        return true;
                                }
                        } else {
                                break;
                        }
                }
                for(int i = col+1; i <= max_col; i++) {
                        if (whatsAtPos(new BoardPosition(i, r)) == p)
                        {
                                streak++;
                                if (streak >= numToWin)
                                {
                                        return true;
                                }
                        } else {
                                break;
                        }
                }
                return false;

        }

        /**
         * returns true if player has a vertical win
         *
         * @param       pos the current BoardPosition
         *              [0,0] < pos < [MAX_ROW,MAX_COLUMN]
         * @param       p the char for the player
         *              p = 'O' OR p = 'X'
         * @return      boolean true OR false
         * @post        checkVertWin iff (numToWin = 5)
         */
        default public boolean checkVertWin(BoardPosition pos, char p)
        {
                //initialize max values
                int numToWin = getNumToWin();
                int max_r = getNumRows();

                //initialize current column & row values
                int col = pos.getColumn();
                int r = pos.getRow();

                //variable for winning streak
                int streak = 0;

                //check down in column
                for(int i = r; i >= 0; i--) {
                        if (whatsAtPos(new BoardPosition(col, i)) == p) {
                                streak++;
                                if (streak >= numToWin)
                                {
                                        return true;
                                }
                        } else {
                                break;
                        }
                }
                //check up in column
                for(int i = r+1; i <= max_r; i++) {
                        if (whatsAtPos(new BoardPosition(col, i)) == p)
                        {
                                streak++;
                                if (streak >= numToWin)
                                {
                                        return true;
                                }
                        } else {
                                break;
                        }
                }
                return false;

        }



        /**
         * returns true if player has a vertical win
         *
         * @param       pos the current BoardPosition
         *              [0,0] < pos < [MAX_ROW,MAX_COLUMN]
         * @param       p the char for the player
         *              p = 'O' OR p = 'X'
         * @return      boolean true OR false
         * @post        checkDiagWin iff (numToWin = 5)
         */
        default public boolean checkDiagWin(BoardPosition pos, char p) {
                //initialize variables
                int numToWin = getNumToWin();
                int spaces = 1;
                int i = 1;
                int r = pos.getRow();
                int c = pos.getColumn();
                int part = 1;

                //board position
                BoardPosition current = pos;

                while (part == 1) {
                        // checks below and to the left
                        while (r - i >= 0 && c - i >= 0) {
                                current = new BoardPosition(c - i, r - i);
                                if (whatsAtPos(current) == p) {
                                        spaces++;
                                        if (spaces == numToWin)
                                                return true;
                                } else
                                        break;
                                i++;
                        }

                        //reset variables back
                        i = 1;
                        current = pos;

                        // checks above and to the right
                        while (r + i < getNumRows() && pos.getColumn() + i < getNumColumns()) {
                                current = new BoardPosition(c + i, r + i);
                                if (whatsAtPos(current) == p) {
                                        spaces++;
                                        if (spaces == numToWin) {
                                                return true;
                                        }
                                } else
                                        break;
                                i++;
                        }
                        part++;
                }

                //reset variables back
                spaces = 1;
                part = 2;
                i = 1;
                current = pos;

                while(part == 2) {
                        //checks above and to the left
                        while (r + i < getNumRows() && c - i >= 0) {
                                current = new BoardPosition(c - i, r + i);
                                if (whatsAtPos(current) == p) {
                                        spaces++;
                                        if (spaces == numToWin)
                                                return true;
                                } else
                                        break;
                                i++;
                        }

                        //reset variables back
                        i = 1;
                        current = pos;

                        //checks below and to the right
                        while (r - i >= 0 && c + i < getNumColumns()) {
                                current = new BoardPosition(c + i, r - i);
                                if (whatsAtPos(current) == p) {
                                        spaces++;
                                        if (spaces == numToWin)
                                                return true;
                                } else
                                        break;
                                i++;
                        }
                        part++;
                }
                return false;
        }


        /**
         * returns true if BoardPosition char is the same as player
         *
         * @param       pos the BoardPositon
         *              [0,0] < pos < [MAX_ROW,MAX_COLUMN]
         * @param       player the char for the player
         *              p = 'O' OR p = 'X'
         * @return      boolean true OR false
         * @post        pos = pos AND player = player
         *              return boolean = true OR false
         *              pos = #pos
         *              player = #player
         *              self = #self
         */
        default public boolean isPlayerAtPos(BoardPosition pos, char player)
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

        /**
         * returns the max number of rows
         *
         * @return      MAX_ROW
         * @post        getNumRow = MAX_ROW
         */

       default public int getNumRows()
        {
                return MAX_ROW;
        }

        /**
         * returns the max number of columns
         *
         * @return      MAX_COLUMN
         * @post        getNumColumns = MAX_COLUMN
         */
      default public int getNumColumns()
        {
                return MAX_COLUMN;
        }

        /**
         * returns the number of markers in a row it takes to win
         *
         * @return numToWin
         * @post getNumToWin = numToWin
         */
       default public int getNumToWin()
        {
                return numToWin;
        }


    }

