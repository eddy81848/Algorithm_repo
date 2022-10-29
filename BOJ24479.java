import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ24479 {
    public static int n;
    public static int m;
    public static int r;
    public static boolean[] visited;
    public static boolean[] contain;
    public static PriorityQueue<Integer>[] edge;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        visited = new boolean[n + 1];
        contain = new boolean[n + 1];
        Arrays.fill(visited, false);
        Arrays.fill(contain, false);

        edge = new PriorityQueue[n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            edge[x].add(y);
            edge[y].add(x);
        }


    }


    public static void dfs() {

    }
}