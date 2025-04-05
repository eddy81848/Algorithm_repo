import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ7576 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[][] tomato = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        LinkedList<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                if (tmp == 1) {
                    int[] element = {i, j};
                    queue.add(element);
                    visited[i][j] = true;
                }
                tomato[i][j] = tmp;
            }
        }
        while (!queue.isEmpty()) {
            int[] element = queue.removeFirst();
            int a = element[0];
            int b = element[1];
            try {
                if (tomato[a + 1][b] != -1 && !visited[a + 1][b]) {
                    int tmp = tomato[a][b] + 1;
                    if (tomato[a + 1][b] == 0 || tomato[a + 1][b] > tmp) {
                        tomato[a + 1][b] = tmp;
                    }
                    queue.addLast(new int[]{a + 1, b});
                    visited[a + 1][b] = true;
                }
            } catch (Exception e) {
            }
            try {
                if (tomato[a - 1][b] != -1 && !visited[a - 1][b]) {
                    int tmp = tomato[a][b] + 1;
                    if (tomato[a - 1][b] == 0 || tomato[a - 1][b] > tmp) {
                        tomato[a - 1][b] = tmp;
                    }
                    queue.addLast(new int[]{a - 1, b});
                    visited[a - 1][b] = true;

                }
            } catch (Exception e) {
            }
            try {
                if (tomato[a][b + 1] != -1 & !visited[a][b + 1]) {
                    int tmp = tomato[a][b] + 1;
                    if (tomato[a][b + 1] == 0 || tomato[a][b + 1] > tmp) {
                        tomato[a][b + 1] = tmp;
                    }
                    queue.addLast(new int[]{a, b + 1});
                    visited[a][b + 1] = true;
                }
            } catch (Exception e) {
            }
            try {
                if (tomato[a][b - 1] != -1 & !visited[a][b - 1]) {
                    int tmp = tomato[a][b] + 1;
                    if (tomato[a][b - 1] == 0 || tomato[a][b - 1] > tmp) {
                        tomato[a][b - 1] = tmp;
                    }
                    queue.addLast(new int[]{a, b - 1});
                    visited[a][b - 1] = true;
                }
            } catch (Exception e) {
            }
        }
        int max = Integer.MIN_VALUE;
        boolean flag = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (tomato[i][j] == 0) {
                    flag = false;
                    break;
                } else if (tomato[i][j] > max) {
                    max = tomato[i][j];
                }
            }
        }
        if (flag) {
            bw.write(Integer.toString(max - 1));
        } else {
            bw.write("-1");
        }
        bw.flush();
        bw.close();
    }
}
