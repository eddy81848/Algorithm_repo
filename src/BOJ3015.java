import java.io.*;
import java.util.LinkedList;

public class BOJ3015 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long n = Long.parseLong(br.readLine());
        long cnt = 0;
        LinkedList<Long> list = new LinkedList<>();
        LinkedList<Long> stack = new LinkedList<>();
        for (long i = 0; i < n; i++) {
            list.add(Long.parseLong(br.readLine()));
        }
        list.addLast(Long.MAX_VALUE);
        stack.addFirst(Long.MAX_VALUE);
        long removeCnt = 0;
        for (long i : list) {
            if (!stack.isEmpty()) {
                long peek = stack.peekLast();
                if (peek < i) {
                    long prev = i;
                    long prevCnt = 1;
                    removeCnt = 0;
                    while (!stack.isEmpty() && stack.peekLast() < i) {
                        /*
                        마지막에 넣은 것 보다 큰 것이 들어올 경우 처리
                        새로운 블록과 높이가 크거나 같을 때까지 pop
                        */
                        long top = stack.removeLast();
                        removeCnt++;
                        if (prev != top) {
                            prevCnt = 1;
                            cnt += 2;
                            //이전이랑 다르면 앞뒤만 볼 수 있으니 2 추가
                        } else {
                            prevCnt++;
                            cnt += prevCnt + 1;
                            //이전이랑 같으면 이전것들 + 앞뒤를 볼 수 있으니 중복 카운트 + 1
                        }
                        prev = top;
                    }
                    if (stack.size() == 1) {
                        cnt -= prevCnt;
                    }//스택에 하나 남으면 앞에 가상으로 만들어둔 사람을 보게 되니 중복 개수만큼 빼주기
                    stack.addLast(i);
                } else {
                    stack.addLast(i);
                }
            }
        }

        bw.write(Long.toString(cnt - removeCnt));
        //마지막에는 가상으로 만들어둔 뒤에 사람을 보게 되니 마지막으로 지운 사람만큼 빼기
        bw.flush();
        bw.close();
    }
}
