/* Q. All Paths From Source to Target
    For a given graph, print all paths that exist from source to target
    Example:
          1 ---- 3
         /       | \
        0        |  5 --- 6
         \       | /
          2 ---- 4

    Input: src = 0, tar = 5
    Output: 0 1 3 5
            0 1 3 4 5
            0 2 4 5
            0 2 4 3 5
*/

import java.util.*;

public class PathsFromSrcToDest {
    
    // Template for an edge
    public static class Edge {
        int src, dest;

        Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    // Method to add an edge to the graph
    public static void addEdge(ArrayList<Edge>[] graph, int src, int dest) {
        graph[src].add(new Edge(src, dest));
        graph[dest].add(new Edge(dest, src)); // For undirected graph
    }

    // Method to perform DFS and find all paths from source to target
    public static void findAllPaths(ArrayList<Edge>[] graph, int src, int tar, boolean[] visited, List<Integer> path) {
        // Add the current node to the path
        path.add(src);
        visited[src] = true;

        // If we reach the target, print the path
        if (src == tar) {
            System.out.println(path);
        } else {
            // Recur for all the vertices adjacent to this vertex
            for (Edge e : graph[src]) {
                if (!visited[e.dest]) {
                    findAllPaths(graph, e.dest, tar, visited, path);
                }
            }
        }

        // Backtrack: remove the current node from the path and mark it as unvisited
        path.remove(path.size() - 1);
        visited[src] = false;
    }

    public static void main(String[] args) {
        int V = 7; // Number of vertices
        ArrayList<Edge>[] graph = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        /* 
        Example graph 
             1 ---- 3
            /       | \
           0        |  5 -- 6
            \       | /
             2 ---- 4
        */

        addEdge(graph, 0, 1);
        addEdge(graph, 0, 2);
        addEdge(graph, 1, 3);
        addEdge(graph, 2, 4);
        addEdge(graph, 3, 5);
        addEdge(graph, 4, 3);
        addEdge(graph, 4, 5);
        addEdge(graph, 5, 6);

        boolean[] visited = new boolean[V];
        List<Integer> path = new ArrayList<>();

        int src = 0; // Source node
        int tar = 5; // Target node

        System.out.println("All paths from node " + src + " to node " + tar + ":");
        findAllPaths(graph, src, tar, visited, path);
    }
}
