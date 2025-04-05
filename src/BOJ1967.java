import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ1967 {
    public static LinkedList<int[]>[] tree;
    public static boolean[] visited;
    public static int maxWeight = Integer.MIN_VALUE;
    public static int maxNode;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        tree = new LinkedList[n + 1];
        visited = new boolean[n + 1];
        for (int i = 1; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            tree[v1].add(new int[] {v2, weight});
            tree[v2].add(new int[] {v1, weight});
        }
    }
    public static void dfs(int n) {
        visited[n] = true;
        for (int[] v : tree[n]) {
            if (!visited[v[0]]) {
                dfs(v[0]);
            }
        }
    }
}
