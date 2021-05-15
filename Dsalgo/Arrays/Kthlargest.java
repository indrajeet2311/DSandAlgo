import java.util.*;

public class Kthlargest {

    public static int findkth(List<Integer> ints, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(ints.subList(0, k));

        for (int i = k; i < ints.size(); i++) {
            if (ints.get(i) > pq.peek()) {
                pq.poll();
                pq.add(ints.get(i));
            }
        }

        return pq.peek();
    }

    public static void main(String[] args) {

        List<Integer> ints = Arrays.asList(7, 4, 3, 1, 2, 8);
        int k = 3;
        System.out.println(findkth(ints, k));

    }
}
