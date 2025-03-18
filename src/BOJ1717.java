package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1717 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            arr[i] = i;
        }
        int a, b, c;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            if (a == 0) {
                union(b, c, arr);
            } else {
                if (find(b, arr) == find(c, arr)) System.out.println("YES");
                else System.out.println("NO");
            }
        }
    }

    public static int find(int x, int[] arr) {
        if (arr[x] == x) return x;
        else return arr[x] = find(arr[x], arr);
    }

    public static void union(int x, int y, int[] arr) {
        x = find(x, arr);
        y = find(y, arr);
        if (x != y) arr[y] = x;
    }
}
