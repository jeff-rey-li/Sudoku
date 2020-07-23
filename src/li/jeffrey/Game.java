package li.jeffrey;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.util.Timer;
import java.util.TimerTask;

public class Game {

    private static JButton[][] buttons = new JButton[9][9];
    private static int numCount = 0;
    private static JLabel errorOne = new JLabel("");
    private static JLabel errorTwo = new JLabel("");
    private static JLabel errorThree = new JLabel("");
    private static Difficulty difficulty;
    private static boolean gameOver = false;

    private static void solveBoard(Board board) {
        board.solve();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (buttons[i][j].getForeground().equals(Color.LIGHT_GRAY) || buttons[i][j].getBackground().equals(Color.RED) || buttons[i][j].getText().equals("")) {
                    buttons[i][j].setForeground(Color.BLACK);
                    buttons[i][j].setText(Integer.toString(board.getNumber(i, j)));
                    buttons[i][j].setBackground(Color.GREEN);
                }
            }
        }
    }

    private static void playGame() {
        int[][] startingBoard;

        switch (difficulty) {
            case EASY:
                startingBoard = StartBoard.getEasyBoard();
                break;
            case MEDIUM:
                startingBoard = StartBoard.getMediumBoard();
                break;
            case HARD:
                startingBoard = StartBoard.getHardBoard();
                break;
            case RANDOM:
                startingBoard = StartBoard.getRandomBoard();
                break;
            default:
                startingBoard = new int[9][9];
        }

        Timer timer = new Timer();
        Board board = new Board(startingBoard);
        Board solvedBoard = new Board(startingBoard);
        solvedBoard.solve();
        JFrame frame = new JFrame();
        frame.setSize(594, 594);
        frame.setResizable(false);
        frame.setLayout(new GridLayout(10, 9));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("Sudoku: " + difficulty);
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
                int num = board.getNumber(i, j);
                String text;
                buttons[i][j].setBackground(Color.WHITE);
                if (num != 0) {
                    buttons[i][j].setFont(new Font("Arial", Font.BOLD, 40));
                    text = Integer.toString(num);
                } else {
                    buttons[i][j].setBackground(Color.WHITE);
                    buttons[i][j].setFont(new Font("Arial", Font.PLAIN, 40));
                    buttons[i][j].setForeground(Color.LIGHT_GRAY);
                    text = "";
                }
                buttons[i][j].setText(text);

                buttons[i][j].setSize(66, 66);
                int row = i;
                int col = j;
                buttons[i][j].addKeyListener(new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {
                        if (e.getKeyChar() == ' ') {
                            if (!gameOver) {
                                gameOver = !gameOver;
                                timer.cancel();
                                frame.setTitle(frame.getTitle() + " - You Lost");
                            }
                            solveBoard(board);
                        }
                        if (!buttons[row][col].getText().equals("") && !buttons[row][col].getBackground().equals(Color.RED)
                                && !buttons[row][col].getForeground().equals(Color.LIGHT_GRAY)) {
                            return;
                        }
                        if (buttons[row][col].getBackground().equals(Color.RED)) {
                            return;
                        }
                        if (buttons[row][col].getForeground().equals(Color.LIGHT_GRAY)) {
                            switch (e.getKeyCode()) {
                                case 49:
                                    buttons[row][col].setText("1");
                                    return;
                                case 50:
                                    buttons[row][col].setText("2");
                                    return;
                                case 51:
                                    buttons[row][col].setText("3");
                                    return;
                                case 52:
                                    buttons[row][col].setText("4");
                                    return;
                                case 53:
                                    buttons[row][col].setText("5");
                                    return;
                                case 54:
                                    buttons[row][col].setText("6");
                                    return;
                                case 55:
                                    buttons[row][col].setText("7");
                                    return;
                                case 56:
                                    buttons[row][col].setText("8");
                                    return;
                                case 57:
                                    buttons[row][col].setText("9");
                                    return;
                                case 10:
                                    break;
                                default:
                                    return;
                            }
                        }
                        switch (buttons[row][col].getText()) {
                            case "1":
                                buttons[row][col].setForeground(Color.BLACK);
                                if (solvedBoard.getNumber(row, col) == 1) {
                                    board.setNumber(row, col, 1);
                                    for (int k = 0; k < 9; k++) {
                                        for (int l = 0; l < 9; l++) {
                                            if (buttons[k][l].getText().equals("") || buttons[k][l].getForeground().equals(Color.LIGHT_GRAY)) {
                                                return;
                                            }
                                        }
                                    }
                                    if (!gameOver) {
                                        gameOver = !gameOver;
                                        timer.cancel();
                                        frame.setTitle(frame.getTitle() + " - You Win!");
                                    }
                                } else {
                                    buttons[row][col].setBackground(Color.RED);
                                    numCount++;
                                    if (numCount == 1) {
                                        errorOne.setText(" X");
                                    } else if (numCount == 2) {
                                        errorTwo.setText(" X");
                                    } else if (numCount == 3) {
                                        gameOver = !gameOver;
                                        timer.cancel();
                                        frame.setTitle(frame.getTitle() + " - You Lost");
                                        errorThree.setText(" X");
                                        for (int k = 0; k < 9; k++) {
                                            for (int l = 0; l < 9; l++) {
                                                if (buttons[k][l].getForeground().equals(Color.LIGHT_GRAY)) {
                                                    buttons[k][l].setForeground(Color.BLACK);
                                                    buttons[k][l].setText("");
                                                }

                                                if (buttons[k][l].getText().equals("")) {
                                                    buttons[k][l].setBackground(Color.LIGHT_GRAY);
                                                }
                                            }
                                        }
                                    }
                                }
                                break;
                            case "2":
                                buttons[row][col].setForeground(Color.BLACK);
                                if (solvedBoard.getNumber(row, col) == 2) {
                                    board.setNumber(row, col, 2);
                                    for (int k = 0; k < 9; k++) {
                                        for (int l = 0; l < 9; l++) {
                                            if (buttons[k][l].getText().equals("") || buttons[k][l].getForeground().equals(Color.LIGHT_GRAY)) {
                                                return;
                                            }
                                        }
                                    }
                                    if (!gameOver) {
                                        gameOver = !gameOver;
                                        timer.cancel();
                                        frame.setTitle(frame.getTitle() + " - You Win!");
                                    }
                                } else {
                                    buttons[row][col].setBackground(Color.RED);
                                    numCount++;
                                    if (numCount == 1) {
                                        errorOne.setText(" X");
                                    } else if (numCount == 2) {
                                        errorTwo.setText(" X");
                                    } else if (numCount == 3) {
                                        gameOver = !gameOver;
                                        timer.cancel();
                                        frame.setTitle(frame.getTitle() + " - You Lost");
                                        errorThree.setText(" X");
                                        for (int k = 0; k < 9; k++) {
                                            for (int l = 0; l < 9; l++) {
                                                if (buttons[k][l].getForeground().equals(Color.LIGHT_GRAY)) {
                                                    buttons[k][l].setForeground(Color.BLACK);
                                                    buttons[k][l].setText("");
                                                }

                                                if (buttons[k][l].getText().equals("")) {
                                                    buttons[k][l].setBackground(Color.LIGHT_GRAY);
                                                }
                                            }
                                        }
                                    }
                                }
                                break;
                            case "3":
                                buttons[row][col].setForeground(Color.BLACK);
                                if (solvedBoard.getNumber(row, col) == 3) {
                                    board.setNumber(row, col, 3);
                                    for (int k = 0; k < 9; k++) {
                                        for (int l = 0; l < 9; l++) {
                                            if (buttons[k][l].getText().equals("") || buttons[k][l].getForeground().equals(Color.LIGHT_GRAY)) {
                                                return;
                                            }
                                        }
                                    }
                                    if (!gameOver) {
                                        gameOver = !gameOver;
                                        timer.cancel();
                                        frame.setTitle(frame.getTitle() + " - You Win!");
                                    }
                                } else {
                                    buttons[row][col].setBackground(Color.RED);
                                    numCount++;
                                    if (numCount == 1) {
                                        errorOne.setText(" X");
                                    } else if (numCount == 2) {
                                        errorTwo.setText(" X");
                                    } else if (numCount == 3) {
                                        gameOver = !gameOver;
                                        timer.cancel();
                                        frame.setTitle(frame.getTitle() + " - You Lost");
                                        errorThree.setText(" X");
                                        for (int k = 0; k < 9; k++) {
                                            for (int l = 0; l < 9; l++) {
                                                if (buttons[k][l].getForeground().equals(Color.LIGHT_GRAY)) {
                                                    buttons[k][l].setForeground(Color.BLACK);
                                                    buttons[k][l].setText("");
                                                }

                                                if (buttons[k][l].getText().equals("")) {
                                                    buttons[k][l].setBackground(Color.LIGHT_GRAY);
                                                }
                                            }
                                        }
                                    }
                                }
                                break;
                            case "4":
                                buttons[row][col].setForeground(Color.BLACK);
                                if (solvedBoard.getNumber(row, col) == 4) {
                                    board.setNumber(row, col, 4);
                                    for (int k = 0; k < 9; k++) {
                                        for (int l = 0; l < 9; l++) {
                                            if (buttons[k][l].getText().equals("") || buttons[k][l].getForeground().equals(Color.LIGHT_GRAY)) {
                                                return;
                                            }
                                        }
                                    }
                                    if (!gameOver) {
                                        gameOver = !gameOver;
                                        timer.cancel();
                                        frame.setTitle(frame.getTitle() + " - You Win!");
                                    }
                                } else {
                                    buttons[row][col].setBackground(Color.RED);
                                    numCount++;
                                    if (numCount == 1) {
                                        errorOne.setText(" X");
                                    } else if (numCount == 2) {
                                        errorTwo.setText(" X");
                                    } else if (numCount == 3) {
                                        gameOver = !gameOver;
                                        timer.cancel();
                                        frame.setTitle(frame.getTitle() + " - You Lost");
                                        errorThree.setText(" X");
                                        for (int k = 0; k < 9; k++) {
                                            for (int l = 0; l < 9; l++) {
                                                if (buttons[k][l].getForeground().equals(Color.LIGHT_GRAY)) {
                                                    buttons[k][l].setForeground(Color.BLACK);
                                                    buttons[k][l].setText("");
                                                }

                                                if (buttons[k][l].getText().equals("")) {
                                                    buttons[k][l].setBackground(Color.LIGHT_GRAY);
                                                }
                                            }
                                        }
                                    }
                                }
                                break;
                            case "5":
                                buttons[row][col].setForeground(Color.BLACK);
                                if (solvedBoard.getNumber(row, col) == 5) {
                                    board.setNumber(row, col, 5);
                                    for (int k = 0; k < 9; k++) {
                                        for (int l = 0; l < 9; l++) {
                                            if (buttons[k][l].getText().equals("") || buttons[k][l].getForeground().equals(Color.LIGHT_GRAY)) {
                                                return;
                                            }
                                        }
                                    }
                                    if (!gameOver) {
                                        gameOver = !gameOver;
                                        timer.cancel();
                                        frame.setTitle(frame.getTitle() + " - You Win!");
                                    }
                                } else {
                                    buttons[row][col].setBackground(Color.RED);
                                    numCount++;
                                    if (numCount == 1) {
                                        errorOne.setText(" X");
                                    } else if (numCount == 2) {
                                        errorTwo.setText(" X");
                                    } else if (numCount == 3) {
                                        gameOver = !gameOver;
                                        timer.cancel();
                                        frame.setTitle(frame.getTitle() + " - You Lost");
                                        errorThree.setText(" X");
                                        for (int k = 0; k < 9; k++) {
                                            for (int l = 0; l < 9; l++) {
                                                if (buttons[k][l].getForeground().equals(Color.LIGHT_GRAY)) {
                                                    buttons[k][l].setForeground(Color.BLACK);
                                                    buttons[k][l].setText("");
                                                }

                                                if (buttons[k][l].getText().equals("")) {
                                                    buttons[k][l].setBackground(Color.LIGHT_GRAY);
                                                }
                                            }
                                        }
                                    }
                                }
                                break;
                            case "6":
                                buttons[row][col].setForeground(Color.BLACK);
                                if (solvedBoard.getNumber(row, col) == 6) {
                                    board.setNumber(row, col, 6);
                                    for (int k = 0; k < 9; k++) {
                                        for (int l = 0; l < 9; l++) {
                                            if (buttons[k][l].getText().equals("") || buttons[k][l].getForeground().equals(Color.LIGHT_GRAY)) {
                                                return;
                                            }
                                        }
                                    }
                                    if (!gameOver) {
                                        gameOver = !gameOver;
                                        timer.cancel();
                                        frame.setTitle(frame.getTitle() + " - You Win!");
                                    }
                                } else {
                                    buttons[row][col].setBackground(Color.RED);
                                    numCount++;
                                    if (numCount == 1) {
                                        errorOne.setText(" X");
                                    } else if (numCount == 2) {
                                        errorTwo.setText(" X");
                                    } else if (numCount == 3) {
                                        gameOver = !gameOver;
                                        timer.cancel();
                                        frame.setTitle(frame.getTitle() + " - You Lost");
                                        errorThree.setText(" X");
                                        for (int k = 0; k < 9; k++) {
                                            for (int l = 0; l < 9; l++) {
                                                if (buttons[k][l].getForeground().equals(Color.LIGHT_GRAY)) {
                                                    buttons[k][l].setForeground(Color.BLACK);
                                                    buttons[k][l].setText("");
                                                }

                                                if (buttons[k][l].getText().equals("")) {
                                                    buttons[k][l].setBackground(Color.LIGHT_GRAY);
                                                }
                                            }
                                        }
                                    }
                                }
                                break;
                            case "7":
                                buttons[row][col].setForeground(Color.BLACK);
                                if (solvedBoard.getNumber(row, col) == 7) {
                                    board.setNumber(row, col, 7);
                                    for (int k = 0; k < 9; k++) {
                                        for (int l = 0; l < 9; l++) {
                                            if (buttons[k][l].getText().equals("") || buttons[k][l].getForeground().equals(Color.LIGHT_GRAY)) {
                                                return;
                                            }
                                        }
                                    }
                                    if (!gameOver) {
                                        gameOver = !gameOver;
                                        timer.cancel();
                                        frame.setTitle(frame.getTitle() + " - You Win!");
                                    }
                                } else {
                                    buttons[row][col].setBackground(Color.RED);
                                    numCount++;
                                    if (numCount == 1) {
                                        errorOne.setText(" X");
                                    } else if (numCount == 2) {
                                        errorTwo.setText(" X");
                                    } else if (numCount == 3) {
                                        gameOver = !gameOver;
                                        timer.cancel();
                                        frame.setTitle(frame.getTitle() + " - You Lost");
                                        errorThree.setText(" X");
                                        for (int k = 0; k < 9; k++) {
                                            for (int l = 0; l < 9; l++) {
                                                if (buttons[k][l].getForeground().equals(Color.LIGHT_GRAY)) {
                                                    buttons[k][l].setForeground(Color.BLACK);
                                                    buttons[k][l].setText("");
                                                }

                                                if (buttons[k][l].getText().equals("")) {
                                                    buttons[k][l].setBackground(Color.LIGHT_GRAY);
                                                }
                                            }
                                        }
                                    }
                                }
                                break;
                            case "8":
                                buttons[row][col].setForeground(Color.BLACK);
                                if (solvedBoard.getNumber(row, col) == 8) {
                                    board.setNumber(row, col, 8);
                                    for (int k = 0; k < 9; k++) {
                                        for (int l = 0; l < 9; l++) {
                                            if (buttons[k][l].getText().equals("") || buttons[k][l].getForeground().equals(Color.LIGHT_GRAY)) {
                                                return;
                                            }
                                        }
                                    }
                                    if (!gameOver) {
                                        gameOver = !gameOver;
                                        timer.cancel();
                                        frame.setTitle(frame.getTitle() + " - You Win!");
                                    }
                                } else {
                                    buttons[row][col].setBackground(Color.RED);
                                    numCount++;
                                    if (numCount == 1) {
                                        errorOne.setText(" X");
                                    } else if (numCount == 2) {
                                        errorTwo.setText(" X");
                                    } else if (numCount == 3) {
                                        gameOver = !gameOver;
                                        timer.cancel();
                                        frame.setTitle(frame.getTitle() + " - You Lost");
                                        errorThree.setText(" X");
                                        for (int k = 0; k < 9; k++) {
                                            for (int l = 0; l < 9; l++) {
                                                if (buttons[k][l].getForeground().equals(Color.LIGHT_GRAY)) {
                                                    buttons[k][l].setForeground(Color.BLACK);
                                                    buttons[k][l].setText("");
                                                }

                                                if (buttons[k][l].getText().equals("")) {
                                                    buttons[k][l].setBackground(Color.LIGHT_GRAY);
                                                }
                                            }
                                        }
                                    }
                                }
                                break;
                            case "9":
                                buttons[row][col].setForeground(Color.BLACK);
                                if (solvedBoard.getNumber(row, col) == 9) {
                                    board.setNumber(row, col, 9);
                                    for (int k = 0; k < 9; k++) {
                                        for (int l = 0; l < 9; l++) {
                                            if (buttons[k][l].getText().equals("") || buttons[k][l].getForeground().equals(Color.LIGHT_GRAY)) {
                                                return;
                                            }
                                        }
                                    }
                                    if (!gameOver) {
                                        gameOver = !gameOver;
                                        timer.cancel();
                                        frame.setTitle(frame.getTitle() + " - You Win!");
                                    }
                                } else {
                                    buttons[row][col].setBackground(Color.RED);
                                    numCount++;
                                    if (numCount == 1) {
                                        errorOne.setText(" X");
                                    } else if (numCount == 2) {
                                        errorTwo.setText(" X");
                                    } else if (numCount == 3) {
                                        gameOver = !gameOver;
                                        timer.cancel();
                                        frame.setTitle(frame.getTitle() + " - You Lost");
                                        errorThree.setText(" X");
                                        for (int k = 0; k < 9; k++) {
                                            for (int l = 0; l < 9; l++) {
                                                if (buttons[k][l].getForeground().equals(Color.LIGHT_GRAY)) {
                                                    buttons[k][l].setForeground(Color.BLACK);
                                                    buttons[k][l].setText("");
                                                }

                                                if (buttons[k][l].getText().equals("")) {
                                                    buttons[k][l].setBackground(Color.LIGHT_GRAY);
                                                }
                                            }
                                        }
                                    }
                                }
                                break;
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
                                                               if (buttons[x][y].getBackground().equals(Color.RED)) {
                                                                   if (numCount < 3)
                                                                       buttons[x][y].setForeground(Color.LIGHT_GRAY);
                                                                   buttons[x][y].setText("");
                                                               }
                                                               buttons[x][y].setBackground(Color.WHITE);
                                                               if (numCount == 3 && buttons[x][y].getText().equals(""))
                                                                   buttons[x][y].setBackground(Color.LIGHT_GRAY);
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
        errorOne.setFont(new Font("Arial", Font.BOLD, 40));
        errorOne.setForeground(Color.RED);
        errorTwo.setFont(new Font("Arial", Font.BOLD, 40));
        errorTwo.setForeground(Color.RED);
        errorThree.setFont(new Font("Arial", Font.BOLD, 40));
        errorThree.setForeground(Color.RED);
        frame.add(errorOne);
        frame.add(errorTwo);
        frame.add(errorThree);
        frame.setVisible(true);

        class TimeElapsed extends TimerTask {

            int totalSeconds = 0;

            @Override
            public void run() {
                String minutes = Integer.toString(totalSeconds / 60);
                String seconds = (totalSeconds % 60 >= 10) ? Integer.toString(totalSeconds % 60) : "0" + Integer.toString(totalSeconds % 60);
                frame.setTitle("Sudoku: " + difficulty + " - Time: " + minutes + ":" + seconds);
                totalSeconds++;
            }
        }
        timer.schedule(new TimeElapsed(), 0, 1000);
    }

    public static void main(String[] args) {
        JFrame levelSelection = new JFrame();
        levelSelection.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        levelSelection.setSize(600, 100);
        levelSelection.setResizable(false);
        levelSelection.setTitle("Choose Difficulty: ");
        levelSelection.setLayout(new GridLayout(1, 4));
        JButton easy = new JButton("Easy");
        easy.setFont(new Font("Arial", Font.PLAIN, 20));
        easy.setBackground(Color.WHITE);
        easy.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                difficulty = Difficulty.EASY;
                levelSelection.setVisible(false);
                playGame();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                easy.setBackground(Color.GREEN);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                easy.setBackground(Color.WHITE);
            }
        });
        JButton medium = new JButton("Medium");
        medium.setFont(new Font("Arial", Font.PLAIN, 20));
        medium.setBackground(Color.WHITE);
        medium.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                difficulty = Difficulty.MEDIUM;
                levelSelection.setVisible(false);
                playGame();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                medium.setBackground(Color.ORANGE);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                medium.setBackground(Color.WHITE);
            }
        });
        JButton hard = new JButton("Hard");
        hard.setFont(new Font("Arial", Font.PLAIN, 20));
        hard.setBackground(Color.WHITE);
        hard.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                difficulty = Difficulty.HARD;
                levelSelection.setVisible(false);
                playGame();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                hard.setBackground(Color.RED);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                hard.setBackground(Color.WHITE);
            }
        });
        JButton random = new JButton("Random");
        random.setFont(new Font("Arial", Font.PLAIN, 20));
        random.setBackground(Color.WHITE);
        random.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                difficulty = Difficulty.RANDOM;
                levelSelection.setVisible(false);
                playGame();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                random.setBackground(Color.CYAN);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                random.setBackground(Color.WHITE);
            }
        });
        levelSelection.add(easy);
        levelSelection.add(medium);
        levelSelection.add(hard);
        levelSelection.add(random);
        levelSelection.setVisible(true);
    }

}
