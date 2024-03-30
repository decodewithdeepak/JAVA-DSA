// N-Queens - LeetCode #51 (https://leetcode.com/problems/n-queens/)
// N-Queens II - LeetCode #52 (https://leetcode.com/problems/n-queens-ii/)

import java.util.*;

class NQueens {

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        // Initialize the board with empty spaces
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        findSolutions(board, 0, result);
        return result;
    }

    public static int totalNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        // Initialize the board with empty spaces
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        findSolutions(board, 0, result);
        return result.size();
    }

    private static void findSolutions(char[][] board, int row, List<List<String>> result) {
        int n = board.length;
        // Base case: If all queens are placed, add the board configuration to the result
        if (row == n) {
            List<String> solution = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                solution.add(new String(board[i]));
            }
            result.add(solution);
            return;
        }
        // Try placing a queen in each column of the current row
        for (int col = 0; col < n; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 'Q'; // Place the queen
                findSolutions(board, row + 1, result); // Recur to the next row
                board[row][col] = '.'; // Backtrack: remove the queen
            }
        }
    }

    private static boolean isSafe(char[][] board, int row, int col) {
        int n = board.length;

        // Check row
        for (int j = 0; j < n; j++) {
            if (board[row][j] == 'Q') return false;
        }
        // Check column
        for (int i = 0; i < n; i++) {
            if (board[i][col] == 'Q') return false;
        }
        // Check north-east diagonal
        for (int i = row, j = col; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }
        // Check north-west diagonal
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }
        // Check south-east diagonal
        for (int i = row, j = col; i < n && j < n; i++, j++) {
            if (board[i][j] == 'Q') return false;
        }
        // Check south-west diagonal
        for (int i = row, j = col; i < n && j >= 0; i++, j--) {
            if (board[i][j] == 'Q') return false;
        }

        return true;
    }

    public static void main(String[] args) {

        // N-Queens - LeetCode #51
        List<List<String>> result = solveNQueens(4);
        for (List<String> solution : result) {
            for (String row : solution) {
                System.out.println(row);
            }
            System.out.println();
        }


        // N-Queens II - LeetCode #52
        System.out.println("Total solutions: " + totalNQueens(4)); // 2

        System.out.println(totalNQueens(1)); // 1
        System.out.println(totalNQueens(2)); // 0
        System.out.println(totalNQueens(3)); // 0
        System.out.println(totalNQueens(8)); // 92
        
    }
}