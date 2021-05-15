import java.util.*;

class Nodes implements Comparator<Nodes> {

    private int v;
    private int weight;

    Nodes() {
    }

    Nodes(int _v, int _w) {
        v = _v;
        weight = _w;
    }

    int getV() {
        return v;
    }

    int getWeight() {
        return weight;
    }

    @Override
    public int compare(Nodes node1, Nodes node2) {
        if (node1.weight < node2.weight)
            return -1;
        if (node1.weight > node2.weight)
            return 1;

        return 0;
    }
}

public class Dijkshetra {

    void shortestpath(int s, ArrayList<ArrayList<Nodes>> adj, int N) {
        int dist[] = new int[N];

        for (int i = 0; i < N; i++)
            dist[i] = 100000000;

        dist[s] = 0;

        PriorityQueue<Nodes> pq = new PriorityQueue<Nodes>(N, new Nodes());
        pq.add(new Nodes(s, 0));

        while (pq.size() > 0) {
            Nodes nodes = pq.poll();

            for (Nodes it : adj.get(nodes.getV())) {
                if (dist[nodes.getV()] + it.getWeight() < dist[it.getV()]) {
                    dist[it.getV()] = dist[nodes.getV()] + it.getWeight();
                    pq.add(new Nodes(it.getV(), dist[it.getV()]));
                }
            }
        }

        for (int i = 0; i < N; i++) {
            System.out.print(dist[i] + " ");
        }
    }

    public static void main(String[] args) {

        int n = 5;

        ArrayList<ArrayList<Nodes>> adj = new ArrayList<ArrayList<Nodes>>();

        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<Nodes>());

        adj.get(0).add(new Nodes(1, 2));
        adj.get(1).add(new Nodes(0, 2));

        adj.get(1).add(new Nodes(2, 4));
        adj.get(2).add(new Nodes(1, 4));

        adj.get(0).add(new Nodes(3, 1));
        adj.get(3).add(new Nodes(0, 1));

        adj.get(3).add(new Nodes(2, 3));
        adj.get(2).add(new Nodes(3, 3));

        adj.get(1).add(new Nodes(4, 5));
        adj.get(4).add(new Nodes(1, 5));

        adj.get(2).add(new Nodes(4, 1));
        adj.get(4).add(new Nodes(2, 1));

        Dijkshetra main = new Dijkshetra();
        main.shortestpath(0, adj, n);

    }

}
