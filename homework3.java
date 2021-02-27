package GB.J_one.Samostoiatelno.Zadachi;

import java.util.Random;
import java.util.Scanner;

public class homework3 {

    public static char[][] map;
    public static int mapSizeX;
    public static int mapSizeY;

    public static char human = 'X';
    public static char ai = '0';
    public static char empty = '_';
    public static Scanner scanner = new Scanner(System.in);
    public static Random random = new Random();

    public static void beMap() {
        mapSizeY = 5;
        mapSizeX = 5;
        map = new char[mapSizeY][mapSizeX];
        for (int y = 0; y < mapSizeY; y++) {
            for (int x = 0; x < mapSizeX; x++) {
                map[y][x] = empty;
            }
        }
    }

    public static void printMap() {
        for (int y = 0; y < mapSizeY; y++) {
            for (int x = 0; x < mapSizeX; x++) {
                System.out.print(map[y][x] + " | ");
            }
            System.out.println();
        }
        System.out.println("*******************");
    }

    public static void turnHuman() {
        int x;
        int y;
        do {
            System.out.println("Enter coordinates:");
            x = scanner.nextInt() -1;
            y = scanner.nextInt() -1;
        } while (!validTurn(y,x) || !emptyCell(y,x));
        map[y][x] = human;
    }

    public static boolean validTurn(int y, int x) {
        return x >= 0 && x < mapSizeX && y >= 0 && y < mapSizeY;
    }

    public static boolean emptyCell(int y, int x) {
        return map[y][x] == empty;
    }

    public static void ternAi() {
        int x;
        int y;
        do {
            x = random.nextInt(mapSizeX);
            y = random.nextInt(mapSizeY);
        } while (!emptyCell(y,x));
        map[y][x] = ai;
    }

    public static boolean checkWin(char player) {
        boolean win = false;
        for (int y = 0; y < mapSizeY; y++) {
            for (int x = 0; x < mapSizeX; x++) {
                if (map[y][x] != player) {
                    break;
                }
                if (x == mapSizeX -1) {
                   win = true;
                }
            }
        }
        for (int x = 0; x < mapSizeX; x++) {
            for (int y = 0; y < mapSizeY; y++) {
                if (map[y][x] != player) {
                    break;
                }
                if (y == mapSizeY -1) {
                    win = true;
                }
            }
        }
        int y = 0;
        for (int x = 0; x < mapSizeX; x++) {
            if (map[y][x] != player) {
                break;
            }
            if (x == mapSizeX -1 && y == mapSizeY -1) {
                win = true;
            }
            y++;
        }
        y = 0;
        for (int x = mapSizeX -1; x >= 0; x--) {
            if (map[y][x] != player) {
                break;
            }
            if (x == 0 && y == mapSizeY -1){
                win = true;
            }
            y++;
        }
        if (win) {
            return true;
        }
        return false;
    }

    public static boolean isDraw() {
        for (int y = 0; y < mapSizeY; y++) {
            for (int x = 0; x < mapSizeX; x++) {
                if (map[y][x] == empty);
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        beMap();
        printMap();
        while (true) {
            turnHuman();
            printMap();
            if (checkWin(human)) {
                System.out.println(human + " WIN!");
                break;
            }
            if (isDraw()) {
                System.out.println("DRAW!");
                break;
            }

            ternAi();
            printMap();
            if (checkWin(ai)) {
                System.out.println(ai + " WIN!");
                break;
            }
            if (isDraw()) {
                System.out.println("DRAW!");
                break;
            }
        }
    }
}
