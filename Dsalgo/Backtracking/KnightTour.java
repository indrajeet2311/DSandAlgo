public class KnightTour {

    static int N = 8;

    static boolean isSafe(int x, int y, int[][] sol) {
        return (x >= 0 && x < N && y >= 0 && y < N && sol[x][y] == -1);
    }

    static void printSolution(int sol[][]) {
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++)
                System.out.print(sol[x][y] + " ");
            System.out.println();
        }
    }

    static boolean Knight() {
        int[][] sol = new int[8][8];

        for (int x = 0; x < N; x++)
            for (int y = 0; y < N; y++)
                sol[x][y] = -1;

        int xMove[] = { 2, 1, -1, -2, -2, -1, 1, 2 };
        int yMove[] = { 1, 2, 2, 1, -1, -2, -2, -1 };

        sol[0][0] = 0;

        if (!solveKnight(0, 0, 1, sol, xMove, yMove)) {
            System.out.println("Solution doesnot exists");
            return false;
        } else {
            printSolution(sol);
        }
        return true;
    }

    static boolean solveKnight(int x, int y, int move, int[][] sol, int[] xMove, int[] yMove) {
        int i, next_x, next_y;

        if (move == N * N)
            return true;

        for (i = 0; i < 8; i++) {
            next_x = x + xMove[i];
            next_y = y + yMove[i];

            if (isSafe(next_x, next_y, sol)) {
                sol[next_x][next_y] = move;
                if (solveKnight(next_x, next_y, move + 1, sol, xMove, yMove))
                    return true;
                else
                    sol[next_x][next_y] = -1;
            }
        }

        return false;

    }

    public static void main(String[] args) {
        Knight();

    }
}
