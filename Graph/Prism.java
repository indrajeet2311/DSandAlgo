import java.util.ArrayList;

class Nod {

    private int v;
    private int weight;

    Nod(int _v, int _w) {
        v = _v;
        weight = _w;
    }

    int getV() {
        return v;
    }

    int getWeight() {
        return weight;
    }
}

public class Prism {

    void primsAlgo(ArrayList<ArrayList<Nod>> adj, int N) {

        int[] key = new int[N];
        int[] parent = new int[N];
        boolean[] mstSet = new boolean[N];

        for (int i = 0; i < N; i++) {
            key[i] = 100000000;
            mstSet[i] = false;
            parent[i] = -1;
        }

        key[0] = 0;

        for (int i = 0; i < N - 1; i++) {
            int mini = 100000000, u = 0;
            for (int v = 0; v < N; v++) {
                if (mstSet[v] == false && key[v] < mini) {
                    mini = key[v];
                    u = v;
                }
            }

            mstSet[u] = true;

            for (Nod it : adj.get(u)) {
                if (mstSet[it.getV()] == false && it.getWeight() < key[it.getV()]) {
                    parent[it.getV()] = u;
                    key[it.getV()] = it.getWeight();
                }
            }

            for (i = 1; i < N; i++) {
                System.out.print(parent[i] + " " + i);
                System.out.println();
            }

        }

    }

    public static void main(String[] args) {
        int n = 5;
        ArrayList<ArrayList<Nod>> adj = new ArrayList<ArrayList<Nod>>();

        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<Nod>());

        adj.get(0).add(new Nod(1, 2));
        adj.get(1).add(new Nod(0, 2));

        adj.get(1).add(new Nod(2, 3));
        adj.get(2).add(new Nod(1, 3));

        adj.get(0).add(new Nod(3, 6));
        adj.get(3).add(new Nod(0, 6));

        adj.get(1).add(new Nod(3, 8));
        adj.get(3).add(new Nod(1, 8));

        adj.get(1).add(new Nod(4, 5));
        adj.get(4).add(new Nod(1, 5));

        adj.get(2).add(new Nod(4, 7));
        adj.get(4).add(new Nod(2, 7));

        Prism obj = new Prism();
        obj.primsAlgo(adj, n);

    }
}
