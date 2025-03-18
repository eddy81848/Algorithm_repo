import java.io.*;
import java.util.EmptyStackException;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine()," ");
            String fst = st.nextToken();
            if ("push".equals(fst)) {
                stack.push(Integer.parseInt(st.nextToken()));
            } else if ("pop".equals(fst)) {
                try{
                    System.out.println(stack.pop());
                } catch (EmptyStackException e){
                    System.out.println(-1);
                }
            } else if ("size".equals(fst)) {
                System.out.println(stack.size());
            } else if ("empty".equals(fst)) {
                if (stack.empty()){
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            } else if ("top".equals(fst)) {
                try{
                    System.out.println(stack.peek());
                } catch (EmptyStackException e) {
                    System.out.println(-1);
                }
            }
        }
    }
}
