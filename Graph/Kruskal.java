import java.util.*;

class N {

    private int u;
    private int v;
    private int weight;

    N() {
    }

    N(int _u, int _v, int _w) {
        u = _u;
        v = _v;
        weight = _w;
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

class SortComparator implements Comparator<N> {
    @Override
    public int compare(N n1, N n2) {

        if (n1.getWeight() < n2.getWeight())
            return -1;
        if (n1.getWeight() > n2.getWeight())
            return 1;

        return 0;
    }

}

public class Kruskal {

    private int findPar(int u, int[] parent) {
        if (u == parent[u])
            return u;

        return findPar(parent[u], parent);
    }

    private void union(int u, int v, int parent[], int rank[]) {
        u = findPar(u, parent);
        v = findPar(v, parent);
        if (rank[u] < rank[v]) {
            parent[u] = v;
        } else if (rank[u] > rank[v]) {
            parent[v] = u;
        } else {
            parent[v] = u;
            rank[u]++;
        }
    }

    void KruskalAlgo(ArrayList<N> adj, int N) {
        Collections.sort(adj, new SortComparator());
        int[] parent = new int[N];
        int[] rank = new int[N];

        for (int i = 0; i < N; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        int costMst = 0;

        ArrayList<N> mst = new ArrayList<N>();

        for (N it : adj) {
            if (findPar(it.getU(), parent) != findPar(it.getV(), parent)) {
                costMst = it.getWeight();
                mst.add(it);
                union(it.getU(), it.getV(), parent, rank);
            }
        }

        System.out.println(costMst + " ");

        for (N it : mst) {
            System.out.println(it.getU() + " " + it.getV());
        }
    }

    public static void main(String[] args) {

        int n = 5;
        ArrayList<N> adj = new ArrayList<N>();

        adj.add(new N(0, 1, 2));
        adj.add(new N(0, 3, 6));
        adj.add(new N(1, 3, 8));
        adj.add(new N(1, 2, 3));
        adj.add(new N(1, 4, 5));
        adj.add(new N(2, 4, 7));

        Kruskal obj = new Kruskal();
        obj.KruskalAlgo(adj, n);

    }

}
