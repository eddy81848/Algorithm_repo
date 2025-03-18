import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class BOJ1744 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int sum = 0;
        LinkedList<Integer> positive = new LinkedList<>();
        LinkedList<Integer> negative = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            int tmp = scanner.nextInt();
            if (tmp > 0) {
                positive.add(tmp);
            } else {
                negative.add(tmp);
            }
        }

        positive.sort(Collections.reverseOrder());
        Collections.sort(negative);

        int pa, pb, na, nb, pTemp, nTemp;
        while (positive.size() > 1 && negative.size() > 1) {
            pa = positive.get(0);
            pb = positive.get(1);
            na = negative.get(0);
            nb = negative.get(1);
            nTemp = pa + pb + na * nb;
            pTemp = na + nb + pa * pb;
            if (pTemp > nTemp) {
                positive.removeFirst();
                positive.removeFirst();
                sum += Math.max(pa * pb, pa + pb);
            } else {
                negative.removeFirst();
                negative.removeFirst();
                sum += na * nb;
            }
        }

        if (positive.size() > 1) {
            while (positive.size() > 1) {
                pa = positive.removeFirst();
                pb = positive.removeFirst();
                sum += Math.max(pa * pb, pa + pb);
            }
        } else {
            while (negative.size() > 1) {
                na = negative.removeFirst();
                nb = negative.removeFirst();
                sum += na * nb;
            }
        }

        if (positive.size() > 0) sum += positive.removeFirst();
        if (negative.size() > 0) sum += negative.removeFirst();

        System.out.println(sum);
    }
}
