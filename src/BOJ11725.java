import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ11725 {
    public static int[] parent;
    public static boolean[] visited;
    public static LinkedList<Integer>[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        tree = new LinkedList[n + 1];
        for (int i = 1; i < n + 1; i++) {
            tree[i] = new LinkedList<>();
        }
        parent = new int[n + 1];
        visited = new boolean[n + 1];
        for (int i = 1; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree[a].add(b);
            tree[b].add(a);
        }
        dfs(1);
        for (int i = 2; i < n + 1; i++) {
            bw.write(parent[i] + "\n");
        }
        bw.flush();
        bw.close();
    }

    public static void dfs(int n) {
        visited[n] = true;
        for (int v : tree[n]) {
            if (!visited[v]) {
                parent[v] = n;
                dfs(v);
            }
        }
    }
}
