package src;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class BOJ11559 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] field = new char[12][6];
        for (int i = 0; i < 12; i++) {
            String s = scanner.next();
            field[i] = s.toCharArray();
        }
        int count = 0;
        int iterate = 1;
        while (iterate > 0) {
            iterate = bfs(field);
            count += iterate;
            refresh(field);
        }
        System.out.println(count);
    }

    public static void refresh(char[][] field) {
        for (int i = 11; i >= 0; i--) {
            for (int j = 0; j <= 5; j++) {
                if (field[i][j] == 'x') {
                    for (int k = i; k >= 0; k--) {
                        if (k == 0) {
                            field[k][j] = '.';
                        } else {
                            field[k][j] = field[k - 1][j];
                        }
                    }
                }
            }
            for (int j = 0; j < 6; j++) {
                if (field[i][j] == 'x') {
                    i++;
                    break;
                }
            }
        }
    }


    public static int bfs(char[][] field) {
        int count = 0;
        int tmpCount;
        char[][] tempField = new char[field.length][];
        char tempChar;
        boolean[][] contain = new boolean[12][6];
        for (int i = 0; i < 12; i++) {
            Arrays.fill(contain[i], false);
        }
        LinkedList<int[]> list = new LinkedList<>();
        for (int i = 11; i >= 0; i--) {
            for (int j = 0; j < 6; j++) {
                tmpCount = 0;
                for (int k = 0; k < field.length; k++) {
                    tempField[k] = field[k].clone();
                }
                if (tempField[i][j] != '.' && tempField[i][j] != 'x') {
                    list.add(new int[]{i, j});
                    contain[i][j] = true;
                    tempChar = tempField[i][j];
                    while (!list.isEmpty()) {
                        int[] temp = list.removeFirst();
                        int a = temp[0];
                        int b = temp[1];
                        tempField[a][b] = 'x';
                        contain[a][b] = false;
                        tmpCount++;
                        try {
                            if (tempField[a - 1][b] == tempChar && !contain[a - 1][b]) {
                                list.add(new int[]{a - 1, b});
                                contain[a - 1][b] = true;
                            }
                        } catch (Exception ignored) {
                        }
                        try {
                            if (tempField[a + 1][b] == tempChar && !contain[a + 1][b]) {
                                list.add(new int[]{a + 1, b});
                                contain[a + 1][b] = true;
                            }
                        } catch (Exception ignored) {
                        }
                        try {
                            if (tempField[a][b - 1] == tempChar && !contain[a][b - 1]) {
                                list.add(new int[]{a, b - 1});
                                contain[a][b - 1] = true;
                            }
                        } catch (Exception ignored) {
                        }
                        try {
                            if (tempField[a][b + 1] == tempChar && !contain[a][b + 1]) {
                                list.add(new int[]{a, b + 1});
                                contain[a][b + 1] = true;
                            }
                        } catch (Exception ignored) {
                        }
                    }
                }
                list.clear();
                if (tmpCount >= 4) {
                    for (int k = 0; k < field.length; k++) {
                        field[k] = tempField[k].clone();
                    }
                    count++;
                }
            }
        }
        if (count > 0) return 1;
        else return 0;
    }
}