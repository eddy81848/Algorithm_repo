import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class BOJ5639 {
    public static int[] tree;
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static HashMap<Integer, Integer> map = new HashMap<>();
    public static Node root;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        int cnt = 1;
        ArrayList<Integer> list = new ArrayList<Integer>();
        while ((line = br.readLine()) != null) {
            list.add(Integer.parseInt(line));
            map.put(Integer.parseInt(line), cnt);
            cnt++;
        }
        int size = list.size();
        tree = new int[(int) Math.pow(2,size)];
        tree[1] = list.get(0);
        for (int i = 1; i < size ; i++) {
            init(list.get(i), 1);
        }
        int a = 0;
        postOrder(1);
        bw.flush();
        bw.close();
    }

    public static Node insert(Node node, int value) {
        if (node == null) {

        }
    }

    public static void postOrder(int node) throws IOException {
        int value = tree[node];
        if (tree[node*2] != 0){
            postOrder(node * 2);
        }
        if (tree[node*2+1] != 0){
            postOrder(node * 2 + 1);
        }
        bw.write(tree[node]+"\n");
    }

    public static class Node{
        public int left;
        public int right;
        public int value;
        public Node(int value){
            this.value = value;
        }
    }
}
