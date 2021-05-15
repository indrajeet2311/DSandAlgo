public class RatMze {

    static int N;

    static void printSolution(int maze[][]) {
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                System.out.print(" " + maze[x][y] + " ");

            }
            System.out.println();
        }
    }

    boolean isSafe(int x, int y, int[][] sol) {
        return (x >= 0 && x < N && y >= 0 && y < N && sol[x][y] == 1);
    }

    boolean solveMaze(int[][] sol) {
        int maze[][] = new int[N][N];

        if (solveMzeUtil(sol, 0, 0, maze) == false) {
            System.out.println("Solution doesnot Exists");
            return false;
        }
        printSolution(maze);

        return true;

    }

    boolean solveMzeUtil(int[][] sol, int x, int y, int[][] maze) {

        if (x == N - 1 && y == N - 1 && sol[x][y] == 1) {
            maze[x][y] = 1;
            return true;
        }

        if (isSafe(x, y, sol) == true) {
            if (maze[x][y] == 1)
                return false;
            maze[x][y] = 1;

            if (solveMzeUtil(sol, x + 1, y, maze))
                return true;

            if (solveMzeUtil(sol, x, y + 1, maze))
                return true;

            if (solveMzeUtil(sol, x - 1, y, maze))
                return true;

            if (solveMzeUtil(sol, x, y - 1, maze))
                return true;

            maze[x][y] = 0;
            return false;

            // if none works then the solution is 0

        }
        return false;
    }

    public static void main(String[] args) {

        RatMze rat = new RatMze();
        int sol[][] = { { 1, 0, 0, 0 }, { 1, 1, 0, 1 }, { 0, 1, 0, 0 }, { 1, 1, 1, 1 } };

        N = sol.length;
        rat.solveMaze(sol);

    }
}
