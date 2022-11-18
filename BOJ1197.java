import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1197 {
    static int[] union;

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        Edge[] weight = new Edge[e];
        union = new int[v + 1];
        int result = 0;


        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            weight[i] = new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(weight);


        for (int index = 0; index < e; index++) {
            if (union_find(weight[index].v1) != union_find(weight[index].v2)) {
                result += weight[index].weight;
                union_set(weight[index].v1, weight[index].v2);
            }
        }
        bw.write(Integer.toString(result));
        bw.flush();
        bw.close();
        br.close();
    }

    public static int union_find(int v) {
        if (union[v] == 0) return v;
        else return union[v] = union_find(union[v]);
    }

    public static void union_set(int v, int s) {
        int rootV = union_find(v);
        int rootS = union_find(s);
        if (rootS != rootV) {
            union[rootV] = rootS;
        }
    }

    static class Edge implements Comparable<Edge> {
        int v1;
        int v2;
        int weight;

        public Edge(int v1, int v2, int weight) {
            this.v1 = v1;
            this.v2 = v2;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge e) {
            return this.weight - e.weight;
        }
    }
}
