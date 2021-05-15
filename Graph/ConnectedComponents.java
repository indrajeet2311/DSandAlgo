import java.util.ArrayList;

public class ConnectedComponents {

    int V;
    ArrayList<ArrayList<Integer>> adj;

    ConnectedComponents(int V) {
        this.V = V;
        adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(i, new ArrayList<>());
        }

    }

    void addEdge(int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    void dfs(int v, boolean[] visited) {
        visited[v] = true;
        System.out.println(v + " ");

        for (int x : adj.get(v)) {
            if (!visited[x])
                dfs(x, visited);
        }

    }

    void ConnectedComponent() {
        boolean[] visited = new boolean[V];
        for (int v = 0; v < V; v++) {
            if (!visited[v]) {
                dfs(v, visited);
                System.out.println();
            }

        }

    }

    public static void main(String[] args) {

        ConnectedComponents g = new ConnectedComponents(5);

        g.addEdge(1, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 4);

        g.ConnectedComponent();

    }

}
