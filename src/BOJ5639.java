import java.io.*;

public class BOJ5639 {
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static Node root = new Node(0);

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null) {
            root.left = insert(root.left, Integer.parseInt(line));
        }
        postOrder(root.left);
        bw.flush();
        bw.close();
    }

    public static Node insert(Node node, int value) {
        if (node == null) {
            return new Node(value);
        } else {
            if (node.value > value) {
                node.left = insert(node.left, value);
            } else {
                node.right = insert(node.right, value);
            }
            return node;
        }
    }

    public static void postOrder(Node node) throws IOException {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        bw.write(node.value + "\n");
    }

    public static class Node {
        public Node left;
        public Node right;
        public int value;

        public Node(int value) {
            this.value = value;
        }
    }
}
