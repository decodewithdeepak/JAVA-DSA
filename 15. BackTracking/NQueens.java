// N-Queens - LeetCode #51 (https://leetcode.com/problems/n-queens/)

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
        backtrack(board, 0, result);
        return result;
    }

    private static void backtrack(char[][] board, int row, List<List<String>> result) {
        int n = board.length;
        // Base case: If all queens are placed, add the board configuration to the result
        if (row == n) {
            result.add(constructSolution(board));
            return;
        }
        // Try placing a queen in each column of the current row
        for (int col = 0; col < n; col++) {
            if (isValid(board, row, col)) {
                board[row][col] = 'Q'; // Place the queen
                backtrack(board, row + 1, result); // Recur to the next row
                board[row][col] = '.'; // Backtrack: remove the queen
            }
        }
    }

    private static boolean isValid(char[][] board, int row, int col) {
        int n = board.length;
        // Check if there is no queen in the same column
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }
        // Check if there is no queen on the upper-left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        // Check if there is no queen on the upper-right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    private static List<String> constructSolution(char[][] board) {
        List<String> solution = new ArrayList<>();
        for (char[] row : board) {
            solution.add(String.valueOf(row));
        }
        return solution;
    }

    public static void main(String[] args) {
        List<List<String>> result = solveNQueens(4);
        for (List<String> solution : result) {
            for (String row : solution) {
                System.out.println(row);
            }
            System.out.println();
        }
    }
}