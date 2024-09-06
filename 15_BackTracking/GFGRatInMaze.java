// GFG: https://practice.geeksforgeeks.org/problems/rat-in-a-maze-problem/1

import java.util.*;

public class GFGRatInMaze {
    public static ArrayList<String> findPath(int[][] m, int n) {
        ArrayList<String> ans = new ArrayList<>();
        boolean[][] isVisited = new boolean[n][n];
        generatePath(m, n, 0, 0, "", ans, isVisited);
        return ans;
    }

    private static void generatePath(int[][] m, int n, int i, int j, String path, ArrayList<String> ans, boolean[][] isVisited) {
        // i -> row, j -> column, m -> matrix, n -> size of matrix, path -> current path, ans -> list of all paths, isVisited -> visited cells
        if (i < 0 || j < 0 || i >= n || j >= n) return; // Out of bounds
        if (m[i][j] == 0) return; // Blocked path
        if (isVisited[i][j] == true) return; // Already visited

        if (i == n - 1 && j == n - 1) { // Reached destination
            ans.add(path);
            return;
        }

        // Mark the cell as visited
        isVisited[i][j] = true;

        // Recursive cases
        generatePath(m, n, i + 1, j, path + "D", ans, isVisited);
        generatePath(m, n, i, j - 1, path + "L", ans, isVisited);
        generatePath(m, n, i, j + 1, path + "R", ans, isVisited);
        generatePath(m, n, i - 1, j, path + "U", ans, isVisited);

        // Backtrack
        isVisited[i][j] = false;
    }

    public static void main(String[] args) {
        int[][] m = {{1, 0, 0, 0},
        {1, 1, 0, 1}, 
        {1, 1, 0, 0},
        {0, 1, 1, 1}};

        ArrayList<String> res = findPath(m, 4);
        for (String s : res) {
            System.out.println(s);
        }

    }
}
