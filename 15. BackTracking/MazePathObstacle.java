// Problem: Rat in a Maze III [ 2 Directions - Right and Down] Using Recursion only 
// Given a maze (n*m) with obstacles, starting from (0,0) you have to reach (n-1, m-1) by moving only right and down. 
// Find the number of ways to reach the destination and print all possible paths.
// Active Block - 1 - True
// Dead Block - 0 - False

public class MazePathObstacle {

    public static int uniquePath(int sr, int sc, int er, int ec, int[][] maze) {
        // sr = start row, sc = start column, er = end row, ec = end column

        if (sr<0 || sc<0) return 0; // Invalid path
        if (sr>er || sc>ec) return 0; // Invalid path
        if (maze[sr][sc] == 0) return 0; // Blocked path
        
        if (sr==er && sc==ec) return 1; // Base case

        // Recursive calls
        int rightWays = uniquePath(sr, sc+1, er, ec, maze); // Go Right
        int downWays = uniquePath(sr+1, sc, er, ec, maze); // Go Down

        return rightWays + downWays;
    }

    public static void printPath(int sr, int sc, int er, int ec, String path, int[][] maze) {
        if (sr<0 || sc<0) return;
        if (sr>er || sc>ec) return;
        if (maze[sr][sc] == 0) return; // If cell is already visited, return
        
        if (sr==er && sc==ec) { // Base case
            System.out.println(path);
            return;
        }

        // Recursive calls
        printPath(sr, sc+1, er, ec, path + "R", maze); // Go Right
        printPath(sr+1, sc, er, ec, path + "D", maze); // Go Down
    }

    public static void main(String[] args) {
        int[][] maze = {{1, 0, 1}, 
                        {1, 1, 1}, 
                        {0, 1, 1}};
        int rows = maze.length;
        int cols = maze[0].length;

        System.out.println(uniquePath(0, 0, rows-1, cols-1, maze));
        printPath(0, 0, rows-1, cols-1, "", maze);
    }
    
}
