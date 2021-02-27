package ru.geekbrains.java_one.lesson_a.online_h1;

import java.util.Random;
import java.util.Scanner;

public class Home3 {
    //human
    private static final char DOT_HUMAN = 'X';
    //AI
    private static final char DOT_AI = '0';
    //humanInput
    private static final Scanner SCANNER = new Scanner(System.in);
    //aiInput
    private static final Random RANDOM = new Random();
    private static final char DOT_EMPTY = '_';
    //fieldSizeX
    private static int fieldSizeX;
    //fieldSizeY
    private static int fieldSizeY;
    //field
    private static char[][] field;

    //initField
    private static void initField() {
        fieldSizeX = 3;
        fieldSizeY = 3;
        field = new char[fieldSizeX][fieldSizeY];
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                field[y][x] = DOT_EMPTY;
            }
        }
    }

    //printField
    private static void printField() {
        System.out.println("+");
        for (int i = 0; i < fieldSizeX * 2 + 1; i++)
            System.out.print((i % 2 == 0) ? "_" : i / 2 + 1);
        System.out.println();

        for (int i = 0; i < fieldSizeY; i++) {
            System.out.print(i + 1 + "|");
            for (int j = 0; j < fieldSizeX; j++)
                System.out.print(field[i][j] + "|");
            System.out.println();
        }

        for (int i = 0; i <= fieldSizeX * 2 + 1; i++)
            System.out.print("_");
        System.out.println();
    }

    //humanTurn
    private static void humanTurn() {
        int x;
        int y;
        do {
            System.out.print("Введите координаты (Х и У) от 1 до " + fieldSizeX + "через пробел >>");
            x = SCANNER.nextInt() - 1;
            y = SCANNER.nextInt() - 1;
        } while (!isCellValid(x, y) || !isCellEmpty(x, y));
        field[y][x] = DOT_HUMAN;
    }

    //aiTurn
    private static void aiTurn() {
        int x;
        int y;
        do{
            x = RANDOM.nextInt(fieldSizeX);
            y = RANDOM.nextInt(fieldSizeY);
        } while(!isCellEmpty(x, y));
        field[y][x]=DOT_AI;
    }

    //isCellEmpty
    private static boolean isCellEmpty(int x, int y) {
        return field[y][x]== DOT_EMPTY;
    }

    //isCellValid
    private static boolean isCellValid(int x, int y) {
        return x >= 0 && y >= 0 && x < fieldSizeX && y < fieldSizeY;
    }

    //checkWin
    private static boolean checkWin(char c) {
        boolean win = false;
        for (int y = 0; y < fieldSizeY; y++) {
            for(int x = 0 ; x < fieldSizeX; x++) {
                if(field[x][y] != c) {
                    break;
                }
                if(x == fieldSizeX - 1) {
                    win = true;
                }
            }
        }
        for (int x = 0; x < fieldSizeX; x++) {
            for(int y = 0; y < fieldSizeY; y++) {
                if(field[x][y] != c) {
                    break;
                }
                if(y == fieldSizeY - 1) {
                    win = true;
                }
            }
        }
        int y = 0;
        for(int x = 0; x < fieldSizeX; x++) {
            if(field[x][y] != c) {
                break;
            }
            if(x == fieldSizeX - 1 && y == fieldSizeY - 1) {
                win = true;
            }
            y++;
        }
        y = 0;
        for(int x = fieldSizeX - 1; x >= 0; x--) {
            if(field[x][y] != c) {
                break;
            }
            if(x == 0 && y == fieldSizeY - 1) {
                win = true;
            }
            y++;
        }
        if(win) {
            return true;
        }
        return false;
    }

    //checkDraw
    private static boolean isDraw() {
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if (field[y][x] == DOT_EMPTY)
                    return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        initField();
        printField();

        while (true) {
            humanTurn();
            printField();
            if (checkWin(DOT_HUMAN)) {
                System.out.println("Human win!");
                break;
            }
            if (isDraw()) {
                System.out.println("Draw!");
                break;
            }
            aiTurn();
            printField();
            if (checkWin(DOT_AI)) {
                System.out.println("Computer wins!");
                break;
            }
            if (isDraw()) {
                System.out.println("Draw!");
                break;
            }
        }
    }
