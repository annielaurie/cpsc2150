package cpsc2150.extendedConnectX;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TestGameBoard {

        private IGameBoard gb(int r, int c, int w) {
            return new GameBoard(r, c, w);
        }

        private String boardString(char[][] board, int row, int col) {
            String str = "";

            for (int i = 0; i < col; i++) {
                if (i < 10) {
                    str += "| " + i;
                } else {
                    str += "|" + i;
                }
            }

            str += "|\n";

            for (int i = row - 1; i >= 0; i--) {
                for (int j = 0; j < col; j++) {
                    str += "|" + board[i][j] + " ";
                }

                str += "|\n";
            }

            return str;

        }

        @Test
        public void ConstructorTest1_Min() {
            char board[][];
            board = new char[3][3];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    board[i][j] = ' ';
                }
            }

            IGameBoard CorrectBoard = gb(3, 3, 3);

            assertTrue(CorrectBoard.toString().equals(boardString(board, 3, 3)));
            assertTrue(CorrectBoard.getNumToWin() == 3);
        }

        @Test
        public void ConstructorTest2_Max() {
            char board[][];
            board = new char[100][100];
            for (int i = 0; i < 100; i++) {
                for (int j = 0; j < 100; j++) {
                    board[i][j] = ' ';
                }
            }

            IGameBoard CorrectBoard = gb(100, 100, 25);

            assertTrue(CorrectBoard.toString().equals(boardString(board, 100, 100)));
            assertTrue(CorrectBoard.getNumToWin() == 25);
        }

        @Test
        public void ConstructorTest3_Uneven() {
            char board[][];
            board = new char[10][5];
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 5; j++) {
                    board[i][j] = ' ';
                }
            }

            IGameBoard CorrectBoard = gb(10, 5, 4);

            assertTrue(CorrectBoard.toString().equals(boardString(board, 10, 5)));
            assertTrue(CorrectBoard.getNumToWin() == 4);
        }

        @Test
        public void CheckIfFree1_Full() {
            char board[][];
            board = new char[8][8];
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    board[i][j] = ' ';
                }
            }
            //test case
            for (int i = 0; i < 8; i++) {
                board[i][1] = 'X';
            }

            //correct test case
            IGameBoard CorrectBoard = gb(8, 8, 4);
            for (int i = 0; i < 8; i++) {
                CorrectBoard.placeToken('X', 1);
            }

            assertTrue(CorrectBoard.toString().equals(boardString(board, 8, 8)));
            assertTrue(!CorrectBoard.checkIfFree(1));
        }

        @Test
        public void CheckIfFree2_Empty() {
            //test case
            char board[][];
            board = new char[8][8];
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    board[i][j] = ' ';
                }
            }

            //correct test case
            IGameBoard CorrectBoard = gb(8, 8, 8);


            assertTrue(CorrectBoard.toString().equals(boardString(board, 8, 8)));
            assertTrue(CorrectBoard.checkIfFree(1));
        }

        @Test
        public void CheckIfFree3_OneLess() {
            //test case
            char board[][];
            board = new char[8][8];
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    board[i][j] = ' ';
                }
            }
            //test case
            for (int i = 0; i < 7; i++) {
                board[i][1] = 'X';
            }

            //correct test case
            IGameBoard CorrectBoard = gb(8, 8, 4);
            for (int i = 0; i < 7; i++) {
                CorrectBoard.placeToken('X', 1);
            }


            assertTrue(CorrectBoard.toString().equals(boardString(board, 8, 8)));
            assertTrue(CorrectBoard.checkIfFree(1));
        }

        @Test
        public void CheckHorizWin1_Min() {
            //test case
            char board[][];
            board = new char[3][3];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    board[i][j] = ' ';
                }
            }
            //test case
            for (int i = 0; i < 3; i++) {
                board[0][i] = 'X';
            }

            //correct test case
            IGameBoard CorrectBoard = gb(3, 3, 3);
            for (int i = 0; i < 3; i++) {
                CorrectBoard.placeToken('X', i);
            }

            assertTrue(CorrectBoard.toString().equals(boardString(board, 3, 3)));
            assertTrue(CorrectBoard.checkHorizWin(new BoardPosition(0, 1), 'X'));

        }

        @Test
        public void CheckHorizWin2_Middle() {
            //test case
            char board[][];
            board = new char[3][3];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    board[i][j] = ' ';
                }
            }
            //test case
            for (int i = 0; i < 3; i++) {
                board[0][i] = 'X';
                board[1][i] = 'O';
            }

            //correct test case
            IGameBoard CorrectBoard = gb(3, 3, 3);
            for (int i = 0; i < 3; i++) {
                CorrectBoard.placeToken('X', i);
            }
            for (int i = 0; i < 3; i++) {
                CorrectBoard.placeToken('O', i);
            }

            assertTrue(CorrectBoard.toString().equals(boardString(board, 3, 3)));
            assertTrue(CorrectBoard.checkHorizWin(new BoardPosition(1, 1), 'O'));

        }

        @Test
        public void CheckHorizWin3_Empty() {
            //test case
            char board[][];
            board = new char[3][3];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    board[i][j] = ' ';
                }
            }

            //correct test case
            IGameBoard CorrectBoard = gb(3, 3, 3);

            assertTrue(CorrectBoard.toString().equals(boardString(board, 3, 3)));
            assertTrue(!CorrectBoard.checkHorizWin(new BoardPosition(2, 2), 'X'));

        }

        @Test
        public void CheckHorizWin4_OneLess() {
            //test case
            char board[][];
            board = new char[4][4];
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    board[i][j] = ' ';
                }
            }
            //test case
            for (int i = 0; i < 3; i++) {
                board[0][i] = 'X';
            }

            //correct test case
            IGameBoard CorrectBoard = gb(4, 4, 4);
            for (int i = 0; i < 3; i++) {
                CorrectBoard.placeToken('X', i);
            }

            assertTrue(CorrectBoard.toString().equals(boardString(board, 4, 4)));
            assertTrue(!CorrectBoard.checkHorizWin(new BoardPosition(0, 1), 'X'));

        }

        @Test
        public void CheckVertWin1_Min() {
            //test case
            char board[][];
            board = new char[3][3];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    board[i][j] = ' ';
                }
            }
            //test case
            for (int i = 0; i < 3; i++) {
                board[i][0] = 'X';
            }

            //correct test case
            IGameBoard CorrectBoard = gb(3, 3, 3);
            for (int i = 0; i < 3; i++) {
                CorrectBoard.placeToken('X', 0);
            }

            assertTrue(CorrectBoard.toString().equals(boardString(board, 3, 3)));
            assertTrue(CorrectBoard.checkVertWin(new BoardPosition(2, 0), 'X'));
        }

        @Test
        public void CheckVertWin2_TooMany() {
            //test case
            char board[][];
            board = new char[5][5];
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    board[i][j] = ' ';
                }
            }
            //test case
            for (int i = 0; i < 5; i++) {
                board[i][0] = 'X';
            }

            //correct test case
            IGameBoard CorrectBoard = gb(5, 5, 4);
            for (int i = 0; i < 5; i++) {
                CorrectBoard.placeToken('X', 0);
            }

            assertTrue(CorrectBoard.toString().equals(boardString(board, 5, 5)));
            assertTrue(CorrectBoard.checkVertWin(new BoardPosition(2, 0), 'X'));
        }

        @Test
        public void CheckVertWin3_OneLess() {
            //test case
            char board[][];
            board = new char[5][5];
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    board[i][j] = ' ';
                }
            }
            //test case
            for (int i = 0; i < 3; i++) {
                board[i][0] = 'X';
            }

            //correct test case
            IGameBoard CorrectBoard = gb(5, 5, 4);
            for (int i = 0; i < 3; i++) {
                CorrectBoard.placeToken('X', 0);
            }


            assertTrue(CorrectBoard.toString().equals(boardString(board, 5, 5)));
            assertTrue(!CorrectBoard.checkVertWin(new BoardPosition(2, 0), 'X'));
        }
        @Test
        public void CheckVertWin4_Middle() {
            //test case
            char board[][];
            board = new char[5][5];
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    board[i][j] = ' ';
                }
            }
            //test case
            board[0][0] = 'O';
            board[1][0] = 'X';
            for (int i = 2; i < 5; i++) {
                board[i][0] = 'X';
            }

            //correct test case
            IGameBoard CorrectBoard = gb(5, 5, 4);
            CorrectBoard.placeToken('O', 0);
            for (int i = 0; i < 4; i++) {
                CorrectBoard.placeToken('X', 0);
            }


            assertTrue(CorrectBoard.toString().equals(boardString(board, 5, 5)));
            assertTrue(CorrectBoard.checkVertWin(new BoardPosition(3, 0), 'X'));
        }

        @Test
        public void CheckDiagWin1_MinNorthEast() {

            //test case
            char board[][];
            board = new char[3][3];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    board[i][j] = ' ';
                }
            }

            //test case
            board[0][0] = 'X';
            board[0][1] = 'O';
            board[0][2] = 'O';

            board[1][1] = 'X';
            board[1][2] = 'O';
            board[2][2] = 'X';

            //correct test case
            IGameBoard CorrectBoard = gb(3, 3, 3);
            CorrectBoard.placeToken('X', 0);
            CorrectBoard.placeToken('O', 1);
            CorrectBoard.placeToken('O', 2);

            CorrectBoard.placeToken('X', 1);
            CorrectBoard.placeToken('O', 2);
            CorrectBoard.placeToken('X', 2);


            assertTrue(CorrectBoard.toString().equals(boardString(board, 3, 3)));
            assertTrue(CorrectBoard.checkDiagWin(new BoardPosition(0, 0), 'X'));
        }

        @Test
        public void CheckDiagWin2_MinSouthWest() {

            //test case
            char board[][];
            board = new char[3][3];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    board[i][j] = ' ';
                }
            }

            //test case
            board[0][0] = 'X';
            board[0][1] = 'O';
            board[0][2] = 'O';

            board[1][1] = 'X';
            board[1][2] = 'O';
            board[2][2] = 'X';

            //correct test case
            IGameBoard CorrectBoard = gb(3, 3, 3);
            CorrectBoard.placeToken('X', 0);
            CorrectBoard.placeToken('O', 1);
            CorrectBoard.placeToken('O', 2);

            CorrectBoard.placeToken('X', 1);
            CorrectBoard.placeToken('O', 2);
            CorrectBoard.placeToken('X', 2);


            assertTrue(CorrectBoard.toString().equals(boardString(board, 3, 3)));
            assertTrue(CorrectBoard.checkDiagWin(new BoardPosition(2, 2), 'X'));
        }

        @Test
        public void CheckDiagWin3_MinSouthEast() {

            //test case
            char board[][];
            board = new char[3][3];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    board[i][j] = ' ';
                }
            }

            //test case
            board[0][0] = 'O';
            board[0][1] = 'O';
            board[0][2] = 'X';

            board[1][1] = 'X';
            board[1][0] = 'O';
            board[2][0] = 'X';

            //correct test case
            IGameBoard CorrectBoard = gb(3, 3, 3);
            CorrectBoard.placeToken('O', 0);
            CorrectBoard.placeToken('O', 1);
            CorrectBoard.placeToken('X', 2);

            CorrectBoard.placeToken('X', 1);
            CorrectBoard.placeToken('O', 0);
            CorrectBoard.placeToken('X', 0);


            assertTrue(CorrectBoard.toString().equals(boardString(board, 3, 3)));
            assertTrue(CorrectBoard.checkDiagWin(new BoardPosition(0, 2), 'X'));
        }

        @Test
        public void CheckDiagWin4_MinNorthWest() {

            //test case
            char board[][];
            board = new char[3][3];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    board[i][j] = ' ';
                }
            }

            //test case
            board[0][0] = 'O';
            board[0][1] = 'O';
            board[0][2] = 'X';

            board[1][1] = 'X';
            board[1][0] = 'O';
            board[2][0] = 'X';

            //correct test case
            IGameBoard CorrectBoard = gb(3, 3, 3);
            CorrectBoard.placeToken('O', 0);
            CorrectBoard.placeToken('O', 1);
            CorrectBoard.placeToken('X', 2);

            CorrectBoard.placeToken('X', 1);
            CorrectBoard.placeToken('O', 0);
            CorrectBoard.placeToken('X', 0);


            assertTrue(CorrectBoard.toString().equals(boardString(board, 3, 3)));
            assertTrue(CorrectBoard.checkDiagWin(new BoardPosition(2, 0), 'X'));
        }

        @Test
        public void CheckDiagWin5_MiddleSouthWest() {

            //test case
            char board[][];
            board = new char[8][8];
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    board[i][j] = ' ';
                }
            }

            //test case row 1
            board[0][2] = 'X';
            board[0][3] = 'O';
            board[0][4] = 'X';
            board[0][5] = 'O';
            //row 2
            board[1][2] = 'O';
            board[1][3] = 'X';
            board[1][4] = 'O';
            board[1][5] = 'X';
            //row 3
            board[2][2] = 'X';
            board[2][3] = 'O';
            board[2][4] = 'X';
            board[2][5] = 'O';
            //row 4
            board[3][5] = 'X';



            //correct test case
            IGameBoard CorrectBoard = gb(8, 8, 4);
            for (int i = 0; i < 3; i++) {
                if (i% 2 == 0) {
                    CorrectBoard.placeToken('X', 2);
                    CorrectBoard.placeToken('O', 3);
                    CorrectBoard.placeToken('X', 4);
                    CorrectBoard.placeToken('O', 5);
                } else
                {
                    CorrectBoard.placeToken('O', 2);
                    CorrectBoard.placeToken('X', 3);
                    CorrectBoard.placeToken('O', 4);
                    CorrectBoard.placeToken('X', 5);
                }
            }
            CorrectBoard.placeToken('X', 5);

            assertTrue(CorrectBoard.toString().equals(boardString(board, 8, 8)));
            assertTrue(CorrectBoard.checkDiagWin(new BoardPosition(0, 2), 'X'));
        }

        @Test
        public void CheckDiagWin6_MiddleNorthEast() {

            //test case
            char board[][];
            board = new char[8][8];
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    board[i][j] = ' ';
                }
            }

            //test case row 1
            board[0][2] = 'X';
            board[0][3] = 'O';
            board[0][4] = 'X';
            board[0][5] = 'O';
            //row 2
            board[1][2] = 'O';
            board[1][3] = 'X';
            board[1][4] = 'O';
            board[1][5] = 'X';
            //row 3
            board[2][2] = 'X';
            board[2][3] = 'O';
            board[2][4] = 'X';
            board[2][5] = 'O';
            //row 4
            board[3][5] = 'X';



            //correct test case
            IGameBoard CorrectBoard = gb(8, 8, 4);
            for (int i = 0; i < 3; i++) {
                if (i% 2 == 0) {
                    CorrectBoard.placeToken('X', 2);
                    CorrectBoard.placeToken('O', 3);
                    CorrectBoard.placeToken('X', 4);
                    CorrectBoard.placeToken('O', 5);
                } else
                {
                    CorrectBoard.placeToken('O', 2);
                    CorrectBoard.placeToken('X', 3);
                    CorrectBoard.placeToken('O', 4);
                    CorrectBoard.placeToken('X', 5);
                }
            }
            CorrectBoard.placeToken('X', 5);


            assertTrue(CorrectBoard.toString().equals(boardString(board, 8, 8)));
            assertTrue(CorrectBoard.checkDiagWin(new BoardPosition(3, 5), 'X'));
        }

        @Test
        public void CheckDiagWin7_MiddleSouthEast() {

            //test case
            char board[][];
            board = new char[8][8];
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    board[i][j] = ' ';
                }
            }

            //test case row 1
            board[0][2] = 'X';
            board[0][3] = 'O';
            board[0][4] = 'X';
            board[0][5] = 'O';
            //row 2
            board[1][2] = 'O';
            board[1][3] = 'X';
            board[1][4] = 'O';
            board[1][5] = 'X';
            //row 3
            board[2][2] = 'X';
            board[2][3] = 'O';
            board[2][4] = 'X';
            board[2][5] = 'O';
            //row 4
            board[3][2] = 'O';

            //correct test case
            IGameBoard CorrectBoard = gb(8, 8, 4);
            for (int i = 0; i < 3; i++) {
                if (i% 2 == 0) {
                    CorrectBoard.placeToken('X', 2);
                    CorrectBoard.placeToken('O', 3);
                    CorrectBoard.placeToken('X', 4);
                    CorrectBoard.placeToken('O', 5);
                } else
                {
                    CorrectBoard.placeToken('O', 2);
                    CorrectBoard.placeToken('X', 3);
                    CorrectBoard.placeToken('O', 4);
                    CorrectBoard.placeToken('X', 5);
                }
            }
            CorrectBoard.placeToken('O', 2);


            assertTrue(CorrectBoard.toString().equals(boardString(board, 8, 8)));
            assertTrue(CorrectBoard.checkDiagWin(new BoardPosition(3, 2), 'O'));
        }

        @Test
        public void CheckTie1_Empty() {

            //test case
            char board[][];
            board = new char[4][4];
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    board[i][j] = ' ';
                }
            }

            //correct test case
            IGameBoard CorrectBoard = gb(4, 4, 4);


            assertTrue(CorrectBoard.toString().equals(boardString(board, 4, 4)));
            assertTrue(!CorrectBoard.checkTie());
        }

        @Test
        public void CheckTie2_Full() {

            //test case
            char board[][];
            board = new char[4][4];
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    board[i][j] = ' ';
                }
            }

            //test case row 1
            board[0][0] = 'X';
            board[1][0] = 'O';
            board[2][0] = 'O';
            board[3][0] = 'X';
            //row 2
            board[0][1] = 'O';
            board[1][1] = 'O';
            board[2][1] = 'X';
            board[3][1] = 'X';
            //row 3
            board[0][2] = 'X';
            board[1][2] = 'O';
            board[2][2] = 'X';
            board[3][2] = 'X';
            //row 4
            board[0][3] = 'X';
            board[1][3] = 'X';
            board[2][3] = 'O';
            board[3][3] = 'O';

            //correct test case
            IGameBoard CorrectBoard = gb(4, 4, 4);
            CorrectBoard.placeToken('X', 0);
            CorrectBoard.placeToken('O', 0);
            CorrectBoard.placeToken('O', 0);
            CorrectBoard.placeToken('X', 0);

            CorrectBoard.placeToken('O', 1);
            CorrectBoard.placeToken('O', 1);
            CorrectBoard.placeToken('X', 1);
            CorrectBoard.placeToken('X', 1);

            CorrectBoard.placeToken('X', 2);
            CorrectBoard.placeToken('O', 2);
            CorrectBoard.placeToken('X', 2);
            CorrectBoard.placeToken('X', 2);

            CorrectBoard.placeToken('X', 3);
            CorrectBoard.placeToken('X', 3);
            CorrectBoard.placeToken('O', 3);
            CorrectBoard.placeToken('O', 3);

            assertTrue(CorrectBoard.toString().equals(boardString(board, 4, 4)));
            assertTrue(CorrectBoard.checkTie());
        }

        @Test
        public void CheckTie3_AlmostFullRight() {

            //test case
            char board[][];
            board = new char[4][4];
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    board[i][j] = ' ';
                }
            }

            //test case row 1
            board[0][0] = 'X';
            board[1][0] = 'O';
            board[2][0] = 'O';
            board[3][0] = 'X';
            //row 2
            board[0][1] = 'O';
            board[1][1] = 'O';
            board[2][1] = 'X';
            board[3][1] = 'X';
            //row 3
            board[0][2] = 'X';
            board[1][2] = 'O';
            board[2][2] = 'X';
            board[3][2] = 'X';
            //row 4
            board[0][3] = 'X';
            board[1][3] = 'X';
            board[2][3] = 'O';

            //correct test case
            IGameBoard CorrectBoard = gb(4, 4, 4);
            CorrectBoard.placeToken('X', 0);
            CorrectBoard.placeToken('O', 0);
            CorrectBoard.placeToken('O', 0);
            CorrectBoard.placeToken('X', 0);

            CorrectBoard.placeToken('O', 1);
            CorrectBoard.placeToken('O', 1);
            CorrectBoard.placeToken('X', 1);
            CorrectBoard.placeToken('X', 1);

            CorrectBoard.placeToken('X', 2);
            CorrectBoard.placeToken('O', 2);
            CorrectBoard.placeToken('X', 2);
            CorrectBoard.placeToken('X', 2);

            CorrectBoard.placeToken('X', 3);
            CorrectBoard.placeToken('X', 3);
            CorrectBoard.placeToken('O', 3);


            assertTrue(CorrectBoard.toString().equals(boardString(board, 4, 4)));
            assertTrue(!CorrectBoard.checkTie());
        }

        @Test
        public void CheckTie4_AlmostFullLeft() {

            //test case
            char board[][];
            board = new char[4][4];
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    board[i][j] = ' ';
                }
            }

            //test case row 1
            board[0][0] = 'X';
            board[1][0] = 'O';
            board[2][0] = 'O';

            //row 2
            board[0][1] = 'O';
            board[1][1] = 'O';
            board[2][1] = 'X';
            board[3][1] = 'X';
            //row 3
            board[0][2] = 'X';
            board[1][2] = 'O';
            board[2][2] = 'X';
            board[3][2] = 'X';
            //row 4
            board[0][3] = 'X';
            board[1][3] = 'X';
            board[2][3] = 'O';
            board[3][3] = 'O';

            //correct test case
            IGameBoard CorrectBoard = gb(4, 4, 4);
            CorrectBoard.placeToken('X', 0);
            CorrectBoard.placeToken('O', 0);
            CorrectBoard.placeToken('O', 0);


            CorrectBoard.placeToken('O', 1);
            CorrectBoard.placeToken('O', 1);
            CorrectBoard.placeToken('X', 1);
            CorrectBoard.placeToken('X', 1);

            CorrectBoard.placeToken('X', 2);
            CorrectBoard.placeToken('O', 2);
            CorrectBoard.placeToken('X', 2);
            CorrectBoard.placeToken('X', 2);

            CorrectBoard.placeToken('X', 3);
            CorrectBoard.placeToken('X', 3);
            CorrectBoard.placeToken('O', 3);
            CorrectBoard.placeToken('O', 3);


            assertTrue(CorrectBoard.toString().equals(boardString(board, 4, 4)));
            assertTrue(!CorrectBoard.checkTie());
        }

        @Test
        public void WhatAtPos1_SouthWest(){
            char board[][];
            board = new char[4][4];
            for(int i = 0; i < 4; i++){
                for(int j = 0; j < 4; j++){
                    board[i][j] = ' ';
                }
            }

            board[0][0] = 'X';

            IGameBoard CorrectBoard = gb(4, 4, 4);

            CorrectBoard.placeToken('X',0);

            assertTrue(CorrectBoard.toString().equals(boardString(board, 4, 4)));
            assertTrue(CorrectBoard.whatsAtPos(new BoardPosition(0,0)) == 'X');
        }
        @Test
        public void WhatAtPos2_SouthEast(){
            char board[][];
            board = new char[4][4];
            for(int i = 0; i < 4; i++){
                for(int j = 0; j < 4; j++){
                    board[i][j] = ' ';
                }
            }

            board[0][3] = 'X';

            IGameBoard CorrectBoard = gb(4, 4, 4);

            CorrectBoard.placeToken('X',3);


            assertTrue(CorrectBoard.toString().equals(boardString(board, 4, 4)));
            assertTrue(CorrectBoard.whatsAtPos(new BoardPosition(0,3)) == 'X');
        }

        @Test
        public void WhatAtPos3_Multiple(){
            char board[][];
            board = new char[4][4];
            for(int i = 0; i < 4; i++){
                for(int j = 0; j < 4; j++){
                    board[i][j] = ' ';
                }
            }

            board[0][3] = 'X';
            board[1][3] = 'O';
            board[2][3] = 'X';
            board[3][3] = 'O';

            IGameBoard CorrectBoard = gb(4, 4, 4);

            CorrectBoard.placeToken('X',3);
            CorrectBoard.placeToken('O',3);
            CorrectBoard.placeToken('X',3);
            CorrectBoard.placeToken('O',3);

            assertTrue(CorrectBoard.toString().equals(boardString(board, 4, 4)));
            assertTrue(CorrectBoard.whatsAtPos(new BoardPosition(3,3)) == 'O');

        }
        @Test
        public void WhatAtPos4_WrongSymbol(){
            char board[][];
            board = new char[4][4];
            for(int i = 0; i < 4; i++){
                for(int j = 0; j < 4; j++){
                    board[i][j] = ' ';
                }
            }

            board[0][3] = 'X';
            board[1][3] = 'O';
            board[2][3] = 'X';
            board[3][3] = 'O';

            IGameBoard CorrectBoard = gb(4, 4, 4);

            CorrectBoard.placeToken('X',3);
            CorrectBoard.placeToken('O',3);
            CorrectBoard.placeToken('X',3);
            CorrectBoard.placeToken('O',3);


            assertTrue(CorrectBoard.toString().equals(boardString(board, 4, 4)));
            assertTrue(CorrectBoard.whatsAtPos(new BoardPosition(3,3)) != 'X');

        }

        @Test
        public void WhatAtPos5_Empty(){
            char board[][];
            board = new char[4][4];
            for(int i = 0; i < 4; i++){
                for(int j = 0; j < 4; j++){
                    board[i][j] = ' ';
                }
            }


            IGameBoard CorrectBoard = gb(4, 4, 4);


            assertTrue(CorrectBoard.toString().equals(boardString(board, 4, 4)));
            assertTrue(CorrectBoard.whatsAtPos(new BoardPosition(3,3)) == ' ');

        }

        @Test
        public void IsPlayerAtPos1_SouthWest(){
            char board[][];
            board = new char[4][4];
            for(int i = 0; i < 4; i++){
                for(int j = 0; j < 4; j++){
                    board[i][j] = ' ';
                }
            }

            board[0][0] = 'X';

            IGameBoard CorrectBoard = gb(4, 4, 4);

            CorrectBoard.placeToken('X',0);

            assertTrue(CorrectBoard.toString().equals(boardString(board, 4, 4)));
            assertTrue(CorrectBoard.isPlayerAtPos(new BoardPosition(0,0), 'X'));
        }

        @Test
        public void IsPlayerAtPos2_SouthEast(){
            char board[][];
            board = new char[4][4];
            for(int i = 0; i < 4; i++){
                for(int j = 0; j < 4; j++){
                    board[i][j] = ' ';
                }
            }

            board[0][3] = 'X';

            IGameBoard CorrectBoard = gb(4, 4, 4);

            CorrectBoard.placeToken('X',3);

            assertTrue(CorrectBoard.toString().equals(boardString(board, 4, 4)));
            assertTrue(CorrectBoard.isPlayerAtPos(new BoardPosition(0,3), 'X'));
        }

        @Test
        public void IsPlayerAtPos3_Multiple(){
            char board[][];
            board = new char[4][4];
            for(int i = 0; i < 4; i++){
                for(int j = 0; j < 4; j++){
                    board[i][j] = ' ';
                }
            }

            board[0][3] = 'X';
            board[1][3] = 'O';
            board[2][3] = 'X';
            board[3][3] = 'O';

            IGameBoard CorrectBoard = gb(4, 4, 4);

            CorrectBoard.placeToken('X',3);
            CorrectBoard.placeToken('O',3);
            CorrectBoard.placeToken('X',3);
            CorrectBoard.placeToken('O',3);

            assertTrue(CorrectBoard.toString().equals(boardString(board, 4, 4)));
            assertTrue(CorrectBoard.isPlayerAtPos(new BoardPosition(3,3),'O'));

        }

        @Test
        public void IsPlayerAtPos4_WrongSymbol(){
            char board[][];
            board = new char[4][4];
            for(int i = 0; i < 4; i++){
                for(int j = 0; j < 4; j++){
                    board[i][j] = ' ';
                }
            }

            board[0][3] = 'X';
            board[1][3] = 'O';
            board[2][3] = 'X';
            board[3][3] = 'O';

            IGameBoard CorrectBoard = gb(4, 4, 4);

            CorrectBoard.placeToken('X',3);
            CorrectBoard.placeToken('O',3);
            CorrectBoard.placeToken('X',3);
            CorrectBoard.placeToken('O',3);

            assertTrue(CorrectBoard.toString().equals(boardString(board, 4, 4)));
            assertTrue(!CorrectBoard.isPlayerAtPos(new BoardPosition(3,3), 'X'));

        }

        @Test
        public void IsPlayerAtPos5_Empty(){
            char board[][];
            board = new char[4][4];
            for(int i = 0; i < 4; i++){
                for(int j = 0; j < 4; j++){
                    board[i][j] = ' ';
                }
            }


            IGameBoard CorrectBoard = gb(4, 4, 4);

            assertTrue(CorrectBoard.toString().equals(boardString(board, 4, 4)));
            assertTrue(!CorrectBoard.isPlayerAtPos(new BoardPosition(3,3), 'O'));

        }


        @Test
        public void PlaceToken1_SouthWest(){
            char board[][];
            board = new char[4][4];
            for(int i = 0; i < 4; i++){
                for(int j = 0; j < 4; j++){
                    board[i][j] = ' ';
                }
            }

            board[0][0] = 'X';

            IGameBoard CorrectBoard = gb(4, 4, 4);

            CorrectBoard.placeToken('X',0);


            assertTrue(CorrectBoard.toString().equals(boardString(board, 4, 4)));
        }

        @Test
        public void PlaceToken2_SouthEast(){
            char board[][];
            board = new char[4][4];
            for(int i = 0; i < 4; i++){
                for(int j = 0; j < 4; j++){
                    board[i][j] = ' ';
                }
            }

            board[0][3] = 'X';

            IGameBoard CorrectBoard = gb(4, 4, 4);

            CorrectBoard.placeToken('X',3);

            assertTrue(CorrectBoard.toString().equals(boardString(board, 4, 4)));
        }

        @Test
        public void PlaceToken3_NorthEast(){
            char board[][];
            board = new char[4][4];
            for(int i = 0; i < 4; i++){
                for(int j = 0; j < 4; j++){
                    board[i][j] = ' ';
                }
            }

            board[0][3] = 'X';
            board[1][3] = '0';
            board[2][3] = 'X';
            board[3][3] = '0';

            IGameBoard CorrectBoard = gb(4, 4, 4);

            CorrectBoard.placeToken('X',3);
            CorrectBoard.placeToken('0',3);
            CorrectBoard.placeToken('X',3);
            CorrectBoard.placeToken('0',3);

            assertTrue(CorrectBoard.toString().equals(boardString(board, 4, 4)));
        }

        @Test
        public void PlaceToken4_NorthWest(){
            char board[][];
            board = new char[4][4];
            for(int i = 0; i < 4; i++){
                for(int j = 0; j < 4; j++){
                    board[i][j] = ' ';
                }
            }

            board[0][0] = 'X';
            board[1][0] = '0';
            board[2][0] = 'X';
            board[3][0] = '0';

            IGameBoard CorrectBoard = gb(4, 4, 4);

            CorrectBoard.placeToken('X',0);
            CorrectBoard.placeToken('0',0);
            CorrectBoard.placeToken('X',0);
            CorrectBoard.placeToken('0',0);

            assertTrue(CorrectBoard.toString().equals(boardString(board, 4, 4)));
        }

        @Test
        public void PlaceToken5_Middle(){
            char board[][];
            board = new char[4][4];
            for(int i = 0; i < 4; i++){
                for(int j = 0; j < 4; j++){
                    board[i][j] = ' ';
                }
            }

            board[0][1] = 'X';
            board[1][1] = '0';
            board[2][1] = 'X';

            board[0][2] = 'X';
            board[1][2] = '0';
            board[2][2] = 'X';


            IGameBoard CorrectBoard = gb(4, 4, 4);

            CorrectBoard.placeToken('X',1);
            CorrectBoard.placeToken('0',1);
            CorrectBoard.placeToken('X',1);

            CorrectBoard.placeToken('X',2);
            CorrectBoard.placeToken('0',2);
            CorrectBoard.placeToken('X',2);

            assertTrue(CorrectBoard.toString().equals(boardString(board, 4, 4)));
        }

    }

