/*
 * author: Annie Hayes
 * class: CPSC 2150
 * section: 004
 * date: 03/24/21
 * project: project 3
 */

package cpsc2150.extendedConnectX;

/**
 * @invariants      0 < column < MAX_COLUMN
 *                  0 < row < MAX_ROW
 *
 * @preconditions   [GameBoard is implemented]
 *                  [BoardPosition is implemented]
 *                  [BoardPosition is formatted [<row>,<column>]]
 *
 * @postconditions  [functions return correct data type with above constraints]
 *                  [BoardPosition is formatted [<row>,<column>]]
 */
public abstract class AbsGameBoard implements IGameBoard
{
    /**
     * converts array to String for GameBoard
     *
     * @return      String of board format
     * @post        [board is formatted]
     */
    @Override
    public String toString()
    {
        //int j= getNumColumns();
        String board = "";
        for (int i = 0; i < getNumColumns(); i++)
        {
            if(i < 10)
            {
                board += "| " + i;
            }
            else
            {
                board += "|" + i;
            }
        }
        board += "|\n";
        for (int i = getNumRows() - 1; i >= 0; i--)
        {
            board +=  "|";
            for (int j = 0; j < getNumColumns(); j++){
                board += whatsAtPos(new BoardPosition(i,j)) + " |";

            }
            board += "\n";
        }

        return board;
    }
}
