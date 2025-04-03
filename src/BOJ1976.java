import java.io.*;
import java.util.StringTokenizer;

public class BOJ1976 {
    public static int[] union;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[][] city = new int[n + 1][n + 1];
        union = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            union[i] = -1;
        }
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                city[i][j] = tmp;
                if (tmp == 1) union(i, j);
            }
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        boolean isPossible = true;
        for (int i = 0; i < m - 1; i++) {
            int end = Integer.parseInt(st.nextToken());
            if (find(start) != find(end)) {
                isPossible = false;
                break;
            }
            start = end;
        }
        if (isPossible) {
            bw.write("YES");
        } else {
            bw.write("NO");
        }
        bw.flush();
        bw.close();
    }

    public static void union(int i, int j) {
        int root1 = find(i);
        int root2 = find(j);
        if (root1 != root2) {
            union[root1] = root2;
        }
    }

    public static int find(int i) {
        if (union[i] == -1) return i;
        while (union[i] != -1) {
            i = union[i];
        }
        return i;
    }
}
