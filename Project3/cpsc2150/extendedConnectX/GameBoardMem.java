/*
 * author: Annie Hayes
 * class: CPSC 2150
 * section: 004
 * date: 03/24/21
 * project: project 3
 */
package cpsc2150.extendedConnectX;

import java.util.HashMap;
import java.util.Map;
import java.util.*;
import java.util.ArrayList;

public class GameBoardMem extends AbsGameBoard {
    /**
     * @invariants      0 < column < MAX_COLUMN
     *                  0 < row < MAX_ROW
     *
     * @preconditions   [GameScreen is implemented]
     *                  [IGameBoard is implemented]
     *                  [BoardPosition is implemented]
     *                  [BoardPosition is formatted [<row>,<column>]]
     *
     * @postconditions  [functions return correct data type with above constraints]
     * @coreespondance
     */


    int numRows, numCols, numWins;
    Map<Character, List<BoardPosition>> gameBoard = new HashMap<Character, List<BoardPosition>>();

    /**
     * post     GameBoard is initialized
     */
    public GameBoardMem(int r, int c, int win) {
        numRows = r;
        numCols = c;
        numWins = win;
    }

    /**
     * @param player    character of a player
     * @param col       the column chosen
     * @return          void
     * @pre             [player & col are valid]
     * @post            [player char is placed in column]
     */
    @Override
    public void placeToken(char player, int col) {
        if (!gameBoard.containsKey(player)) {
            gameBoard.put(player, new ArrayList<>());
        }
        for (int i = 0; i < getNumRows(); i++) {
            if (whatsAtPos(new BoardPosition(i, col)) == ' ') {
                gameBoard.get(player).add(new BoardPosition(i, col));
                break;
            }
        }
    }

    /**
     * @param pos      the current board position
     * @return         char at board position
     * @pre            none
     * @post           [char at position returned]
     */
    @Override
    public char whatsAtPos(BoardPosition pos) {
        for (HashMap.Entry<Character, List<BoardPosition>> map : gameBoard.entrySet()) {
            if (isPlayerAtPos(pos, map.getKey())) {
                return map.getKey();
            }
        }
        return ' ';
    }

    /**
     * @param pos       the current board position
     * @param player    is character of a player
     * @return          returns true if player is at position
     * @pre             [pos & player are valid]
     * @post            [true iff char at pos is player, false otherwise]
     */
    @Override
    public boolean isPlayerAtPos(BoardPosition pos, char player) {
        if (!gameBoard.containsKey(player)) {
            return false;
        }
        for (BoardPosition bp : gameBoard.get(player)) {
            if (bp.equals(pos)) {
                return true;
            }
        }
        return false;
    }

    /**
     * @return          numRows number of rows
     * @post            [number of rows returned]
     */
    public int getNumRows() {
        return numRows;
    }

    /**
     * @return          numCols number of columns
     * @post            [number of columns returned]
     */
    public int getNumColumns() {
        return numCols;
    }

    /**
     * @return          numWins number of tokens needed to win
     * @post            [number of tokens needed to win returned]
     */
    public int getNumToWin() {
        return numWins;
    }

}
