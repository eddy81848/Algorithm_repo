package src;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ1931 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int cnt = 0;
        int time = 0;
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = scanner.nextInt();
            arr[i][1] = scanner.nextInt();
        }

        Arrays.sort(arr, (a, b) -> {
            if (a[1] == b[1]) {
                return a[0] - b[0];
            } else {
                return a[1] - b[1];
            }
        });

        for (int i = 0; i < n; i++) {
            if (arr[i][0] >= time) {
                cnt++;
                time = arr[i][1];
            }
        }

        System.out.println(cnt);
    }
}
