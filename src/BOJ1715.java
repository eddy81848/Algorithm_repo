package src;

import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ1715 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        PriorityQueue<Integer> list = new PriorityQueue<>();
        int result = 0;
        int temp;
        for (int i = 0; i < n; i++) {
            list.add(scanner.nextInt());
        }

        while (list.size() > 1) {
            temp = list.poll() + list.poll();
            result += temp;
            list.add(temp);
        }

        System.out.println(result);
    }
}
