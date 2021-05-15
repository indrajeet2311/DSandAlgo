import java.util.*;

class GraphRep {

    // Directed graph - the graph is moving only in a one direction
    // indegree - the number of edges incoming in the graph outdegree - the number
    // of edges outgoing in the graph
    public static void main(String[] args) {

        int n = 3;
        int m = 3;

        // Adjacency matrix
        int[][] adj = new int[m + 1][n + 1];

        // edge 1-2
        adj[1][2] = 1;
        adj[2][1] = 1;

        // edge 2-3
        adj[2][3] = 2;
        adj[3][2] = 2;

        // edge 1-3
        adj[1][3] = 3;
        adj[3][1] = 3;

        // Adjacent List

        int a = 3, b = 3;
        ArrayList<ArrayList<Integer>> adjs = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i <= a; i++)
            adjs.add(new ArrayList<Integer>());

        // for edge 1-2
        adjs.get(1).add(2);
        adjs.get(2).add(1);

        // for edge 2-3
        adjs.get(2).add(3);
        adjs.get(3).add(2);

        // for edge 1-3
        adjs.get(1).add(3);
        adjs.get(3).add(1);

        for (int i = 1; i < a; i++) {
            for (int j = 0; j < adjs.get(i).size(); j++) {
                System.out.println(adjs.get(i).get(j) + " ");
            }
            System.out.println();
        }

    }

}
