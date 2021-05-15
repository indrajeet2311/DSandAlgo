import java.util.*;

public class DFS {

    static void dfsUtil(int node, boolean[] vis, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> storedfs) {
        storedfs.add(node);
        vis[node] = true;
        for (Integer it : adj.get(node)) {
            if (vis[it] == false) {
                dfsUtil(it, vis, adj, storedfs);
            }
        }
    }

    public static ArrayList<Integer> dfs(int V, ArrayList<ArrayList<Integer>> adj) {

        ArrayList<Integer> storedfs = new ArrayList<>();
        boolean vis[] = new boolean[V + 1];

        for (int i = 1; i < V; i++) {
            if (vis[i] == false) {
                dfsUtil(i, vis, adj, storedfs);
            }
        }
        return storedfs;
    }

    public static void main(String[] args) {

        int a = 3;
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

        System.out.println(dfs(a, adj));

    }

}
