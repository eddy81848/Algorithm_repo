import java.io.*;
import java.util.LinkedList;

public class BOJ3015 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int cnt = 0;
        LinkedList<Integer> list = new LinkedList<>();
        LinkedList<Integer> stack = new LinkedList<>();
        stack.addLast(Integer.MAX_VALUE);
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }
        list.addLast(Integer.MAX_VALUE);

        for (int i : list) {
            if (!stack.isEmpty()) {
                int peek = stack.peekLast();
                if (peek < i) {
                    while (!stack.isEmpty() && stack.peekLast() < peek) {
                        int top = stack.removeLast();
                        /*
                        마지막에 넣은 것 보다 큰 것이 들어올 경우 처리
                        새로운 블록과 높이가 크거나 같을 때까지 pop
                        */


                    }
                } else {
                    stack.addLast(i);
                }
            }
        }

        bw.write(Integer.toString(cnt));
        bw.flush();
        bw.close();
    }
}
