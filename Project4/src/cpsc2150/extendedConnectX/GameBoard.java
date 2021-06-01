/*
 * author: Annie Hayes
 * class: CPSC 2150
 * section: 004
 * date: 03/24/21
 * project: project 3
 */
package cpsc2150.extendedConnectX;


public class GameBoard extends AbsGameBoard

/**
 * @invariants      0 < MAX_COLUMN < 8
 *                  0 < MAX_ROW < 5
 * @preconditions   [BoardPosition is implemented]
 *                  [GameScreen is implemented]
 *                  0 < MAX_COLUMN < 8
 *                  0 < MAX_ROW < 5
 * @postconditions  [functions return correct data type with above constraints]
 * @coreespondance
 *
 */

{
    //initiate board
    private final char[][] board;
    private int cols;
    private int rows;
    private int winNum;

    /**
     * post     board = board[c][r]
     *          board values = " "
     */
    public GameBoard(int row, int col, int win)
    {
        cols = col;
        rows = row;
        winNum = win;
        board = new char[rows][cols];
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < cols; j++)
            {
                board[i][j] = ' ';
            }
        }

    }

    public int getNumRows()
    {
        return rows;
    }


    public int getNumColumns()
    {
        return cols;
    }


    public int getNumToWin()
    {
        return winNum;
    }


    public void placeToken(char p, int c)
    {
        for(int i = 0; i <= getNumRows(); i++)
        {
            if(board[i][c] == ' ')
            {
                board[i][c] = p;
                break;
            }
        }
    }


    public char whatsAtPos(BoardPosition pos)
    {
        //checks whats at specified position
        int row = pos.getRow();
        int col = pos.getColumn();
        char val = board[row][col];
        return val;
    }


}
