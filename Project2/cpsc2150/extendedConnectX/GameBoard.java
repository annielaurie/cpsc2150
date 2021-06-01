/*
 * author: Annie Hayes
 * class: CPSC 2150
 * section: 004
 * date: 02/28/21
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

    /**
     * post     board = board[c][r]
     *          board values = " "
     */
    public GameBoard()
    {
        int c = getNumColumns();
        int r = getNumRows();
        board = new char[c+1][r+1];
        for (int i = 0; i <= c; i++)
        {
            for (int j = 0; j <= r; j++)
            {
                board[i][j] = ' ';
            }
        }

    }

    public void placeToken(char p, int c)
    {
        int r = getNumRows();
        if (checkIfFree(c) == false)
        {
            System.out.println("checkIfFree is false, no spaces left");
        } else {
            for(int i = 0; i <= r; i++)
            {
                if(board[c][i] == ' ')
                {
                    board[c][i] = p;
                    break;
                }
            }
        }


    }

    public char whatsAtPos(BoardPosition pos)
    {
        //checks whats at specified position
        int row = pos.getRow();
        int col = pos.getColumn();
        char val = board[col][row];
        return val;
    }




}
