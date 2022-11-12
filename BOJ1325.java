import java.io.*;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1325 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int a, b;
        LinkedList<Integer>[] graph = new LinkedList[n + 1];
        PriorityQueue<int[]> hack = new PriorityQueue<>((x, y) -> {
            if (x[0] == y[0]) {
                return x[1] - y[1];
            } else {
                return y[0] - x[0];
            }
        }); // 개수, 노드번호
        for (int i = 0; i <= n; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            graph[b].add(a);
        }
        int temp;
        for (int i = 1; i <= n; i++) {
            temp = bfs(graph, i);
            hack.add(new int[]{temp, i});
        }
        temp = hack.peek()[0];
        while (hack.peek()[0] == temp) {
            bw.write(Integer.toString(hack.poll()[1]) + ' ');
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public static int bfs(LinkedList<Integer>[] g, int x) {
        LinkedList<Integer>[] graph = new LinkedList[g.length];
        for (int i = 0; i < g.length; i++) {
            graph[i] = new LinkedList<>(g[i]);
        }
        int result = 0;
        LinkedList<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[graph.length];
        queue.addLast(x);
        visited[x] = true;
        int n, size, temp;
        while (!queue.isEmpty()) {
            n = queue.removeFirst();
            size = graph[n].size();
            for (int i = 0; i < size; i++) {
                temp = graph[n].removeFirst();
                if (!visited[temp]) {
                    result++;
                    visited[temp] = true;
                    queue.addLast(temp);
                }
            }
        }
        return result;
    }
}
