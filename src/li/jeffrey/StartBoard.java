package li.jeffrey;

import java.util.ArrayList;
import java.util.List;

public class StartBoard {

    private static List<int[][]> easyBoards = new ArrayList<int[][]>();
    private static List<int[][]> mediumBoards = new ArrayList<int[][]>();
    private static List<int[][]> hardBoards = new ArrayList<int[][]>();

    private static final int[][] easy0 = new int[][]{
            {0, 0, 8, 0, 0, 0, 0, 4, 7},
            {0, 1, 0, 0, 3, 8, 2, 0, 0},
            {0, 5, 0, 1, 0, 0, 0, 0, 3},
            {2, 0, 0, 0, 0, 7, 8, 9, 0},
            {0, 0, 0, 0, 1, 0, 0, 0, 0},
            {0, 9, 6, 3, 0, 0, 0, 0, 2},
            {8, 0, 0, 0, 0, 2, 0, 6, 0},
            {0, 0, 9, 6, 5, 0, 0, 1, 0},
            {3, 6, 0, 0, 0, 0, 4, 0, 0}
    };
    private static final int[][] easy1 = new int[][]{
            {0, 0, 0, 0, 1, 0, 0, 0, 0},
            {0, 0, 4, 5, 0, 0, 7, 6, 0},
            {0, 1, 0, 9, 0, 7, 0, 8, 0},
            {0, 0, 2, 4, 0, 0, 3, 1, 0},
            {0, 0, 0, 0, 3, 0, 0, 0, 0},
            {0, 7, 1, 0, 0, 2, 5, 0, 0},
            {0, 6, 0, 1, 0, 5, 0, 7, 0},
            {0, 5, 8, 0, 0, 6, 2, 0, 0},
            {0, 0, 0, 0, 2, 0, 0, 0, 0}
    };
    private static final int[][] easy2 = new int[][]{
            {0, 9, 0, 0, 6, 0, 0, 8, 0},
            {1, 5, 0, 0, 9, 0, 0, 4, 7},
            {0, 0, 0, 2, 0, 5, 0, 0, 0},
            {0, 0, 7, 1, 0, 9, 3, 0, 0},
            {6, 3, 0, 0, 0, 0, 0, 1, 4},
            {0, 0, 5, 6, 0, 8, 7, 0, 0},
            {0, 0, 0, 3, 0, 1, 0, 0, 0},
            {9, 7, 0, 0, 5, 0, 0, 6, 8},
            {0, 8, 0, 0, 7, 0, 0, 2, 0}
    };
    private static final int[][] easy3 = new int[][] {
            {0, 0, 4, 5, 2, 0, 0, 0, 0},
            {1, 5, 0, 0, 0, 0, 0, 4, 6},
            {0, 0, 0, 0, 6, 7, 5, 0, 0},
            {0, 3, 1, 8, 0, 0, 0, 0, 0},
            {6, 0, 0, 0, 0, 0, 0, 0, 3},
            {0, 0, 0, 0, 0, 5, 2, 1, 0},
            {0, 0, 3, 1, 8, 0, 0, 0, 0},
            {5, 2, 0, 0, 0, 0, 0, 6, 7},
            {0, 0, 0, 0, 5, 2, 0, 0, 0}
    };
    private static final int[][] easy4 = new int[][] {
            {0, 0, 7, 0, 0, 0, 4, 0, 0},
            {0, 8, 0, 1, 0, 7, 0, 3, 0},
            {5, 0, 0, 0, 2, 0, 0, 0, 1},
            {0, 9, 0, 4, 0, 3, 0, 6, 0},
            {0, 0, 2, 0, 0, 0, 5, 0, 0},
            {0, 6, 0, 5, 0, 2, 0, 4, 0},
            {1, 0, 0, 0, 6, 0, 0, 0, 2},
            {0, 2, 0, 3, 0, 4, 0, 5, 0},
            {0, 0, 8, 0, 0, 0, 7, 0, 0}
    };
    private static final int[][] easy5 = new int[][] {
            {0, 1, 0, 0, 0, 8, 7, 0, 0},
            {0, 0, 3, 2, 0, 0, 0, 9, 0},
            {7, 0, 0, 0, 3, 0, 0, 8, 0},
            {0, 9, 8, 0, 0, 3, 0, 0, 4},
            {0, 0, 0, 8, 0, 4, 0, 0, 0},
            {2, 0, 0, 9, 0, 0, 5, 6, 0},
            {0, 2, 0, 0, 4, 0, 0, 0, 3},
            {0, 7, 0, 0, 0, 9, 1, 0, 0},
            {0, 0, 6, 5, 0, 0, 0, 4, 0}
    };
    private static final int[][] easy6 = new int[][]  {
            {0, 6, 0, 0, 5, 0, 0, 0, 0},
            {9, 0, 0, 0, 0, 0, 8, 4, 0},
            {0, 0, 4, 3, 0, 0, 2, 1, 0},
            {0, 0, 3, 4, 0, 0, 0, 0, 0},
            {8, 5, 0, 0, 0, 0, 0, 6, 7},
            {0, 0, 0, 0, 0, 7, 9, 0, 0},
            {0, 1, 5, 0, 0, 8, 3, 0, 0},
            {0, 7, 2, 0, 0, 0, 0, 0, 9},
            {0, 0, 0, 0, 6, 0, 0, 2, 0}
    };
    private static final int[][] easy7 = new int[][] {
            {0, 9, 8, 7, 0, 0, 0, 0, 0},
            {1, 0, 0, 0, 2, 3, 4, 0, 0},
            {2, 0, 0, 0, 0, 0, 0, 6, 0},
            {3, 0, 0, 0, 0, 0, 0, 2, 0},
            {0, 6, 0, 0, 0, 0, 0, 8, 0},
            {0, 7, 0, 0, 0, 0, 0, 0, 4},
            {0, 8, 0, 0, 0, 0, 0, 0, 9},
            {0, 0, 4, 5, 6, 0, 0, 0, 7},
            {0, 0, 0, 0, 0, 8, 5, 1, 0}
    };

    private static final int[][] medium0 = new int[][] {
            {0, 0, 0, 0, 8, 0, 0, 0, 0},
            {3, 0, 0, 0, 9, 0, 1, 6, 0},
            {0, 4, 0, 0, 0, 5, 0, 0, 2},
            {0, 0, 1, 0, 0, 2, 0, 0, 0},
            {8, 0, 6, 0, 0, 0, 7, 0, 9},
            {0, 0, 0, 3, 0, 0, 4, 0, 0},
            {9, 0, 0, 6, 0, 0, 0, 3, 0},
            {0, 2, 8, 0, 4, 0, 0, 0, 5},
            {0, 0, 0, 0, 1, 0, 0, 0, 0}
    };
    private static final int[][] medium1 = new int[][]  {
            {0, 2, 7, 6, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 1, 0, 0, 0, 5},
            {0, 0, 0, 7, 0, 8, 0, 0, 9},
            {0, 0, 1, 0, 0, 0, 4, 0, 7},
            {0, 3, 0, 0, 2, 0, 0, 6, 0},
            {4, 0, 5, 0, 0, 0, 1, 0, 0},
            {1, 0, 0, 4, 0, 5, 0, 0, 0},
            {9, 0, 0, 0, 8, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 1, 3, 2, 0}
    };
    private static final int[][] medium2 = new int[][] {
            {3, 0, 0, 0, 0, 7, 5, 0, 1},
            {0, 0, 0, 0, 0, 2, 9, 0, 0},
            {4, 8, 0, 0, 0, 0, 0, 0, 0},
            {1, 2, 0, 3, 0, 4, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 5, 0, 6, 0, 7, 8},
            {0, 0, 0, 0, 0, 0, 0, 4, 2},
            {0, 0, 6, 9, 0, 0, 0, 0, 0},
            {5, 0, 7, 1, 0, 0, 0, 0, 6}
    };
    private static final int[][] medium3 = new int[][] {
            {0, 0, 1, 6, 0, 0, 0, 0, 0},
            {0, 5, 0, 7, 0, 0, 1, 9, 0},
            {3, 0, 2, 0, 0, 9, 4, 0, 0},
            {6, 0, 0, 0, 4, 8, 9, 0, 0},
            {0, 4, 0, 0, 0, 0, 0, 2, 0},
            {0, 0, 5, 3, 7, 0, 0, 0, 1},
            {0, 0, 9, 2, 0, 0, 8, 0, 3},
            {0, 7, 8, 0, 0, 1, 0, 6, 0},
            {0, 0, 0, 0, 0, 5, 7, 0, 0}
    };
    private static final int[][] medium4 = new int[][] {
            {0, 0, 0, 0, 0, 8, 0, 0, 0},
            {0, 0, 4, 0, 0, 5, 3, 0, 0},
            {7, 0, 0, 0, 0, 0, 6, 0, 0},
            {2, 9, 0, 0, 0, 0, 0, 0, 0},
            {8, 0, 0, 7, 0, 2, 0, 0, 9},
            {0, 0, 0, 0, 0, 0, 0, 6, 5},
            {0, 0, 5, 0, 0, 0, 0, 0, 8},
            {0, 0, 3, 6, 0, 0, 4, 0, 0},
            {0, 0, 0, 2, 0, 0, 0, 0, 0}
    };
    private static final int[][] medium5 = new int[][] {
            {0, 4, 5, 1, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 3, 0, 0, 0, 8},
            {0, 0, 0, 0, 2, 0, 0, 7, 3},
            {0, 2, 9, 7, 0, 0, 0, 0, 4},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {8, 0, 0, 0, 0, 1, 3, 6, 0},
            {1, 8, 0, 0, 6, 0, 0, 0, 0},
            {7, 0, 0, 0, 5, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 4, 6, 9, 0}
    };
    private static final int[][] medium6 = new int[][] {
            {7, 0, 0, 2, 0, 0, 0, 0, 0},
            {0, 0, 0, 3, 0, 0, 6, 4, 0},
            {0, 0, 8, 0, 0, 4, 0, 1, 0},
            {5, 9, 0, 0, 2, 0, 3, 0, 0},
            {0, 0, 0, 6, 0, 5, 0, 0, 0},
            {0, 0, 4, 0, 7, 0, 0, 5, 8},
            {0, 2, 0, 9, 0, 0, 7, 0, 0},
            {0, 8, 1, 0, 0, 3, 0, 0, 0},
            {0, 0, 0, 0, 0, 2, 0, 0, 4}
    };
    private static final int[][] medium7 = new int[][] {
            {0, 0, 2, 3, 0, 0, 0, 5, 0},
            {0, 1, 0, 0, 4, 0, 0, 0, 0},
            {9, 0, 0, 0, 0, 5, 0, 2, 0},
            {8, 0, 0, 7, 6, 0, 0, 3, 0},
            {7, 0, 0, 0, 0, 0, 0, 0, 4},
            {0, 6, 0, 0, 3, 4, 0, 0, 5},
            {0, 5, 0, 2, 0, 0, 0, 0, 6},
            {0, 0, 0, 0, 1, 0, 0, 7, 0},
            {0, 7, 0, 0, 0, 9, 8, 0, 0}
    };

    private static final int[][] hard0 = new int[][] {
            {5, 0, 0, 0, 9, 0, 0, 3, 0},
            {7, 0, 0, 0, 0, 5, 6, 0, 0},
            {0, 0, 4, 0, 0, 0, 0, 0, 1},
            {0, 0, 0, 5, 0, 4, 8, 1, 0},
            {4, 0, 0, 0, 0, 0, 0, 0, 3},
            {0, 8, 9, 3, 0, 2, 0, 0, 0},
            {6, 0, 0, 0, 0, 0, 2, 0, 0},
            {0, 0, 7, 2, 0, 0, 0, 0, 8},
            {0, 4, 0, 0, 8, 0, 0, 0, 6}
    };
    private static final int[][] hard1 = new int[][] {
            {0, 9, 1, 7, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 6, 0},
            {0, 0, 4, 0, 0, 8, 0, 0, 2},
            {0, 0, 0, 1, 0, 0, 5, 0, 7},
            {1, 0, 0, 0, 8, 0, 0, 0, 9},
            {2, 0, 3, 0, 0, 4, 0, 0, 0},
            {7, 0, 0, 2, 0, 0, 8, 0, 0},
            {0, 5, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 3, 4, 9, 0}
    };
    private static final int[][] hard2 = new int[][] {
            {0, 9, 0, 0, 0, 0, 0, 0, 5},
            {0, 0, 8, 6, 0, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 2, 0},
            {0, 7, 0, 0, 0, 9, 0, 0, 4},
            {0, 0, 3, 0, 0, 0, 6, 0, 0},
            {2, 0, 0, 5, 0, 0, 0, 9, 0},
            {0, 1, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 4, 0, 3, 8, 0, 0},
            {5, 0, 0, 0, 0, 0, 0, 1, 0}
    };
    private static final int[][] hard3 = new int[][] {
            {0, 0, 0, 5, 0, 1, 0, 0, 0},
            {0, 9, 0, 7, 0, 4, 0, 3, 0},
            {0, 0, 3, 0, 0, 0, 2, 0, 0},
            {3, 2, 0, 0, 0, 0, 0, 7, 1},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {9, 1, 0, 0, 0, 0, 0, 2, 6},
            {0, 0, 6, 0, 0, 0, 8, 0, 0},
            {0, 5, 0, 4, 0, 2, 0, 9, 0},
            {0, 0, 0, 3, 0, 7, 0, 0, 0}
    };
    private static final int[][] hard4 = new int[][] {
            {0, 2, 3, 0, 0, 7, 0, 5, 0},
            {1, 0, 0, 0, 0, 6, 0, 0, 4},
            {0, 0, 0, 4, 5, 0, 0, 0, 3},
            {6, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 8, 9, 0, 4, 3, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 1},
            {7, 0, 0, 0, 4, 3, 0, 0, 0},
            {8, 0, 0, 5, 0, 0, 0, 0, 6},
            {0, 9, 0, 6, 0, 0, 8, 7, 0}
    };
    private static final int[][] hard5 = new int[][] {
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 3, 8, 2, 0, 0, 0, 0},
            {0, 0, 6, 0, 1, 9, 5, 7, 0},
            {0, 0, 8, 0, 0, 0, 0, 6, 0},
            {0, 5, 2, 0, 0, 0, 8, 3, 0},
            {0, 9, 0, 0, 0, 0, 4, 0, 0},
            {0, 7, 4, 5, 8, 0, 2, 0, 0},
            {0, 0, 0, 0, 3, 2, 6, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0}
    };
    private static final int[][] hard6 = new int[][] {
            {0, 0, 0, 0, 0, 0, 0, 6, 0},
            {1, 4, 0, 0, 0, 0, 5, 7, 0},
            {0, 2, 5, 0, 0, 4, 8, 0, 0},
            {0, 0, 3, 6, 0, 9, 0, 0, 0},
            {0, 0, 0, 0, 8, 0, 0, 0, 0},
            {0, 0, 0, 7, 0, 1, 2, 0, 0},
            {0, 0, 8, 5, 0, 0, 3, 4, 0},
            {0, 9, 4, 0, 0, 0, 0, 5, 6},
            {0, 3, 0, 0, 0, 0, 0, 0, 0}
    };
    private static final int[][] hard7 = new int[][] {
            {0, 0, 0, 0, 5, 3, 2, 8, 0},
            {0, 0, 0, 0, 0, 1, 0, 0, 4},
            {0, 0, 0, 0, 0, 0, 7, 0, 6},
            {0, 0, 0, 0, 0, 0, 0, 1, 8},
            {1, 0, 0, 0, 0, 0, 0, 0, 3},
            {2, 5, 0, 0, 0, 0, 0, 0, 0},
            {3, 0, 8, 0, 0, 0, 0, 0, 0},
            {7, 0, 0, 6, 0, 0, 0, 0, 0},
            {0, 6, 9, 4, 2, 0, 0, 0, 0}
    };

    private static void addEasyBoards() {
        easyBoards.add(easy0);
        easyBoards.add(easy1);
        easyBoards.add(easy2);
        easyBoards.add(easy3);
        easyBoards.add(easy4);
        easyBoards.add(easy5);
        easyBoards.add(easy6);
        easyBoards.add(easy7);
    }

    public static int[][] getEasyBoard() {
        addEasyBoards();
        return easyBoards.get((int) (Math.random() * easyBoards.size()));
    }

    private static void addMediumBoards() {
        mediumBoards.add(medium0);
        mediumBoards.add(medium1);
        mediumBoards.add(medium2);
        mediumBoards.add(medium3);
        mediumBoards.add(medium4);
        mediumBoards.add(medium5);
        mediumBoards.add(medium6);
        mediumBoards.add(medium7);
    }

    public static int[][] getMediumBoard() {
        addMediumBoards();
        return mediumBoards.get((int) (Math.random() * mediumBoards.size()));
    }

    private static void addHardBoards() {
        hardBoards.add(hard0);
        hardBoards.add(hard1);
        hardBoards.add(hard2);
        hardBoards.add(hard3);
        hardBoards.add(hard4);
        hardBoards.add(hard5);
        hardBoards.add(hard6);
        hardBoards.add(hard7);
    }

    public static int[][] getHardBoard() {
        addHardBoards();
        return hardBoards.get((int) (Math.random() * hardBoards.size()));
    }

    public static int[][] getRandomBoard() {
        switch ((int) (Math.random() * 3)) {
            case 0:
                addEasyBoards();
                return easyBoards.get((int) (Math.random() * easyBoards.size()));
            case 1:
                addMediumBoards();
                return mediumBoards.get((int) (Math.random() * mediumBoards.size()));
            case 2:
                addHardBoards();
                return hardBoards.get((int) (Math.random() * hardBoards.size()));
            default:
                return null;
        }
    }

}
