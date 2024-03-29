// Problem: Rat in a Maze II [ 4 Directions - Right, Down, Left, Up] Using Backtracking

public class MazePathFourDir {

    public static int uniquePath(int sr, int sc, int er, int ec, boolean[][] isVisited) {
        // sr = start row, sc = start column, er = end row, ec = end column

        if (sr<0 || sc<0) return 0; // Invalid path
        if (sr>er || sc>ec) return 0; // Invalid path
        if (isVisited[sr][sc] == true) return 0; // Already visited
        
        if (sr==er && sc==ec) return 1; // Base case

        isVisited[sr][sc] = true; // Mark the cell as visited

        // Recursive calls
        int rightWays = uniquePath(sr, sc+1, er, ec, isVisited); // Go Right
        int downWays = uniquePath(sr+1, sc, er, ec, isVisited); // Go Down
        int leftWays = uniquePath(sr, sc-1, er, ec, isVisited); // Go Left
        int upWays = uniquePath(sr-1, sc, er, ec, isVisited); // Go Up

        isVisited[sr][sc] = false; // Backtrack - Mark the cell as unvisited

        return rightWays + downWays + leftWays + upWays;
    }
    
    public static void printPath(int sr, int sc, int er, int ec, String path, boolean[][] isVisited) {
        if (sr<0 || sc<0) return;
        if (sr>er || sc>ec) return;
        if (isVisited[sr][sc] == true) return; // Already visited
        
        if (sr==er && sc==ec) { // Base case
            System.out.println(path);
            return;
        }

        isVisited[sr][sc] = true; // Mark the cell as visited

        // Recursive calls
        printPath(sr, sc+1, er, ec, path + "R", isVisited); // Go Right
        printPath(sr+1, sc, er, ec, path + "D", isVisited); // Go Down
        printPath(sr, sc-1, er, ec, path + "L", isVisited); // Go Left
        printPath(sr-1, sc, er, ec, path + "U", isVisited); // Go Up

        // Backtrack - Mark the cell as unvisited
        isVisited[sr][sc] = false;
    }
    

    public static void main(String[] args) {

    int rows = 3;
    int cols = 3;
    boolean[][] isVisited = new boolean[rows][cols]; // By default all values are false (unvisited)

    System.out.println(uniquePath(0, 0, rows-1, cols-1, isVisited)); // 12
    printPath(0, 0, rows-1, cols-1, "", isVisited);


    

    }
}
