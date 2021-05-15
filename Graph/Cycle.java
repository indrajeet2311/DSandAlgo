import java.util.*;

public class Cycle {

    private static int V;

    private static LinkedList<Integer> adj[];

    Cycle(int v) {
        V = v;
        adj = new LinkedList[v];

        for (int i = 0; i < v; i++)
            adj[i] = new LinkedList();
    }

    void addEdge(int a, int b) {
        adj[a].add(b);
        adj[b].add(a);
    }

    static boolean cylic(int v, Boolean[] vis, int parent) {
        vis[v] = true;
        Integer i;

        Iterator<Integer> it = adj[v].iterator();

        while (it.hasNext()) {
            i = it.next();

            if (!vis[i]) {
                if (cylic(i, vis, v))
                    return true;
            }

            else if (i != parent)
                return true;
        }

        return false;

    }

    static boolean isCylic() {

        Boolean[] vis = new Boolean[V];

        for (int i = 0; i < V; i++)
            vis[i] = false;

        for (int u = 0; u < V; u++) {
            if (!vis[u])
                if (cylic(u, vis, -1))
                    ;
            return true;
        }

        return false;

    }

    public static void main(String[] args) {

        Cycle g1 = new Cycle(5);

        g1.addEdge(1, 0);
        g1.addEdge(0, 2);
        g1.addEdge(2, 1);
        g1.addEdge(0, 3);
        g1.addEdge(3, 4);

        if (isCylic())
            System.out.println("Graph contains cycle");
        else
            System.out.println("Graph doesnot contains cycle");

    }

}
