import java.io.*;
import java.util.*;

public class BOJ24445 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        //정점 및 간선 정보 입력
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        //각종 객체 선언
        boolean[] visited = new boolean[n + 1]; //노드가 방문되었는지 확인하기 위한 배열
        int[] visitedOrder = new int[n]; //방문 순서를 담을 배열
        boolean[] contain = new boolean[n + 1]; //노드가 큐에 있는지 판단하기 위한 배열
        PriorityQueue<Integer>[] list = new PriorityQueue[n + 1];//간선을 표현하기 위한 우선순위 큐를 담고 있는 연결리스트
        LinkedList<Integer> queue = new LinkedList<>(); //bfs에서 사용할 큐

        //초기화
        for (int i = 0; i <= n; i++) {
            list[i] = new PriorityQueue<>(Collections.reverseOrder());
        }
        Arrays.fill(visited, false);
        Arrays.fill(contain, false);
        queue.add(r);
        int order = 1;

        //간선 입력
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list[x].add(y);
            list[y].add(x);
        }

        //bfs
        while (!queue.isEmpty()) {
            r = queue.removeFirst();
            visited[r] = true;
            contain[r] = false;
            visitedOrder[r - 1] = order++;
            int size = list[r].size();
            for (int i = 0; i < size; i++) {
                int tmp = list[r].poll();
                if (!visited[tmp] && !contain[tmp]) {
                    queue.add(tmp);
                    contain[tmp] = true;
                }
            }
        }

        for (int j : visitedOrder) {
            sb.append(j).append("\n");
        }
        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
        br.close();
    }
}