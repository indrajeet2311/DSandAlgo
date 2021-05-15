import java.util.*;

class Nodess {
    private int u;
    private int v;
    private int weight;

    Nodess(int _u, int _v, int _w) {
        u = _u;
        v = _v;
        weight = _w;
    }

    Nodess() {
    }

    int getV() {
        return v;
    }

    int getU() {
        return u;
    }

    int getWeight() {
        return weight;
    }

}

class BellmanFord {
    void bellmanFord(ArrayList<Nodess> edges, int N, int src) {
        int dist[] = new int[N];
        for (int i = 0; i < N; i++)
            dist[i] = 10000000;

        dist[src] = 0;

        for (int i = 1; i <= N - 1; i++) {
            for (Nodess node : edges) {
                if (dist[node.getU()] + node.getWeight() < dist[node.getV()]) {
                    dist[node.getV()] = dist[node.getU()] + node.getWeight();
                }
            }
        }

        int fl = 0;
        for (Nodess node : edges) {
            if (dist[node.getU()] + node.getWeight() < dist[node.getV()]) {
                fl = 1;
                System.out.println("Negative Cycle");
                break;
            }
        }

        if (fl == 0) {
            for (int i = 0; i < N; i++) {
                System.out.println(i + " " + dist[i]);
            }
        }
    }

    public static void main(String args[]) {
        int n = 6;
        ArrayList<Nodess> adj = new ArrayList<Nodess>();

        adj.add(new Nodess(3, 2, 6));
        adj.add(new Nodess(5, 3, 1));
        adj.add(new Nodess(0, 1, 5));
        adj.add(new Nodess(1, 5, -3));
        adj.add(new Nodess(1, 2, -2));
        adj.add(new Nodess(3, 4, -2));
        adj.add(new Nodess(2, 4, 3));

        BellmanFord obj = new BellmanFord();
        obj.bellmanFord(adj, n, 0);

    }
}