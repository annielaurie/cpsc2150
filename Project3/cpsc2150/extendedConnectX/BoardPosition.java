/*
 * author: Annie Hayes
 * class: CPSC 2150
 * section: 004
 * date: 03/24/21
 * project: project 3
 */

package cpsc2150.extendedConnectX;

public class BoardPosition
/**
 * @invariants      0 < column < MAX_COLUMN
 *                  0 < row < MAX_ROW
 * @preconditions   [GameBoard is implemented]
 *                  [GameScreen is implemented]
 *
 *                  [BoardPosition is formatted [<row>,<column>]]
 * @postconditions  [functions return correct data type with above constraints]
 */

{
    private int row;
    private int column;

    /**
     * takes in row and column for constructor
     *
     * @param row the int that represents the row
     *           0 < row < MAX_ROW
     * @param column the int the represents the column
     *               0 < column < MAX_COLUMN
     * @post BoardPosition = (this.row, this.column)
     */
    public BoardPosition(int row, int column)
    {
        this.row = row;
        this.column = column;

    }


    /**
     * gets row
     *
     * @return int returns the row
     * @post getRow = row
     */
    public int getRow()
    {
        return row;
    }


    /**
     * gets column
     *
     * @return int returns the row
     * @post getColumn = column
     */
    public int getColumn()
    {
        return column;
    }


    /**
     * overrides equals method
     * BoardPosition equals another BoardPosition
     * if they have the same row and column
     *
     * @param val Object being compared
     *
     * @return boolean true or false
     */
    @Override
    public boolean equals(Object val)
    {
        if (val.getClass() != getClass())
        {
            return false;
        }
        BoardPosition x = (BoardPosition)val;
        return (x.getRow() == getRow() && x.getColumn() == getColumn());
    }


    /**
     * overrides toString() method
     * creates a string
     *
     * @return String format is [<row>,<column>]
     * @post get row and get column
     *      [BoardPosition does not change]
     */
    @Override
    public String toString()
    {
        String val = "[";
        val += this.getColumn() + "," + this.getRow() + "]";
        return val;
    }
}
