/*
* author: Annie Hayes
* class: CPSC 2150
* section: 004
* date: 02/28/21
*/

package cpsc2150.extendedConnectX;
/**
 * @invariants      0 < column < MAX_COLUMN
 *                  0 < row < MAX_ROW
 * @preconditions   [BoardPosition.java is implemented]
 *                  [GameBoard.java is implemented]
 *                  [GameScreen.java is implemented]
 *
 *
 * @postconditions  [functions return correct data type with above constraints]
 *                  [BoardPosition is formatted [<row>,<column>]]
 */
public abstract class AbsGameBoard implements IGameBoard
{
    /**
     * converts array to String for GameBoard
     *
     * @return String
     * @post [board is formatted]
     */
    @Override
    public String toString()
    {
        //int j= getNumColumns();
        String board = "";
         board += "|0|1|2|3|4|5|6|7|8|\n";
        for (int i = getNumRows(); i >= 0; i--)
         {
             for (int j = 0; j <= getNumColumns(); j++){
                 board += "|" + whatsAtPos(new BoardPosition(j,i));

                 //board += "|" + i + j;
             }
            board += "|\n";
        }


        return board;
    }
}
