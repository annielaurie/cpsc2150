package cpsc2150.extendedConnectX;
/*
 * author: Annie Hayes
 * class: CPSC 2150
 * section: 004
 * date: 02/07/21
 */
public class BoardPosition
{
    /**
     * @invariants      0 < MAX_COLUMN < 8
     *                  0 < MAX_ROW < 5
     * @preconditions   [GameBoard.java is implemented]
     *                  [GameScreen.java is implemented]
     *                  0 < MAX_COLUMN < 8
     *                  0 < MAX_ROW < 5
     *                  [BoardPosition is formatted [<row>,<column>]]
     * @postconditions  [functions return correct data type with above constraints]
     */

    /**
     * takes in row and column for constructor
     *
     * @param row the int that represents the row
     *           0 < row < MAX_ROW
     * @param column the int the represents the column
     *               0 < column < MAX_COLUMN
     */
    public BoardPosition(int row, int column)
    {

    }

    /**
     * gets row
     *
     * @return int returns the row
     */
    public int getRow()
    {

    }

    /**
     * gets column
     *
     * @return int returns the row
     */
    public int getColumn()
    {

    }

    /**
     * overrides equals method
     * BoardPosition equals another BoardPosition
     * if they have the same row and column
     *
     * @return boolean true or false
     */
    @Override
    public boolean equals()
    {

    }

    /**
     * overrides toString() method
     * creates a string
     *
     * @return String format is [<row>,<column>]
     */
    @Override
    public String toString()
    {

    }
}
