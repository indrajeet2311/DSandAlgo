import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSort {

    static void findTopoSort(int node, int[] vis, ArrayList<ArrayList<Integer>> adj, Stack<Integer> st) {

        vis[node] = 1;
        for (Integer it : adj.get(node)) {
            if (vis[it] == 0) {
                findTopoSort(it, vis, adj, st);
            }
        }
        st.push(node);
    }

    static int[] topoSort(int n, ArrayList<ArrayList<Integer>> adj) {
        Stack<Integer> st = new Stack<Integer>();
        int vis[] = new int[n];

        for (int i = 0; i < n; i++) {
            if (vis[i] == 0) {
                findTopoSort(i, vis, adj, st);
            }
        }

        int topo[] = new int[n];
        int ind = 0;
        while (!st.isEmpty()) {
            topo[ind++] = st.pop();
        }

        return topo;
    }

    public static void main(String[] args) {

        int n = 7;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<Integer>());

        adj.get(0).add(1);
        adj.get(1).add(0);

        adj.get(1).add(2);
        adj.get(2).add(1);

        adj.get(2).add(3);
        adj.get(3).add(2);

        adj.get(4).add(3);
        adj.get(3).add(4);

        adj.get(4).add(5);
        adj.get(5).add(4);

        adj.get(4).add(6);
        adj.get(6).add(4);

        adj.get(1).add(6);
        adj.get(6).add(1);

        int[] y = topoSort(n, adj);
        System.out.println("The Toplogical Sorting Order");
        for (int i = 0; i < y.length; i++) {
            System.out.print(y[i] + " ");
        }

    }

}
