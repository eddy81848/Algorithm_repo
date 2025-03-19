import java.io.*;
import java.util.StringTokenizer;

public class BOJ2042 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        long[] elements = new long[n + 1];
        int treeHeight = (int) (Math.ceil(Math.log(n) / Math.log(2)) + 1);
        int treeSize = (int) Math.pow(2, treeHeight);
        long[] segmentTree = new long[treeSize + 1];
        for (int i = 1; i <= n; i++) {
            elements[i] = Long.parseLong(br.readLine());
        }
        init(elements, segmentTree, 1, 1, n);
        for (int i = 0; i < m + k; i++) {
            st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());
            long c = Long.parseLong(st.nextToken());
            switch ((int) a) {
                case 1:
                    update(elements, segmentTree, 1, b, c - elements[(int) b], 1, n);
                    break;
                case 2:
                    long sum = sum(segmentTree, 1, 1, n, b, c);
                    bw.write(sum + "\n");
                    break;
            }
        }
        bw.flush();
        bw.close();
    }

    public static long init(long[] elements, long[] tree, long node, long start, long end) {
        if (start == end) {
            tree[(int) node] = elements[(int) start];
        } else {
            tree[(int) node] = init(elements, tree, node * 2, start, (start + end) / 2) +
                    init(elements, tree, node * 2 + 1, (start + end) / 2 + 1, end);
        }
        return tree[(int) node];
    }

    public static void update(long[] elements, long[] tree, long node, long changedNode, long diff, long start, long end) {
        if (changedNode >= start && changedNode <= end) {
            if (start == end) {
                elements[(int) changedNode] += diff;
                tree[(int) node] += diff;
            } else {
                tree[(int) node] += diff;
                update(elements, tree, node * 2, changedNode, diff, start, (start + end) / 2);
                update(elements, tree, node * 2 + 1, changedNode, diff, (start + end) / 2 + 1, end);
            }
        }
    }

    public static long sum(long[] tree, long node, long start, long end, long startRange, long endRange) {
        if (startRange <= start && end <= endRange) {
            return tree[(int) node];
        }
        if (end < startRange || endRange < start) {
            return 0;
        }

        return sum(tree, node * 2, start, (start + end) / 2, startRange, endRange)
                + sum(tree, node * 2 + 1, (start + end) / 2 + 1, end, startRange, endRange);

    }
}
