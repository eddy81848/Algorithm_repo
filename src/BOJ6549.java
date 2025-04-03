import java.io.*;
import java.util.StringTokenizer;

public class BOJ6549 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long n = Integer.parseInt(st.nextToken());
            if (n == 0) break;
            long[] elements = new long[(int) (n + 1)];
            for (long i = 1; i <= n; i++) {
                elements[(int) i] = Integer.parseInt(st.nextToken());
            }
            long treeHeight = (long) (Math.ceil(Math.log(n) / Math.log(2)) + 1);
            long treeSize = (long) Math.pow(2, treeHeight);
            long[] segmentTree = new long[(int) treeSize];
            init(segmentTree, elements, 1, 1, n);
            bw.write(histogram(segmentTree, elements, 1, n) + "\n");
        }
        bw.flush();
        bw.close();
    }

    public static long init(long[] tree, long[] elements, long node, long start, long end) {
        if (start == end) {
            tree[(int) node] = start;
            return tree[(int) node];
        }
        long a = init(tree, elements, node * 2, start, (start + end) / 2);
        long b = init(tree, elements, node * 2 + 1, (start + end) / 2 + 1, end);
        tree[(int) node] = elements[(int) a] < elements[(int) b] ? a : b;
        return tree[(int) node];
    }

    public static long range(long[] tree, long[] elements, long node, long start, long end, long startRange, long endRange) {
        if (startRange <= start && end <= endRange) {
            return tree[(int) node];
        }
        if (startRange > end || endRange < start) {
            return -1;
        }
        long a = range(tree, elements, node * 2, start, (start + end) / 2, startRange, endRange);
        long b = range(tree, elements, node * 2 + 1, (start + end) / 2 + 1, end, startRange, endRange);
        long aVal = a != -1 ? elements[(int) a] : Integer.MAX_VALUE;
        long bVal = b != -1 ? elements[(int) b] : Integer.MAX_VALUE;
        return aVal < bVal ? a : b;
    }

    public static long histogram(long[] tree, long[] elements, long start, long end) {
        if (start == end) {
            return elements[(int) start];
        }
        long n = elements.length - 1;
        long m = range(tree, elements, 1, 1, n, start, end);
        long area = elements[(int) m] * (end - start + 1);
        if (m == start) {
            long tmp = histogram(tree, elements, m + 1, end);
            area = Math.max(area, tmp);
        } else if (m == end) {
            long tmp = histogram(tree, elements, start, m - 1);
            area = Math.max(area, tmp);
        } else {
            long tmp1 = histogram(tree, elements, m + 1, end);
            long tmp2 = histogram(tree, elements, start, m - 1);
            area = Math.max(area, Math.max(tmp1, tmp2));
        }
        return area;
    }
}
