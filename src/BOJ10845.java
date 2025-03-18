package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.StringTokenizer;

public class BOJ10845 {
    public static void main(String[] args) throws IOException {
        LinkedList<Integer> queue = new LinkedList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String s = st.nextToken();
            if (Objects.equals(s, "push")) {
                queue.add(Integer.parseInt(st.nextToken()));
            } else if (Objects.equals(s, "pop")) {
                try {
                    System.out.println(queue.removeFirst());
                } catch (NoSuchElementException e) {
                    System.out.println(-1);
                }
            } else if (Objects.equals(s, "size")) {
                System.out.println(queue.size());
            } else if (Objects.equals(s, "empty")) {
                if (queue.isEmpty()) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            } else if (Objects.equals(s, "front")) {
                try {
                    System.out.println(queue.getFirst());
                } catch (NoSuchElementException e) {
                    System.out.println(-1);
                }
            } else if (Objects.equals(s, "back")) {
                try {
                    System.out.println(queue.getLast());
                } catch (NoSuchElementException e) {
                    System.out.println(-1);
                }
            }
        }
    }
}
