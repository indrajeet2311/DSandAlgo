public class Nqueens {

    static int N = 4;

    static void printSolution(int[][] board) {

        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++)
                System.out.print(" " + board[x][y] + " ");
            System.out.println();
        }
    }

    boolean isSafe(int board[][], int row, int col) {

        int i, j;

        for (i = 0; i < col; i++)
            if (board[row][i] == 1)
                return false;

        for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1)
                return false;

        for (i = row, j = col; j >= 0 && i < N; i++, j--)
            if (board[i][j] == 1)
                return false;

        return true;
    }

    boolean solveNQUtil(int board[][], int col) {
        /*
         * base case: If all queens are placed then return true
         */
        if (col >= N)
            return true;

        /*
         * Consider this column and try placing this queen in all rows one by one
         */
        for (int i = 0; i < N; i++) {
            /*
             * Check if the queen can be placed on board[i][col]
             */
            if (isSafe(board, i, col)) {
                /* Place this queen in board[i][col] */
                board[i][col] = 1;

                /* recur to place rest of the queens */
                if (solveNQUtil(board, col + 1) == true)
                    return true;

                /*
                 * If placing queen in board[i][col] doesn't lead to a solution then remove
                 * queen from board[i][col]
                 */
                board[i][col] = 0; // BACKTRACK
            }
        }

        /*
         * If the queen can not be placed in any row in this colum col, then return
         * false
         */
        return false;
    }

    boolean solveNQ() {
        int board[][] = { { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 } };

        if (solveNQUtil(board, 0) == false) {
            System.out.print("Solution does not exist");
            return false;
        }

        printSolution(board);
        return true;
    }

    public static void main(String[] args) {
        Nqueens queen = new Nqueens();
        queen.solveNQ();
    }

}
