package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ24479 {
    public static int n;
    public static int m;
    public static int r;
    public static int[] visited;
    public static boolean[] contain;
    public static LinkedList<Integer>[] edge;
    public static int order = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        visited = new int[n + 1];
        contain = new boolean[n + 1];
        Arrays.fill(visited, 0);
        Arrays.fill(contain, false);

        edge = new LinkedList[n + 1];

        for (int i = 0; i < n + 1; i++) {
            edge[i] = new LinkedList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            edge[x].add(y);
            edge[y].add(x);
        }

        for (int i = 0; i < n + 1; i++) {
            Collections.sort(edge[i]);
        }

        dfs(r);

        for (int i = 1; i <= n; i++) {
            System.out.println(visited[i]);
        }
    }


    public static void dfs(int vertex) {
        visited[vertex] = order;
        order++;
        for (int v : edge[vertex]) {
            if (visited[v] == 0) {
                dfs(v);
            }
        }
    }
}