// Rat in a Maze IV [ 4 Directions - Right, Down, Left, Up] Using Backtracking
// Given a maze (n*m) with obstacles, starting from (0,0) you have to reach (n-1, m-1) by moving only right, down, left, and up.
// Find the number of ways to reach the destination and print all possible paths.
// Active Block - 1 - True
// Dead Block - 0 - False
// GFG - https://www.geeksforgeeks.org/rat-in-a-maze-problem-when-movement-in-all-possible-directions-is-allowed/

public class RatInMazeObstacleFourDir {

    public static int uniquePath(int sr, int sc, int er, int ec, int[][] maze, boolean[][] isVisited) {
        // sr = start row, sc = start column, er = end row, ec = end column

        if (sr<0 || sc<0) return 0; // Invalid path
        if (sr>er || sc>ec) return 0; // Invalid path
        if (maze[sr][sc] == 0) return 0; // Blocked path
        if (isVisited[sr][sc] == true) return 0; // Already visited
        
        if (sr==er && sc==ec) return 1; // Base case

        isVisited[sr][sc] = true; // Mark the cell as visited

        // Recursive calls
        int rightWays = uniquePath(sr, sc+1, er, ec, maze, isVisited); // Go Right
        int downWays = uniquePath(sr+1, sc, er, ec, maze, isVisited); // Go Down
        int leftWays = uniquePath(sr, sc-1, er, ec, maze, isVisited); // Go Left
        int upWays = uniquePath(sr-1, sc, er, ec, maze, isVisited); // Go Up

        isVisited[sr][sc] = false; // Backtrack - Mark the cell as unvisited

        return rightWays + downWays + leftWays + upWays;
    }

    public static void printPath(int sr, int sc, int er, int ec, String path, int[][] maze, boolean[][] isVisited) {
        if (sr<0 || sc<0) return;
        if (sr>er || sc>ec) return;
        if (maze[sr][sc] == 0) return; // Blocked path
        if (isVisited[sr][sc] == true) return; // Already visited
        
        if (sr==er && sc==ec) { // Base case
            System.out.println(path);
            return;
        }

        isVisited[sr][sc] = true; // Mark the cell as visited

        // Recursive calls
        printPath(sr, sc+1, er, ec, path + "R", maze, isVisited); // Go Right
        printPath(sr+1, sc, er, ec, path + "D", maze, isVisited); // Go Down
        printPath(sr, sc-1, er, ec, path + "L", maze, isVisited); // Go Left
        printPath(sr-1, sc, er, ec, path + "U", maze, isVisited); // Go Up

        // Backtrack - Mark the cell as unvisited
        isVisited[sr][sc] = false;
    }

    // Optimised approach - Reducing space complexity without using isVisited array
    public static int uniquePath(int sr, int sc, int er, int ec, int[][] maze) {
        if (sr<0 || sc<0) return 0; // Invalid path
        if (sr>er || sc>ec) return 0; // Invalid path
        if (maze[sr][sc] == 0) return 0; // Blocked path
        if (maze[sr][sc] == -1) return 0; // Already visited
        
        if (sr==er && sc==ec) return 1; // Base case

        maze[sr][sc] = -1; // Mark the cell as visited

        // Recursive calls
        int rightWays = uniquePath(sr, sc+1, er, ec, maze); // Go Right
        int downWays = uniquePath(sr+1, sc, er, ec, maze); // Go Down
        int leftWays = uniquePath(sr, sc-1, er, ec, maze); // Go Left
        int upWays = uniquePath(sr-1, sc, er, ec, maze); // Go Up

        maze[sr][sc] = 1; // Backtrack - Mark the cell as unvisited

        return rightWays + downWays + leftWays + upWays;
    }

    public static void printPath(int sr, int sc, int er, int ec, String path, int[][] maze) {
        if (sr<0 || sc<0) return;
        if (sr>er || sc>ec) return;
        if (maze[sr][sc] == 0) return; // Blocked path
        if (maze[sr][sc] == -1) return; // Already visited

        if (sr==er && sc==ec) { // Base case
            System.out.println(path);
            return;
        }

        maze[sr][sc] = -1; // Mark the cell as visited

        // Recursive calls
        printPath(sr, sc+1, er, ec, path + "R", maze); // Go Right
        printPath(sr+1, sc, er, ec, path + "D", maze); // Go Down
        printPath(sr, sc-1, er, ec, path + "L", maze); // Go Left
        printPath(sr-1, sc, er, ec, path + "U", maze); // Go Up

        // Backtrack - Mark the cell as unvisited
        maze[sr][sc] = 1;
    }

    public static void main(String[] args) {
        int[][] maze = {{1, 0, 0, 0},
                        {1, 1, 0, 1}, 
                        {1, 1, 0, 0},
                        {0, 1, 1, 1}};
        int rows = maze.length;
        int cols = maze[0].length;
        
        boolean[][] isVisited = new boolean[rows][cols]; // By default all values are false (unvisited)

        System.out.println(uniquePath(0, 0, rows-1, cols-1, maze, isVisited));
        printPath(0, 0, rows-1, cols-1, "", maze, isVisited);

        // Optimised approach - Reducing space complexity without using isVisited array
        System.out.println(uniquePath(0, 0, rows-1, cols-1, maze));
        printPath(0, 0, rows-1, cols-1, "", maze);

    }
}
