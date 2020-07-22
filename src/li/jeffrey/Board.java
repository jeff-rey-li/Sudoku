package li.jeffrey;

import java.awt.*;
import java.util.concurrent.TimeUnit;

public class Board {

    private int[][] board;

    public Board() {
        board = new int[9][9];
    }

    public Board(int[][] startBoard) {
        board = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j] = startBoard[i][j];
            }
        }
    }

    public void setNumber(int row, int col, int num) {
        board[row][col] = num;
    }

    public int getNumber(int row, int col) {
        return board[row][col];
    }

    public boolean checkNumber(int row, int col) {
        for (int i = 0; i < board.length; i++) {
            if (i == row)
                continue;
            if (board[i][col] == board[row][col]) {
                return false;
            }
        }
        for (int j = 0; j < board[0].length; j++) {
            if (j == col)
                continue;
            if (board[row][j] == board[row][col]) {
                return false;
            }
        }
        int squareRow = row - row % 3;
        int squareCol = col - col % 3;
        for (int i = squareRow; i < squareRow + 3; i++) {
            for (int j = 0; j < squareCol + 3; j++) {
                if (i == row && j == col)
                    continue;
                if (board[i][j] == board[row][col]) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean tryNum(int row, int col, int num) {
        for (int i = 0; i < 9; i++) {
            if (i == row)
                continue;
            if (board[i][col] == num) {
                return false;
            }
        }
        for (int j = 0; j < 9; j++) {
            if (j == col)
                continue;
            if (board[row][j] == num) {
                return false;
            }
        }

        int squareRow = row - (row % 3);
        int squareCol = col - (col % 3);
        for (int i = squareRow; i < squareRow + 3; i++) {
            for (int j = squareCol; j < squareCol + 3; j++) {
                if (i == row && j == col)
                    continue;
                if (board[i][j] == num) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean solve() {
        int row = -1;
        int col = -1;
        boolean numLeft = false;
        for (int i = 0; i < 9; i++) {
            if (numLeft)
                break;
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == 0) {
                    row = i;
                    col = j;
                    numLeft = true;
                    break;
                }
            }
        }
        if (!numLeft) {
            return true;
        }

        for (int i = 1; i <= 9; i++) {
            if (tryNum(row, col, i)) {
                board[row][col] = i;
                if (solve()) {
                    return true;
                } else {
                    board[row][col] = 0;
                }
            }
        }
        return false;
    }

    public void printBoard() {
        for (int i = 0; i < board.length; i++) {
            System.out.print("{");
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j]);
                if (j != board[0].length - 1)
                    System.out.print(", ");
            }
            System.out.print("}");
            if (i != board.length - 1)
                System.out.print(",");
            System.out.print("\n");
        }
        System.out.print("\n");
    }
}
