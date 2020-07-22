package li.jeffrey;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class BoardGenerator {

    private static JButton[][] buttons = new JButton[9][9];

    public static void solveBoard(Board board) {
        board.solve();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (buttons[i][j].getText().equals("")) {
                    buttons[i][j].setForeground(Color.BLACK);
                    buttons[i][j].setText(Integer.toString(board.getNumber(i, j)));
                    if (buttons[i][j].getText().equals("0")) {
                        buttons[i][j].setBackground(Color.RED);
                    } else {
                        buttons[i][j].setBackground(Color.GREEN);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Board board = new Board();
        JFrame frame = new JFrame();
        frame.setSize(594, 594);
        frame.setLayout(new GridLayout(9, 9));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("Sudoku Generator");
        Border defaultBorder = new JButton().getBorder();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                buttons[i][j] = new JButton();
                int left = (j % 3 == 0) ? 2 : 1;
                if (j == 0) {
                    left = 8;
                }
                int right = ((j + 1) % 3 == 0) ? 2 : 1;
                if (j == 8) {
                    right = 8;
                }
                int top = (i % 3 == 0) ? 2 : 1;
                if (i == 0) {
                    top = 8;
                }
                int bottom = ((i + 1) % 3 == 0) ? 2 : 1;
                if (i == 8) {
                    bottom = 8;
                }
                buttons[i][j].setBorder(BorderFactory.createMatteBorder(top, left, bottom, right, Color.BLACK));
                buttons[i][j].setBackground(Color.WHITE);
                buttons[i][j].setFont(new Font("Arial", Font.PLAIN, 40));
                buttons[i][j].setForeground(Color.BLACK);
                buttons[i][j].setText("");
                buttons[i][j].setSize(66, 66);

                int row = i;
                int col = j;
                buttons[i][j].addKeyListener(new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {
                        switch (e.getKeyCode()) {
                            case 10:
                                board.printBoard();
                                return;
                            case 32:
                                board.printBoard();
                                solveBoard(board);
                                return;
                            case 48:
                                buttons[row][col].setText("");
                                board.setNumber(row, col, 0);
                                return;
                            case 49:
                                buttons[row][col].setText("1");
                                board.setNumber(row, col, 1);
                                return;
                            case 50:
                                buttons[row][col].setText("2");
                                board.setNumber(row, col, 2);
                                return;
                            case 51:
                                buttons[row][col].setText("3");
                                board.setNumber(row, col, 3);
                                return;
                            case 52:
                                buttons[row][col].setText("4");
                                board.setNumber(row, col, 4);
                                return;
                            case 53:
                                buttons[row][col].setText("5");
                                board.setNumber(row, col, 5);
                                return;
                            case 54:
                                buttons[row][col].setText("6");
                                board.setNumber(row, col, 6);
                                return;
                            case 55:
                                buttons[row][col].setText("7");
                                board.setNumber(row, col, 7);
                                return;
                            case 56:
                                buttons[row][col].setText("8");
                                board.setNumber(row, col, 8);
                                return;
                            case 57:
                                buttons[row][col].setText("9");
                                board.setNumber(row, col, 9);
                                return;
                            default:
                                return;
                        }
                    }

                    @Override
                    public void keyReleased(KeyEvent e) {

                    }
                });
                buttons[i][j].addMouseListener(new MouseListener() {
                                                   @Override
                                                   public void mouseClicked(MouseEvent e) {

                                                   }

                                                   @Override
                                                   public void mousePressed(MouseEvent e) {
                                                       for (int x = 0; x < 9; x++) {
                                                           for (int y = 0; y < 9; y++) {
                                                               buttons[x][y].setBackground(Color.WHITE);
                                                           }
                                                       }
                                                       buttons[row][col].setBackground(Color.YELLOW);
                                                   }

                                                   @Override
                                                   public void mouseReleased(MouseEvent e) {

                                                   }

                                                   @Override
                                                   public void mouseEntered(MouseEvent e) {

                                                   }

                                                   @Override
                                                   public void mouseExited(MouseEvent e) {

                                                   }
                                               }
                );
                frame.add(buttons[i][j]);
            }

        }
        frame.setVisible(true);
    }

}

