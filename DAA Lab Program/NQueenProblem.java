public class NQueenProblem {
    final int N = 4; // Size of the chessboard

    // Function to print the solution
    void printSolution(int board[][]) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 1)
                    System.out.print("Q ");
                else
                    System.out.print(". ");
            }
            System.out.println();
        }
    }

    // Function to check if a queen can be placed on board[row][col]
    boolean isSafe(int board[][], int row, int col) {
        int i, j;
        // Check this row on left side
        for (i = 0; i < col; i++)
            if (board[row][i] == 1)
                return false;
        // Check upper diagonal on left side
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1)
                return false;
        // Check lower diagonal on left side
        for (i = row, j = col; j >= 0 && i < N; i++, j--)
            if (board[i][j] == 1)
                return false;
        return true;
    }

    // Utility function to solve N-Queens problem
    boolean solveNQUtil(int board[][], int col) {
        // Base case: If all queens are placed
        if (col >= N)
            return true;
        // Consider this column and try placing this queen
        for (int i = 0; i < N; i++) {
            if (isSafe(board, i, col)) {
                board[i][col] = 1; // Place the queen
                // Recur to place the rest of the queens
                if (solveNQUtil(board, col + 1))
                    return true;
                // BACKTRACK: Remove the queen
                board[i][col] = 0;
            }
        }
        return false; // No place found
    }

    // Function to solve the N-Queens problem
    boolean solveNQ() {
        int board[][] = new int[N][N]; // Initialize the board
        if (!solveNQUtil(board, 0)) { // Start from the first column
            System.out.print("Solution does not exist");
            return false;
        }
        printSolution(board); // Print the solution
        return true;
    }

    // Driver program to test the above functions
    public static void main(String args[]) {
        NQueenProblem queen = new NQueenProblem();
        queen.solveNQ();
    }
}
