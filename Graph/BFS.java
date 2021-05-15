import java.util.*;

public class BFS {

    public static ArrayList<Integer> bfs(int V, ArrayList<ArrayList<Integer>> adj) {

        ArrayList<Integer> bfs = new ArrayList<>();
        boolean[] vis = new boolean[V + 1];

        for (int i = 1; i <= V; i++) {
            if (vis[i] == false) {
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                vis[i] = true;

                while (!q.isEmpty()) {
                    Integer node = q.poll();
                    bfs.add(node);

                    for (Integer it : adj.get(node)) {
                        if (vis[it] == false) {
                            vis[it] = true;
                            q.add(it);
                        }
                    }
                }
            }
        }

        return bfs;

    }

    public static void main(String[] args) {

        int a = 3, b = 3;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i <= a; i++)
            adj.add(new ArrayList<Integer>());

        // for edge 1-2
        adj.get(1).add(2);
        adj.get(2).add(1);

        // for edge 2-3
        adj.get(2).add(3);
        adj.get(3).add(2);

        // for edge 1-3
        adj.get(1).add(3);
        adj.get(3).add(1);

        System.out.println(bfs(a, adj));

    }
}
