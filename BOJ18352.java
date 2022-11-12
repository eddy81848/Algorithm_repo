import java.util.LinkedList;
import java.util.Scanner;

public class BOJ18352 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();
        int x = scanner.nextInt();
        LinkedList<Integer>[] edge = new LinkedList[n + 1];
        int[] weight = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            edge[i] = new LinkedList<>();
        }
        for (int i = 0; i < m; i++) {
            edge[scanner.nextInt()].addLast(scanner.nextInt());
        }

        bfs(edge, weight, x);

        boolean b = false;
        for (int i = 1; i < weight.length; i++) {
            if (weight[i] == k) {
                System.out.println(i);
                b = true;
            }
        }
        if (!b) System.out.println(-1);
    }

    public static void bfs(LinkedList<Integer>[] edge, int[] weight, int x) {
        LinkedList<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[weight.length];
        weight[x] = 0;
        visited[x] = true;
        queue.addLast(x);
        int n, size;
        while (!queue.isEmpty()) {
            n = queue.removeFirst();
            size = edge[n].size();
            for (int i = 0; i < size; i++) {
                if (!visited[edge[n].peekFirst()]) {
                    weight[edge[n].peekFirst()] = weight[n] + 1;
                    visited[edge[n].peekFirst()] = true;
                    queue.addLast(edge[n].removeFirst());
                }
            }
        }
    }
}
