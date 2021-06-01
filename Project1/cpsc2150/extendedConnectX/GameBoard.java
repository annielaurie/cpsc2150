package cpsc2150.extendedConnectX;
/*
 * author: Annie Hayes
 * class: CPSC 2150
 * section: 004
 * date: 02/07/21
 */
public class GameBoard
{
    /**
     * @invariants      0 < MAX_COLUMN < 8
     *                  0 < MAX_ROW < 5
     * @preconditions   [BoardPosition is implemented]
     *                  [GameScreen is implemented]
     *                  0 < MAX_COLUMN < 8
     *                  0 < MAX_ROW < 5
     * @postconditions  [functions return correct data type with above constraints]
     *
     */

    /**
     * returns true if column can take another token
     *
     * @param c the int for the column
     *          0 < c < MAX_COLUMN
     * @return boolean true OR false
     */
    public boolean checkIfFree(int c)
    {

    }

    /**
     * returns true if last placed token results in a win
     *
     * @param c the int for the column
     *          0 < c < MAX_COLUMN
     * @return boolean true OR false
     */
    public boolean checkForWin(int c)
    {

    }

    /**
     * returns true if GameBoard is full,
     * which is a tie
     *
     * @return boolean true OR false
     */
    public boolean checkTie()
    {

    }
    /**
     * places token for player in specified column
     *
     * @param p the char for the player
     *          p = 'O' OR p = 'X'
     * @param c the int for the column
     *          0 < c < MAX_COLUMN
     * @return void
     */
    public void placeToken(char p, int c)
    {

    }

    /**
     * returns true id player has a horizontal win
     *
     * @param pos the current BoardPosition
     *            [0,0] < pos < [MAX_ROW,MAX_COLUMN]
     * @param p the char for the player
     *           p = 'O' OR p = 'X'
     * @return boolean true OR false
     */
    public boolean checkHorizWin(BoardPosition pos, char p)
    {

    }

    /**
     * returns true if player has a vertical win
     *
     * @param pos the current BoardPosition
     *          [0,0] < pos < [MAX_ROW,MAX_COLUMN]
     * @param p the char for the player
     *          p = 'O' OR p = 'X'
     * @return boolean true OR false
     */
    public boolean checkVertWin(BoardPosition pos, char p)
    {

    }

    /**
     * returns what is at specified BoardPosition
     *
     * @param pos the BoardPositon
     *            [0,0] < pos < [MAX_ROW,MAX_COLUMN]
     * @return char the character that is at position
     *            char = 'O' or char = 'X'
     */
    public char whatsAtPos(BoardPosition pos)
    {

    }

    /**
     * returns true if BoardPosition char is the same as player
     *
     * @param pos the BoardPositon
     *            [0,0] < pos < [MAX_ROW,MAX_COLUMN]
     * @param player the char for the player
     *            p = 'O' OR p = 'X'
     * @return boolean true OR false
     */
    public boolean isPlayerAtPos(BoardPosition pos, char player)
    {

    }

    /**
     * converts array to String for GameBoard
     *
     * @return String
     */
    @Override
    public String toString()
    {

    }

}
