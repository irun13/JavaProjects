package com.hw4;

import java.util.Random;
import java.util.Scanner;

public class XOGame {
    static final int SIZE = 9;
    static final int DOTS_TO_WIN = 4; //победная линия
    static final char DOT_X = 'X';
    static final char DOT_O = 'O';
    static final char DOT_EMPTY = '.';
    public static int x;
    public static int y;

    static char map[][];

    static Scanner sc = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {
        intMap();
        printMap();

        while (true) {
            humanTurn();
            printMap();

            if (checkWin(DOT_X)) {
                System.out.println("Ты победил!");
                break;
            }

            if (isFull()) {
                System.out.println("Ничья");
                break;
            }

            aiTurn();
            printMap();

            if (checkWin(DOT_O)) {
                System.out.println("Компьютер победил!");
                break;
            }

            if (isFull()) {
                System.out.println("Ничья");
                break;
            }
        }
    }

    public static void intMap() {
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
            System.out.print((i + 1) + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void humanTurn() {
        do {
            System.out.println("Введите координаты вашего хода X Y");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(y, x));

        map[y][x] = DOT_X;
    }

    public static boolean isCellValid(int y, int x) {
        if (x < 0 || y < 0 || x > SIZE || y > SIZE) {
            // System.out.println("Некорректные координаты");
            return false;
        }
        if (map[y][x] != DOT_EMPTY) {
            // System.out.println("Занято!");
            return false;
        }
        return true;
    }

    public static void aiTurn() {
        int turn = 0; // был ли умный ход?
        turn = cleveAaiTurn(turn);
        //System.out.println(" turn = "+ turn);
        if (turn == 0) {
            do {
                x = random.nextInt(SIZE);
                y = random.nextInt(SIZE);
            } while (!isCellValid(y, x));
            System.out.println("Шаг ai " + (x + 1) + " " + (y + 1));
            map[y][x] = DOT_O;
        }
        turn = 0;
    }

    // Умный мешающий ход ai. Если есть рядом 2 крестика ставит нолик рядом
    public static int cleveAaiTurn(int turn) {
        //горизонталь
        //System.out.println(" я тут был");
        for (int i = 0; i < SIZE; i++) {
            if (i + 1 < SIZE && map[y][i] == DOT_X && map[y][i + 1] == DOT_X) {
                //  XX_
                //System.out.println("и тут был");
                if (x + 2 <= SIZE && isCellValid(y, i + 2)) {
                    //System.out.println("XX_");
                    map[y][i + 2] = DOT_O;
                    turn = 1;
                }
                // XX0 ||  XXX0
                if (turn == 0 && i + 2 <= SIZE && (map[y][i + 2] == DOT_O || map[y][i + 2] == DOT_X) && isCellValid(y, i - 1)) {
                    // System.out.println("XX0");
                    map[y][i - 1] = DOT_O;
                    turn = 1;
                }
                // XX|
                if (turn == 0 && i + 2 == SIZE && isCellValid(y, i - 1)) {
                    //System.out.println("XX|");
                    map[y][i - 1] = DOT_O;
                    turn = 1;
                }
            }
        }
        return turn;
    }

    // есть ли еще свободные клетки?
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

    // мой первый корявый варик проверки
    /* public static boolean checkWin(char c) {
        int charactersPerLine = 0;
        // проверяем горизонталь
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == c) {
                    charactersPerLine++;
                    if (charactersPerLine == DOTS_TO_WIN) {
                        return true;
                    }
                } else {
                    charactersPerLine = 0;
                }
            }
            charactersPerLine = 0;
        }
        // роверяем вертикать
        for (int j = 0; j < SIZE; j++) {
            for (int i = 0; i < SIZE; i++) {
                if (map[i][j] == c) {
                    charactersPerLine++;
                    if (charactersPerLine == DOTS_TO_WIN) {
                        return true;
                    }
                } else {
                    charactersPerLine = 0;
                }
            }
            charactersPerLine = 0;
        }
        // проверям диагональ сверху вниз
        for (int i = SIZE - 1; i >= 0; i--) {
            for (int j = 0; (i + j) < SIZE; j++) {
                if (map[i + j][j] == c) {
                    charactersPerLine++;
                    if (charactersPerLine == DOTS_TO_WIN) {
                        return true;
                    }
                } else {
                    charactersPerLine = 0;
                }
            }
            charactersPerLine = 0;
        }

        // проверям диагональ снизу вверх
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j <=i; j++) {
                if (map[i - j][j] == c) {
                    charactersPerLine++;
                    if (charactersPerLine == DOTS_TO_WIN) {
                        return true;
                    }
                } else {
                    charactersPerLine = 0;
                }
            }
            charactersPerLine = 0;
        }

        return false;
    }*/
    // второй варик проверки
    public static boolean checkWin(char c) {
        int charactersPerLineG = 0;
        int charactersPerLineW = 0;
        int charactersPerLineM = 0; //
        int charactersPerLineN = 0; //
        int m = y - x;
        int n = y + x;
        //вертикаль и горизонталь
        for (int i = 0; i < SIZE; i++) {
            //горизон
            if (map[y][i] == c) {
                charactersPerLineG++;
                if (charactersPerLineG == DOTS_TO_WIN) {
                    return true;
                }
            } else {
                charactersPerLineG = 0;
            }
            //вертикаль
            if (map[i][x] == c) {
                charactersPerLineW++;
                if (charactersPerLineW == DOTS_TO_WIN) {
                    return true;
                }
            } else {
                charactersPerLineW = 0;
            }
            // проверяю диагональ y = x + m
            if (i + m >= 0 && i + m < SIZE) {
                if (map[i + m][i] == c) {
                    charactersPerLineM++;
                    if (charactersPerLineM == DOTS_TO_WIN) {
                        return true;
                    }

                } else {
                    charactersPerLineM = 0;
                }
            }
            // проверяю диагональ y = n - x
            if (n - i >= 0 && n - i < SIZE) {
                if (map[n - i][i] == c) {
                    charactersPerLineN++;
                    if (charactersPerLineN == DOTS_TO_WIN) {
                        return true;
                    }
                } else {
                    charactersPerLineN = 0;
                }
            }
        }
        return false;
    }


}
