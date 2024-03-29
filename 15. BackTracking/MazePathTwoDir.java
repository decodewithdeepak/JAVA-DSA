// Problem: Rat in a Maze I [ 2 Directions - Right and Down] Using Recursion
// Time Complexity: O(2^(n+m)) where n = rows, m = columns - TLE for n,m > 10

public class MazePathTwoDir {

    public static int uniquePath(int sr, int sc, int er, int ec) {
        // sr = start row, sc = start column, er = end row, ec = end column

        if (sr>er || sc>ec) return 0; // Invalid path

        if (sr==er && sc==ec) return 1; // Base case

        // Recursive calls
        int downWays = uniquePath(sr+1, sc, er, ec);
        int rightWays = uniquePath(sr, sc+1, er, ec);

        return downWays + rightWays;
    }

    public static void printPath(int sr, int sc, int er, int ec, String path) {
        if (sr>er || sc>ec) return;
        if (sr==er && sc==ec) { // Base case
            System.out.println(path);
            return;
        }

        // Recursive calls
        printPath(sr, sc+1, er, ec, path + "R"); // Go Right
        printPath(sr+1, sc, er, ec, path + "D"); // Go Down
    }



    public static void main(String[] args) {
        
        int rows = 2;
        int cols =2;
        System.out.println(uniquePath(0, 0, rows-1, cols-1)); // 2
        printPath(0, 0, rows-1, cols-1, ""); // RD DR
    
        rows = 3;
        cols = 3;
        System.out.println(uniquePath(0, 0, rows-1, cols-1)); // 6
        printPath(0, 0, rows-1, cols-1, ""); // RRDD RDRD RDDR DRRD DRDR DDRR
    
        rows = 3;
        cols = 7;
        System.out.println(uniquePath(0, 0, rows-1, cols-1)); // 28
        printPath(0, 0, rows-1, cols-1, "");
        
    
    }

}
