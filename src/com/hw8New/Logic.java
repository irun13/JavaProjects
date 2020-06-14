package hw8New;

import java.util.Random;
import java.util.Scanner;

public class Logic {
    static int SIZE = 3;
    static int DOTS_TO_WIN = 3;

    static final char DOT_X = 'X';
    static final char DOT_O = 'O';
    static final char DOT_EMPTY = '.';
    // координаты победной линии
    static int[] winArr = new int[4];

    static char[][] map;
    static boolean gameFinished = false;

    static Random random = new Random();

    public static void go() {
        gameFinished = true;

        printMap();

        if (checkWinLines(DOT_X)) {
            System.out.println("Ты выиграл!");
            return;
        }

        if (isFull()) {
            System.out.println(" что то то ");
            return;
        }

        aiTurn();
        printMap();

        if (checkWinLines(DOT_O)) {
            System.out.println("Компьютер выиграл!");
            return;
        }

        if (isFull()) {
            System.out.println("Ничья");
            return;
        }

        gameFinished = false;
    }


    public static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    public static void printMap() {
        System.out.print("  ");
        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + 1 + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void setHumanCoords(int x, int y) {
        if (isCellValid(y, x)) {
            map[y][x] = DOT_X;
            go();
        }

    }

    public static boolean isCellValid(int y, int x) {
        if (x < 0 || y < 0 || x >= SIZE || y >= SIZE) {
            return false;
        }
        return map[y][x] == DOT_EMPTY;
    }

    public static void aiTurn() {
        int x, y;

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (isCellValid(i, j)) {
                    map[i][j] = DOT_O;
                    if (checkWinLines(DOT_O)) {
                        return;
                    }
                    map[i][j] = DOT_EMPTY;
                }
            }
        }

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (isCellValid(i, j)) {
                    map[i][j] = DOT_X;
                    if (checkWinLines(DOT_X)) {
                        map[i][j] = DOT_O;
                        return;
                    }
                    map[i][j] = DOT_EMPTY;
                }
            }
        }

        do {
            x = random.nextInt(SIZE);
            y = random.nextInt(SIZE);
        } while (!isCellValid(y, x));
        map[y][x] = DOT_O;
    }

    public static boolean isFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }


    static boolean checkLine(int cy, int cx, int vy, int vx, char dot) {
        if (cx + vx * (DOTS_TO_WIN - 1) > SIZE - 1 || cy + vy * (DOTS_TO_WIN - 1) > SIZE - 1 ||
                cy + vy * (DOTS_TO_WIN - 1) < 0) {
            return false;
        }

        for (int i = 0; i < DOTS_TO_WIN; i++) {
            if (map[cy + i * vy][cx + i * vx] != dot) {
                return false;
            }
        }
        ///////////требует рефакторинга
        if (vy == 0 && vx == 1) {
            int n = 0;
            for (int i = 0; i < SIZE; i++) {
                if (map[i][cy] == dot) {
                    n++;
                    if (n == DOTS_TO_WIN) {
                        winArr[0] = i - DOTS_TO_WIN;
                        winArr[1] = cy;
                        winArr[2] = i;
                        winArr[3] = cy;
                    }
                    break;
                } else {
                    n = 0;
                }

            }
        }
        return true;
    }

    static boolean checkWinLines(char dot) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (checkLine(i, j, 0, 1, dot) || checkLine(i, j, 1, 0, dot) ||
                        checkLine(i, j, 1, 1, dot) || checkLine(i, j, -1, 1, dot)) {
                    return true;
                }
            }
        }
        return false;
    }

}