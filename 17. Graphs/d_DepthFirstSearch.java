// Graph Traversal: Depth First Search (DFS) - 
// Go to the deepest node first
// Keep going to the first neighbor
// DFS Algorithm uses Stack or Recursion
// Time Complexity: O(V + E) where V is the number of vertices and E is the number of edges in the graph

import java.util.*;

public class d_DepthFirstSearch {
    
    // Template for an edge with weight
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

    // Method to create and initialize the graph
    public static ArrayList<Edge>[] createGraph(int V) {
        ArrayList<Edge>[] graph = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        // Example graph
        //      1
        //     / \
        //    2   3
        //     \ / \
        //      4   7
        //     / \ 
        //    5   6
        // DFS - 1 2 4 5 6 3 7

        addEdge(graph, 1, 2);
        addEdge(graph, 1, 3);
        addEdge(graph, 2, 4);
        addEdge(graph, 4, 5);
        addEdge(graph, 4, 6);
        addEdge(graph, 3, 4);
        addEdge(graph, 3, 7);

        return graph;
    }

    public static ArrayList<Edge>[] createGraph1(int V) {
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
        DFS - 0 1 3 4 2 5 6 
        */

        addEdge(graph, 0, 1);
        addEdge(graph, 0, 2);
        addEdge(graph, 1, 3);
        addEdge(graph, 2, 4);
        addEdge(graph, 3, 4);
        addEdge(graph, 3, 5);
        addEdge(graph, 4, 5);
        addEdge(graph, 5, 6);
        
        return graph;
    }

    // Method to perform DFS traversal using backtracking
    public static void dfs(ArrayList<Edge>[] graph, int curr, boolean[] visited) {
        visited[curr] = true;
        System.out.print(curr + " ");
        for (Edge e : graph[curr]) {
            if (!visited[e.dest]) {
                dfs(graph, e.dest, visited);
            }
        }
    }

    public static void main(String[] args) {
        int V = 8; // Number of vertices (index 0 is unused)
        ArrayList<Edge>[] graph = createGraph(V);
        boolean[] visited = new boolean[V];
        System.out.println("DFS traversal of graph starting from node 1:");
        dfs(graph, 1, visited);

        System.out.println();

        ArrayList<Edge>[] graph1 = createGraph1(7); // V = 7
        visited = new boolean[7];
        System.out.println("DFS traversal of graph1 starting from node 0:");
        dfs(graph1, 0, visited);
        
    }
}
